package com.example.demo;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String index() {
		return "hello";
	}
	
	@PostMapping
	public DeptVo post(DeptVo bean) {
		return bean;
	}
	
}
