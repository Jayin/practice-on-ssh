package com.hibernate.ch02.orm.test.many2one;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.many2one.Company;
import com.hibernate.ch02.orm.entity.many2one.Flight;

public class Test {
	public static void main(String[] args) {
		BaseDAO<Object> dao = new BaseDAO<Object>();
		Company company = new Company();
		company.setCompanyName("�й����չ�˾");
		dao.saveObject(company);
		
		Flight flight1 = new Flight();
		flight1.setFlightCode("F00001");
		flight1.setFlightName("���ʺ���");
		
		Flight flight2 = new Flight();
		flight2.setFlightCode("F00002");
		flight2.setFlightName("���ں���");
		
		Flight flight3 = new Flight();
		flight3.setFlightCode("F00002");
		flight3.setFlightName("�Ϻ�ר��");
		
		
		//����������ϵ
		flight1.setCompany(company);//flight1��������company
		flight2.setCompany(company);//flight2��������company
		flight3.setCompany(company);//flight3��������company
		
		
		//�־û������ݿ�
		dao.saveObject(flight1);
		dao.saveObject(flight2);
		dao.saveObject(flight3);
	}
}
