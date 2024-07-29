package com.application.busangiants.bestPlayer;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BestPlayerDAO {

	public void insertBestPlayer(BestPlayerDTO bestPlayerDTO);
	
}
