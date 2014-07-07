package com.hibernate.ch02.orm.entity.extend.ex1;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//@Inheritanceָ���̳й�ϵ�����ݿ�Ľṹ������
//InheritanceType.TABLE_PER_CLASSÿ����һ�ű�������,����ʹ��AUTO �� IdEntity��������
//InheritanceType.SINGLE_TABLE  ÿ�����νṹһ�ű����ã�
//InheritanceType.JOINED ���ӵ�����

//@DiscriminatorColumn���������������С�������Ĭ������ΪDTYPE
//@DiscriminatorValue���ڶ�������е�ֵ�������е�ֵĬ����Ϊʵ����

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "planeType",discriminatorType =DiscriminatorType.INTEGER ,length = 1)//�����
@DiscriminatorValue("1")//����е�ֵ
public class Plane {
	private Long id;
	private String planeCode;
	private String planeName;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public String getPlaneCode() {
		return planeCode;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPlaneCode(String planeCode) {
		this.planeCode = planeCode;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	
	
	
}
