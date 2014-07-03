package com.hib.test;

import java.util.Date;
import java.util.List;

import com.hib.dao.EventDao;
import com.hib.entity.Event;

public class Test1 {
	private EventDao eventDao = new EventDao();

	public void add() {
		Event event = new Event();
		event.setTitle("title");
		event.setDate(new Date());

		for (int i = 0; i < 10; i++) {
			event.setTitle("title " + i);
			eventDao.add(event);
		}
	}

	public void delete(Event e) {
		eventDao.delete(e);
	}

	public void update() {

	}

	public Event findById(Long id) {
		Event e = eventDao.findById(id);
		System.out.println(e.toString());
		return e;
	}

	public static void main(String[] args) {
		Test1 t = new Test1();
		// t.add();
		t.findById(1L);
		t.delete(t.findById(1L));
	}
}
