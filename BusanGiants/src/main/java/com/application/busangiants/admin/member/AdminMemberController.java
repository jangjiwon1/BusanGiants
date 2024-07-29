package com.application.busangiants.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@Autowired
	private AdminMemberService adminMemberService;
	
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "admin/member/adminLogin";
	}
	
	@PostMapping("/adminLogin")
	@ResponseBody
	public String adminLogin(AdminDTO adminDTO, HttpServletRequest request) {
		String jsScript = "";
		
		if (adminMemberService.adminLogin(adminDTO)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("memberId", adminDTO.getAdminId());
			session.setAttribute("role", "admin");
			
			jsScript = """
					<script>
						alert('로그인 되었습니다.');
						location.href = '/';
						</script>
					""";
			
		}
		else {
			
			jsScript = """
					<script>
						alert('로그인에 실패하였습니다. 아이디와 비밀번호를 확인하세요.');
						history.go(-1);
						</script>
					""";
		}
		
		return jsScript;
		
	}
	
	@GetMapping("/adminMemberList")
	public String adminMemberList(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		session.setAttribute("sideMenu", "adminMode");
		
		model.addAttribute("memberList" , adminMemberService.getMemberList());
		
		return "/";
		
	}
	
	
}
