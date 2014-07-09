package com.ssh.demo.service;

import java.util.List;

import javax.annotation.Resource;

import com.ssh.demo.entity.User;
import com.ssh.demo.utils.Page;
import com.ssh.demo.dao.IUserDAO;
import com.ssh.demo.dto.UserQueryDTO;

//业务层：一个业务可以调用多个持久层，负责根据复杂的业务建立对象的映射关系
public class UserService implements IUserService{
	@Resource
	private IUserDAO userDAO;
	
	public void saveUser(User user){
		//System.out.println(100/0);//测试异常通知
//		User usertemp = userDAO.findUserById(user.getId());
//		if(usertemp==null){
//			//throw new Exception();
//		}	
		userDAO.saveUser(user);
	}
	
	public void updateUser(User user){
		userDAO.updateUser(user);
	}
	
	public void deleteUser(Long id){
		User user = userDAO.findUserById(id);
		
		//通过更新,移除关联关系,再执行删除
		if(user!=null){
			userDAO.deleteUser(user);
		}
	}
	
	public User findUserById(Long id){
		return userDAO.findUserById(id);
	}
	
	public List<User> findAllUsers(){
		return userDAO.findAllUsers();
	}

	@Override
	public Page<User> findUsers(UserQueryDTO qdto, int page, int rows,
			String sidx, String sord) {

		return userDAO.findUsers(qdto, page, rows, sidx, sord);
	}
	
}
