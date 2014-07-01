package com.spring.service;

import com.spring.entity.User;

public interface IUserService {
	public void add(User user);

	public void delete(Long id);

	public void findById(Long id);
	
	public void update(User user);
}
