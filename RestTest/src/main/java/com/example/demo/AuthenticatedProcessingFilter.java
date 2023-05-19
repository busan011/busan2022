package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class AuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		System.out.println("getPreAuthenticatedPrincipal");
		return "aaaa";
	}

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		System.out.println("getPreAuthenticatedCredentials");
		return "bbbb";
	}

}
