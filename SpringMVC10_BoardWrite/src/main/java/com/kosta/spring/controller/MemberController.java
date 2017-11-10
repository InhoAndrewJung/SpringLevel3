package com.kosta.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.spring.model.MemberVO;
import com.kosta.spring.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, MemberVO pvo) throws Exception{
		System.out.println(" 1. login.....controller..."+pvo);
		MemberVO rvo=memberService.login(pvo);
		System.out.println(" 2. login.....controller..."+rvo);
		if(rvo!=null) {
			request.getSession().setAttribute("mvo", rvo);
		}
		System.out.println(" 3. login.....controller..."+pvo);
		return new ModelAndView("member/login_result");
	}
	
	@RequestMapping("logout.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("mvo");
		if(mvo != null) {//로그인 상태이다
			session.invalidate();
		}
		return new ModelAndView("redirect:/index.jsp");//리다이렉트는 suffix, prefix를 따로 써줘야한다.
	}
}
