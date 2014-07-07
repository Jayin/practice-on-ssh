package com.hibernate.ch02.orm.entity.one2one.ex01;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Heart {

	private Long id;
	private String heartCode;
	private Body body;//˫�����
	
	@Id
	@GeneratedValue
	//@Column(unique = true)
	public Long getId() {
		return id;
	}
	
	@OneToOne(mappedBy="heart")//ӳ�䵽Body���heart����
	public Body getBody() {
		return body;
	}


	public void setBody(Body body) {
		this.body = body;
	}


	public String getHeartCode() {
		return heartCode;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setHeartCode(String heartCode) {
		this.heartCode = heartCode;
	}
	
	
	
}
