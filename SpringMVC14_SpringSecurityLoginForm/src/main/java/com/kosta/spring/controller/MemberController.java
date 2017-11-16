package com.kosta.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/main")
	public String main() {
		return "/member/main";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "/member/mypage";
	}
}
