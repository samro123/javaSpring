package com.checonbinh.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmployee")
	int idEmployee;
	@Column(name = "UserName")
	String userName;
	@Column(name = "Age")
	int age;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "employee_product",
			joinColumns = {@JoinColumn(name = "idEmployee", referencedColumnName = "idEmployee")},
			inverseJoinColumns = {@JoinColumn(name = "idProduct", referencedColumnName = "idProduct")}
			)
	Set<Product> products;
	
	
	
	
	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	

}
