package com.hibernate.ch02.orm.test.extend;

import java.util.Date;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.extend.ex2.Orders;

public class TestExtend2 {
	public static void main(String[] args) {
		BaseDAO<Object> dao = new BaseDAO<Object>();
		

		Orders order = new Orders();
		order.setCreater("sailer");
		order.setCreateTime(new Date());
		order.setUpdater("sailer");
		order.setUpdateTime(new Date());
		order.setRemark("±¸×¢");
		order.setDescription("ÃèÊö");
		
		dao.saveObject(order);
		
	}
}
