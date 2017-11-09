package com.kosta.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.ExpandVetoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.kosta.spring.model.MyProductService;
import com.kosta.spring.model.MyProductVO;
@Controller
public class MyProductController{
	//register(), findByProductName(), findByMaker()
	@Autowired
	private MyProductService myProductService;

	@RequestMapping("myProduct1.do")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, MyProductVO vo) throws Exception{
		System.out.println("시퀀스 주입 전 : "+vo.getId());
		myProductService.insertMyProduct(vo);
		System.out.println("시퀀스 주입 후 : "+vo.getId());
		return new ModelAndView("insert_result","vo",vo);
	}
	@RequestMapping("myProduct2.do")
	public ModelAndView findByProductName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		System.out.println(word+"*****************");
		List<MyProductVO> list=myProductService.findByProductName(word);
		System.out.println("상품 검색하기...ProductController..."+word);
		return new ModelAndView("find_result","list",list);
	}
	
/*	public ModelAndView findByMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		return new ModelAndView("find_result","list",myProductService.findByProductMaker(word));
	}*/
	
	
}
