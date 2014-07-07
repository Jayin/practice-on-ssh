package com.hibernate.ch02.orm.entity.extend.ex2;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Orders extends BaseEntity
{
	
	private String orderCode;
//	private String create;
	public String getOrderCode() {
		return orderCode;
	}
	
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	

	
	
}
