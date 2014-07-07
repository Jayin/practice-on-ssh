package com.hibernate.ch02.orm.dao.pojo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.pojo.User;
import com.hibernate.utils.HibernateUtil;

public class UserDAO extends BaseDAO<User> {
	public User findUserById(Long id)
	{
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 User user=null;
		 try {
			user = (User)session.get(User.class,id);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}
	
	//findByName()...
	//etc...
}
