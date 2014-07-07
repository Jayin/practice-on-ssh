package com.hibernate.ch02.orm.entity.extend.ex3;

import javax.persistence.Entity;

@Entity
public class Ferry extends Boat{
	private String ferryCode;

	/**
	 * @return the ferryCode
	 */
	public String getFerryCode() {
		return ferryCode;
	}

	/**
	 * @param ferryCode the ferryCode to set
	 */
	public void setFerryCode(String ferryCode) {
		this.ferryCode = ferryCode;
	}
	
	
}
