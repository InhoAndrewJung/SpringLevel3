package com.kosta.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewResolverController {

		@RequestMapping("findBoard.do")
		public ModelAndView findBoard() {
			System.out.println("findBoard.do....요청됨");
			return new ModelAndView("board_result");
		}
		
		@RequestMapping("findProduct.do")
		public ModelAndView findProduct() {
			System.out.println("findProduct.do....요청됨");
			return new ModelAndView("product_result");
		}
		
		@RequestMapping("registerCustom.do")
		public ModelAndView registerCustom() {
			System.out.println("registerCustom.do....요청됨");
			return new ModelAndView("register_result");
		}
}
