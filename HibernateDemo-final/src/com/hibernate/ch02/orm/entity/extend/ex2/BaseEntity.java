package com.hibernate.ch02.orm.entity.extend.ex2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass//��ע���ʶ���಻�ᱻ�־û������ݿ⣬����������Կ���ͨ���̳б��־û������ݿ�
//ע�⣺�ڼ̳и���������в����ظ����常����ӵ�е����ԡ�
public class BaseEntity
{
	private Long id;
	
	private String creater;
	private Date createTime;
	private String updater;
	private Date updateTime;
	private String remark;
	private String description;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}
	@Column(length = 10)
	public String getCreater() {
		return creater;
	}
	@Column(length = 10)
	public String getUpdater() {
		return updater;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}
	@Lob
	public String getRemark() {
		return remark;
	}
	@Lob
	public String getDescription() {
		return description;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public void setCreater(String creater) {
		this.creater = creater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	
	
	
}
