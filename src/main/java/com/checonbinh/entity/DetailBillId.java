package com.checonbinh.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class DetailBillId {
	int idBill;
	int idDetailProduct;
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public int getIdDetailProduct() {
		return idDetailProduct;
	}
	public void setIdDetailProduct(int idDetailProduct) {
		this.idDetailProduct = idDetailProduct;
	}
}
