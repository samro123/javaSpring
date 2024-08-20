package com.checonbinh.imp;

import java.util.List;

import com.checonbinh.entity.Product;


public interface ProductImp {
	List<Product> listProducts(int startProduct);
	Product ProductDetails(int idProduct);
}
