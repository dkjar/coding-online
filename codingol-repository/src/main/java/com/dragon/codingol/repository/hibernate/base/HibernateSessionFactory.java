package com.dragon.codingol.repository.hibernate.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

 
public abstract class HibernateSessionFactory {
	
	@Autowired
	@Qualifier("sessionFactory")
	protected SessionFactory sessionFactory;
 
	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}
	
}
