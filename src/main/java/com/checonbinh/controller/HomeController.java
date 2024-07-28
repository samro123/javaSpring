package com.checonbinh.controller;


import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.checonbinh.entity.Manager;
import com.checonbinh.entity.NhanVien;

@Controller
public class HomeController {
	@RequestMapping("/home")
	@ResponseBody
	public String Home() {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		NhanVien nhanVien = (NhanVien) context.getBean("nhanvien");
//		nhanVien.getMessage();
//		((ClassPathXmlApplicationContext)context).close();
		System.out.println(nhanVien.getManager().getMoneny());
		for(Manager value:nhanVien.getList()) {
			System.out.println(value.getName());
		}
		//duyệt 1 giá trị
//		Manager manger = (Manager)nhanVien.getMap().get("key2");
//		System.out.println(manger.getName());
		
		//duyệt tất cả các giá trị entry.
		for(Entry<String, Object> entry: nhanVien.getMap().entrySet()) {
			System.out.println(entry.getKey() +  " - " + entry.getValue());
		}
		
		//property
		String jdbc = nhanVien.getProperties().getProperty("jdbc");
		System.out.println(jdbc);
		return "abc";
	}

}
