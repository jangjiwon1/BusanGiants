package com.application.busangiants.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/register")
	public String register() {
		return "user/member/register";
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String register(MemberDTO memberDTO) {
		
		memberService.addMember(memberDTO);
		
		String jsScript = """
				<script>
					alert('회원가입되었습니다.');
					location.href='/';
				</script>""";
		
		return jsScript;
	}
	
	@PostMapping("/checkDuplicatedId")
	@ResponseBody
	public String checkDuplicatedId(@RequestParam("memberId") String memberId) {
		return memberService.checkDuplicatedId(memberId);
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/member/login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String login(MemberDTO memberDTO, HttpServletRequest request) {
		
		String jsScript = "";
		if (memberService.login(memberDTO)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberDTO.getMemberId());
			
			jsScript = """
					<script>
						location.href='/';
					</script>""";
		
		}
		
		else {
			jsScript = """
					<script>
						alert('로그인에 실패하였습니다. 아이디와 비밀번호를 확인하세요.')
						history.go(-1);
					</script>
					""";
		}
		
		return jsScript;
	}
	
	@GetMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		String jsScript = """
				<script>
					alert('로그아웃 되었습니다.');
					location.href='/';
				</script>
				""";
		
		return jsScript;
	}
	
	
	
}
