package com.hibernate.ch01.dao;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.ch01.entity.Event;
import com.hibernate.utils.HibernateUtil;

//Event对象的CURD
public class EventDAO 
{
	//getCurrentSession与openSession的区别：
		//  1)getCurrentSession()创建的session会绑定到当前线程，而openSession()不会。
		//	2)getCurrentSession()在事务提交或事务回滚后会自动关闭session,而openSession()需要在finally内手工关闭。
				//	在getCurrentSession()本地事务（JDBC事务）时候需要配置：
				//	<property name="current_session_context_class">thread</property>
				//	在getCurrentSession()全局事务（JTA事务）时候需要配置：
				//	<property name="current_session_context_class">jta</property>
		//	3)getCurrentSession()使用当前session,openSession()新建一个session.
	public void createEvent(Event event)
	{
		//1.通过工具类获取一个会话对象
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 //Session session2 = HibernateUtil.getSessionFactory().openSession();
		//2.通过会话开始一个事务（一次事务包含一到多个业务，要么全部成功，要么全部失败）
		 Transaction tx = session.beginTransaction();
		 try {
			//3.通过session执行具体业务：
			session.save(event);	//缓存中
			
			//4.提交事务：
			tx.commit();//真正的把缓存中实体对象映射到数据库
			//session.getTransaction().commit();//与tx.commit();等效。
			
		} catch (Exception ex) {
			//5.事务回滚：事务过程中一旦发生错误回滚所有操作。
			tx.rollback();
			ex.printStackTrace();
		}
//		finally{
//			session.close();//只有openSession()需要在finally内手工关闭。
//		}
		
	}
	
	//通过openSession不需要事务实现自动提交(hibernate3.3以后已经不建议这样使用,提倡通过事物管理操作过程.)
	public void createEvent2(Event event)
	{
		//1.通过工具类获取一个会话对象
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 try {
			//session.connection().setAutoCommit(true);//hibernate3.3以后默认不会自动提交
			session.save(event);	//缓存中并自动提交
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			session.close();//只有openSession()需要在finally内手工关闭。
		}
		
	}
	//Hibernate对象三种状态
	public void createEvent3()
	{

		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {
			//瞬时状态
				Event event = new Event();
				event.setTitle("郊游");
				event.setDate(new Date());
			//瞬时状态
			
			
			session.save(event);
			//持久状态
			
			tx.commit();
		} catch (Exception ex) {
			
			tx.rollback();
			ex.printStackTrace();
		}
		// session.close();的时候托管状态
	}
	
	//session.save()
	public void testSave(){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {
			//瞬时状态例子1
//				Event event = new Event();
//				event.setTitle("郊游");
//				event.setDate(new Date());
			 
			//瞬时状态例子2
//			 Event event = new Event();
//			 event.setTitle("去旅游2");
//			 event.setDate(new Date());
//			 //event.setId(1L);//无效，主要和id的生成策略有关。
			 
			 
			//持久状态例子：数据库中存在的，
			Event event = (Event)session.get(Event.class, 1L);
			event.setTitle("去旅游");//必须发生改变才会update

			session.save(event);//执行时候使用update
			//持久状态
			
			tx.commit();
		} catch (Exception ex) {
			
			tx.rollback();
			ex.printStackTrace();
		}
	}
	
	//session.delete()
	public void testDelete(){//以后只需要传Long id
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {

			//持久状态例子：数据库中存在的
			Event event = (Event)session.get(Event.class, 1L);//先select

			//瞬时状态例子:不建议大家这样直接删除瞬时状态的对象。
//				 Event event = new Event();
//				 event.setId(2L);
			 
			session.delete(event);//根据id到session寻找匹配的持久化对象
			//持久状态
			
			tx.commit();//执行delete语句
		} catch (Exception ex) {
			
			tx.rollback();
			ex.printStackTrace();
		}
		 //close()方法时才会从Session的缓存中删除该对象。
	}
		
	//session.update()
	public void testUpdate(){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {

			//持久状态例子：如果持久对象与数据库保持一致则不做任何操作。如果改变了则执行update
//			Event event = (Event)session.get(Event.class, 1L);//先select
//			event.setTitle("去旅游");
			//瞬时状态例子:如果瞬时对象不做任何修改操作。在session中一旦关联上，则无论如何都会执行update
			 Event event = new Event();
			 event.setId(1L);
			 
			session.update(event);//
			//持久状态
			
			tx.commit();//执行delete语句
		} catch (Exception ex) {
			
			tx.rollback();
			ex.printStackTrace();
		}
		 //close()方法时才会从Session的缓存中删除该对象。
	}
	
	//session.load()
		public void testLoad(){
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 Transaction tx = session.beginTransaction();
			 try {

				//持久状态例子：如果持久对象与数据库保持一致则不做任何操作。如果改变了则执行update
				Event event = (Event)session.load(Event.class, 1L);
				//与get的区别：只有访问对象内容的时候才真正执行select,load性能比get好，减轻数据库的负担
				
				//可注释下面这行代码看区别
				System.out.println(event.getTitle());
				tx.commit();
			} catch (Exception ex) {
				
				tx.rollback();
				ex.printStackTrace();
			}
			
		}
}
