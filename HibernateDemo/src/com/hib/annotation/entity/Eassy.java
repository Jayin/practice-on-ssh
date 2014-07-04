package com.hib.annotation.entity;

import javax.persistence.Entity;

@Entity
public class Eassy extends Article {
	
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
