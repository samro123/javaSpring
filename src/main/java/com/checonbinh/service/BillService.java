package com.checonbinh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checonbinh.dao.BillDao;
import com.checonbinh.entity.Bill;
import com.checonbinh.imp.BillImp;

@Service
public class BillService implements BillImp{
	
	@Autowired
	BillDao billDao;

	public int addBill(Bill bill) {
		
		return  billDao.addBill(bill);
	}

}
