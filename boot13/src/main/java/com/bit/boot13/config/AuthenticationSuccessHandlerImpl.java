package com.bit.boot13.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		System.out.println("1Post "+authentication);
	}
	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("3Post ");
		return super.determineTargetUrl(request, response);
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("2Post "+authentication);
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
