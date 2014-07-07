package com.hibernate.utils;

import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	//�����Ự�����ķ���
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			//��hibernate3.5֮ǰ��Ҫʹ��AnnotationConfiguration������SessionFactory�ſ���ʵ�ֻ���ע���ӳ�䡣
			//new AnnotationConfiguration().configure().buildSessionFactory();
			//��hibernate3.5����ӳ���ļ���Configuration������SessionFactory�ſ���ʵ��
			//new Configuration().configure().buildSessionFactory();
			
			//��hibernate3.5֮�󶼺ϲ���һ��ֱ��ʹ��Configuration������SessionFactory��ͬʱʵ�ֻ���ע�⣬����ӳ���ļ�����ӳ�䷽ʽ��
			return new Configuration().configure().buildSessionFactory();
			 
		}
		catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	//��ȡ�Ự�����ķ���
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
