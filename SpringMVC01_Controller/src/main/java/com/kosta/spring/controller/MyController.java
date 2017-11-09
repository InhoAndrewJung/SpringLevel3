package com.kosta.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MyController extends MultiActionController{
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse resonse) {
		
		System.out.println("비지니스 로직 호출....");
		return new ModelAndView("update_result","info","Maven SpringMVC!!");
	}
	//
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse resonse) {
		
		System.out.println("비지니스 로직 호출....");
		return new ModelAndView("delete_result","info","Delete, SpringMVC!!");
	}	
}










