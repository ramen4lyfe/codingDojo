package com.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class HelloHumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String searchQuery) {
		if(searchQuery==null) {
			return "HELLO HUMAN";
		}
		else {
			return "You searched for: " + searchQuery;
		}
		
	}
}