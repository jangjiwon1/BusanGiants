package com.application.busangiants.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired PasswordEncoder passwordEncoder;
	
	@Override
	public boolean login(MemberDTO memberDTO) {
		
		MemberDTO checkExsistId = memberDAO.login(memberDTO);
		if (checkExsistId != null) {
			if (passwordEncoder.matches(memberDTO.getPasswd() ,checkExsistId.getPasswd())) {
				return true;
			}
		}
		
		return false;
		
	}
	
	@Override
	public void addMember(MemberDTO memberDTO) {
		
		memberDTO.setPasswd(passwordEncoder.encode(memberDTO.getPasswd()));
		memberDAO.register(memberDTO);
	}
	
	@Override
	public String checkDuplicatedId(String memberId) {
		
		if (memberDAO.checkDuplicatedId(memberId) == null)	return "duplicate";
		else												return "notDuplicate";
			
	}
	
}
