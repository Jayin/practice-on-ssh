package com.hibernate.ch02.orm.test.pojo;

import java.util.Date;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.pojo.User;
import com.hibernate.utils.Sex;

public class TsetPojo 
{
	public static void main(String[] args) 
	{
		//1.创建持久层
		BaseDAO<User> dao = new BaseDAO<User>();
		
		//2.创建持久对象User
		
		byte[] b = new byte[10];
				
		User user = new User();
		//user.setId(1L);
		user.setUserName("admin");
		user.setPassword("admin");
		user.setTran("tean");
		user.setCreateTime(new Date());
		user.setSex(Sex.BOY);
		user.setRemake("Hello");
		user.setFullCode(b);

		
		//3.持久化之前必须把持久对象配置到配置文件
		
		//4.持久化
		dao.saveObject(user);
	}
}	
