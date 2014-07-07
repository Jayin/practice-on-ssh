package com.hibernate.ch02.orm.entity.many2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;


@Entity
public class Flight {
	private Long id;
	private String flightCode;
	private String flightName;
	
	private Company company;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @return the flightCode
	 */
	public String getFlightCode() {
		return flightCode;
	}

	/**
	 * @return the flightName
	 */
	public String getFlightName() {
		return flightName;
	}

	/**
	 * @return the company
	 */
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST},targetEntity=Company.class)
	//@JoinColumn(name = "company_fk")//д╛хо
	public Company getCompany() {
		return company;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param flightCode the flightCode to set
	 */
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	/**
	 * @param flightName the flightName to set
	 */
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
