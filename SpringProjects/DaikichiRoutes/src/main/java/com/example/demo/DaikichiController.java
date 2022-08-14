package com.example.demo;

//import java.util.Scanner;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DaikichiController {
	
	@RequestMapping("/daikichi")
	public String welcome() {
		return "Welcome";
	}
	
	//using @PatchVariable, things inside the {} are the path names. Conventionally, you should name the variable the same as the path name for sanity reason. 
	@RequestMapping("/daikichi/travel/{city}")
	public String showDestination(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to  " + city + "!";
	}
	
	@RequestMapping("/daikichi/lotto/{number}")
	public String showLotto (@PathVariable("number") int number) {
		
		// If number is even
		if( number %2 == 0) {
			return ("You will take a grand journey in the future, but we weary of tempting offers.");
		}
		// If number is odd
		else {
			return ("You have enjoyed the fruit of your labot but now is a great time to spend time with family and friends.");
		}
	}
	
}