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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name="product")
public class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idProduct;
	String nameProduct;
	int price;
	String image;
	String describes;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCategory")
	Category category;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idProduct")
	Set<DetailProduct> detailProducts;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="detail_discount", 
    joinColumns = {@JoinColumn(name="idProduct", referencedColumnName = "idProduct")},
    inverseJoinColumns = {@JoinColumn(name = "idDiscount", referencedColumnName = "idDiscount")})
    Set<Discount> discounts;
	
	
	
	

	public Set<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}

	public Set<DetailProduct> getDetailProducts() {
		return detailProducts;
	}

	public void setDetailProducts(Set<DetailProduct> detailProducts) {
		this.detailProducts = detailProducts;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
