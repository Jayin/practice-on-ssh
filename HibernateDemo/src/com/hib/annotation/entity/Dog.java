package com.hib.annotation.entity;

import javax.persistence.Entity;

@Entity
@javax.persistence.Table(name = "dog")
public class Dog extends Animal {
	
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
