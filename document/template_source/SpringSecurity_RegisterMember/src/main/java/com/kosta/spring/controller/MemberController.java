package com.kosta.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.spring.model.MemberService;
import com.kosta.spring.model.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//회원정보수정시 비밀번호 암호화처리를 위한 객체를 주입받는다
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
		
	//회원가입 폼
	@RequestMapping("registerForm")
	public String registerForm() {
		return "member/registerForm";
	}
	
	//회원 가입하기
	/*@RequestMapping("member/registerMember")
		public String insertMaember(MemberVO vo) {
			memberService.registerMember(vo);
			return "member/register_success";
		
	}*/
	//회원 가입하기 :: redirect 방식
	@RequestMapping("member/registerMember")
	public String insertMaember(MemberVO vo) {
		memberService.registerMember(vo);
		return "redirect:/";
	
	}
	
	//로그인 폼
	@RequestMapping("loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	//회원 검색 폼
	@RequestMapping("findMemberByIdForm")
	public String findIdMember() {
		return "member/findForm";
	}
	
	//특정 회원 검색하기
	@RequestMapping("member/findMember")
	public ModelAndView findMember(HttpServletRequest request) {
		String id = request.getParameter("id");
		MemberVO vo=memberService.findMemberById(id);
		return new ModelAndView("member/findMember_result","vo",vo);
	}
	
	//관리자 권한으로 들어가서 회원 명수 파악하기
	@RequestMapping("admin/enterCafe")
	public  ModelAndView adminWelcome() {
		return new ModelAndView("admin/main","count",memberService.getMemberCount());
	}
	
	//아이디 중복확인
	@RequestMapping("idcheckAjax")
	@ResponseBody
	public String idCheckAjax(HttpServletRequest request) {
		return memberService.idcheck(request.getParameter("id"));
	}
	
	//주소 종류별 검색 :: select form
	@RequestMapping("member/addressList")
	public ModelAndView addressList() {
		System.out.println("addressList");
		return new ModelAndView("member/addressList", "list", memberService.getAddressList());
	}
	
	//주소별 회원 검색...?안나옴..Ajax
	/*@RequestMapping("findMemberListByAddress")
	@ResponseBody
	public List<MemberVO> findMemberListByAddress(HttpServletRequest request) { //?address
		System.out.println("findMemberListByAddress");
		return memberService.findMemberListByAddress(request.getParameter("address"));
	}*/
	
	@RequestMapping("findMemberListByAddress")
	/*@ResponseBody*/
	public ModelAndView findMemberListByAddress(HttpServletRequest request) { //?address
		System.out.println("findMemberListByAddress");
		List<MemberVO> list=memberService.findMemberListByAddress(request.getParameter("address"));
		return new ModelAndView("jsonView","list",list);
	}
	
	@RequestMapping("member/updateForm") 
	public String updateForm() {
		return "member/updateForm";
	}
	
	@RequestMapping("updateMemberAction")
	public ModelAndView updateMemberAction(HttpServletRequest request, MemberVO vo) {
		System.out.println("1. MemberVO  :: "+vo);
		//회원정보 수정위해 Spring Security 세션 회원정보를 반환받는다
		MemberVO pvo=(MemberVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println("2. Spring Security 세션 수정 전 회원정보:" + pvo);
		
		//변경할 비밀번호를 암호화한다 
		String encodePassword=passwordEncoder.encode(vo.getPassword());
		vo.setPassword(encodePassword);
		memberService.updateMember(vo);
		
		System.out.println("**********************************************");
		// 수정한 회원정보로 Spring Security 세션 회원정보를 업데이트한다
		pvo.setPassword(encodePassword);
		pvo.setName(vo.getName());
		pvo.setAddress(vo.getAddress());
		System.out.println("3. Spring Security 세션 수정 후 회원정보:" + pvo);
				
		
		return new ModelAndView("member/update_result");
	}
	
}












