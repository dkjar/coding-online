package com.dragon.codingol.repository.mybatis.base;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class DynamicDefaultObjectFactory  extends DefaultObjectFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3321409810319223929L;

	@Override
	public <T> T create(Class<T> type) {
		// TODO Auto-generated method stub
		return super.create(type);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes,
			List<Object> constructorArgs) {
		T t = super.create(type, constructorArgTypes, constructorArgs);
		return t;
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		super.setProperties(properties);
	}

	@Override
	protected Class<?> resolveInterface(Class<?> type) {
		// TODO Auto-generated method stub
		return super.resolveInterface(type);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		// TODO Auto-generated method stub
		return super.isCollection(type);
	}

	
	
}
