package com.checonbinh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="size")
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idSize;
	String nameSize;
	public int getIdSize() {
		return idSize;
	}
	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}
	public String getNameSize() {
		return nameSize;
	}
	public void setNameSize(String nameSize) {
		this.nameSize = nameSize;
	}
	
}
