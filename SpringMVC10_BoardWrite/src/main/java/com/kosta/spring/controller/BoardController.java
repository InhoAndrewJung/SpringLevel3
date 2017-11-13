package com.kosta.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.spring.model.BoardVO;
import com.kosta.spring.model.MemberVO;
import com.kosta.spring.service.BoardService;
import com.kosta.spring.service.ListVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("write.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response,
							HttpSession session,BoardVO bvo) throws Exception{
		MemberVO mvo = (MemberVO)session.getAttribute("mvo");
		if(mvo==null){ //로그인 상태가 아니다...글쓰기로 못간다..
			return new ModelAndView("redirect:/index.jsp");			
		}
		//로그인 한 상태라면
		bvo.setMemberVO(mvo); //bvo와 mvo의 Hasing 관계가 성립된다..
		boardService.write(bvo); //w_date
		return new ModelAndView("board/show_content", "bvo",bvo);
	}
	
	@RequestMapping("delete.do")
	public ModelAndView delete(String no) throws Exception{
		System.out.println("init delete controller...");		
		boardService.delete(no);
		System.out.println("complete delete...");
		//boardService.delete(no); //w_date
		return new ModelAndView("redirect:/list.do");
	}
	
	@RequestMapping("update.do")
	public ModelAndView update(String no) throws Exception{
		System.out.println("init update controller...");
		BoardVO bvo = boardService.showContent(no);
		System.out.println("complete update...");
		return new ModelAndView("board/update","bvo",bvo);
	}
	
	@RequestMapping("updateBoard.do")
	public ModelAndView update(BoardVO bvo) throws Exception{
		boardService.updateBoard(bvo);//디비에 데이터를 직접 수정
		return new ModelAndView("board/show_content","bvo",boardService.showContent(bvo.getNo()+""));
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, String pageNo) throws Exception{
			ListVO lvo = boardService.getBoardList(pageNo);
			
			return new ModelAndView("board/list", "lvo",lvo);			
		}
	
	@RequestMapping("showContent.do")
	public ModelAndView showContent(HttpServletRequest request, HttpServletResponse response, String no) throws Exception{
		MemberVO mvo = (MemberVO)request.getSession().getAttribute("mvo");
		if(mvo == null) {//로그인하지 않았다
			return new ModelAndView("redirect:/index.jsp");//리다이렉트는 viewResolver에 영향을 받지 않음
		}
		//조회수 증가 로직을 추가
		boardService.updateCount(no);
		BoardVO bvo = boardService.showContent(no);		
		return new ModelAndView("board/show_content", "bvo",bvo);			
		
	}
}








