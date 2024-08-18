package com.checonbinh.controller;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {
	
//	@Autowired
//	SessionFactory sessionFactory;
	
	
	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap, HttpSession httpSession) {
		if(httpSession.getAttribute("user")!=null) {
		 String name = (String) httpSession.getAttribute("user");
	
		 String firstName = name.substring(0,1);
		 System.out.println(firstName);
		 modelMap.addAttribute("firstName", firstName);
		}
		return "home";
	}
	
    

}
