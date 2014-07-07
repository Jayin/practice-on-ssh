package com.hibernate.ch02.orm.entity.one2one.ex02;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.OneToOne;

//±ªøÿ¿‡
@Entity
public class IdCard {
	private IdCardPK pk;
	private String 	province;
	private Student student;
	/**
	 * @return the pk
	 */
	@EmbeddedId
	public IdCardPK getPk() {
		return pk;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @return the student
	 */
	@OneToOne(mappedBy = "cardId")
	public Student getStudent() {
		return student;
	}
	/**
	 * @param pk the pk to set
	 */
	public void setPk(IdCardPK pk) {
		this.pk = pk;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
