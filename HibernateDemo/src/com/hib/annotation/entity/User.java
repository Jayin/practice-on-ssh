package com.hib.annotation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="table_user") //指定表明
public class User {
	//主键 默认自动增长
	@Id
	@GeneratedValue 
	private Long id;
	//自动类型判断,不用
	private String name;
	
	// 指定约束，和列名
	@Column(name="user_id",unique=true,nullable=false)   
	private long userId;
	
	//比如密码比较密码啦，我们不保存到数据库,表对应的列也不会声场
	@Transient
	private long psw;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPsw() {
		return psw;
	}

	public void setPsw(long psw) {
		this.psw = psw;
	}
}
