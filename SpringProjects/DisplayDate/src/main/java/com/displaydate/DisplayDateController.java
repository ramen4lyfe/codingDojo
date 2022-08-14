package com.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class DisplayDateController {
	@RequestMapping("/date")
	public String getDate() {
		return new java.util.Date()
	}

}

