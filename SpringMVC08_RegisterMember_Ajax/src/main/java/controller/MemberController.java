package controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.metal.MetalMenuBarUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.MemberService;
import model.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("register.do")
	public ModelAndView register(MemberVO vo)throws Exception {
		memberService.registerMember(vo);//디비에 인자값으로 바인딩된  vo가 들어갔다.
		return new ModelAndView("redirect:allMember.do");
	}
	
	@RequestMapping("ajaxidcheck.do")
	public ModelAndView ajaxidcheck(String id)throws Exception {
		boolean flag=memberService.idcheck(id);
		return new ModelAndView("idcheck.jsp", "flag", flag);
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,MemberVO pvo)throws Exception {
		String path = "login_fail.jsp";
		MemberVO rvo=memberService.login(pvo);
		System.out.println("pvo :: "+pvo);//address, name은 null로
		System.out.println("rvo :: "+rvo);//null값이 없는 꽉찬 vo로 출력
		
		if(rvo != null) {
			//중요!!
			request.getSession().setAttribute("vo", rvo);
			path = "login_ok.jsp";
		}
		return new ModelAndView(path);//이미 위에서 바인딩은 됬다.
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)throws Exception {
		HttpSession session=request.getSession();
		
		if(session.getAttribute("vo") != null) {
			session.invalidate();
		}
		return new ModelAndView("index.jsp");
	}
	
	@RequestMapping("updateMember.do")	
		public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response
				, MemberVO pvo)	throws Exception{
			memberService.updateMember(pvo);//이 부분에서 디비의 vo내용이 pvo로 수정이 일어났다.
			//그걸 다시 세션에 반드시 바인딩 해야한다.
			request.getSession().setAttribute("vo", pvo);
			return new ModelAndView("update_result.jsp");//바인딩은 이미 위에서 했다.			
	}	
	@RequestMapping("findByAddress.do")
	public ModelAndView findByAddress(HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<MemberVO> memList=memberService.findByAddress(request.getParameter("address"));
	
		return new ModelAndView("findByAddress_result.jsp","memList",memList);
	}	
	@RequestMapping("getAddressKind.do")
	public ModelAndView getAddressKind
	(HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<String> list=memberService.getAddressKind();
		return new ModelAndView("findByAddress.jsp","list",list);		
	}
	@RequestMapping("allMember.do")
	public ModelAndView allMember(HttpServletRequest request, HttpServletResponse response)throws Exception {
		List<MemberVO> allList=memberService.getAllMember();
		return new ModelAndView("allMember_result.jsp","allList",allList);
	}
}












