package com.hib.annotation.test;

import com.hib.annotation.dao.UserDao;
import com.hib.annotation.entity.User;

public class TestUser {
	public void add(){
		UserDao u =  new UserDao();
		for(int i=0;i<10;i++){
			User user = new User();
			user.setName("user_"+i);
			user.setUserId(i);
			user.setPsw(i+100);
			u.add(user);
		}
		
	}

	public void update() {
		//Name: "user_"+i -> "user"+i
		UserDao u =  new UserDao();
		for(int i=1;i<=10;i++){
			User user = new User();
			user.setId(Long.valueOf(i));
			user.setName("user"+i);
			user.setUserId(i-1);
			u.update(user);
		}
		
	}

	public static void main(String[] args) {
		TestUser t = new TestUser();
//		t.add();
		t.update();
	}
}
