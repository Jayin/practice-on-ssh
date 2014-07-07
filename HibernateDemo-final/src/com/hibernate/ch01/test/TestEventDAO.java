package com.hibernate.ch01.test;

import java.util.Date;

import com.hibernate.ch01.dao.EventDAO;
import com.hibernate.ch01.entity.Event;

public class TestEventDAO 
{
	public static void main(String[] args) 
	{
		
		EventDAO dao = new EventDAO();
		
		//����ʵ��
		Event event = new Event();
		event.setTitle("����");
		event.setDate(new Date());
		
		//ͨ���־ò�ʵ���־û������ݿ�
		dao.createEvent(event);
		//dao.createEvent2(event);
		
		//dao.testSave();
		//dao.testDelete();
		//dao.testUpdate();
		dao.testLoad();
	}
}
