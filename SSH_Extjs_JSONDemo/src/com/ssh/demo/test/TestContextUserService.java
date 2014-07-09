package com.ssh.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.ssh.demo.entity.User;
import com.ssh.demo.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestContextUserService extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private IUserService userService;
	
	//针对业务层的每个业务方法编写测试用例
	@Test
	public void testSaveUser(){
		User user = new User();
		user.setUserName("Admin");
		user.setPassword("Admin");
		
		userService.saveUser(user);
	}
	
	//@Test//可以通过屏蔽注解来暂停调试
	public void testUpdateUser(){
		
	}
}
