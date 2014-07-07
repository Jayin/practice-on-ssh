package com.hibernate.ch02.orm.entity.extend.ex3;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "BOAT_ID")
public class SailerBoat extends Boat{
	private String sailerBoatCode;

	/**
	 * @return the sailerBoatCode
	 */
	public String getSailerBoatCode() {
		return sailerBoatCode;
	}

	/**
	 * @param sailerBoatCode the sailerBoatCode to set
	 */
	public void setSailerBoatCode(String sailerBoatCode) {
		this.sailerBoatCode = sailerBoatCode;
	}
	
	
}
