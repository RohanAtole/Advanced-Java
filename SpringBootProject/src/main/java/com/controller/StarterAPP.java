package com.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StarterAPP {

	public static void main(String args[]) {
		
		SpringApplication springApplication = new SpringApplication(StarterAPP.class);
		ConfigurableApplicationContext container = springApplication.run();
	}
}
