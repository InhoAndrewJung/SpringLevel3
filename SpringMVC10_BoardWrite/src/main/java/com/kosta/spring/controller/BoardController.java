package com.kosta.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.spring.model.BoardVO;
import com.kosta.spring.model.MemberVO;
import com.kosta.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("write.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response, BoardVO bvo) throws Exception{
		System.out.println("4.write controllor...start");
		boardService.write(bvo);
		return new ModelAndView("/board/show_content");
	}
}
