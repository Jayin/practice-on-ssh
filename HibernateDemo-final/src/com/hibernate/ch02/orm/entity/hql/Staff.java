package com.hibernate.ch02.orm.entity.hql;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Staff {
	private Long id;
	private String staffName;
	private String staffCode;
	
	private Department department;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @return the staffName
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * @return the staffCode
	 */
	public String getStaffCode() {
		return staffCode;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the department
	 */
	@ManyToOne
	@JoinColumn(name = "departmant_id")
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param staffName the staffName to set
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * @param staffCode the staffCode to set
	 */
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	public String toString()
    {
        StringBuffer toString = new StringBuffer();

        toString.append("\nid = ");
        toString.append(id);

        toString.append("\nstaffCode = ");
        toString.append(staffCode);

        toString.append("\nstaffName = ");
        toString.append(staffName);

//        toString.append("\ndepartment = ");
//        toString.append(department);

        toString.append("\n");

        return new String(toString);
    }
	
}
