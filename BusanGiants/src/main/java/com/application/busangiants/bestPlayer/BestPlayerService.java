package com.application.busangiants.bestPlayer;

import java.util.List;

public interface BestPlayerService {
	
	public List<BestPlayerDTO> getBestPlayerList(BestPlayerDTO bestPlayerDTO);
	public BestPlayerDTO getBestPlayerDetail(long bestPlayerId);

}
