package com.example.demo;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cloak01Application {

	public static void main(String[] args) {
		SpringApplication.run(Cloak01Application.class, args);
	}

}
