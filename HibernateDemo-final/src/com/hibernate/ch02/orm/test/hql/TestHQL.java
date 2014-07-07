package com.hibernate.ch02.orm.test.hql;

import java.util.List;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.dao.hql.DepartmentDAO;
import com.hibernate.ch02.orm.entity.hql.Department;
import com.hibernate.ch02.orm.entity.hql.Staff;

public class TestHQL {
	//��ʼ��DepartmentDAO ���Ը��������HQL��ѯ����
	DepartmentDAO departmentDao = new DepartmentDAO();
	//1.������������
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
		staff1.setStaffName("��ǿ");
		
		Staff staff2 = new Staff();
		staff2.setStaffCode("S00002");
		staff2.setStaffName("���");
		
		Staff staff3 = new Staff();
		staff3.setStaffCode("S00003");
		staff3.setStaffName("����");
		
		Staff staff4 = new Staff();
		staff4.setStaffCode("S00004");
		staff4.setStaffName("�϶�");
		
		Staff staff5 = new Staff();
		staff5.setStaffCode("S00005");
		staff5.setStaffName("����");
		
		//���ö���֮��Ĺ�����ϵ
		department1.getStaffs().add(staff1);
		department1.getStaffs().add(staff2);
		staff1.setDepartment(department1);
		staff2.setDepartment(department1);
		
		department2.getStaffs().add(staff3);
		department2.getStaffs().add(staff5);
		staff3.setDepartment(department2);
		staff5.setDepartment(department2);
		
		
		//�־û������ݿ�
		//cascade=CascadeType.ALL ����������������
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
			
			System.out.println("���ű��: "+object[0]);
			System.out.println("��������: "+object[1]);
			
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
			System.out.println("��������:");
			System.out.println(object[0]);//������е����ݶ��᷵��
			System.out.println("������������ұ������:");
			System.out.println(object[1]);
			System.out.println("**************************************************");	
		}
		
	}
	
	//Test DepartmentDAO findDepartmentsRightOuterJoinStaffs()
		public void findDepartmentsRightOuterJoinStaffs(){
			List<Object[]> objects2 =  departmentDao.findDepartmentsRightOuterJoinStaffs();
			for (Object[] object : objects2) {
				System.out.println("********findDepartmantLeftOuterJoinUsers*********");
				System.out.println("��������:");
				System.out.println(object[0]);
				System.out.println("������������ұ������:");
				System.out.println(object[1]);//�ұ����е����ݶ��᷵��
				System.out.println("**************************************************");	
			}
		
		}
	public static void main(String[] args) {
		//1.���ô����������ݷ���
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
