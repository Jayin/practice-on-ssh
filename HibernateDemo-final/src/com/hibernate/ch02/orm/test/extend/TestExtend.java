package com.hibernate.ch02.orm.test.extend;


import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.extend.ex1.A320;
import com.hibernate.ch02.orm.entity.extend.ex1.Plane;

public class TestExtend {
	public static void main(String[] args) {
		BaseDAO<Object> dao = new BaseDAO<Object>();
		
		Plane plane = new Plane();
		plane.setPlaneCode("0001");
		plane.setPlaneName("空军1号");
		
		dao.saveObject(plane);
		
		A320  aplane = new A320();
		aplane.setPlaneCode("00002");
		aplane.setPlaneName("珍宝客机");
		aplane.setRemake("最多承载320个客人");
		
		dao.saveObject(aplane);

	}
}
