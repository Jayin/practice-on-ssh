/**
 * 单向联合主键关联
 */
package com.hibernate.ch02.orm.entity.one2one.ex02;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
//主控类
@Entity
public class Student {
	private Long sid;
	private String name;
	private IdCard	cardId;
	/**
	 * @return the sid
	 */
	@Id
	@GeneratedValue
	public Long getSid() {
		return sid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the cardId
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name="pid",referencedColumnName="pid"),
		@JoinColumn(name="bloodType",referencedColumnName="bloodtype")
	})
	//@Embedded//组件IdCard内不需要编写任何注解
	public IdCard getCardId() {
		return cardId;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(Long sid) {
		this.sid = sid;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(IdCard cardId) {
		this.cardId = cardId;
	}
	
	
}
