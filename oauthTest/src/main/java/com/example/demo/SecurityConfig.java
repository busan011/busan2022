package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
//				.antMatchers("/", "/home").permitAll()
				
				.mvcMatchers("/articles/**")
		        .hasAuthority("SCOPE_articles.read")
				.anyRequest().authenticated()
			)
			.oauth2ResourceServer().jwt().and().and()
			.formLogin((form) -> form
//				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
		return http.build();
	}
	
}
