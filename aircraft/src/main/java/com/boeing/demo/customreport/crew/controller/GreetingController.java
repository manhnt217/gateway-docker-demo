package com.boeing.demo.customreport.crew.controller;

import com.boeing.demo.customreport.crew.entity.Greeting;
import com.boeing.demo.customreport.crew.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class GreetingController {

	@Autowired
	GreetingService greetingService;

	@GetMapping("/greeting")
	public Greeting greeting() {
		return greetingService.greet();
	}

	@GetMapping("/")
	public String index() {
		return "AIRCRAFT";
	}
}
