package com.checonbinh.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "detail_bill")
public class DetailBill implements Serializable{
	@EmbeddedId
	DetailBillId detailBillId;
	
    int quantity;
    String price;
	public DetailBillId getDetailBillId() {
		return detailBillId;
	}
	public void setDetailBillId(DetailBillId detailBillId) {
		this.detailBillId = detailBillId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
    
    
}
