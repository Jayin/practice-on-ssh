package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.entity.User;
import com.spring.service.IUserService;

public class TestAOP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create and configure beans
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IUserService service = (IUserService) context.getBean("userService");
		//或者IUserService service = ontext.getBean("userService",IUserService.class);
		User user = new User();
		user.setUserName("Jayin");
		service.add(user);
	}

}
