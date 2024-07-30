package com.application.busangiants.admin.bestPlayer;

import java.util.List;

import com.application.busangiants.bestPlayer.BestPlayerDTO;

public interface AdminBestPlayerDAO {
	
	public List<BestPlayerDTO>getBestPlayerList();
	public void insertBestPlayer(BestPlayerDTO bestPlayerDTO);
	public void updateBestPlayer(BestPlayerDTO bestPlayerDTO);
	public void deleteBestPlayer(long bestPlayerId);

}
