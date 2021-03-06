package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.entity.User;
import com.spring.service.UserService;

public class TestIOC {

	public static void main(String[] args) {

		// create and configure beans
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		UserService service = context.getBean("userService",UserService.class);
		UserService service1 = context.getBean("userService",UserService.class);
		UserService service2 = context.getBean("userService",UserService.class);
		service.add(new User());
		service1.add(new User());
		service2.add(new User());
		
	}

}
