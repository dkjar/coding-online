package com.dragon.codingol.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.dragon.codingol.common.util.CriteriaUtil;
 
public interface CommonService {

	public <T> void save(T entity) throws Exception;
	public <T> void saveOrUpdate(T entity) throws Exception;
	public <T> void delete(T entity) throws Exception;
	
	public <T> void batchSave(List<T> entitys) throws Exception;
	/**
	 * 根据实体名称和主键获取实体
	 * 
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> class1, Serializable id);
	/**
	 * 根据实体名称和主键获取实体
	 * 
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @return
	 */
	public <T> T getEntity(Class<T> entityName, Serializable id);
	
	
	public <T> List<T> getEntitys(Class<T> entityName, String ids);
	/**
	 * 根据实体名称和字段名称和字段值获取唯一记录
	 * @param <T>
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName, Object value);
	/**
	 * 按属性查找对象列表.
	 */
	public <T> List<T> findByProperty(Class<T> entityClass,String propertyName, Object value);
	
	/**
	 * 按属性查找 datastaus<>-1 对象列表.
	 */
	public <T> List<T> findEffectiveByProperty(Class<T> entityClass, String propertyName, Object value);
	
	/**
	 * 加载全部实体
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> loadAll(final Class<T> entityClass);
		

	/**
	 * 删除实体主键删除
	 * 
	 * @param <T>
	 * @param entities
	 */
	public <T> void deleteEntityById(Class entityName, Serializable id);
	/**
	 * 
	 * @param entityName
	 * @param ids
	 */
	public <T> void deleteEntityByIds(Class entityName, String ids);

	/**
	 * 更新指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 */
	public <T> void updateEntitie(T pojo) throws Exception;

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findByQueryString(String hql);
	/**
	 * 根据sql更新
	 * 
	 * @param query
	 * @return
	 */
	public int updateBySqlString(String sql);

	/**
	 * 根据sql查找List
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findListbySql(Class<T> entityClass, String sql,Object... param );
	public <T> List<T> findListbySql(Class<T> entityClass, String query);
	public <T> List<T> findListbySql(String query);
	
	/**
	 * hibernate 分页
	 * @param detachedCriteria
	 * @return
	 */
	public void queryCriteriaPage(CriteriaUtil criteriaUtil);
	/**
	 * 通过属性称获取实体带排序
	 * 
	 * @param <T>
	 * @param clas
	 * @return
	 */
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass, String propertyName, Object value, boolean isAsc);
	
	public <T> List<T> getList(Class clas);
	
	public <T> T singleResult(String hql) throws Exception;
	
	public Map<Object, Object> getHashMapbyQuery(String sql, Object... param);
	public Map<Object, Object> getHashMapbyHqlQuery(String hql, Object... param);
	   
	public List findByExample(final Object exampleEntity);
	 
	/**
	 * 执行SQL 调用时请注意缓存的清除
	 */
	public Integer executeSql(String sql, List<Object> param);
	
	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findHql(String hql, Object... param) ;
	
	/**********************************************************************************************
	 * 计算hql查询数据的总数 在网上直接找到的以下方法。因为以前的方法计算总条数的方法都不支持 count distinct的 hql.
	 * 这个方法是将hql 转成sql后，再绑定参数。（他会根据你的数据库来动态转成sql。这比实际写成sql要好得多。 数据库的移植性要高得多。
	 * 
	 * @param hql
	 * @param values
	 * @return
	 */
	public Integer getDataTotalByHQL(String hql);

	/**
	 * 多关键字查询拼写
	 * @param property 要查找的属性，比如"s.name"
	 * @param keywords 关键字
	 * @param hql 拼接好的HQL,注意要传入StringBuffer，传String无法返回值
	 */
	public void createFuzzyQuery(String property, String keywords, StringBuffer hql);
	
	/**
	 * 根据已经拼装好的hql来生成查询数量的hql语句,并返回Query。
	 * 主要功能是截取from到order by之间的内容，并加上count语句
	 * @param hql
	 * @return
	 */
	public Query getSimpleCountQuery(String hql);
	  
	 
}
