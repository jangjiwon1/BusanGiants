package com.application.busangiants.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@GetMapping("/contactList")
	public String contact() {
		return "user/contact/contact";
	}
	

}
