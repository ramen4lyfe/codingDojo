package com.omikuji2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowOmikujiController {
	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		String result = (String) session.getAttribute("resultOmikuji");
		model.addAttribute("result", result);
		return "showOmikuji.jsp";
	}
}
