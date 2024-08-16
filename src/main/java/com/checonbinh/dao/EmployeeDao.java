package com.checonbinh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checonbinh.entity.Employee;
import com.checonbinh.imp.EmployeeImp;

@Repository
public class EmployeeDao implements EmployeeImp{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean checkLogin(String name, String password) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "from employee where userName='"+name+"' AND password='"+password+"'";
			Employee employee = (Employee)session.createQuery(sql).getSingleResult();
			
			if(employee != null) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
}
