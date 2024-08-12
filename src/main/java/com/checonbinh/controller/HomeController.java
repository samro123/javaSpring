package com.checonbinh.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checonbinh.entity.Employee;
import com.checonbinh.entity.Product;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@GetMapping
	@Transactional
	public String Default() {
		Session session = sessionFactory.getCurrentSession();
//		String sql1 = "from employee where idEmployee = 1";
//		Employee list1 = (Employee)session.createQuery(sql1).uniqueResult();
////		list1.setUserName("No No Ro"); 
////		session.update(list1);
//		session.delete(list1);
//		
//		
//		String sql = "from employee";
//		List<Employee> list = session.createQuery(sql).getResultList();
//		for(Employee ee: list) {
//			System.out.println(ee.getUserName());
//		}
		
		Product product = new Product();
		product.setNameProduct("Items5");
		product.setPrice("50000 VND");
		
		
		
		
		Employee employee = new Employee();
		employee.setUserName("Ro");
		employee.setAge(18);
		
		Employee employee1 = new Employee();
		employee1.setUserName("Pu");
		employee1.setAge(18);
		
		Employee employee2 = new Employee();
		employee2.setUserName("Sam");
		employee2.setAge(18);
		
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(employee);
		employees.add(employee1);
		employees.add(employee2);
		
		product.setEmployee(employees);
		
		
		session.save(product);
		
		
		return "home";
	}
	
    

}
