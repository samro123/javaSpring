package com.checonbinh.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
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
	public String processLogin(@RequestParam String name, @RequestParam String password, ModelMap map) {
		boolean checkLogin = employeeService.checkLogin(name, password);
		if(checkLogin) {
			map.addAttribute("checkLogin", "Successly");
		}else {
			map.addAttribute("checkLogin", "Fauil");
		}
		return "login";
	}
}
