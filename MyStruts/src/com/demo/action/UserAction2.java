package com.demo.action;



import com.demo.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction2 extends ActionSupport implements ModelDriven<User>{
	//ModelDriven Model对象必须初始化
	private User user = new User();

	//注入不需要get/set
	//@Autowired
	//private IUserService userService;
	
	@Override
	public User getModel() {

		return user;
	}
	
	
	public String execute()
	{
		//String com.opensymphony.xwork2.Action.SUCCESS = "success"
		return SUCCESS;
	}
	
	public String add()
	{
		System.out.println("UserAction2  add()");
		//userService.save(user);
		//String com.opensymphony.xwork2.Action.SUCCESS = "success"
		return SUCCESS;
	}
	
	public String update()
	{
		//userService.update(user);
		//String com.opensymphony.xwork2.Action.SUCCESS = "success"
		return SUCCESS;
	}
	
	public String delete()
	{
		//userService.deleteById(id);
		//String com.opensymphony.xwork2.Action.SUCCESS = "success"
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
