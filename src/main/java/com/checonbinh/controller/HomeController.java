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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.checonbinh.entity.Manager;
import com.checonbinh.entity.NhanVien;

@Controller
@RequestMapping("/home")
public class HomeController {
	@GetMapping()
	public String Default() {
		return "home";
	}
	
	@GetMapping("/{name}")
	public String TruyenData(@PathVariable String name, ModelMap modelMap) {
		modelMap.addAttribute("name", name);
		return "home";
	}

}
