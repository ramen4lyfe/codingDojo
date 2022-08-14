package com.patient.manger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

	@GetMapping("/")
	public String dashboard() {
		return "dashboard.jsp";
	}
}