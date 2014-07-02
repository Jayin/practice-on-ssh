package com.spring.dao;

import com.spring.entity.User;

public interface IUserDao {

	public void add(User user);

	public void delete(Long id);

	public void findById(Long id);

	public void update(User user);

}
