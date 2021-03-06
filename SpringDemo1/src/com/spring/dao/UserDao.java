package com.spring.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;


@Scope("prototype")
@Repository
public class UserDao implements IUserDao {
	
	public UserDao(){
		System.out.println("init");
	}

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
