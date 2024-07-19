package com.application.busangiants.config;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Component
public class AuthInterceptorMember implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		
		if (memberId == null) {
			
			String jsScript = """
					
					<script>
						alert('로그인 해주세요.');
						location.href = '/member/login';
					</script>""";
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsScript);
			
			return false;
			
		}
		
		return true;
		
	}

}
