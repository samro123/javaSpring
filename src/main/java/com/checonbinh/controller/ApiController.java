package com.checonbinh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.checonbinh.service.EmployeeService;

@Controller
@RequestMapping("api/")
@SessionAttributes("user")
public class ApiController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("checkLogin")
	@ResponseBody
	public String checkLogin(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
		boolean checkLogin = employeeService.checkLogin(name, password);
		modelMap.addAttribute("user", name);
		return ""+checkLogin;
	}
}
