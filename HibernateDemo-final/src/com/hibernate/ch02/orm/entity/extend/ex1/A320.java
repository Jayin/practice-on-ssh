package com.hibernate.ch02.orm.entity.extend.ex1;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class A320 extends Plane 
{
	private String remake;

	public String getRemake() {
		return remake;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}
	
	
}	
