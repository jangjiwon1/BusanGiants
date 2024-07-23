package com.application.busangiants.admin.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.busangiants.member.MemberDTO;

@Mapper
public interface AdminMemberDAO {

	public AdminDTO adminLogin(AdminDTO adminDTO);
	public List<MemberDTO> getMemberList();
	
}
