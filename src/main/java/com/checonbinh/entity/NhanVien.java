package com.checonbinh.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class NhanVien {
	String name;
	int age;
	Manager manager;
	List<Manager> list;
	Map<String, Object> map;
	Properties properties;
	
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
	
	

	public List<Manager> getList() {
		return list;
	}

	public void setList(List<Manager> list) {
		this.list = list;
	}
	

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
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
