package com.checonbinh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "positions")
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idPositions;
	String namePosition;
	public int getIdPositions() {
		return idPositions;
	}
	public void setIdPositions(int idPositions) {
		this.idPositions = idPositions;
	}
	public String getNamePosition() {
		return namePosition;
	}
	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}
	

}
