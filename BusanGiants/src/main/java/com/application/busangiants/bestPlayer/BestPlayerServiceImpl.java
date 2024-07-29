package com.application.busangiants.bestPlayer;

import org.springframework.beans.factory.annotation.Autowired;

public class BestPlayerServiceImpl implements BestPlayerService {

	@Autowired
	private BestPlayerDAO bestPlayerDAO;
	
	@Override
	public void addNewBestPlayer(BestPlayerDTO bestPlayerDTO) {
		bestPlayerDAO.insertBestPlayer(bestPlayerDTO);
	}
	
}
