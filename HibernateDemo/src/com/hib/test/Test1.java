package com.hib.test;

import java.util.Date;

import com.hib.dao.EventDao;
import com.hib.entity.Event;

public class Test1 {
	public static void main(String[] args) {
		Event event = new Event();
		event.setTitle("title");
		event.setDate(new Date());
		
		new EventDao().addEvent(event);
	}
}
