package com.checonbinh.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name="detail_product")
public class DetailProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idDetailProduct;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProduct")
	Product product;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idColor")
	Color color;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSize")
	Size size;
	
	int quantity;
	String entryDate;
	public int getIdDetailProduct() {
		return idDetailProduct;
	}
	public void setIdDetailProduct(int idDetailProduct) {
		this.idDetailProduct = idDetailProduct;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	
	
}
