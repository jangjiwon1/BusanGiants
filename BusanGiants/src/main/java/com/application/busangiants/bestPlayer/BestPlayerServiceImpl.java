package com.application.busangiants.bestPlayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BestPlayerServiceImpl implements BestPlayerService {

	@Autowired
	private BestPlayerDAO bestPlayerDAO;
	
	public List<BestPlayerDTO> getBestPlayerList(BestPlayerDTO bestPlayerDTO) {
		return bestPlayerDAO.getBestPlayerList(bestPlayerDTO);
	}
	
	public BestPlayerDTO getBestPlayerDetail(long bestPlayerId) {
		return bestPlayerDAO.getBestPlayerDetail(bestPlayerId);
	}
	
}
