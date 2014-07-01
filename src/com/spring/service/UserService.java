package com.spring.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.spring.dao.IUserDao;
import com.spring.entity.User;
@Scope("prototype")
@Service
public class UserService implements IUserService {
	
	@Resource
	IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		System.out.println("UserService add method");
		userDao.add(user);
	}

	@Override
	public void delete(Long id) {
		System.out.println("UserService delete method");
		userDao.delete(id);
	}

	@Override
	public void findById(Long id) {
		System.out.println("UserService find By Id method");
		userDao.findById(id);
	}

	@Override
	public void update(User user) {
		System.out.println("UserService update method");
		userDao.update(user);
	}

}
