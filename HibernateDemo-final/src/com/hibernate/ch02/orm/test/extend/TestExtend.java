package com.hibernate.ch02.orm.test.extend;


import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.extend.ex1.A320;
import com.hibernate.ch02.orm.entity.extend.ex1.Plane;

public class TestExtend {
	public static void main(String[] args) {
		BaseDAO<Object> dao = new BaseDAO<Object>();
		
		Plane plane = new Plane();
		plane.setPlaneCode("0001");
		plane.setPlaneName("�վ�1��");
		
		dao.saveObject(plane);
		
		A320  aplane = new A320();
		aplane.setPlaneCode("00002");
		aplane.setPlaneName("�䱦�ͻ�");
		aplane.setRemake("������320������");
		
		dao.saveObject(aplane);

	}
}
