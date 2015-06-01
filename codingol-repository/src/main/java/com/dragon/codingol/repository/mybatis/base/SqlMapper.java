package com.dragon.codingol.repository.mybatis.base;

import java.util.List;
import java.util.Map;

public interface SqlMapper<T> {

	int deleteByPrimaryKey(String id);

	int insert(T t);
	
	int dynamicInsert(Map<String, Object> map);

	T selectByPrimaryKey(String id);

	int updateByPrimaryKey(T t);
	
	int dynamicUpdateByPrimaryKey(Map<String, Object> map);
	
	int restoreByPrimaryKey(String id);
	
	T check(T t);

	List<T> getAll();

	List<T> queryPage(Map<String, Object> param);
}
