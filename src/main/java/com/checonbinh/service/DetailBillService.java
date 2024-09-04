package com.checonbinh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checonbinh.dao.DetailBillDao;
import com.checonbinh.entity.DetailBill;
import com.checonbinh.imp.DetailBillImp;

@Service
public class DetailBillService implements DetailBillImp{
	
	@Autowired
	DetailBillDao detailBillDao;

	public boolean addDetailBill(DetailBill detailBill) {

		return detailBillDao.addDetailBill(detailBill);
	}

}
