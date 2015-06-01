package com.dragon.codingol.web.interceptors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import com.dragon.codingol.common.Pager;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor {
	 
	private static final Log logger = LogFactory.getLog(PaginationInterceptor.class);
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static String defaultDialect = "mysql"; // 数据库类型(默认为mysql)
	private static String defaultPageSqlId = ".*Page$"; // 需要拦截的ID(正则匹配)
	private static String dialect = ""; // 数据库类型(默认为mysql)
	private static String pageSqlId = ""; // 需要拦截的ID(正则匹配)

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY,
				DEFAULT_OBJECT_WRAPPER_FACTORY);
		// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
		while (metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = MetaObject.forObject(object,
					DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		}
		// 分离最后一个代理对象的目标类
		while (metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = MetaObject.forObject(object,
					DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		}
		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
		dialect = configuration.getVariables().getProperty("dialect");
		if (null == dialect || "".equals(dialect)) { 
			dialect = defaultDialect;
		}
		pageSqlId = configuration.getVariables().getProperty("pageSqlId");
		if (null == pageSqlId || "".equals(pageSqlId)) { 
			pageSqlId = defaultPageSqlId;
		}
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		// 只重写需要分页的sql语句。通过MappedStatement的ID匹配，默认重写以Page结尾的MappedStatement的sql
		if (mappedStatement.getId().matches(pageSqlId)) {
			BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
			Object parameterObject = boundSql.getParameterObject();
			if (parameterObject == null) {
				throw new NullPointerException("parameterObject is null!");
			} else {
				Pager page = (Pager) metaStatementHandler.getValue("delegate.boundSql.parameterObject.page");
				String sql = boundSql.getSql();
				// 重写sql
				String pageSql = buildPageSql(sql, page);
				 
				metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
				// 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
				metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
				metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
				Connection connection = (Connection) invocation.getArgs()[0];
				// 重设分页参数里的总页数等
				setPageParameter(sql, connection, mappedStatement, boundSql, page);
			}
		}
		// 将执行权交给下一个拦截器
		return invocation.proceed();
	}

	private String getCountSql(String sql){
		int orderIndex = sql.lastIndexOf("order by");
		if(orderIndex == -1){
			orderIndex = sql.length();
		}
		return "select count(0) " + sql.substring(sql.indexOf("from"), orderIndex);
	}
	
	private void setPageParameter(String sql, Connection connection, 
			MappedStatement mappedStatement, BoundSql boundSql, Pager page) {
		// 记录总记录数
		String countSql = getCountSql(sql.toLowerCase());
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			countStmt = connection.prepareStatement(countSql);
			BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(),
					countSql, boundSql.getParameterMappings(),
					boundSql.getParameterObject());
			setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
			rs = countStmt.executeQuery();
			int totalCount = 0;
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
			page.setTotal(totalCount);
		} catch (SQLException e) {
			logger.error("Ignore this exception", e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
			try {
				countStmt.close();
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
		}
	}

	/**
	 * 对SQL参数(?)设值
	 * 
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	private void setParameters(PreparedStatement ps,
			MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
		parameterHandler.setParameters(ps);
	}

	/**
	 * 根据数据库类型，生成特定的分页sql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	private String buildPageSql(String sql, Pager page) {
		if (page != null) {
			StringBuilder pageSql = new StringBuilder();
			if ("mysql".equals(dialect)) {
				pageSql = buildPageSqlForMysql(sql, page);
			} else if ("oracle".equals(dialect)) {
				pageSql = buildPageSqlForOracle(sql, page);
			} if ("sqlserver".equals(dialect)) {
				pageSql = buildPageSqlForSqlServer(sql, page);
			}  else {
				return sql;
			}
			return pageSql.toString();
		} else {
			return sql;
		}
	}

	/**
	 * mysql的分页语句
	 * 
	 * @param sql
	 * @param page
	 * @return String
	 */
	public StringBuilder buildPageSqlForMysql(String sql, Pager page) {
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf((page.getLimit() - 1) * page.getPage());
		pageSql.append(sql);
		pageSql.append(" limit " + beginrow + "," + page.getPage());
		return pageSql;
	}

	/**
	 * 参考hibernate的实现完成oracle的分页
	 * 
	 * @param sql
	 * @param page
	 * @return String
	 */
	public StringBuilder buildPageSqlForOracle(String sql, Pager page) {
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf((page.getLimit() - 1) * page.getPage());
		String endrow = String.valueOf(page.getLimit() * page.getPage());

		pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
		pageSql.append(sql);
		pageSql.append(" ) temp where rownum <= ").append(endrow);
		pageSql.append(") where row_id > ").append(beginrow);
		return pageSql;
	}
	
	
	public StringBuilder buildPageSqlForSqlServer(String sql, Pager page) {
		 StringBuilder sb = new StringBuilder(sql.trim().toLowerCase());
		 String beginrow = String.valueOf((page.getLimit() - 1) * page.getPage()  + 1);
		 String endrow = String.valueOf(page.getLimit() * page.getPage());
	     int orderByIndex = sb.indexOf("order by");
	     CharSequence orderby = (orderByIndex > 0) ? sb.subSequence(orderByIndex, sb.length())  : "ORDER BY CURRENT_TIMESTAMP";
	 
	     if (orderByIndex > 0) {
	       sb.delete(orderByIndex, orderByIndex + orderby.length());
	     }
	 
	     replaceDistinctWithGroupBy(sb); 
	 
	     insertRowNumberFunction(sb, orderby);
	 
	     sb.insert(0, " WITH query AS (").append(") SELECT * FROM query ");
	     sb.append("WHERE rank BETWEEN ");
	     sb.append(beginrow);
	     sb.append(" AND ");
	     sb.append(endrow);
	 
	     return sb;
	}
	
	protected static void insertRowNumberFunction(StringBuilder sql, CharSequence orderby) {
		int selectEndIndex = sql.indexOf("select") + "select".length() + 1;

		sql.insert(selectEndIndex, " ROW_NUMBER() OVER (" + orderby
				+ ") as rank,");
	}

	protected static void replaceDistinctWithGroupBy(StringBuilder sql) {
		int distinctIndex = sql.indexOf("distinct");
		if (distinctIndex > 0) {
			sql.delete(distinctIndex, distinctIndex + "distinct".length() + 1);
			sql.append(" group by").append(getSelectFieldsWithoutAliases(sql));
		}
	}

	protected static CharSequence getSelectFieldsWithoutAliases(
			StringBuilder sql) {
		String select = sql.substring(
				sql.indexOf("select") + "select".length(), sql.indexOf("from"));

		return stripAliases(select);
	}

	protected static String stripAliases(String str) {
		return str.replaceAll("\\sas[^,]+(,?)", "$1");
	}
	
	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

}
