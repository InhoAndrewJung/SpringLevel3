package com.kosta.spring.aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.spring.aop.model.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@RequestMapping("/report.do")
	public ModelAndView selectReport() throws Exception{
		List list = reportService.selectReport();
		System.out.println("selectReport call----Contorller----");
		
		return new ModelAndView("report_result", "list", list);
			
	}
}
