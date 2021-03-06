package com.hib.dao.base;

import java.util.List;

public interface IBaseDao<T> {
	public void add(T object);

	public void update(T object);

	public void delete(T object);

	public T findById(Long id);
	
	public List<T> findAll();

}
