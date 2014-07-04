package com.hib.annotation.entity;

import com.hib.annotation.dao.DogDao;

public class TestMapsupperclass {
	
	public static void main(String[] args) {
		Dog d = new Dog();
		d.setName("MK2");
		d.setWord("wowowo");
		
		DogDao dao = new DogDao();
		dao.add(d);
	}
}
