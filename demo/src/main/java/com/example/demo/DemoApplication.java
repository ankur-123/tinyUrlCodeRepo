package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.example.interfaces.IUrlService;

@SpringBootApplication
@EntityScan("com")
public class DemoApplication {

	
	@Autowired
	IUrlService urlService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
		
	}

}
