package com.application.busangiants.admin.bestPlayer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.application.busangiants.bestPlayer.BestPlayerDTO;
import com.application.busangiants.bestPlayer.BestPlayerService;

@Controller
@RequestMapping("/admin/bestplayer")
public class AdminBestPlayerController {
	
	@Autowired
	private AdminBestPlayerService adminBestPlayerService;
	
	@Autowired
	private BestPlayerService bestPlayerService;
	
	@GetMapping("/adminBestPlayerList")
	public String adminBestPlayerList(Model model) {
		model.addAttribute("bestPlayerList", adminBestPlayerService.getBestPlayerList());
		return "admin/bestplayer/adminBestPlayerList";
	}
	
	@GetMapping("/adminBestPlayerAdd")
	public String addBestPlayer() {
		return "admin/bestplayer/adminBestPlayerAdd";
	}
	
	@PostMapping("/adminBestPlayerAdd")
	@ResponseBody
	public String addNewBestPlayer(@RequestParam("upFile") MultipartFile upFile , @ModelAttribute BestPlayerDTO bestPlayerDTO) throws IllegalStateException, IOException {
		
		adminBestPlayerService.addBestPlayer(upFile, bestPlayerDTO);
		
		String jsScript = """
				<script>
					alert('정보를 등록하였습니다.');
					location.href='/admin/bestplayer/adminBestPlayerList';
				</script>""";
		
		return jsScript;
		
	}
	
	@GetMapping("/adminBestPlayerUpdate")
	public String updateBestPlayer(Model model , @RequestParam("bestPlayerId") long bestPlayerId) {
		
		model.addAttribute("bestPlayerDTO" , bestPlayerService.getBestPlayerDetail(bestPlayerId));
		
		return "admin/bestplayer/adminBestPlayerUpdate";
		
	}
	
	@PostMapping("/adminBestPlayerUpdate")
	@ResponseBody
	public String updateBestPlayer(@RequestParam("upFile") MultipartFile upFile , @ModelAttribute BestPlayerDTO bestPlayerDTO) throws IllegalStateException, IOException {
		
		adminBestPlayerService.updateBestPlayer(upFile, bestPlayerDTO);
		
		String jsScript = """
				<script>
					alert('정보를 수정하였습니다.');
					location.href='/admin/bestplayer/adminBestPlayerList';
				</script>""";
		
		return jsScript;
	}
	
	@GetMapping("/adminBestPlayerDelete")
	@ResponseBody
	public String adminBestPlayerDelete(@RequestParam("bestPlayerId") long bestPlayerId) {
		
		adminBestPlayerService.deleteBestPlayer(bestPlayerId);
		
		String jsScript = """
				<script>
					alert('등록된 정보를 삭제하였습니다.');
					location.href='/admin/bestplayer/adminBestPlayerList';
				</script>
				""";
		
		return jsScript;
	}


}
