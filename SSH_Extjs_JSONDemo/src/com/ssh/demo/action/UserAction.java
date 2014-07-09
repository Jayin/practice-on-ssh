package com.ssh.demo.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.json.annotations.JSON;

import org.springframework.beans.factory.annotation.Autowired;

import com.asiasoft.javaee.web.struts.action.BaseAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.demo.dto.UserQueryDTO;
import com.ssh.demo.entity.User;
import com.ssh.demo.service.IUserService;
import com.ssh.demo.utils.Page;

//BaseAction:提供了封装好的processSuccess及processException方法。主要返回成功及国际化后的异常信息。
//使用时需要在继承的子类中添加对应的getSuccess及getErrorMessage方法,必须提供依赖的国际化信息文件messageResource_zh_CN.properties
public class UserAction extends BaseAction implements ModelDriven<User>,ParameterAware{

	private static final long serialVersionUID = -3386708655206031807L;

	@Autowired
	private IUserService userService;//业务层
	
	private User user = new User();//创建或者更新服务的时候使用的Model,配合ModelDriven传参更加简单
	private List<User> userLists = new ArrayList<User>();//集合-查询结果集（查询全部或者更加条件查询的,分页）
	private UserQueryDTO userQueryConditionDTO = new UserQueryDTO();//查询条件封装类
	private Map<String, String[]> parameters;

	private int page = 1;
	private int rows = 30;
	private String sidx = "id";//排列字段
	private String sord = "ASC";//排列顺序
    private long total;
    private long totalCount;
      
	public String add()
	{
		userService.saveUser(user);
		return processSuccess();		
	}
	
	public String update()
	{
		try {
			userService.updateUser(user);
			return processSuccess();
	
		} catch (Exception ex) {
			return processException(ex);		
		}	
	}
	
	public String showUpdate()
	{
		try {
			String[] userIds = parameters.get("userId");
			if(userIds!=null){
				Long id = Long.parseLong(userIds[0]);
				user = userService.findUserById(id);
			}
			return processSuccess();		
		} catch (Exception ex) {
			return processException(ex);		
		}
		
	}
	public String delete()
	{
		//考虑事务管理机制，在service层完成遍历及调用删除集合的操作
		try {
			String[] userIds = parameters.get("userIds");
			if(userIds!=null){
				Long id = Long.parseLong(userIds[0]);
				userService.deleteUser(id);
			}
			
			return processSuccess();		
		} catch (Exception ex) {
			return processException(ex);		
		}
	}
	
	
	public String findUsers()
	{
		try {
			Page<User> userPage = userService.findUsers(userQueryConditionDTO, page, rows, sidx, sord);
			userLists = userPage.getObjectsList();
			totalCount = userPage.getTotalRecordsCount();
			total = userPage.getTotalPagesCount();
			page = userPage.getPageNumber();
			rows = userPage.getPageSize();
			return processSuccess();		
		} catch (Exception ex) {
			return processException(ex);		
		}	
	}
	
	

	@Override
	public void setParameters(Map<String, String[]> parameters) 
	{
		this.parameters= parameters;
	}


	

	public List<User> getUserLists() {
		return userLists;
	}

	public void setUserLists(List<User> userLists) {
		this.userLists = userLists;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	

	/**
	 * @return the userQueryConditionDTO
	 */
	public UserQueryDTO getUserQueryConditionDTO() {
		return userQueryConditionDTO;
	}

	/**
	 * @param userQueryConditionDTO the userQueryConditionDTO to set
	 */
	public void setUserQueryConditionDTO(UserQueryDTO userQueryConditionDTO) {
		this.userQueryConditionDTO = userQueryConditionDTO;
	}

	/**
	 * @return the totalCount
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public User getModel() {
		return user;
	}

	/**
     * @return the success
     */
    public String getSuccess()
    {
        return success;
    }
    
    /**
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
        return errorMessage;
    }



	
	
}
