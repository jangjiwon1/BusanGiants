package com.application.busangiants.bestPlayer;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/bestplayer")
public class BestPlayerController {
	
	@Autowired
	private BestPlayerService bestPlayerService;
	
	@GetMapping("/bestplayerList")
	public String bestPlayerList(Model model , @ModelAttribute BestPlayerDTO bestPlayerDTO) {
		model.addAttribute("bestplayerList" , bestPlayerService.getBestPlayerList(bestPlayerDTO));
		return "/user/bestplayer/bestplayer";
	}
	


	

	
}

