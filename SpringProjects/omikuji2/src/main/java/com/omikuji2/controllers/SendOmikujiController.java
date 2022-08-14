package com.omikuji2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SendOmikujiController {

	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String sendOmikuji() {
		return "sendOmikuji.jsp";
	}
	
	@PostMapping("/omikuji/show")
	public String process(
			@RequestParam("number") int number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,
			@RequestParam("livingThing") String livingThing,
			@RequestParam("nice") String message,
			HttpSession session) {
		String resultOmikuji = String.format("In %s years, you will live in %s with %s as your roommate, %s for a living. The next time you see a %s, you will have good luck. Also, %s", number, city, person, hobby, livingThing, message);
		session.setAttribute("resultOmikuji", resultOmikuji);
		
		return "redirect:/omikuji/show";
	}
}
