package com.application.busangiants.member;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {

	private String memberId;
	private String memberNm;
	private String nickNm;
	private String passwd;
	private String sex;
	private String dateBirth;
	private String phoneNo;
	private String email;
	private String zipcode;
	private String roadAddress;
	private String jibunAddress;
	private String namujiAddress;
	private Date   joinDt;
	
}
