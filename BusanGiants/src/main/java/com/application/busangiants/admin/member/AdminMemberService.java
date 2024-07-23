package com.application.busangiants.admin.member;

import java.util.List;

import com.application.busangiants.member.MemberDTO;

public interface AdminMemberService {
	
	public boolean adminLogin(AdminDTO adminDTO);
	public List<MemberDTO> getMemberList();

}
