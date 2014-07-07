package com.hibernate.ch02.orm.entity.many2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Store {
	private Long id;
	private String storeName;
	
	private Set<StoreCustomer> customers = new HashSet<StoreCustomer>();

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/**
	 * @return the storeName
	 */
	@Column()
	public String getStoreName() {
		return storeName;
	}

	/**
	 * @return the customers
	 */
	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "Store_Customer",
//			joinColumns = @JoinColumn(name = "storeId"),
//			inverseJoinColumns = @JoinColumn(name = "customerId")
//	)
	public Set<StoreCustomer> getCustomers() {
		return customers;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(Set<StoreCustomer> customers) {
		this.customers = customers;
	}
	
	
}
