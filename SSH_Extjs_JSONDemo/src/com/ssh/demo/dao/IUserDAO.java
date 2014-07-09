package com.ssh.demo.dao;

import java.util.List;

import com.ssh.demo.dto.UserQueryDTO;
import com.ssh.demo.entity.User;
import com.ssh.demo.utils.Page;

//面向接口编程：解耦，低耦合高内聚
public interface IUserDAO 
{
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User findUserById(Long id);
	public List<User> findAllUsers();
	public Page<User> findUsers(UserQueryDTO qdto,int page,int rows,String sidx,String sord);
}
