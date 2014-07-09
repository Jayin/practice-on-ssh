package com.demo.action;

import com.demo.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport //extends Action
{
	private User user;

//	private String name; 
//	private int age; 
//	private String sex; 
//	private String[] hobby;    
//	private String country;
	
	public String execute()
	{
		//String com.opensymphony.xwork2.Action.SUCCESS = "success"
//		ERROR is returned when the action execution fails.
//
//		INPUT is returned when the action requires more input from the user.
//
//		LOGIN is returned when the user is not logged into the system.
//
//		NONE is returned when the action execution is successfull and there are no views to display.
//
//		SUCCESS is returned when the action executed successfully and the corresponding result is displayed to the user.


		return SUCCESS;
	}
	
	
	public User getUser() {
		System.out.println("getUser()");
		return user;
	}

	public void setUser(User user) {
		System.out.println("setUser()");
		this.user = user;
	}
	
	
	
}
