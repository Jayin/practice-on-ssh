package com.hibernate.utils;

import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	//创建会话工厂的方法
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			//在hibernate3.5之前需要使用AnnotationConfiguration来创建SessionFactory才可以实现基于注解的映射。
			//new AnnotationConfiguration().configure().buildSessionFactory();
			//在hibernate3.5基于映射文件，Configuration来创建SessionFactory才可以实现
			//new Configuration().configure().buildSessionFactory();
			
			//在hibernate3.5之后都合并在一起，直接使用Configuration来创建SessionFactory。同时实现基于注解，基于映射文件两种映射方式。
			return new Configuration().configure().buildSessionFactory();
			 
		}
		catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	//获取会话工厂的方法
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
