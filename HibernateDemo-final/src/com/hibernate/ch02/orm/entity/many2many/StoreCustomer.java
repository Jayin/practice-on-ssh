package com.hibernate.ch02.orm.entity.many2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_customer")
public class StoreCustomer {
	private Long id;
	private String customerName;
	
	private Set<Store> stores = new HashSet<Store>();

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @return the stores
	 */
	@ManyToMany(mappedBy = "customers")
	public Set<Store> getStores() {
		return stores;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @param stores the stores to set
	 */
	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}
	
	
}
