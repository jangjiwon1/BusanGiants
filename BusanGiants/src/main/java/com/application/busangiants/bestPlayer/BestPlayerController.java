package com.application.busangiants.bestPlayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bestplayer")
public class BestPlayerController {

	@GetMapping("/bestplayerList")
	public String registration() {
		return "/user/bestplayer/bestplayer";
	}
	
}
