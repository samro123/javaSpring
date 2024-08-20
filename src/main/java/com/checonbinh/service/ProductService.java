package com.checonbinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checonbinh.dao.ProductDao;
import com.checonbinh.entity.Product;
import com.checonbinh.imp.ProductImp;

@Service
public class ProductService implements ProductImp{
	
	@Autowired
	ProductDao productDao;

	public List<Product> listProducts(int startProduct) {
		return productDao.listProducts(startProduct);
		
	}

}
