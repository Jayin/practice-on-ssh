package com.hib.dao.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import com.hib.utils.HibernateUtil;

public class BaseDao<T> implements IBaseDao<T> {
	private Class<T> entity;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		// get T
        this.entity =  (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())
        .getActualTypeArguments()[0]; 
	}

	@Override
	public void add(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(object);

		session.getTransaction().commit();

	}

	@Override
	public void update(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
	}

	@Override
	public void delete(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		T result = (T) session.get(this.entity, id);
		session.getTransaction().commit();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	 
		List<T> result =  session.createQuery("from "+this.entity.getName()).list();

		session.getTransaction().commit();
		return result;
	}
	
}
