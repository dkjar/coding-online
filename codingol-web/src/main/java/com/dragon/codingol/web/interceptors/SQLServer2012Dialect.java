package com.dragon.codingol.web.interceptors;

import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class SQLServer2012Dialect extends SQLServerDialect {
	private static final String SELECT = "select";
	private static final String FROM = "from";
	private static final String DISTINCT = "distinct";
	private static final int MAX_LENGTH = 8000;

	public SQLServer2012Dialect() {
		registerColumnType(2004, "varbinary(MAX)");
		registerColumnType(-3, "varbinary(MAX)");
		registerColumnType(-3, 8000, "varbinary($l)");
		registerColumnType(-4, "varbinary(MAX)");

		registerColumnType(2005, "varchar(MAX)");
		registerColumnType(-1, "varchar(MAX)");
		registerColumnType(12, "varchar(MAX)");
		registerColumnType(12, 8000, "varchar($l)");

		registerColumnType(-5, "bigint");
		registerColumnType(-7, "bit");
		registerColumnType(16, "bit");

		registerFunction("row_number", new NoArgSQLFunction("row_number",
				StandardBasicTypes.INTEGER, true));
	}

	public boolean supportsLimitOffset() {
		return true;
	}

	public boolean bindLimitParametersFirst() {
		return false;
	}

	public boolean supportsVariableLimit() {
		return false;
	}

	public int convertToFirstRowValue(int zeroBasedFirstResult) {
		return (zeroBasedFirstResult + 1);
	}

	public String getLimitString(String query, int offset, int limit) {
		if ((offset > 1) || (limit > 1)){
			int orderByIndex = query.trim().indexOf("order by");
			if(orderByIndex > 0)
				return  " set nocount on;" +query+ " OFFSET "+offset+" ROW FETCH NEXT "+(limit-offset-1)+" rows only set nocount off  ";
			else
				return  " set nocount on;" +query+ " ORDER BY CURRENT_TIMESTAMP OFFSET "+offset+" ROW FETCH NEXT "+(limit-offset-1)+" rows only set nocount off ";
		}
		return query;
	}

	public String getLimitString(String querySqlString, boolean hasOffset) {
		StringBuilder sb = new StringBuilder(querySqlString.trim());
		int orderByIndex = sb.indexOf("order by");
		if(orderByIndex > 0)
			return querySqlString = " set nocount on;" +querySqlString+ " OFFSET (?-1) ROW FETCH NEXT (?-1) rows only set nocount off ";
		else
			return querySqlString = " set nocount on;" +querySqlString+ " ORDER BY CURRENT_TIMESTAMP OFFSET (?-1) ROW FETCH NEXT (?-1) rows only set nocount off ";
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
		String select = sql.substring(sql.indexOf("select") + "select".length(), sql.indexOf("from"));

		return stripAliases(select);
	}

	protected static String stripAliases(String str) {
		return str.replaceAll("\\sas[^,]+(,?)", "$1");
	}

	protected static void insertRowNumberFunction(StringBuilder sql,
			CharSequence orderby) {
		int selectEndIndex = sql.indexOf("select") + "select".length();

		sql.insert(selectEndIndex, " ROW_NUMBER() OVER (" + orderby + ") as rank,");
	}
}
