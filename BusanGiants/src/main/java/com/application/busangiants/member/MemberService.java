package com.application.busangiants.member;

public interface MemberService {
	
	public boolean login(MemberDTO memberDTO);
	public void addMember(MemberDTO memberDTO);
	public String checkDuplicatedId(String memberId);


}
