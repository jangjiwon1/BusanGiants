package com.application.busangiants.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@GetMapping("/registrationList")
	public String registrationList() {
		return "user/registration/registration";
	}

}
