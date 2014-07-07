package com.hibernate.ch02.orm.entity.one2many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Soldier 
{
	private Long id;
	private String soldierCode;
	private String soldierName;
	
	//private Troop troop;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @return the soldierCode
	 */
	public String getSoldierCode() {
		return soldierCode;
	}

	/**
	 * @return the soldierName
	 */
	public String getSoldierName() {
		return soldierName;
	}

	/**
	 * @return the troop
	 */
//	@ManyToOne
//	@JoinColumn(name = "troop_fk")
//	public Troop getTroop() {
//		return troop;
//	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param soldierCode the soldierCode to set
	 */
	public void setSoldierCode(String soldierCode) {
		this.soldierCode = soldierCode;
	}

	/**
	 * @param soldierName the soldierName to set
	 */
	public void setSoldierName(String soldierName) {
		this.soldierName = soldierName;
	}

	/**
	 * @param troop the troop to set
	 */
//	public void setTroop(Troop troop) {
//		this.troop = troop;
//	}
	
	
}
