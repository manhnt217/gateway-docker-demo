package com.boeing.demo.customreport.crew.service.impl;

import com.boeing.demo.customreport.crew.entity.Greeting;
import com.boeing.demo.customreport.crew.service.GreetingService;
import com.boeing.demo.customreport.lib.StringUtil;
import org.springframework.stereotype.Service;

/**
 */
@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {
	public Greeting greet() {
		return new Greeting();
	}
}
