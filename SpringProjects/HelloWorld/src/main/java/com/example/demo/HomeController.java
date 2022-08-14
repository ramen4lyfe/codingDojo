package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("")
	public String hello() {
		return "Hello asdfasdfs";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "class level annotation are cool too";
	}
	
	@RequestMapping("/")
	public String index() {
	    return "index.jsp";
	}
}
