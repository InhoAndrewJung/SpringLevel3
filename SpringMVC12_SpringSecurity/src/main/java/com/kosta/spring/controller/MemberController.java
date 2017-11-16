package com.kosta.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("user.kosta")
	public String user() {
		return "security/user";
	}
	
	@RequestMapping("admin.kosta")
	public String admin() {
		return "security/admin";
	}
	
	@RequestMapping("guest.kosta")
	public String guest() {
		return "security/guest";
	}
}
