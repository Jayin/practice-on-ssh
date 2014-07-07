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

	
	//��ӹ��캯��
	public Department(){}
	//��Ӵ������Ĺ��캯��
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
	@Basic(fetch=FetchType.EAGER)//��ͨ����Ĭ��Ϊ��ʱ��ȡ��ֻ��fetch=FetchType.LAZY����Ҫ��ʾ����
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

	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch=FetchType.LAZY)//��������Ĭ��Ϊ�ӳټ��ء�ֻ��fetch=FetchType.EAGER����Ҫ��ʾ����
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
        //�ӳټ���fetch=FetchType.LAZY
        //ֱ�Ӽ���fetch=FetchType.EAGER
//        toString.append("\nstaffs = ");
//        toString.append(staffs);

        toString.append("\n");

        return new String(toString);
    }
	
}
