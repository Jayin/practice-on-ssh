/**
 * 声明一个简单的POJO类
 * 必须要有@Entity和@Id
 */
package com.hibernate.ch02.orm.entity.pojo;

//EJB3.0规范引用javax.persistence.*;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.hibernate.utils.Sex;

//@Entity 声明当前对象为一个实体对象，简单的说声明为@Entity的类是将要映射到数据库的
//注意：类及类的属性声明尽量避免为数据库的关键字，例如fullText,Order等等。
@Entity
@Table(name="t_user")//@Table可选，默认为类名小写作为数据库表名，注意不同系统底层对大小敏感，保持全小写可以增强程序的可移植性
public class User
{
	
	//注意：在实体内编写属性的注解，要么全部定义在属性的上方，要么就全部定义在属性的 getter方法上方。EJB3.0建议统一在getter方法上定义注解
	private Long id;
	private String userName;
	private String password;
	private String tran;
	private Date createTime;
	private Sex sex;
	private String remake;
	private byte[] fullCode;
	

	@Id//默认情况下需要Assigned手动生成主键
	@GeneratedValue//默认为AUTO-native
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@GeneratedValue(strategy = GenerationType.TABLE)
//	@GeneratedValue(strategy = GenerationType.AUTO)//根据不同底层数据库自动选择以上三种的其中一种方式（移植性）
	public Long getId() {
		return id;
	}
	
	//映射简单属性
	//@Basic所有没有定义注解的属性等价于在其上面定义了@Basic，Basic可以声明属性的获取策略
	//获取策略(普通属性):
		//LAZY:延迟获取
		//EAGER:即时获取（默认）
	//加载策略(关联对象属性):
	@Basic
	
	public String getUserName() {
		return userName;
	}
	@Basic(fetch = FetchType.LAZY)
	//@Basic(fetch = FetchType.EAGER)（因为默认即为EAGER，所以没有声明的必要）
	@Column(name="password" , length = 8, nullable=false)//@Column注解属性映射到列，使用该注解覆盖默认值
	public String getPassword() {
		return password;
	}
	
	//@Transient注解声明的属性不会被持久化到数据库，因为所有非声明为static及transient的属性均可被持久化到数据库。
	@Transient
	public String getTran() {
		return tran;
	}
	//@Temporal指定日期类型数据插入书库的时间精度
	
//	@Temporal(TemporalType.DATE)
//	@Temporal(TemporalType.TIME)
	@Temporal(TemporalType.TIMESTAMP)//(默认)
	public Date getCreateTime() {
		return createTime;
	}
	//@Enumerated 注解用于声明枚举类型持久化到数据库的列值类型，默认为ORDINAL顺序列，还支持STRING字符串类型列
	//	@Enumerated(EnumType.ORDINAL)//(默认)
	@Enumerated(EnumType.STRING)
	public Sex getSex() {
		return sex;
	}
	@Lob//CLOB：String:LONGTEXT 类型, 其他:Clob ,char[] Character[] 
	public String getRemake() {
		return remake;
	}
	@Lob//BLOB :byte[]: LONGBLOB(图片)其他:BLOB,Serializable,Byte[]
	public byte[] getFullCode() {
		return fullCode;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTran(String tran) {
		this.tran = tran;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}
	
	public void setFullCode(byte[] fullCode) {
		this.fullCode = fullCode;
	}
	
	
}
