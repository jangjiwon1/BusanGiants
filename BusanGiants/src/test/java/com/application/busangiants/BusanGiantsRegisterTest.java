package com.application.busangiants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.busangiants.member.MemberDAO;
import com.application.busangiants.member.MemberDTO;

@SpringBootTest
public class BusanGiantsRegisterTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	@DisplayName("회원가입")
	public void memberRegister() {
	
		System.out.println("\n --- 회원가입 --- \n");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId("testUser1");
		
		memberDAO.register(memberDTO);
		
		
		
	}
	
}
