package com.checonbinh.entity;

public class Manager extends NhanVien{
	double moneny;
	
	public Manager() {
		
	}
	public Manager(String name, int age, double moneny) {
		super(name, age);
		this.moneny = moneny;
	}

	public double getMoneny() {
		return moneny;
	}

	public void setMoneny(double moneny) {
		this.moneny = moneny;
	}
	
	
	
	
}
