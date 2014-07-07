/**
 * ����һ���򵥵�POJO��
 * ����Ҫ��@Entity��@Id
 */
package com.hibernate.ch02.orm.entity.pojo;

//EJB3.0�淶����javax.persistence.*;
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

//@Entity ������ǰ����Ϊһ��ʵ����󣬼򵥵�˵����Ϊ@Entity�����ǽ�Ҫӳ�䵽���ݿ��
//ע�⣺�༰�������������������Ϊ���ݿ�Ĺؼ��֣�����fullText,Order�ȵȡ�
@Entity
@Table(name="t_user")//@Table��ѡ��Ĭ��Ϊ����Сд��Ϊ���ݿ������ע�ⲻͬϵͳ�ײ�Դ�С���У�����ȫСд������ǿ����Ŀ���ֲ��
public class User
{
	
	//ע�⣺��ʵ���ڱ�д���Ե�ע�⣬Ҫôȫ�����������Ե��Ϸ���Ҫô��ȫ�����������Ե� getter�����Ϸ���EJB3.0����ͳһ��getter�����϶���ע��
	private Long id;
	private String userName;
	private String password;
	private String tran;
	private Date createTime;
	private Sex sex;
	private String remake;
	private byte[] fullCode;
	

	@Id//Ĭ���������ҪAssigned�ֶ���������
	@GeneratedValue//Ĭ��ΪAUTO-native
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@GeneratedValue(strategy = GenerationType.TABLE)
//	@GeneratedValue(strategy = GenerationType.AUTO)//���ݲ�ͬ�ײ����ݿ��Զ�ѡ���������ֵ�����һ�ַ�ʽ����ֲ�ԣ�
	public Long getId() {
		return id;
	}
	
	//ӳ�������
	//@Basic����û�ж���ע������Եȼ����������涨����@Basic��Basic�����������ԵĻ�ȡ����
	//��ȡ����(��ͨ����):
		//LAZY:�ӳٻ�ȡ
		//EAGER:��ʱ��ȡ��Ĭ�ϣ�
	//���ز���(������������):
	@Basic
	
	public String getUserName() {
		return userName;
	}
	@Basic(fetch = FetchType.LAZY)
	//@Basic(fetch = FetchType.EAGER)����ΪĬ�ϼ�ΪEAGER������û�������ı�Ҫ��
	@Column(name="password" , length = 8, nullable=false)//@Columnע������ӳ�䵽�У�ʹ�ø�ע�⸲��Ĭ��ֵ
	public String getPassword() {
		return password;
	}
	
	//@Transientע�����������Բ��ᱻ�־û������ݿ⣬��Ϊ���з�����Ϊstatic��transient�����Ծ��ɱ��־û������ݿ⡣
	@Transient
	public String getTran() {
		return tran;
	}
	//@Temporalָ�������������ݲ�������ʱ�侫��
	
//	@Temporal(TemporalType.DATE)
//	@Temporal(TemporalType.TIME)
	@Temporal(TemporalType.TIMESTAMP)//(Ĭ��)
	public Date getCreateTime() {
		return createTime;
	}
	//@Enumerated ע����������ö�����ͳ־û������ݿ����ֵ���ͣ�Ĭ��ΪORDINAL˳���У���֧��STRING�ַ���������
	//	@Enumerated(EnumType.ORDINAL)//(Ĭ��)
	@Enumerated(EnumType.STRING)
	public Sex getSex() {
		return sex;
	}
	@Lob//CLOB��String:LONGTEXT ����, ����:Clob ,char[] Character[] 
	public String getRemake() {
		return remake;
	}
	@Lob//BLOB :byte[]: LONGBLOB(ͼƬ)����:BLOB,Serializable,Byte[]
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
