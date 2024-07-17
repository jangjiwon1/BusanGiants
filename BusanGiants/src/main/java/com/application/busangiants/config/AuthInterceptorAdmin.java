package com.application.busangiants.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthInterceptorAdmin implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		String role = (String)session.getAttribute("role");
		
		if (role == null || !role.equals("admin")) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		
		return true;
	}
	
}
