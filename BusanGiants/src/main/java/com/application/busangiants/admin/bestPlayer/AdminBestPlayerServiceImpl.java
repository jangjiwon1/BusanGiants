package com.application.busangiants.admin.bestPlayer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.busangiants.bestPlayer.BestPlayerDTO;
import com.application.busangiants.bestPlayer.BestPlayerService;

@Service
public class AdminBestPlayerServiceImpl implements AdminBestPlayerService {

	@Autowired
	public AdminBestPlayerDAO adminBestPlayerDAO;
	
	@Autowired
	private BestPlayerService bestPlayerService;
	
	@Value("${file.repo.path}")
	private String fileRepositoryPath;
	
	@Override
	public List<BestPlayerDTO> getBestPlayerList() {
		return adminBestPlayerDAO.getBestPlayerList();
	}
	
	@Override
	public void addBestPlayer(MultipartFile upFile , BestPlayerDTO bestPlayerDTO) throws IllegalStateException, IOException {
		
		if(!upFile.isEmpty()) {
			String uploadFileName = UUID.randomUUID() + "_" + upFile.getOriginalFilename();
			upFile.transferTo(new File(fileRepositoryPath + uploadFileName));
			bestPlayerDTO.setUpBestPlayer1Img(uploadFileName);
		}
		adminBestPlayerDAO.insertBestPlayer(bestPlayerDTO);
	}
	
	@Override
	public void updateBestPlayer(MultipartFile upFile , BestPlayerDTO bestPlayerDTO) throws IllegalStateException, IOException {
		
		if (!upFile.isEmpty()) {
			String uploadFileName = UUID.randomUUID() + "_" + upFile.getOriginalFilename();
			upFile.transferTo(new File(fileRepositoryPath + uploadFileName));
			bestPlayerDTO.setUpBestPlayer1Img(uploadFileName);
			
			new File(fileRepositoryPath + bestPlayerService.getBestPlayerDetail(bestPlayerDTO.getBestPlayerId()).getPlayer1UUID()).delete();
			
		}
		
		adminBestPlayerDAO.updateBestPlayer(bestPlayerDTO);
	}
	
	@Override
	public void deleteBestPlayer(long bestPlayerId) {
		new File(fileRepositoryPath + bestPlayerService.getBestPlayerDetail(bestPlayerId).getPlayer1UUID()).delete();
		adminBestPlayerDAO.deleteBestPlayer(bestPlayerId);
	}
	
}
