package com.application.busangiants.user;

import java.util.Date;

import lombok.Data;

@Data
public class loginDTO {
	
	private String memberId;
	private String memberNm;
	private String nickNm;
	private String passwd;
	private String sex;
	private String phoneNo;
	private String email;
	private String zipcode;
	private String roadAdress;
	private String jibunAdress;
	private String namujiAdress;
	private Date   joinDt;

}
