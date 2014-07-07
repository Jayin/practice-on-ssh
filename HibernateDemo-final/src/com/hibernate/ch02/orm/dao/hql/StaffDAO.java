package com.hibernate.ch02.orm.dao.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.hql.Staff;
import com.hibernate.utils.HibernateUtil;


public class StaffDAO extends BaseDAO<Staff> 
{
	 //HQL���3�ִ�ֵ�ķ�ʽ
		public List<Staff> findStaffByName(String staffName){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			//2.ͨ��Session �Ự ��ʼһ������
			session.beginTransaction();
			//3.�������ݣ�CURD��
			
			//Examples1 ��+������ƴװHQL ������ʹ�� SQLע��
			//Query query = session.createQuery("From Staff staff Where staff.staffName ='"+staffName+"'");
			
			//Examples2 ?ռλ����ֵ��Ԥ���� ��Ч ��ֹSQLע��
//			Query query = session.createQuery("From Staff staff Where staff.staffName = ?");
//			query.setString(0, staffName);//ע��JDBC��1��ʼ,Hibernate��Query��0��ʼ��
			
			
			//Examples3 ��� ����������ֵ ��Ԥ���� ��Ч ��ֹSQLע��
			Query query = session.createQuery("From Staff staff Where staff.staffName = :staffName");
			query.setString("staffName", staffName);


			List<Staff> staffs = query.list();
			//4.�ύ����
			session.getTransaction().commit();
			return staffs;
		}
}
