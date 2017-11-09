package com.kosta.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.kosta.spring.model.CarVO;
import com.kosta.spring.model.MockService;

public class CarMultiActionController extends MultiActionController{
	private MockService mockService;

	public void setMockService(MockService mockService) {
		this.mockService = mockService;
	}
	//car2_result.jsp
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, CarVO carvo) {
		return new ModelAndView("car2_result","carInfo2",mockService.registerCar(carvo));
	}
	
}
