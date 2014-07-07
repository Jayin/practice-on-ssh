package com.hibernate.ch02.orm.dao.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.hql.Staff;
import com.hibernate.utils.HibernateUtil;


public class StaffDAO extends BaseDAO<Staff> 
{
	 //HQL语句3种传值的方式
		public List<Staff> findStaffByName(String staffName){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			//2.通过Session 会话 开始一个事务
			session.beginTransaction();
			//3.事务内容（CURD）
			
			//Examples1 “+”连接拼装HQL 不建议使用 SQL注入
			//Query query = session.createQuery("From Staff staff Where staff.staffName ='"+staffName+"'");
			
			//Examples2 ?占位符传值：预编译 高效 防止SQL注入
//			Query query = session.createQuery("From Staff staff Where staff.staffName = ?");
//			query.setString(0, staffName);//注意JDBC从1开始,Hibernate的Query从0开始。
			
			
			//Examples3 最佳 命名参数传值 ：预编译 高效 防止SQL注入
			Query query = session.createQuery("From Staff staff Where staff.staffName = :staffName");
			query.setString("staffName", staffName);


			List<Staff> staffs = query.list();
			//4.提交事务
			session.getTransaction().commit();
			return staffs;
		}
}
