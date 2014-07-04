package com.hib.annotation.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Department {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name; //部门名称
	
	private long count; //人数
	
//	private List<>
}
