package com.hib.dao;

import org.hibernate.Session;

import com.hib.entity.Event;
import com.hib.utils.HibernateUtil;

public class EventDao {

	public void addEvent(Event event) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(event);
		
		session.getTransaction().commit();
	}

}
