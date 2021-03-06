package com.spring.test;

import com.spring.dao.UserDao;
import com.spring.entity.User;
import com.spring.service.UserService;

public class TestUserService {
	public static void main(String[] args) {
		UserService userService = new UserService();
		userService.setUserDao(new UserDao());
		User user = new User();

		userService.add(user);
		System.out.println();

		userService.update(user);
		System.out.println();

		userService.delete(1L);
		System.out.println();

		userService.findById(2L);
	}
}
