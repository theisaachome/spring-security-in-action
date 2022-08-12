package com.isaachome.conntroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

	@GetMapping
	public List<String> getProducts() {
		return List.of("Cocacola","Pessi","Coke","Lotteria","KFC");
	}
}
