package com.application.busangiants.bestPlayer;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/bestplayer")
public class BestPlayerController {
	
	@Value("${file.repo.path}")
	private String fileRepositoryPath;
	
	@GetMapping("/bestplayerList")
	public String registration() {
		return "/user/bestplayer/bestplayer";
	}
	
	@GetMapping("/thumbnails")
	@ResponseBody
	public Resource thumbnails(@RequestParam("upBestPlayer1") String upBestPlayer1) throws MalformedURLException {
		// new UrlResource("file:" + 파일접근경로) 객체를 반환하여 이미지를 조회한다.
		return new UrlResource("file:" + fileRepositoryPath + upBestPlayer1);	// 이미지 경로를 수정하여 사용한다.
	}
	
}

