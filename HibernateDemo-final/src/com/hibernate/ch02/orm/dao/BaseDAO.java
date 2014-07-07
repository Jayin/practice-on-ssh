/**
 * @author Sailer
 * 持久层的基础服务类
 * 提供公共的CURD方法
 */
package com.hibernate.ch02.orm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;


public class BaseDAO <T>
{
	public void saveObject(T object)
	{
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {
			session.save(object);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
	}
	
	public void updateObject(T object)
	{
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {
			session.update(object);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
	}
	
	public void deleteObject(T object)
	{
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {
			session.delete(object);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
	}
	
	//findById()...
	//etc...
}
