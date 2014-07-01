package com.spring.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public class UserDao implements IUserDao {
	

	@Override
	public void add(com.spring.entity.User user) {
		System.out.println("UserDao add method");
	}

	@Override
	public void delete(Long id) {
		System.out.println("UserDao delete method");
	}

	@Override
	public void findById(Long id) {
		System.out.println("UserDao findById method");
	}

	@Override
	public void update(User user) {
		System.out.println("UserDao update method");
	}

}