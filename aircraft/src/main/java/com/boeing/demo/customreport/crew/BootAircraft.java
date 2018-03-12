package com.boeing.demo.customreport.crew;

import com.boeing.demo.customreport.crew.controller.GreetingController;
import com.boeing.demo.customreport.crew.service.GreetingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 */
@SpringBootApplication(scanBasePackageClasses = {
		GreetingController.class,
		GreetingService.class
})
public class BootAircraft {

	public static void main(String[] args) {

		SpringApplication.run(BootAircraft.class, args);
	}
}
