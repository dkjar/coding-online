package com.dragon.codingol.service;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.base.CommonHelper;
import com.dragon.codingol.common.util.BeanUtils;
import com.dragon.codingol.common.util.CriteriaUtil;
import com.dragon.codingol.repository.hibernate.base.IGenericCommonDao;
import com.dragon.codingol.repository.redis.RedisClientTemplate;

@Service("commonService")
@Transactional(rollbackFor=Exception.class)
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	protected RedisClientTemplate redisClientTemplate;
	
	protected boolean iscache = false;
	protected String key = null;
	
	@Resource
	public IGenericCommonDao genericCommonDao = null;

	public <T> void save(T entity) throws Exception {
		if(iscache)
			redisClientTemplate.delObject(key);
		
		genericCommonDao.save(entity);
	}

	public <T> void saveOrUpdate(T entity) throws Exception {
		if(iscache)
			redisClientTemplate.delObject(key);
		
		Method m = entity.getClass().getMethod("getId");
		Object id = m.invoke(entity, new Object[] {});
		if(org.springframework.util.StringUtils.isEmpty(id)){
			genericCommonDao.save(entity);
			return;
		}
		String k = entity.getClass().getName()+id;
		Object old = redisClientTemplate.getObject(k);
		if(old==null){
			old = genericCommonDao.getEntity(entity.getClass(), id.toString());
		}
		BeanUtils.copyBeanNotNull2Bean(entity, old);
		redisClientTemplate.delObject(k);
		
 		genericCommonDao.saveOrUpdate(old);
	}

	public <T> void delete(T entity) throws Exception {
		if(iscache)
			redisClientTemplate.delObject(key);
		Method m = entity.getClass().getMethod("getId");
		Object id = m.invoke(entity, new Object[] {});
		if(org.springframework.util.StringUtils.isEmpty(id)){
			genericCommonDao.deleteEntityByProperty(entity);
		}else{
			String k = entity.getClass().getName()+m.invoke(entity, new Object[] {});
			redisClientTemplate.delObject(k);
			
			genericCommonDao.delete(entity);
		}
		
	}

	/**
	 * 根据实体名获取对象 , 将实体保存到redis中 保存时取出更新。
	 */
	
	public <T> T get(Class<T> class1, Serializable id) {
		String key = class1.getName()+id;
		Object t = redisClientTemplate.getObject(key);
		if(t==null){
			t =  genericCommonDao.get(class1, id);
			redisClientTemplate.setObject(key, t);
		}
		return (T) t;
	}

	/**
	 * 根据实体名返回全部对象
	 * 
	 * @param <T>
	 * @param hql
	 * @param size
	 * @return
	 */
	
	public <T> List<T> getList(Class clas) {
		return genericCommonDao.loadAll(clas);
	}

	/**
	 * 根据实体名获取对象
	 */
	
	public <T> T getEntity(Class<T> entityName, Serializable id) {
		String key = entityName.getName()+id;
		Object t = redisClientTemplate.getObject(key);
		if(t==null){
			t =  genericCommonDao.get(entityName, id);
			redisClientTemplate.setObject(key, t);
		}
		return (T) t;
	}
	
	public <T> List<T> getEntitys(Class<T> entityName, String ids){
		if(StringUtils.isEmpty(ids)){
			return null;
		}
		return genericCommonDao.getEntitys(entityName, ids);
	}

	/**
	 * 根据实体名称和字段名称和字段值获取唯一记录
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @return
	 */
	
	public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName, Object value) {
		if(iscache){
			Object o = redisClientTemplate.getObject(key);
			if(o==null){
				o =  genericCommonDao.loadAll(entityClass);
				redisClientTemplate.setObject(key, o);
			} 
			List<T> list = (List<T>)o;
			try {
				
				Method m = entityClass.getMethod("get"+CommonHelper.captureName(propertyName));
				if(m!=null){
					for(T t : list){
						if(m.invoke(t, new Object[] {}).equals(value)){
							return t;
						}
					}
				}
			} catch (NoSuchMethodException 
					| SecurityException 
					| IllegalAccessException 
					| IllegalArgumentException 
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		return genericCommonDao.findUniqueByProperty(entityClass, propertyName, value);
	}

	/**
	 * 按属性查找对象列表.
	 */
	
	public <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value) {
		if(iscache){
			Object o = redisClientTemplate.getObject(key);
			if(o==null){
				o =  genericCommonDao.loadAll(entityClass);
				redisClientTemplate.setObject(key, o);
			} 
			List<T> list = (List<T>)o;
			List<T> rlist = new ArrayList<T>();
			try {
				
				Method m = entityClass.getMethod("get"+CommonHelper.captureName(propertyName));
				if(m!=null){
					for(T t : list){
						if(m.invoke(t, new Object[] {}).equals(value)){
							rlist.add(t);
						}
					}
					return rlist;
				}
			} catch (NoSuchMethodException 
					| SecurityException 
					| IllegalAccessException 
					| IllegalArgumentException 
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return genericCommonDao.findByProperty(entityClass, propertyName, value);
	}
	
	/**
	 * 按属性查找 datastaus<>-1 对象列表.
	 */
	
	public <T> List<T> findEffectiveByProperty(Class<T> entityClass, String propertyName, Object value){
		
		return genericCommonDao.findEffectiveByProperty(entityClass, propertyName, value);
	}
		
	
	/**
	 * 加载全部实体
	 * 
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	
	public <T> List<T> loadAll(final Class<T> entityClass) {
		if(iscache){
			Object o = redisClientTemplate.getObject(key);
			if(o==null){
				o =  genericCommonDao.loadAll(entityClass);
				redisClientTemplate.setObject(key, o);
				return (List<T>) o;
			}
		}
		return genericCommonDao.loadAll(entityClass);
	}

	
	public <T> T singleResult(String hql) throws Exception {
		return genericCommonDao.singleResult(hql);
	}

	/**
	 * 通过sql 查询语句查找HashMap对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	
	public Map<Object, Object> getHashMapbyQuery(String sql, Object... param) {
		return genericCommonDao.getHashMapbyQuery(sql, param);
	}

	/**
	 * 通过hql 查询语句查找HashMap对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	
	public Map<Object, Object> getHashMapbyHqlQuery(String hql, Object... param) {
		return genericCommonDao.getHashMapbyHqlQuery(hql, param);
	}
	
	/**
	 * 删除实体主键ID删除对象
	 * 
	 * @param <T>
	 * @param entities
	 */
	public <T> void deleteEntityById(Class entityName, Serializable id) {
		if(iscache)
			redisClientTemplate.delObject(key);
		
		String k = entityName.getName()+ id;
		redisClientTemplate.delObject(k);
		
		genericCommonDao.deleteEntityById(entityName, id);
	}

	/**
	 * 
	 */
	public <T> void deleteEntityByIds(Class entityName, String ids){
		if(StringUtils.isEmpty(ids)){
			return;
		}
		if(iscache)
			redisClientTemplate.delObject(key);
		
		String id[] = ids.split(",");
		for(String i : id){
			redisClientTemplate.delObject(entityName.getName()+ i);
		}
		
		genericCommonDao.deleteEntityByIds(entityName, ids);
	}
	/**
	 * 更新指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public <T> void updateEntitie(T pojo) throws Exception {
		if(iscache)
			redisClientTemplate.delObject(key);
		
		Method m = pojo.getClass().getMethod("getId");
		String k = pojo.getClass().getName()+m.invoke(pojo, new Object[] {});
		Object old = redisClientTemplate.getObject(k);
		BeanUtils.copyBeanNotNull2Bean(pojo, old);
		
		redisClientTemplate.delObject(k);
		
		genericCommonDao.updateEntitie(pojo);
	}

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	
	public <T> List<T> findByQueryString(String hql) {
		return genericCommonDao.findByQueryString(hql);
	}

	/**
	 * 根据sql更新
	 * 
	 * @param query
	 * @return
	 */
	public int updateBySqlString(String sql) {
		if(iscache)
			redisClientTemplate.delObject(key);
		return genericCommonDao.updateBySqlString(sql);
	}

	public int updateBySqlString(String sql, List<Object> param) {
		if(iscache)
			redisClientTemplate.delObject(key);
		return genericCommonDao.updateBySqlString(sql, param);
	}
	
	/**
	 * 根据sql查找List
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	
	public <T> List<T> findListbySql(Class<T> entityClass, String query, Object... param) {
		return genericCommonDao.findListbySql(entityClass, query, param);
	}
	
	public <T> List<T> findListbySql(Class<T> entityClass, String query) {
		return genericCommonDao.findListbySql(entityClass, query);
	}
	
	public <T> List<T> findListbySql(String query) {
		return genericCommonDao.findListbySql(query);
	}

	
	public void queryCriteriaPage(CriteriaUtil criteriaUtil){
		genericCommonDao.queryCriteriaPage(criteriaUtil);
	}

	/**
	 * 通过属性称获取实体带排序
	 * 
	 * @param <T>
	 * @param clas
	 * @return
	 */
	
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass, String propertyName, Object value, boolean isAsc) {
		return genericCommonDao.findByPropertyisOrder(entityClass, propertyName, value, isAsc);
	}
	
	public List findByExample(final Object exampleEntity) {
		return genericCommonDao.findByExample(exampleEntity);
	}

	 
	public Integer executeSql(String sql, List<Object> param) {
		if(iscache)
			redisClientTemplate.delObject(key);
		return genericCommonDao.executeSql(sql, param);
	}
 

	public <T> void batchSave(List<T> entitys) throws Exception{
		if(iscache)
			redisClientTemplate.delObject(key);
		this.genericCommonDao.batchSave(entitys);
	}

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	
	public <T> List<T> findHql(String hql, Object... param) {
		return this.genericCommonDao.findHql(hql, param);
	}
 

	/**
	 * 去除hql的orderby子句
	 */
	private static String removeOrders(String hql) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	public void createFuzzyQuery(String property, String keywords, StringBuffer hql) {
		if (!keywords.trim().equals("")) {
			String[] params = keywords.trim().split("\\s+");
			for (int i = 0; i < params.length; i++) {
				hql.append(" and " + property + " like '%" + params[i] + "%'");
			}
		}

	}

	public Query getSimpleCountQuery(String hql) {
		String countHQL = "select count(*) " + hql.substring(hql.indexOf(" from"), hql.indexOf("order by"));
		return genericCommonDao.getSession().createQuery(countHQL);
	}

 

	@Override
	public Integer getDataTotalByHQL(String hql) {
		QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(removeOrders(hql), removeOrders(hql), Collections.EMPTY_MAP,
				(SessionFactoryImplementor) this.genericCommonDao.getSession().getSessionFactory());
		queryTranslator.compile(Collections.EMPTY_MAP, false);
		String tempSQL = queryTranslator.getSQLString();
		String countSQL = "select count(*) from (" + tempSQL + ") tmp_count_t";
		Query query = this.genericCommonDao.getSession().createSQLQuery(countSQL);
		List list = query.list();

		if ((list.get(0).getClass() + "").indexOf("lang.Integer") != -1) {// msSQL
			Integer count = (Integer) list.get(0);
			return count;
		} else if ((list.get(0).getClass() + "").indexOf("math.BigInteger") != -1) {// mysql
			Integer count = (Integer) list.get(0);
			return count;
		}
		return null;
	}
}
