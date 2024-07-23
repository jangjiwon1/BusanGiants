package com.application.busangiants.admin.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.busangiants.member.MemberDTO;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	private AdminMemberDAO adminMemberDAO;
	
	@Override
	public boolean adminLogin(AdminDTO adminDTO) {
		
		if (adminMemberDAO.adminLogin(adminDTO) != null) {
			return true;
		}
		return false;
		
	}
	
	public List<MemberDTO> getMemberList() {
		return adminMemberDAO.getMemberList();
	}
	
}
