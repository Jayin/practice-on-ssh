package com.hibernate.ch02.orm.test.many2many;


import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.many2many.Store;
import com.hibernate.ch02.orm.entity.many2many.StoreCustomer;


public class TestStoreDAO {
	public static void main(String[] args) {
		BaseDAO<Object> dao = new BaseDAO<Object>();
		
		Store store = new Store();
		store.setStoreName("Android Market");
		
		Store store2 = new Store();
		store2.setStoreName("Apple Store");
		
		StoreCustomer customer = new StoreCustomer();
		customer.setCustomerName("customer1");
		
		StoreCustomer customer2 = new StoreCustomer();
		customer2.setCustomerName("customer2");
		
		store.getCustomers().add(customer);
		store.getCustomers().add(customer2);
		
		store2.getCustomers().add(customer);
		store2.getCustomers().add(customer2);
		
		
		dao.saveObject(store);
		dao.saveObject(store2);

	}
}
