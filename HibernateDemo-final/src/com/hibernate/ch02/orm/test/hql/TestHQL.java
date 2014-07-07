package com.hibernate.ch02.orm.test.hql;

import java.util.List;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.dao.hql.DepartmentDAO;
import com.hibernate.ch02.orm.entity.hql.Department;
import com.hibernate.ch02.orm.entity.hql.Staff;

public class TestHQL {
	//初始化DepartmentDAO 测试该类的所有HQL查询方法
	DepartmentDAO departmentDao = new DepartmentDAO();
	//1.创建测试数据
	public void createTestData(){
		Department  department1 = new Department();
		department1.setDepartmantCode("D000001");
		department1.setDepartmantName("IT Department");

		
		Department  department2 = new Department();
		department2.setDepartmantCode("D000002");
		department2.setDepartmantName("MARKET Department");
		
		Department  department3 = new Department();
		department3.setDepartmantCode("D000003");
		department3.setDepartmantName("Orther Department");
		
		Staff staff1 = new Staff();
		staff1.setStaffCode("S00001");
		staff1.setStaffName("陈强");
		
		Staff staff2 = new Staff();
		staff2.setStaffCode("S00002");
		staff2.setStaffName("李俊材");
		
		Staff staff3 = new Staff();
		staff3.setStaffCode("S00003");
		staff3.setStaffName("贲月");
		
		Staff staff4 = new Staff();
		staff4.setStaffCode("S00004");
		staff4.setStaffName("嫦娥");
		
		Staff staff5 = new Staff();
		staff5.setStaffCode("S00005");
		staff5.setStaffName("熊威");
		
		//设置对象之间的关联关系
		department1.getStaffs().add(staff1);
		department1.getStaffs().add(staff2);
		staff1.setDepartment(department1);
		staff2.setDepartment(department1);
		
		department2.getStaffs().add(staff3);
		department2.getStaffs().add(staff5);
		staff3.setDepartment(department2);
		staff5.setDepartment(department2);
		
		
		//持久化到数据库
		//cascade=CascadeType.ALL 级联创建关联对象
		BaseDAO<Object> dao = new BaseDAO<Object>();
		
		dao.saveObject(department1);
		dao.saveObject(department2);
		dao.saveObject(department3);

		dao.saveObject(staff4);
	}
	//1.Test DepartmentDAO findAllDepartments()
	public void findAllDepartments(){
		 List<Department>  departments = departmentDao.findAllDepartments();
		 for (Department department : departments) {
			System.out.println("***********************Test FindAllDepartments************************");
			System.out.println(department);
			System.out.println("**********************************************************************");
			
		}
		 
	}
	
	//2.Test DepartmentDAO findColumnByDepartment()
	public void findColumnByDepartment(){
		List<Object[]> objects = departmentDao.findColumnByDepartment();
		for (Object[] object : objects) {
			System.out.println("*************Test findColumnByDepartment()************");
			
			System.out.println("部门编号: "+object[0]);
			System.out.println("部门名称: "+object[1]);
			
			System.out.println("******************************************************");
		}
	}
		
	//3.Test DepartmentDAO findNewEntityByDepartment()
	public void findNewEntityByDepartment(){
		List<Department> departments = departmentDao.findNewEntityByDepartment();
		for (Department department : departments) {
			System.out.println("*************Test findNewEntityByDepartment()************");
			
			System.out.println(department);
					
			System.out.println("******************************************************");
		}
	}
	
	//4.Test DepartmentDAO findDepartmentInnerJoinStaffs()
	public void findDepartmentsInnerJoinStaffs(){
		List<Department> departments = departmentDao.findDepartmentsInnerJoinStaffs();
		
		for (Department department : departments) {
			System.out.println("****************Test findDepartmentInnerJoinStaffs()*************");

			System.out.println(department);

			System.out.println("******************************************************");
		}
	}
	
	//Test DepartmentDAO findDepartmentsLeftOuterJoinStaffs()
	public void findDepartmentsLeftOuterJoinStaffs(){
	
		List<Object[]> objects1 =  departmentDao.findDepartmentsLeftOuterJoinStaffs();
		for (Object[] object : objects1) {
			System.out.println("********findDepartmantLeftOuterJoinUsers*********");
			System.out.println("左表的数据:");
			System.out.println(object[0]);//左表所有的数据都会返回
			System.out.println("左表左外连接右表的数据:");
			System.out.println(object[1]);
			System.out.println("**************************************************");	
		}
		
	}
	
	//Test DepartmentDAO findDepartmentsRightOuterJoinStaffs()
		public void findDepartmentsRightOuterJoinStaffs(){
			List<Object[]> objects2 =  departmentDao.findDepartmentsRightOuterJoinStaffs();
			for (Object[] object : objects2) {
				System.out.println("********findDepartmantLeftOuterJoinUsers*********");
				System.out.println("左表的数据:");
				System.out.println(object[0]);
				System.out.println("左表右外连接右表的数据:");
				System.out.println(object[1]);//右表所有的数据都会返回
				System.out.println("**************************************************");	
			}
		
		}
	public static void main(String[] args) {
		//1.调用创建测试数据方法
		TestHQL testDemo = new TestHQL();
		testDemo.createTestData();
		
//		testDemo.findAllDepartments();
//		testDemo.findColumnByDepartment();
//		testDemo.findNewEntityByDepartment();	
//		testDemo.findDepartmentsInnerJoinStaffs();
//		testDemo.findDepartmentsLeftOuterJoinStaffs();
		testDemo.findDepartmentsRightOuterJoinStaffs();
	}
}
