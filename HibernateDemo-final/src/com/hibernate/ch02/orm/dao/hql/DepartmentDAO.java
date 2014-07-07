package com.hibernate.ch02.orm.dao.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.hql.Department;
import com.hibernate.utils.HibernateUtil;

public class DepartmentDAO extends BaseDAO<Department> 
{
	//查询方法:
	//1.按实体类查询
	public List<Department> findAllDepartments(){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 List<Department> departments = null;
		 try {
			 departments = session.createQuery("from Department").list();//from Department 相当于select * from t_department
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		
		return departments;
	}
	
	//2.按实体类属性查询
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
	
	//3.使用实体类带参数的构造方法查询
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
	
	//HQL语句3种传值的方式
	//详见StaffDAO
	
	//Examples JOIN（inner join）
		//1.在Department与Staff类中重写toString()
	    //2.与findDepartmants（）方法做比较
	    //3.设置Departmant内的 fetch=FetchType.LAZY 
	    //4.fetch 关键字效果等效于 fetch=FetchType.EAGER (建议：附加条件查询时候使用)
		//5.使用fetch后返回department.staffs对象，若果按属性查询则使用Object[]接收返回
	
	
//	想要hibernate默认的性能又想要临时的灵活性该怎么办？这就是fetch的功能。
//	我们可以把fetch与lazy="true"的关系类比为事务当中的编程式事务与声明式事务。
//	fetch关键字强制Hibernate进行集合填充操作
//	如:from TUser user inner join fetch user.addresses
//	 这里的"fetch"关键字表明TAddress对象读出以后立即填充到对应的TUser对象中。
	
	
	public List<Department> findDepartmentsInnerJoinStaffs(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//2.通过Session 会话 开始一个事务
		session.beginTransaction();
		//3.事务内容（CURD）
		List<Department> departments = session.createQuery("From Department department INNER JOIN  fetch department.staffs").list();
		
		//List<Staff> staffs = session.createQuery("From Staff staff INNER JOIN  fetch staff.department").list();//双向的时候可以从staff查找到关联的department
		
		//4.提交事务
		session.getTransaction().commit();
		//5.返回结果集合列表
		return departments;
	}
	
	//Examples LEFT OUTER JOIN
		//1.设置Departmant内的 fetch=FetchType.LAZY 
		//2.把Departmant 内toString()关于staffs部分注释
	public List<Object[]> findDepartmentsLeftOuterJoinStaffs(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//2.通过Session 会话 开始一个事务
		session.beginTransaction();
		//3.事务内容（CURD）
		List<Object[]> objects = session.createQuery("From Department department LEFT OUTER JOIN department.staffs").list();
		//List<Department> objects = session.createQuery("From Department department LEFT OUTER JOIN fetch department.staffs").list();//有填充和无填充区别
		//4.提交事务
		session.getTransaction().commit();
		//5.返回结果集合列表
		return objects;
	}
	
	//Examples Right OUTER JOIN
	//1.把Staff 内toString()关于department部分注释
	 //fetch不能使用在右外连接，fetch只能使用在左外连接和内连接
	public List<Object[]> findDepartmentsRightOuterJoinStaffs(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//2.通过Session 会话 开始一个事务
		session.beginTransaction();
		//3.事务内容（CURD）
		List<Object[]> objects = session.createQuery("From Department department Right OUTER JOIN department.staffs").list();
		//4.提交事务
		session.getTransaction().commit();
		//5.返回结果集合列表
		return objects;
	}
}
