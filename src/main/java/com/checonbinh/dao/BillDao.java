package com.checonbinh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checonbinh.entity.Bill;
import com.checonbinh.imp.BillImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BillDao implements BillImp{
	
	@Autowired
    SessionFactory sessionFactory;
	
	
    @Transactional
	public int addBill(Bill bill) {
    	Session session = sessionFactory.getCurrentSession();
    	int id = (Integer) session.save(bill);
    	if(0<id) {
    		return id;
    	}else {
    	return 0;
    	}
	}

}
