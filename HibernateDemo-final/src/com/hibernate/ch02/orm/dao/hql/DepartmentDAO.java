package com.hibernate.ch02.orm.dao.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.hql.Department;
import com.hibernate.utils.HibernateUtil;

public class DepartmentDAO extends BaseDAO<Department> 
{
	//��ѯ����:
	//1.��ʵ�����ѯ
	public List<Department> findAllDepartments(){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 List<Department> departments = null;
		 try {
			 departments = session.createQuery("from Department").list();//from Department �൱��select * from t_department
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		
		return departments;
	}
	
	//2.��ʵ�������Բ�ѯ
	public List<Object[]> findColumnByDepartment(){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 List<Object[]> departments = null;
		 try {
			 departments = session.createQuery("Select department.departmantCode,department.departmantName From Department department").list();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		
		return departments;	
	}
	
	//3.ʹ��ʵ����������Ĺ��췽����ѯ
	public List<Department> findNewEntityByDepartment(){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 List<Department> departments = null;
		 try {
			 departments = session.createQuery("Select new Department(department.departmantCode,department.departmantName) From Department department").list();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return departments;
	}
	
	//HQL���3�ִ�ֵ�ķ�ʽ
	//���StaffDAO
	
	//Examples JOIN��inner join��
		//1.��Department��Staff������дtoString()
	    //2.��findDepartmants�����������Ƚ�
	    //3.����Departmant�ڵ� fetch=FetchType.LAZY 
	    //4.fetch �ؼ���Ч����Ч�� fetch=FetchType.EAGER (���飺����������ѯʱ��ʹ��)
		//5.ʹ��fetch�󷵻�department.staffs�������������Բ�ѯ��ʹ��Object[]���շ���
	
	
//	��ҪhibernateĬ�ϵ���������Ҫ��ʱ������Ը���ô�죿�����fetch�Ĺ��ܡ�
//	���ǿ��԰�fetch��lazy="true"�Ĺ�ϵ���Ϊ�����еı��ʽ����������ʽ����
//	fetch�ؼ���ǿ��Hibernate���м���������
//	��:from TUser user inner join fetch user.addresses
//	 �����"fetch"�ؼ��ֱ���TAddress��������Ժ�������䵽��Ӧ��TUser�����С�
	
	
	public List<Department> findDepartmentsInnerJoinStaffs(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//2.ͨ��Session �Ự ��ʼһ������
		session.beginTransaction();
		//3.�������ݣ�CURD��
		List<Department> departments = session.createQuery("From Department department INNER JOIN  fetch department.staffs").list();
		
		//List<Staff> staffs = session.createQuery("From Staff staff INNER JOIN  fetch staff.department").list();//˫���ʱ����Դ�staff���ҵ�������department
		
		//4.�ύ����
		session.getTransaction().commit();
		//5.���ؽ�������б�
		return departments;
	}
	
	//Examples LEFT OUTER JOIN
		//1.����Departmant�ڵ� fetch=FetchType.LAZY 
		//2.��Departmant ��toString()����staffs����ע��
	public List<Object[]> findDepartmentsLeftOuterJoinStaffs(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//2.ͨ��Session �Ự ��ʼһ������
		session.beginTransaction();
		//3.�������ݣ�CURD��
		List<Object[]> objects = session.createQuery("From Department department LEFT OUTER JOIN department.staffs").list();
		//List<Department> objects = session.createQuery("From Department department LEFT OUTER JOIN fetch department.staffs").list();//���������������
		//4.�ύ����
		session.getTransaction().commit();
		//5.���ؽ�������б�
		return objects;
	}
	
	//Examples Right OUTER JOIN
	//1.��Staff ��toString()����department����ע��
	 //fetch����ʹ�����������ӣ�fetchֻ��ʹ�����������Ӻ�������
	public List<Object[]> findDepartmentsRightOuterJoinStaffs(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//2.ͨ��Session �Ự ��ʼһ������
		session.beginTransaction();
		//3.�������ݣ�CURD��
		List<Object[]> objects = session.createQuery("From Department department Right OUTER JOIN department.staffs").list();
		//4.�ύ����
		session.getTransaction().commit();
		//5.���ؽ�������б�
		return objects;
	}
}
