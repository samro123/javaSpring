package com.checonbinh.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "discount")
public class Discount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idDiscount;
	String nameDiscount;
	String timeStart;
    String timeEnd ;
    String image ;
    String describes;
    int discountPrice;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="detail_discount", 
    joinColumns = {@JoinColumn(name="idDiscount", referencedColumnName = "idDiscount")},
    inverseJoinColumns = {@JoinColumn(name = "idProduct", referencedColumnName = "idProduct")})
    Set<Product> products;

	public int getIdDiscount() {
		return idDiscount;
	}

	public void setIdDiscount(int idDiscount) {
		this.idDiscount = idDiscount;
	}

	public String getNameDiscount() {
		return nameDiscount;
	}

	public void setNameDiscount(String nameDiscount) {
		this.nameDiscount = nameDiscount;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
    
    
    
    
}
