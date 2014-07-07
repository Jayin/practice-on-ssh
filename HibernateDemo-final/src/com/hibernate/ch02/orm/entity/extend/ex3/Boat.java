package com.hibernate.ch02.orm.entity.extend.ex3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//@Inheritance(strategy = InheritanceType.JOINED)
//���е����Զ����浽ͬһ���У�
//���������˽�е�������ͨ��������е�������������н��й���
//@PrimaryKeyJoinColumn(name = "BOAT_ID")��ָ��������й�������������������
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
