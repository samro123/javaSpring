package com.checonbinh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="color_product")
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idColor;
	String nameColor;
	public int getIdColor() {
		return idColor;
	}
	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}
	public String getNameColor() {
		return nameColor;
	}
	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}
	

}
