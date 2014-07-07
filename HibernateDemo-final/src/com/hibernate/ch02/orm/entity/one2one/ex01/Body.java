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
	
	@OneToOne(cascade = CascadeType.ALL)//��������:
	//Ψһ
//	@PrimaryKeyJoinColumn//��������
	@JoinColumn(unique=true,name="my_heart_id")//�������(Ĭ��),ΨһԼ��
//	@JoinTable(name="t_body_heart",
//		joinColumns = @JoinColumn(name= "body_fk"),
//		inverseJoinColumns =  @JoinColumn(name= "heart_fk")
//	)//���������
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
