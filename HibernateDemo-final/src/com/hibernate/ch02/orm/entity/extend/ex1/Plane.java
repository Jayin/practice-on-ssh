package com.hibernate.ch02.orm.entity.extend.ex1;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//@Inheritance指定继承关系到数据库的结构、策略
//InheritanceType.TABLE_PER_CLASS每个类一张表（不建议,不能使用AUTO 和 IdEntity生成器）
//InheritanceType.SINGLE_TABLE  每个类层次结构一张表（常用）
//InheritanceType.JOINED 连接的子类

//@DiscriminatorColumn用于重命名辨别符列。辨别符列默认名称为DTYPE
//@DiscriminatorValue用于定义辨别符列的值。辨别符列的值默认名为实体名

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "planeType",discriminatorType =DiscriminatorType.INTEGER ,length = 1)//辨别列
@DiscriminatorValue("1")//辨别列的值
public class Plane {
	private Long id;
	private String planeCode;
	private String planeName;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public String getPlaneCode() {
		return planeCode;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPlaneCode(String planeCode) {
		this.planeCode = planeCode;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	
	
	
}
