package com.checonbinh.imp;

import com.checonbinh.entity.Employee;

public interface EmployeeImp {
	boolean checkLogin(String name, String password);
	boolean addEmployee(Employee employee);
}
