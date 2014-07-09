package com.ssh.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.demo.entity.User;
import com.ssh.demo.service.IUserService;

public class TestUserService {
	public static void main(String[] args) {
		User user = new User();
		user.setUserName("Admin");
		user.setPassword("Admin");
		
		User user2 = new User();
		user2.setUserName("Guest");
		user2.setPassword("Guest");
		//硬编码方式：
		ApplicationContext  context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		IUserService service = (IUserService) context.getBean("userService");
		
		service.saveUser(user);
		service.saveUser(user2);
		
		
		System.out.println(service.findAllUsers().size());
	}
}
