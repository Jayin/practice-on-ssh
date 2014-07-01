package com.spring.dao;

import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public class HibernateUserDao implements IUserDao {

	
	@Override
	public void add(com.spring.entity.User user) {
		System.out.println("HibernateUserDao add method");
	}

	@Override
	public void delete(Long id) {
		System.out.println("HibernateUserDao delete method");
	}

	@Override
	public void findById(Long id) {
		System.out.println("HibernateUserDao findById method");
	}

	@Override
	public void update(User user) {
		System.out.println("HibernateUserDao update method");
	}

}
