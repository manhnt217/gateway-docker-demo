package com.boeing.demo.customreport.crew.controller;

import com.boeing.demo.customreport.crew.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class GreetingController {

	private static int count = 0;

	@Autowired
	GreetingService greetingService;

	@GetMapping("/greeting")
	public String greeting() {
		return "Hello. You've seen me " + (count++) + " time(s).";
	}

	@GetMapping("/")
	public String index() {
		return "CREW";
	}

	@GetMapping("/foo")
	public String foo() {
		return "CREW - foo";
	}
}
