package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.auth.ApplicationUserService;
import com.example.demo.security.ApplicationSecurityConfig;

@SpringBootApplication
public class SpringSecurityApplication {
	
    private static ApplicationContext applicationContext;

	public static void main(String[] args) {
	
		applicationContext = SpringApplication.run(SpringSecurityApplication.class, args);
		
	}   

}