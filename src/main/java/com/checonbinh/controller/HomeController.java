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
		System.out.println(nhanVien.getManager().getMoneny() + " " + nhanVien.getManager().getName());
		
		//Resource resource = context.getResource("https://samapi123.wiremockapi.cloud/storeDetails/1");
//		CustomLoader customLoader = new CustomLoader();
//		customLoader.setResourceLoader(context);
		CustomLoader customLoader = (CustomLoader) context.getBean("customLoader");
		Resource resource = customLoader.getResource("https://samapi123.wiremockapi.cloud/storeDetails/1");
		try {
			InputStream inputStream = resource.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = "";
			StringBuilder datas = new StringBuilder();
			while((line = bufferedReader.readLine()) != null) {
				datas.append(line + "\n");
			}
			
			bufferedReader.close();
			reader.close();
			inputStream.close();
			
			System.out.println("Giá trị : " + datas.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "abc";
	}

}
