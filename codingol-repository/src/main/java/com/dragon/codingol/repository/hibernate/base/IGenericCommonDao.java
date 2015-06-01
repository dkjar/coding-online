package com.dragon.codingol.repository.hibernate.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.dragon.codingol.common.util.CriteriaUtil;

/**
 * 
 * 类描述：DAO层泛型基类接口
 * 
 * @author: dx
 * @date： 日期：2012-12-8 时间：下午05:37:33
 * @version 1.0
 */
public interface IGenericCommonDao {

	public <T> void save(T entity) throws Exception;

	public <T> void batchSave(List<T> entitys) throws Exception;

	public <T> void saveOrUpdate(T entity) throws RuntimeException;

	public <T> void delete(T entitie);

	public <T> T get(Class<T> entityName, Serializable id);

	public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName,
			Object value);

	public <T> List<T> findByProperty(Class<T> entityClass, String propertyName,
			Object value);

	public <T> T getEntity(Class<T> entityName, Serializable id);

	public <T> List<T> getEntitys(Class<T> entityName, String ids);

	/**
	 * 按属性查找 datastaus<>-1 对象列表.
	 */
	public <T> List<T> findEffectiveByProperty(Class<T> entityClass,
			String propertyName, Object value);

	public <T> List<T> loadAll(final Class<T> entityClass);

	public <T> void deleteEntityById(Class<T> entityName, Serializable id);

	public <T> void deleteEntityByIds(Class<T> entityName, String ids);
	
	public <T> void deleteEntityByProperty(T entityName) throws Exception;

	public <T> void deleteAllEntitie(Collection<T> entities);

	public <T> void updateEntitie(T pojo);

	public <T> void updateEntityById(Class<T> entityName, Serializable id);

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findByQueryString(String hql);

	/**
	 * 通过hql查询唯一对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> T singleResult(String hql) throws Exception;

	/**
	 * 根据sql更新
	 * 
	 * @param query
	 * @return
	 */
	public int updateBySqlString(String sql);

	public int updateBySqlString(String sql, List<Object> param);

	/**
	 * 根据sql查找List
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findListbySql(String query);

	public <T> List<T> findListbySql(Class<T> entityClass, String query);

	public <T> List<T> findListbySql(Class<T> entityClass, final String sql,
			Object... param);

	public void queryCriteriaPage(CriteriaUtil criteriaUtil);

	/**
	 * 根据sql查找统计总数
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public Integer getCountBySql(String sql, Object... param);

	public Integer getCountByHql(String hql, Object... param);

	/**
	 * 通过属性称获取实体带排序
	 * 
	 * @param <T>
	 * @param clas
	 * @return
	 */
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
			String propertyName, Object value, boolean isAsc);

	public Session getSession();

	public List findByExample(final Object exampleEntity);

	/**
	 * 通过hql 查询语句查找HashMap对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public Map<Object, Object> getHashMapbyQuery(String query, Object... param);

	public Map<Object, Object> getHashMapbyHqlQuery(String hql, Object... param);

	public Map<Object, Object> getLinkedHashMapbyHqlQuery(String hql,
			Object... param);

	/**
	 * 执行SQL
	 */
	public Integer executeSql(String sql, List<Object> param);

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findHql(String hql, Object... param);

	/**
	 * 执行HQL语句操作更新
	 * 
	 * @param hql
	 * @return
	 */
	public Integer executeHql(String hql);

	public Integer executeHql(String hql, Object... param);
}
