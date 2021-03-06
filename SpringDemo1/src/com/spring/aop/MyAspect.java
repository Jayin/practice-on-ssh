package com.spring.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.spring.entity.User;

@Aspect
public class MyAspect {

	//添加操作的事务
	@Pointcut("execution(public * add*(..))")
	private void addAspect(){}
	
	//删除操作的事务
	@Pointcut("execution(public * delete*(..))")
	private void deleteAspect(){}
	
	//切入到所有service包下的类
	@Pointcut("within(com.spring.service.*)")
	private void allService(){};
	
	//纯表达式AjectJ表达式
	@Before(value="execution(public * *(..)) && within(com.spring.service.*)")
	private void opertation(){
		System.out.println("before a opertation!");
	}
	//表达式+切点	args(user) -->拦截user参数
	@Before(value="addAspect() && allService() && args(user)")
	private void beforeAdd( User user){
		System.out.println("before -->"+user.getUserName());
	}
}
