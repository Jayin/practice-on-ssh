package com.hibernate.ch02.orm.entity.one2one.ex02;

import java.io.Serializable;

import javax.persistence.Embeddable;

//身份证主键类
@Embeddable
public class IdCardPK implements Serializable{
	private String pid;
	private String bloodType;
	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * @return the bloodType
	 */
	public String getBloodType() {
		return bloodType;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * @param bloodType the bloodType to set
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
