package com.isaachome.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class HelloController {

	@GetMapping
	public String getStudent() {
		return "Hello Student !";
	}
	@PostMapping
	public String createStudent() {
		return "create new Student";
	}
}
