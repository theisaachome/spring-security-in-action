package com.isaachome.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	
	@GetMapping
	public String getCourses() {
		return "Get All Courses";
	}
	
	@GetMapping("/one")
	public String getCourse() {
		return "Get One Course";
	}
	
	@PostMapping
	public String createCourse() {
		return "Create Course";
	}
	
}
