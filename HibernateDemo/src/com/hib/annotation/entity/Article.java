package com.hib.annotation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="article")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class Article {
	
	@Id
	@GeneratedValue
	private Long id;
	
	//LOB(large object)是一种用于存储大对象的数据类型 
	//因为默认长度是255，太短了，一遍文章可能是2000+字，一张图片可以能10K
	@Lob 
	private String text;
	
	//一张图片可以能10K，所以用大对象来存储
	@Lob
	private byte[] img;
	
	@Column(name="post_time")
	@Temporal(TemporalType.TIMESTAMP) //时间的存储精度，默认是TIMESTAMP
	private Date posttime;
	
	@Enumerated(EnumType.ORDINAL) //集合的存储格式 默认是ORDINAL,存数字
	private ArticleType type;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public ArticleType getType() {
		return type;
	}

	public void setType(ArticleType type) {
		this.type = type;
	}
	
}
