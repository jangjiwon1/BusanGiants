package com.application.busangiants.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptorAdmin authInterceptorAdmin;
	
	@Autowired
	private AuthInterceptorMember authInterceptorMember;
	
	String[] adminAcceessModifierList = {"/admin/**"};
	String[] memberAcceessModifierList = {"/myPage/*"};
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(authInterceptorAdmin)
				.order(1)
				.addPathPatterns(adminAcceessModifierList)
				.excludePathPatterns("/admin/member/adminLogin");
		
		registry.addInterceptor(authInterceptorMember)
				.order(2)
				.addPathPatterns(memberAcceessModifierList);
		
	}
	
}
