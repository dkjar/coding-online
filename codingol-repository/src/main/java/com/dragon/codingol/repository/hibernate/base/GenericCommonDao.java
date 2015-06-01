package com.dragon.codingol.repository.hibernate.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.Transformers;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.dragon.codingol.common.IDCardValidate;
import com.dragon.codingol.common.SystemConfig;
import com.dragon.codingol.common.base.ReflectHelper;
import com.dragon.codingol.common.util.CriteriaUtil;
import com.dragon.codingol.domain.base.Valiform;

/**
 * 
 * 类描述： DAO层泛型基类
 * 
 * @author: dx
 * @date： 日期：2012-12-7 时间：上午10:16:48
 * @param <T>
 * @param <PK>
 * @version 1.0
 */
@Repository("genericCommonDao")
public class GenericCommonDao<T, PK extends Serializable> extends HibernateSessionFactory implements IGenericCommonDao {
	
	/**
	 * 根据实体名字获取唯一记录
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName, Object value) {
		Assert.hasText(propertyName);
		return (T) createCriteria(entityClass, Restrictions.eq(propertyName, value)).uniqueResult();
	}

	/**
	 * 按属性查找对象列表.
	 */
	public <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value) {
		Assert.hasText(propertyName);
		return (List<T>) createCriteria(entityClass, Restrictions.eq(propertyName, value)).list();
	}

	/**
	 * 按属性查找 datastaus<>-1 对象列表.
	 */
	public <T> List<T> findEffectiveByProperty(Class<T> entityClass, String propertyName, Object value) {
		Criteria c = getSession().createCriteria(entityClass);
		c.add(Restrictions.eq(propertyName, value));
		c.add(Restrictions.ne(SystemConfig.getDatastatus(), -1));
		return (List<T>) c.list();
	}

	public <T> List<T> findEffectiveByPropertys(Class<T> entityClass, List<String> propertyName, List<Object> propertyValue) {
		Criteria c = getSession().createCriteria(entityClass);
		for (int i = 0; i < propertyName.size(); i++) {
			c.add(Restrictions.eq(propertyName.get(i), propertyValue.get(i)));
		}
		c.add(Restrictions.ne(SystemConfig.getDatastatus(), -1));
		return (List<T>) c.list();
	}


	/**
	 * 根据传入的实体持久化对象
	 * 
	 * @throws Exception
	 */
	public <T> void save(T entity) throws Exception {
		try {
			valiform(entity);
			getSession().save(entity);
			getSession().flush();
		} catch (Exception e) {
			throw e;
		}

	}

	private void valiform(Object entity) throws Exception {
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field f : fields) {
			Valiform valiform = f.getAnnotation(Valiform.class);
			if (valiform != null) {
				// 拼写get方法名
				String str = f.getName();
				String firstChar = str.substring(0, 1).toUpperCase();
				String behindWord = str.substring(1, str.length());
				// 取得id值
				Method getId = entity.getClass().getMethod("getId");
				Object oId = getId.invoke(entity);
				String IdValue = (oId == null ? null : oId.toString());
				// 取得属性值
				Method getValue = entity.getClass().getMethod("get" + firstChar + behindWord);
				Object o = getValue.invoke(entity);
				String value = (o == null ? null : o.toString());

				if (valiform.notNull()) {
					if (StringUtils.isEmpty(value)) {
						throw new RuntimeException("\"" + valiform.title() + "\"不能为空！");
					}
				}

				if (valiform.idCard() && !StringUtils.isEmpty(value)) {
					IDCardValidate cc = new IDCardValidate();
					String validate = cc.IDCardValidate(value);
					if (!validate.equals("YES")) {
						throw new RuntimeException("\"" + valiform.title() + "\"格式不正确！");
					}

				}
				if (valiform.isUnique() && !StringUtils.isEmpty(value)) {
					List list = this.findEffectiveByProperty(entity.getClass(), f.getName(), value);
					if (list != null && list.size() > 0) {
						if (!StringUtils.isEmpty(IdValue)) { // id不为空，查检id是否相等
							Object s = list.get(0);
							Object sId = getId.invoke(s);
							String sIdValue = (sId == null ? null : sId.toString());
							if (!IdValue.equals(sIdValue)) {// id不相等，则重复；相等，则是修改，不是重复
								throw new RuntimeException("\"" + valiform.title() + "\"已经存在，请勿重复录入！");
							}
						} else {
							throw new RuntimeException("\"" + valiform.title() + "\"已经存在，请勿重复录入！");
						}
					}
				}
 
			}
		}
	}

	/**
	 * 批量保存数据
	 * 
	 * @param <T>
	 * @param entitys
	 *            要持久化的临时实体对象集合
	 * @throws Exception
	 */
	public <T> void batchSave(List<T> entitys) throws Exception {
		for (int i = 0; i < entitys.size(); i++) {
			try {
				valiform(entitys.get(i));
				getSession().save(entitys.get(i));
				if (i % 20 == 0) {
					// 20个对象后才清理缓存，写入数据库
					getSession().flush();
					getSession().clear();
				}
			} catch (Exception e) {
				throw e;
			}
		}
	}

	/**
	 * 根据传入的实体添加或更新对象
	 * 
	 * @param <T>
	 * 
	 * @param entity
	 * @throws Exception
	 */

	public <T> void saveOrUpdate(T entity) throws RuntimeException {
		try {
			valiform(entity);
			getSession().saveOrUpdate(entity);
			getSession().flush();
		} catch (Exception e) {
			if(e.getCause()!=null && e.getCause().getMessage().equals("将截断字符串或二进制数据。")){
				throw new RuntimeException("更新失败。填写内容超过最大长度");
			}else{
				throw new RuntimeException(e.getMessage());
			} 
		}
	}

	private <T> boolean isHaveDataStatus(T entity) {
		boolean isHave = false;
		ReflectHelper reflectHelper = new ReflectHelper(entity);
		Field[] field = entity.getClass().getDeclaredFields();
		for (Field f : field) {
			if (f.getName().equals("dataStatus")) {
				try {
					if (f.getType().equals(Integer.class)) {
						reflectHelper.setMethodValue(f.getName(), -1);
					} else
						reflectHelper.setMethodValue(f.getName(), (short) -1);
					isHave = true;
					break;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (isHave) {
			try {
				this.saveOrUpdate(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isHave;
	}

	/**
	 * 根据传入的实体删除对象
	 * 
	 * @throws Exception
	 */
	public <T> void delete(T entity) {
		try {
			if (!isHaveDataStatus(entity)) {
				getSession().delete(entity);
				getSession().flush();
			}

		} catch (RuntimeException e) {
			throw e;
		}
	}

	/**
	 * 根据主键删除指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 * @throws Exception
	 */
	public <T> void deleteEntityById(Class<T> entityName, Serializable id) {
		Table table = entityName.getAnnotation(Table.class);
		if(table!=null &&  !StringUtils.isEmpty(table.name())){
			String sql  = "delete from " + table.name() + " where id  = ? ";
			List<Object> param = new ArrayList<Object>();
			param.add(id);
			this.executeSql(sql, param);
		}else{
			delete(get(entityName, id));
			getSession().flush();
		}
	}
	
	public <T> void deleteEntityByProperty(T entityName) throws Exception{
		Table table = entityName.getClass().getAnnotation(Table.class);
		if(table!=null &&  !StringUtils.isEmpty(table.name())){
			String sql  = "delete from " + table.name() + " where";
			Method method[] = entityName.getClass().getDeclaredMethods();
			List<Object> param = new ArrayList<Object>();
			
			for(Method m:method){
				if(m.getName().startsWith("get")){
					Column c = m.getAnnotation(Column.class);
					Object o = m.invoke(entityName, new Object[] {});
					if(StringUtils.isEmpty(o)){
						continue;
					}
					if(sql.endsWith("where")){
						sql += " "+ c.name().replace("[", "").replace("]", "")+ " = ? ";
						param.add(o);
					}else{
						sql += " and "+ c.name().replace("[", "").replace("]", "")+ " = ? ";
						param.add(o);
					}
				}
			}
			if(param.size() > 0)
				this.executeSql(sql, param);
		} 
	}
	
	/**
	 * 根据主键删除指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 * @throws Exception
	 */
	public <T> void deleteEntityByIds(Class<T> entityName, String ids){
		Table table = entityName.getAnnotation(Table.class);
		if(table!=null &&  !StringUtils.isEmpty(table.name())){
			String sql  = "delete from " + table.name() + " where 1=0 ";
			List<Object> param = new ArrayList<Object>();
			String id[] = ids.split(",");
			for(String i : id){
				sql += " or id = ? ";
				param.add(i);
			}
			this.executeSql(sql, param);
		}
	}

	/**
	 * 删除全部的实体
	 * 
	 * @param <T>
	 * 
	 * @param entitys
	 */
	public <T> void deleteAllEntitie(Collection<T> entitys) {
		for (Object entity : entitys) {
			if (!isHaveDataStatus(entity)) {
				getSession().delete(entity);
				getSession().flush();
			}
		}
	}

	/**
	 * 根据Id获取对象。
	 */
	public <T> T get(Class<T> entityClass, final Serializable id) {

		return (T) getSession().get(entityClass, id);

	}

	/**
	 * 根据主键获取实体并加锁。
	 * 
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @param lock
	 * @return
	 */
	public <T> T getEntity(Class<T> entityName, Serializable id) {

		T t = (T) getSession().get(entityName, id);
		if (t != null) {
			getSession().flush();
		}
		return t;
	}
	
	public <T> List<T> getEntitys(Class<T> entityName, String ids){
		Criteria criteria = getSession().createCriteria(entityName);
		String id[] = ids.split(",");
		for(String i :id){
			criteria.add(Restrictions.or(Restrictions.eq("id", i)));
		}
		return criteria.list();
	}

	/**
	 * 更新指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 */
	public <T> void updateEntitie(T pojo) {
		getSession().update(pojo);
		getSession().flush();
	}

	/**
	 * 更新指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 */
	public <T> void updateEntitie(String className, Object id) {
		getSession().update(className, id);
		getSession().flush();
	}

	/**
	 * 根据主键更新实体
	 */
	public <T> void updateEntityById(Class<T> entityName, Serializable id) {
		updateEntitie(get(entityName, id));
	}

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public List<T> findByQueryString(final String query) {

		Query queryObject = getSession().createQuery(query);
		List<T> list = queryObject.list();
		if (list.size() > 0) {
			getSession().flush();
		}
		return list;

	}

	/**
	 * 通过hql查询唯一对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 * @throws Exception 
	 */
	public <T> T singleResult(String hql) throws Exception {
		T t = null;
		Query queryObject = getSession().createQuery(hql);
		List<T> list = queryObject.list();
		if (list.size() == 1) {
			getSession().flush();
			t = list.get(0);
		} else if (list.size() > 0) {
			throw new Exception("查询结果数:" + list.size() + "大于1");
		}
		return t;
	}

	/**
	 * 通过sql 查询语句查找HashMap对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public Map<Object, Object> getHashMapbyQuery(String sql, Object... param) {

		Query query = getSession().createSQLQuery(sql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		List list = query.list();
		Map<Object, Object> map = new HashMap<Object, Object>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] tm = (Object[]) iterator.next();
			map.put(tm[0].toString(), tm[1].toString());
		}
		return map;
	}

	/**
	 * 通过hql 查询语句查找HashMap对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public Map<Object, Object> getHashMapbyHqlQuery(String hql, Object... param) {

		Query query = getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		List list = query.list();
		Map<Object, Object> map = new HashMap<Object, Object>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] tm = (Object[]) iterator.next();
			map.put(tm[0].toString(), tm[1].toString());
		}
		return map;

	}

	public Map<Object, Object> getLinkedHashMapbyHqlQuery(String hql, Object... param) {

		Query query = getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		List list = query.list();
		Map<Object, Object> map = new LinkedHashMap<Object, Object>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] tm = (Object[]) iterator.next();
			map.put(tm[0].toString(), tm[1].toString());
		}
		return map;

	}

	/**
	 * 通过sql更新记录
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public int updateBySqlString(final String query) {

		Query querys = getSession().createSQLQuery(query);
		return querys.executeUpdate();
	}

	public int updateBySqlString(final String query, List<Object> param) {

		Query querys = getSession().createSQLQuery(query);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				querys.setParameter(i, param.get(i));
			}
		}
		return querys.executeUpdate();
	}

	/**
	 * 通过sql查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findListbySql(String sql) {
		SQLQuery querys = getSession().createSQLQuery(sql);

		return querys.list();
	}

	public <T> List<T> findListbySql(Class<T> entityClass, String sql) {
		SQLQuery querys = getSession().createSQLQuery(sql);
		Field[] fields = entityClass.getFields();
		for (Field f : fields) {
			querys.addScalar(f.getName());
		}
		querys.setResultTransformer(Transformers.aliasToBean(entityClass));
		return querys.list();
	}

	/**
	 * 通过sql查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findListbySql(Class<T> entityClass, String sql, Object... param) {
		SQLQuery querys = getSession().createSQLQuery(sql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				querys.setParameter(i, param[i]);
			}
		}
		Field[] fields = entityClass.getFields();
		for (Field f : fields) {
			if (f.getName().equals("areaList")) {
				continue;
			}
			querys.addScalar(f.getName());
		}
		querys.setResultTransformer(Transformers.aliasToBean(entityClass));
		return querys.list();
	}

	
	public void queryCriteriaPage(CriteriaUtil criteriaUtil){
		 
		Criteria criteria = criteriaUtil.getDetachedCriteria().getExecutableCriteria(getSession());
		CriteriaImpl impl = (CriteriaImpl) criteria;
		  
		Projection projection = impl.getProjection();
		final int allCounts = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(projection);
		
		if (projection == null) {
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		} else {
			criteria.setResultTransformer(Transformers.aliasToBean(criteriaUtil.getTclass()));
		}
		
		criteria.setFirstResult((criteriaUtil.getPage() - 1 )*criteriaUtil.getLimit());
		criteria.setMaxResults(criteriaUtil.getLimit());
		
		if(!criteriaUtil.isIsorder()){
			addOrder(criteria, criteriaUtil.getTclass());
		}
		
		List list = criteria.list();
		
		criteriaUtil.getPager().setTotal(allCounts);
		criteriaUtil.getPager().setRows(list);
	}

	public Integer getCountBySql(String sql, Object... param) {
		SQLQuery countQuery = getSession().createSQLQuery(sql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				countQuery.setParameter(i, param[i]);
			}
		}
		return ((Number) countQuery.uniqueResult()).intValue();
	}

	public Integer getCountByHql(String hql, Object... param) {
		Query countQuery = getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				countQuery.setParameter(i, param[i]);
			}
		}
		return ((Number) countQuery.uniqueResult()).intValue();
	}

	/**
	 * 创建Criteria对象，有排序功能。
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param orderBy
	 * @param isAsc
	 * @param criterions
	 * @return
	 */
	private <T> Criteria createCriteria(Class<T> entityClass, boolean isAsc, Criterion... criterions) {
		Criteria criteria = createCriteria(entityClass, criterions);
		if (isAsc) {
			criteria.addOrder(Order.asc("asc"));
		} else {
			criteria.addOrder(Order.desc("desc"));
		}
		return criteria;
	}

	/**
	 * 创建Criteria对象带属性比较
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param criterions
	 * @return
	 */
	private <T> Criteria createCriteria(Class<T> entityClass, Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		 
		addOrder(criteria, entityClass);
		return criteria;
	}
	
	private void addOrder(Criteria criteria, Class entityClass){
		Field fields[] = entityClass.getDeclaredFields();
		for(Field f : fields){
			if(f.getName() == "order"){
				criteria.addOrder(Order.asc("order"));
			}
		}
	}

	public <T> List<T> loadAll(final Class<T> entityClass) {
		Criteria criteria = createCriteria(entityClass);
		return criteria.list();
	}

	/**
	 * 创建单一Criteria对象
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param criterions
	 * @return
	 */
	private <T> Criteria createCriteria(Class<T> entityClass) {
		Criteria criteria = getSession().createCriteria(entityClass);
		return criteria;
	}

	/**
	 * 根据属性名和属性值查询. 有排序
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @param orderBy
	 * @param isAsc
	 * @return
	 */
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass, String propertyName, Object value, boolean isAsc) {
		Assert.hasText(propertyName);
		return createCriteria(entityClass, isAsc, Restrictions.eq(propertyName, value)).list();
	}

	/**
	 * 根据属性名和属性值 查询 且要求对象唯一.
	 * 
	 * @return 符合条件的唯一对象.
	 */
	public <T> T findUniqueBy(Class<T> entityClass, String propertyName, Object value) {
		Assert.hasText(propertyName);
		return (T) createCriteria(entityClass, Restrictions.eq(propertyName, value)).uniqueResult();
	}

	/**
	 * 根据查询条件与参数列表创建Query对象
	 * 
	 * @param session
	 *            Hibernate会话
	 * @param hql
	 *            HQL语句
	 * @param objects
	 *            参数列表
	 * @return Query对象
	 */
	public Query createQuery(Session session, String hql, Object... objects) {
		Query query = session.createQuery(hql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
		}
		return query;
	}

	/**
	 * 批量插入实体
	 * 
	 * @param clas
	 * @param values
	 * @return
	 * @throws Exception
	 */
	public <T> int batchInsertsEntitie(List<T> entityList) throws Exception {
		int num = 0;
		for (int i = 0; i < entityList.size(); i++) {
			save(entityList.get(i));
			num++;
		}
		return num;
	}

	/**
	 * 根据实体名返回全部对象
	 * 
	 * @param <T>
	 * @param hql
	 * @param size
	 * @return
	 */
	public List<T> executeQuery(final String hql, final Object[] values) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; values != null && i < values.length; i++) {
			query.setParameter(i, values[i]);
		}

		return query.list();

	}

	/**
	 * 根据实体模版查找
	 * 
	 * @param entityName
	 * @param exampleEntity
	 * @return
	 */

	public List findByExample(final Object exampleEntity) {
		Criteria executableCriteria =  getSession().createCriteria(exampleEntity.getClass());
		executableCriteria.add(Example.create(exampleEntity));
		return executableCriteria.list();
	}
	
	
 
	/**
	 * 调用存储过程
	 */
	public void callableStatementByName(String proc) {
	}

	/**
	 * 查询指定实体的总记录数
	 * 
	 * @param clazz
	 * @return
	 */
	public int getCount(Class<T> clazz) {

		int count = DataAccessUtils.intResult(getSession().createQuery("select count(*) from " + clazz.getName()).list());
		return count;
	}


	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findHql(String hql, Object... param) {
		Query q = getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	/**
	 * 执行HQL语句操作更新
	 * 
	 * @param hql
	 * @return
	 */

	public Integer executeHql(String hql) {
		Query q = getSession().createQuery(hql);
		return q.executeUpdate();
	}

	public Integer executeHql(String hql, Object... param) {
		Query q = getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	@Override
	public Integer executeSql(String sql, List<Object> param) {
		Query q = getSession().createSQLQuery(sql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}

 
}
