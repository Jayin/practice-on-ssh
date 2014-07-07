package com.hibernate.ch02.orm.entity.one2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Troop 
{
	private Long id;
	private String troopCode;
	private String troopName;

	private Set<Soldier> soldiers = new HashSet<Soldier>();

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @return the troopCode
	 */
	public String getTroopCode() {
		return troopCode;
	}

	/**
	 * @return the troopName
	 */
	public String getTroopName() {
		return troopName;
	}

	/**
	 * @return the soldiers
	 */
	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn//单向,不建议的
	//@JoinTable//关联表，首选的推荐的
	public Set<Soldier> getSoldiers() {
		return soldiers;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param troopCode the troopCode to set
	 */
	public void setTroopCode(String troopCode) {
		this.troopCode = troopCode;
	}

	/**
	 * @param troopName the troopName to set
	 */
	public void setTroopName(String troopName) {
		this.troopName = troopName;
	}

	/**
	 * @param soldiers the soldiers to set
	 */
	public void setSoldiers(Set<Soldier> soldiers) {
		this.soldiers = soldiers;
	}
	
	
}
