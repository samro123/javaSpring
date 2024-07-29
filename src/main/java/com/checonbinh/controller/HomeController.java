package com.checonbinh.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.checonbinh.entity.Manager;
import com.checonbinh.entity.NhanVien;

@Controller
public class HomeController {
//	@RequestMapping("/home")
//	public ModelAndView Home() {
//		ModelAndView viewHome = new ModelAndView();
//		viewHome.setViewName("home");
//		
//	String username = "Sam";
//	String password = "123456789";
//	
//	viewHome.addObject("username", username);
//	viewHome.addObject("password", "password");
//		return viewHome;
//	}
	@RequestMapping("/home")
	public String Home(ModelMap modelMap) {
		String username = "Sam";
		String password = "123456789";
		
		modelMap.addAttribute("username", username);
		modelMap.addAttribute("password", "password");
		return "home";
	}

}
