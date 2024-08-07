package com.checonbinh.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

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

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@GetMapping
	@Transactional
	public String Default() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from employee";
		List<Employee> list = session.createQuery(sql).getResultList();
		for(Employee ee: list) {
			System.out.println(ee.getUserName());
		}
		return "home";
	}
	
//	@GetMapping("/{name}")
//	public String TruyenData(@PathVariable String name, ModelMap modelMap) {
//		modelMap.addAttribute("name", name);
//		NhanVien nv = new NhanVien();
//		nv.setName("Sam");
//		nv.setAge(12);
//		
//		NhanVien nv1 = new NhanVien();
//		nv1.setName("Sam");
//		nv1.setAge(12);
//		
//		List<NhanVien> list = new ArrayList<NhanVien>();
//		list.add(nv1);
//		list.add(nv);
//		modelMap.addAttribute("list", list);
//		
//		return "home";
//	}

}
