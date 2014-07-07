package com.hibernate.ch02.orm.entity.one2one.ex01;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Body {
	
	private Long id;
	private String bodyCode;
	private Heart heart;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)//级联策略:
	//唯一
//	@PrimaryKeyJoinColumn//共享主键
	@JoinColumn(unique=true,name="my_heart_id")//外键关联(默认),唯一约束
//	@JoinTable(name="t_body_heart",
//		joinColumns = @JoinColumn(name= "body_fk"),
//		inverseJoinColumns =  @JoinColumn(name= "heart_fk")
//	)//关联表关联
	public Heart getHeart() {
		return heart;
	}
	
	public String getBodyCode() {
		return bodyCode;
	}
	public void setBodyCode(String bodyCode) {
		this.bodyCode = bodyCode;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setHeart(Heart heart) {
		this.heart = heart;
	}
	
	
}
