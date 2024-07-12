package com.application.busangiants.myPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

	@GetMapping("user/mypage")
	public String myPage() {
		return "user/mypage";
	}
	
}
