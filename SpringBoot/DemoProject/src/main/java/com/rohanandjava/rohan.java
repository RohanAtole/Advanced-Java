package com.rohanandjava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class rohan {

	@GetMapping("/home")
	public String home() {
		return "Hey EveryOne"; 
	}
}
