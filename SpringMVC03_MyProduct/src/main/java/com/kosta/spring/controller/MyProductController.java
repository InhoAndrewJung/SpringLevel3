package com.kosta.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.ExpandVetoException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.kosta.spring.model.MyProductService;
import com.kosta.spring.model.MyProductVO;

public class MyProductController extends MultiActionController{
	//register(), findByProductName(), findByMaker()
	private MyProductService myProductService;

	public void setMyProductService(MyProductService myProductService) {
		this.myProductService = myProductService;
	}
	
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, MyProductVO vo) throws Exception{
		System.out.println("시퀀스 주입 전 : "+vo.getId());
		myProductService.insertMyProduct(vo);
		System.out.println("시퀀스 주입 후 : "+vo.getId());
		return new ModelAndView("insert_result","vo",vo);
	}
	
	public ModelAndView findByProductName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		myProductService.findByProductName(word);
		return new ModelAndView("find_result","list",myProductService.findByProductName(word));
	}
	
	public ModelAndView findByMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		return new ModelAndView("find_result","list",myProductService.findByProductMaker(word));
	}
	
	
}
