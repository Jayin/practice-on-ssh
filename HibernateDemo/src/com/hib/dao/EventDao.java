package com.hib.dao;

import java.util.List;

import org.hibernate.Session;

import com.hib.dao.base.BaseDao;
import com.hib.entity.Event;
import com.hib.utils.HibernateUtil;

public class EventDao extends BaseDao<Event> implements IEventDao<Event> {
	// implement IEventDao<Event>
	@Override
	public void deleteAll() {
		List<Event> es = this.findAll();
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (Event e : es) {
			session.delete(e);
		}
		session.getTransaction().commit();

	}

}
