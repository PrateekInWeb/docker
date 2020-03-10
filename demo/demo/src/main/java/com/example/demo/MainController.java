package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MainController {
	
	
	public String hello() {
		
		return "hello docker host";
	}

}
