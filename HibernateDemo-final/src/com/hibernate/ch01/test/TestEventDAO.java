package com.hibernate.ch01.test;

import java.util.Date;

import com.hibernate.ch01.dao.EventDAO;
import com.hibernate.ch01.entity.Event;

public class TestEventDAO 
{
	public static void main(String[] args) 
	{
		
		EventDAO dao = new EventDAO();
		
		//对象实例
		Event event = new Event();
		event.setTitle("郊游");
		event.setDate(new Date());
		
		//通过持久层实例持久化到数据库
		dao.createEvent(event);
		//dao.createEvent2(event);
		
		//dao.testSave();
		//dao.testDelete();
		//dao.testUpdate();
		dao.testLoad();
	}
}
