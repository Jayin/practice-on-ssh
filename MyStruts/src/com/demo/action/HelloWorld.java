package com.demo.action;

public class HelloWorld 
{
	//前后台交互的数据字段
	private String message; 
	private String userName;
	
	
	//Action类默认执行的函数execute()，必须返回一个String
	//该String 对应Struts.xml中的result name="SUCCESS"
	public String execute() { 
		setMessage("Hello " + getUserName()); 
		return "SUCCESS";
	}


	//get/set
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
}
