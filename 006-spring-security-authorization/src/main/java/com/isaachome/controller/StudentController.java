package com.isaachome.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	
	@GetMapping
	public List<String> getStudents() {
		return List.of("Maung Maung","Thaw Thaw","Maw Maw");
	}
	
	@PostMapping
	public String createStudent() {
		return "Create new Student";
	}
}
