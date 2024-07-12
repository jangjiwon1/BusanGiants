package com.application.busangiants.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {

	public MemberDTO login(MemberDTO memberDTO);
	public void register(MemberDTO memberDTO);
	public String checkDuplicatedId(String memberId);
	
}
