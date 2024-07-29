package com.application.busangiants.bestPlayer;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


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
	public Resource thumbnails(@RequestParam("upBestPlayer1Img") String upBestPlayer1) throws MalformedURLException {
		// new UrlResource("file:" + 파일접근경로) 객체를 반환하여 이미지를 조회한다.
		return new UrlResource("file:" + fileRepositoryPath + upBestPlayer1);	// 이미지 경로를 수정하여 사용한다.
	}
	
	@PostMapping("/upload")
	@ResponseBody
	
	public String upload(@RequestParam("upBestPlayer1Img") List<MultipartFile> upBestPlayer1Img) throws IllegalStateException, IOException {
		
		for (MultipartFile file : upBestPlayer1Img) {
			
			if (!upBestPlayer1Img.isEmpty()) {
				
				String originalFilename = file.getOriginalFilename();
				
				UUID uuid = UUID.randomUUID();
				
				String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
				
				String uploadFileName = uuid + extension;
				
				file.transferTo(new File(fileRepositoryPath + uploadFileName));
			}
		}
		
		String jsScript = """
				<script>
					alert('업로드 되었습니다.);
					location.href = '/bestplayer/bestplayerList';
				</script>
				""";
		
		return jsScript;
	}
	
	@PostMapping("/update")
	@ResponseBody
	public String update(@RequestParam("deleteFileName") String deleteFileName , @RequestParam("upBestPlayer1") MultipartFile modifyFile) throws IllegalStateException, IOException {
		
		File deleteFile = new File(fileRepositoryPath + deleteFileName);
		
		if (deleteFile.exists() && !modifyFile.isEmpty()) {
			
			deleteFile.delete();
			
			String originalFilename = modifyFile.getOriginalFilename();
			
			UUID uuid = UUID.randomUUID();
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String uploadFileName = uuid + extension;
			
			modifyFile.transferTo(new File(fileRepositoryPath + uploadFileName));
			
		}
		
		String jsScript = """
				<script>
					alert('수정 되었습니다.');
					location.href = '/bestplayer/bestplayerList';
				</script>
				""";
		
		return jsScript;
	}
	
}

