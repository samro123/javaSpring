package com.checonbinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checonbinh.entity.DetailProduct;
import com.checonbinh.entity.Product;
import com.checonbinh.imp.ProductImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductDao implements ProductImp{
   
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Product> listProducts(int startProduct) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from product";
		
		List<Product> listProduct = (List<Product>) session.createQuery(sql).setFirstResult(startProduct).setMaxResults(20).getResultList();
		return listProduct;
	}

	@Transactional
	public Product ProductDetails(int idProduct) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from product where idProduct = "+idProduct;
		Product product = (Product) session.createQuery(sql).getSingleResult();
		return product;
	}

}
