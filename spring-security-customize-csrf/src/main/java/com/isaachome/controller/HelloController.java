package com.isaachome.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

	@PostMapping("/hello")
	public String hello() {
		return "Post Hello!";
	}
	
	@PostMapping("/ciao")
	public String  ciao() {
		return "Postt Ciao";
	}
	
	@GetMapping("/hello")
	public String getHello() {
		return "Get Hello";
	}
	
}
