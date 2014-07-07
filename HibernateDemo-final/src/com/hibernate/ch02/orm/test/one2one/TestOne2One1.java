package com.hibernate.ch02.orm.test.one2one;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.one2one.ex01.Body;
import com.hibernate.ch02.orm.entity.one2one.ex01.Heart;

public class TestOne2One1 {
	public static void main(String[] args) {
		BaseDAO<Object> dao = new BaseDAO<Object>();
		
		
		Heart heart = new Heart();
		heart.setHeartCode("心脏编号881");
		dao.saveObject(heart);//数据库内只有一条heart记录，没有与body关联关系
		

		Body body = new Body();
		body.setBodyCode("身体编号881");
		dao.saveObject(body);//触发级联更新heart update与body的关联关系
		
		
		
		
		//建立关联关系
		body.setHeart(heart);
		heart.setBody(body);
		
		dao.updateObject(body);
		//单向关联的时候，我们可以直接使用级联创建模式来创建关联对象
		//双向关联的时候，由于对象之间需要互相关联，所以必须先创建从对象，再与助对象互相关联。通过级联更新来创建主对象。
	}
}
