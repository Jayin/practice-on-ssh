package com.hib.dao;

import java.util.List;

import org.hibernate.Session;

import com.hib.entity.Event;
import com.hib.utils.HibernateUtil;

public class EventDao implements IEventDao {

	@Override
	public void add(Event event) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(event);

		session.getTransaction().commit();
	}

	@Override
	public void update(Event event) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(event);
		session.getTransaction().commit();
	}

	@Override
	public void delete(Event event) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(event);
		session.getTransaction().commit();
	}

	// 查询所有？
	public Event findById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Event result = (Event) session.get(Event.class, id);

		session.getTransaction().commit();
		return result;
	}

}
