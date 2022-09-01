package com.isaachome.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaachome.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@GetMapping
	public List<Product> products() {
		return List.of(new Product("1", "MacBook Pro", "$2500"),
				new Product("3", "Iphone 13 Pro", "$1500"),
				new Product("2", "iMac Pro", "$3500"),
				new Product("4", "Macbook Pro 14", "$4500"));
	}
}
