package com.hibernate.ch02.orm.test.pojo;

import java.util.Date;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.pojo.User;
import com.hibernate.utils.Sex;

public class TsetPojo 
{
	public static void main(String[] args) 
	{
		//1.�����־ò�
		BaseDAO<User> dao = new BaseDAO<User>();
		
		//2.�����־ö���User
		
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

		
		//3.�־û�֮ǰ����ѳ־ö������õ������ļ�
		
		//4.�־û�
		dao.saveObject(user);
	}
}	
