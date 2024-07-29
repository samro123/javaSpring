package com.checonbinh.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class NhanVien {
	String name;
	int age;
	Manager manager;
	
	public NhanVien() {
		
	}
	
	public NhanVien(Manager manager) {
		this.manager = manager;
	}
	
	public NhanVien(String name) {
		this.name = name;
	}
	
	public NhanVien(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	


	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	public void Start() {
		System.out.println("Hello init");
	}
	
	public void Destroy() {
		System.out.println("Hello destroy");
	}
	

	public void getMessage() {
		System.out.println("Hello Employee: "+ name);
	}
}
