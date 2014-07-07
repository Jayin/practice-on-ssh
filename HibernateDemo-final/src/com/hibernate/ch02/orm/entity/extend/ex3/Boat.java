package com.hibernate.ch02.orm.entity.extend.ex3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//@Inheritance(strategy = InheritanceType.JOINED)
//公有的属性都保存到同一张中，
//其他子类的私有的属性则通过父类表中的主键在子类表中进行关联
//@PrimaryKeyJoinColumn(name = "BOAT_ID")：指定子类表中关联父类表的主键的列名
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Boat {
	private Long id;
	private String boatName;
	private String boatCode;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	/**
	 * @return the boatName
	 */
	public String getBoatName() {
		return boatName;
	}
	/**
	 * @return the boatCode
	 */
	public String getBoatCode() {
		return boatCode;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param boatName the boatName to set
	 */
	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}
	/**
	 * @param boatCode the boatCode to set
	 */
	public void setBoatCode(String boatCode) {
		this.boatCode = boatCode;
	}
	
	
	
}
