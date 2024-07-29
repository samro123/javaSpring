package com.checonbinh.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
		
		NhanVien nv = new NhanVien();
		nv.setName("Sam ");
		nv.setAge(10);
		
		NhanVien nv1 = new NhanVien();
		nv1.setName("Ro");
		nv1.setAge(12);
		
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		listNhanVien.add(nv);
		listNhanVien.add(nv1);
		
		modelMap.addAttribute("nhanvien", listNhanVien);
		modelMap.addAttribute("password", "password");
		return "home";
	}

}
