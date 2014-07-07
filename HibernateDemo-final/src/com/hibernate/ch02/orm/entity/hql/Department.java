package com.hibernate.ch02.orm.entity.hql;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;

@Entity
public class Department 
{
	private Long id;

	private String departmantName;
	private String departmantCode;
	
	private Set<Staff> staffs = new HashSet<Staff>();

	
	//添加构造函数
	public Department(){}
	//添加带参数的构造函数
	public Department(String departmantCode,String departmantName){
		this.departmantCode  = departmantCode;
		this.departmantName  = departmantName;
	}
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @return the departmantName
	 */
	@Basic(fetch=FetchType.EAGER)//普通属性默认为即时获取，只有fetch=FetchType.LAZY才需要显示声明
	public String getDepartmantName() {
		return departmantName;
	}

	/**
	 * @return the departmantCode
	 */
	public String getDepartmantCode() {
		return departmantCode;
	}

	/**
	 * @return the staffs
	 */

	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch=FetchType.LAZY)//关联对象，默认为延迟加载。只有fetch=FetchType.EAGER菜需要显示声明
	public Set<Staff> getStaffs() {
		return staffs;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param departmantName the departmantName to set
	 */
	public void setDepartmantName(String departmantName) {
		this.departmantName = departmantName;
	}

	/**
	 * @param departmantCode the departmantCode to set
	 */
	public void setDepartmantCode(String departmantCode) {
		this.departmantCode = departmantCode;
	}

	/**
	 * @param staffs the staffs to set
	 */
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}
	
	public String toString()
    {
        StringBuffer toString = new StringBuffer();

        toString.append("\nid = ");
        toString.append(id);

        toString.append("\ndepartmantCode = ");
        toString.append(departmantCode);

        toString.append("\ndepartmantName = ");
        toString.append(departmantName);
        //延迟加载fetch=FetchType.LAZY
        //直接加载fetch=FetchType.EAGER
//        toString.append("\nstaffs = ");
//        toString.append(staffs);

        toString.append("\n");

        return new String(toString);
    }
	
}
