package com.application.busangiants.admin.member;

import java.util.Date;

import lombok.Data;

@Data
public class AdminDTO {
	
	private String adminId;
	private String passwd;
	private Date joinDt;

}
