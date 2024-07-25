package com.application.busangiants.matches;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/matches")
public class MatchesController {
	
	@GetMapping("matchesList")
	public String matchesList() {
		return "user/matches/matches";
	}
}
