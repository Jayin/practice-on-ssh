package com.hibernate.ch01.dao;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.ch01.entity.Event;
import com.hibernate.utils.HibernateUtil;

//Event�����CURD
public class EventDAO 
{
	//getCurrentSession��openSession������
		//  1)getCurrentSession()������session��󶨵���ǰ�̣߳���openSession()���ᡣ
		//	2)getCurrentSession()�������ύ������ع�����Զ��ر�session,��openSession()��Ҫ��finally���ֹ��رա�
				//	��getCurrentSession()��������JDBC����ʱ����Ҫ���ã�
				//	<property name="current_session_context_class">thread</property>
				//	��getCurrentSession()ȫ������JTA����ʱ����Ҫ���ã�
				//	<property name="current_session_context_class">jta</property>
		//	3)getCurrentSession()ʹ�õ�ǰsession,openSession()�½�һ��session.
	public void createEvent(Event event)
	{
		//1.ͨ���������ȡһ���Ự����
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 //Session session2 = HibernateUtil.getSessionFactory().openSession();
		//2.ͨ���Ự��ʼһ������һ���������һ�����ҵ��Ҫôȫ���ɹ���Ҫôȫ��ʧ�ܣ�
		 Transaction tx = session.beginTransaction();
		 try {
			//3.ͨ��sessionִ�о���ҵ��
			session.save(event);	//������
			
			//4.�ύ����
			tx.commit();//�����İѻ�����ʵ�����ӳ�䵽���ݿ�
			//session.getTransaction().commit();//��tx.commit();��Ч��
			
		} catch (Exception ex) {
			//5.����ع������������һ����������ع����в�����
			tx.rollback();
			ex.printStackTrace();
		}
//		finally{
//			session.close();//ֻ��openSession()��Ҫ��finally���ֹ��رա�
//		}
		
	}
	
	//ͨ��openSession����Ҫ����ʵ���Զ��ύ(hibernate3.3�Ժ��Ѿ�����������ʹ��,�ᳫͨ����������������.)
	public void createEvent2(Event event)
	{
		//1.ͨ���������ȡһ���Ự����
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 try {
			//session.connection().setAutoCommit(true);//hibernate3.3�Ժ�Ĭ�ϲ����Զ��ύ
			session.save(event);	//�����в��Զ��ύ
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			session.close();//ֻ��openSession()��Ҫ��finally���ֹ��رա�
		}
		
	}
	//Hibernate��������״̬
	public void createEvent3()
	{

		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {
			//˲ʱ״̬
				Event event = new Event();
				event.setTitle("����");
				event.setDate(new Date());
			//˲ʱ״̬
			
			
			session.save(event);
			//�־�״̬
			
			tx.commit();
		} catch (Exception ex) {
			
			tx.rollback();
			ex.printStackTrace();
		}
		// session.close();��ʱ���й�״̬
	}
	
	//session.save()
	public void testSave(){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {
			//˲ʱ״̬����1
//				Event event = new Event();
//				event.setTitle("����");
//				event.setDate(new Date());
			 
			//˲ʱ״̬����2
//			 Event event = new Event();
//			 event.setTitle("ȥ����2");
//			 event.setDate(new Date());
//			 //event.setId(1L);//��Ч����Ҫ��id�����ɲ����йء�
			 
			 
			//�־�״̬���ӣ����ݿ��д��ڵģ�
			Event event = (Event)session.get(Event.class, 1L);
			event.setTitle("ȥ����");//���뷢���ı�Ż�update

			session.save(event);//ִ��ʱ��ʹ��update
			//�־�״̬
			
			tx.commit();
		} catch (Exception ex) {
			
			tx.rollback();
			ex.printStackTrace();
		}
	}
	
	//session.delete()
	public void testDelete(){//�Ժ�ֻ��Ҫ��Long id
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {

			//�־�״̬���ӣ����ݿ��д��ڵ�
			Event event = (Event)session.get(Event.class, 1L);//��select

			//˲ʱ״̬����:������������ֱ��ɾ��˲ʱ״̬�Ķ���
//				 Event event = new Event();
//				 event.setId(2L);
			 
			session.delete(event);//����id��sessionѰ��ƥ��ĳ־û�����
			//�־�״̬
			
			tx.commit();//ִ��delete���
		} catch (Exception ex) {
			
			tx.rollback();
			ex.printStackTrace();
		}
		 //close()����ʱ�Ż��Session�Ļ�����ɾ���ö���
	}
		
	//session.update()
	public void testUpdate(){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 try {

			//�־�״̬���ӣ�����־ö��������ݿⱣ��һ�������κβ���������ı�����ִ��update
//			Event event = (Event)session.get(Event.class, 1L);//��select
//			event.setTitle("ȥ����");
			//˲ʱ״̬����:���˲ʱ�������κ��޸Ĳ�������session��һ�������ϣ���������ζ���ִ��update
			 Event event = new Event();
			 event.setId(1L);
			 
			session.update(event);//
			//�־�״̬
			
			tx.commit();//ִ��delete���
		} catch (Exception ex) {
			
			tx.rollback();
			ex.printStackTrace();
		}
		 //close()����ʱ�Ż��Session�Ļ�����ɾ���ö���
	}
	
	//session.load()
		public void testLoad(){
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 Transaction tx = session.beginTransaction();
			 try {

				//�־�״̬���ӣ�����־ö��������ݿⱣ��һ�������κβ���������ı�����ִ��update
				Event event = (Event)session.load(Event.class, 1L);
				//��get������ֻ�з��ʶ������ݵ�ʱ�������ִ��select,load���ܱ�get�ã��������ݿ�ĸ���
				
				//��ע���������д��뿴����
				System.out.println(event.getTitle());
				tx.commit();
			} catch (Exception ex) {
				
				tx.rollback();
				ex.printStackTrace();
			}
			
		}
}
