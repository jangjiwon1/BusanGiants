package com.application.busangiants.bestPlayer;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BestPlayerDAO {

	public List<BestPlayerDTO> getBestPlayerList(BestPlayerDTO bestPlayerDTO);
	public BestPlayerDTO getBestPlayerDetail(long bestPlayerId);
	
}
