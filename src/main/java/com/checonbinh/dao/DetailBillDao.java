package com.checonbinh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checonbinh.entity.DetailBill;
import com.checonbinh.entity.DetailBillId;
import com.checonbinh.imp.DetailBillImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DetailBillDao implements DetailBillImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addDetailBill(DetailBill detailBill) {
		Session session = sessionFactory.getCurrentSession();
		DetailBillId id = (DetailBillId) session.save(detailBill);
		if(null != id ) {
			return true;
		}else {
		return false;
		}
	}

}
