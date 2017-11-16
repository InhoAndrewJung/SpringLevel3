package com.kosta.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/home/main")
	public String homeMain() {
		return "homeMain";
	}
	
	@RequestMapping("/manager/main")
	public String managerMain() {
		return "managerMain";
	}
	
	@RequestMapping("/member/main")
	public String memberMain() {
		return "memberMain";
	}
	
	@RequestMapping("/admin/main")
	public String adminMain() {
		return "adminMain";
	}
}
