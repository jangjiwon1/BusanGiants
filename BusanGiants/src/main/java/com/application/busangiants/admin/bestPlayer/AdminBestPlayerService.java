package com.application.busangiants.admin.bestPlayer;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.application.busangiants.bestPlayer.BestPlayerDTO;

public interface AdminBestPlayerService {
	
	public List<BestPlayerDTO> getBestPlayerList();
	public void addBestPlayer(MultipartFile upFile , BestPlayerDTO bestPlayerDTO) throws IllegalStateException, IOException;
	public void updateBestPlayer(MultipartFile upFile , BestPlayerDTO bestPlayerDTO) throws IllegalStateException, IOException;
	public void deleteBestPlayer(long bestPlayerId);

}
