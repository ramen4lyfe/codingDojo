package com.relationships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class createPersonController {

	
//	@Autowired
	
	@GetMapping("/") 
	public String redirect() {
		return "redirect:/persons";
	}
	
	@GetMapping("/persons")
	public String persons() {
		return "persons.jsp";
	}
}
