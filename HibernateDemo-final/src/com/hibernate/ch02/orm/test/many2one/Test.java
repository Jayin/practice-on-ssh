package com.hibernate.ch02.orm.test.many2one;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.many2one.Company;
import com.hibernate.ch02.orm.entity.many2one.Flight;

public class Test {
	public static void main(String[] args) {
		BaseDAO<Object> dao = new BaseDAO<Object>();
		Company company = new Company();
		company.setCompanyName("中国航空公司");
		dao.saveObject(company);
		
		Flight flight1 = new Flight();
		flight1.setFlightCode("F00001");
		flight1.setFlightName("国际航班");
		
		Flight flight2 = new Flight();
		flight2.setFlightCode("F00002");
		flight2.setFlightName("国内航班");
		
		Flight flight3 = new Flight();
		flight3.setFlightCode("F00002");
		flight3.setFlightName("上海专航");
		
		
		//建立关联关系
		flight1.setCompany(company);//flight1级联更新company
		flight2.setCompany(company);//flight2级联更新company
		flight3.setCompany(company);//flight3级联更新company
		
		
		//持久化到数据库
		dao.saveObject(flight1);
		dao.saveObject(flight2);
		dao.saveObject(flight3);
	}
}
