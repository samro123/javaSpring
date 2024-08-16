package com.checonbinh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checonbinh.dao.EmployeeDao;
import com.checonbinh.imp.EmployeeImp;

@Service
public class EmployeeService implements EmployeeImp{
	@Autowired
	EmployeeDao employeeDao;
	
	public boolean checkLogin(String name, String password) {
		boolean check = employeeDao.checkLogin(name, password);
		return check;
	}

}
