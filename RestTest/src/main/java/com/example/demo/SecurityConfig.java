package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		AuthenticatedProcessingFilter filter = new AuthenticatedProcessingFilter();
        
        filter.setAuthenticationManager(new AuthenticationManager() 
        {
            @Override
            public Authentication authenticate(Authentication authentication) 
                              throws AuthenticationException 
            {
                String principal = (String) authentication.getPrincipal();
                authentication.setAuthenticated(true);
                System.out.println(principal);
                System.out.println(authentication.getAuthorities());
                return authentication;
            }
        });
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		http
			.httpBasic()
			.and()
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()//.hasRole("USER")
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.formLogin().permitAll()//.defaultSuccessUrl("/")
			.and()
			.logout().permitAll();
		return http.build();
		}
	
	@Bean
	UserDetailsService userDetailsService() {
 		UserDetails user = User.builder()
 			.username("aaa")
 			.password(passwordEncoder().encode("bbb"))
 			.roles("USER")
 			.build();
 		return new InMemoryUserDetailsManager(user);
  	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
