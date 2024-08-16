package com.checonbinh.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checonbinh.entity.Employee;
import com.checonbinh.service.EmployeeService;

@Controller
@RequestMapping("login/")
public class LoginController {

	@GetMapping
	public String Default() {
		return "login";
	}
	
	

	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping
	@Transactional
	public String processLogin(@RequestParam String name, @RequestParam String password) {
		boolean checkLogin = employeeService.checkLogin(name, password);
		if(checkLogin) {
			System.out.println("Successly");
		}else {
			System.out.println("fauil");
		}
		return "login";
	}
}
