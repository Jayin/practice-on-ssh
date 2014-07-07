package com.hibernate.ch02.orm.test.one2one;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.one2one.ex01.Body;
import com.hibernate.ch02.orm.entity.one2one.ex01.Heart;

public class TestOne2One1 {
	public static void main(String[] args) {
		BaseDAO<Object> dao = new BaseDAO<Object>();
		
		
		Heart heart = new Heart();
		heart.setHeartCode("������881");
		dao.saveObject(heart);//���ݿ���ֻ��һ��heart��¼��û����body������ϵ
		

		Body body = new Body();
		body.setBodyCode("������881");
		dao.saveObject(body);//������������heart update��body�Ĺ�����ϵ
		
		
		
		
		//����������ϵ
		body.setHeart(heart);
		heart.setBody(body);
		
		dao.updateObject(body);
		//���������ʱ�����ǿ���ֱ��ʹ�ü�������ģʽ��������������
		//˫�������ʱ�����ڶ���֮����Ҫ������������Ա����ȴ����Ӷ��������������������ͨ����������������������
	}
}
