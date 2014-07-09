package com.ssh.demo.service;

import java.util.List;

import com.ssh.demo.dto.UserQueryDTO;
import com.ssh.demo.entity.User;
import com.ssh.demo.utils.Page;

public interface IUserService 
{
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long id);
	public User findUserById(Long id);
	public List<User> findAllUsers();
	
	public Page<User> findUsers(UserQueryDTO qdto,int page,int rows,String sidx,String sord);
	
	
//	public void saveUser(UserDTO userDTO);
//	public void updateUser(UserDTO userDTO);
//	public void deleteUser(Long id);
//	public UserDTO findUserById(Long id);
//	public List<UserDTO> findAllUsers();
//	public Page<UserDTO> findUsers(UserQueryDTO qdto,int page,int rows,String sidx,String sord);
	
}
