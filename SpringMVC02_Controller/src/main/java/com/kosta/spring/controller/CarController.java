package com.kosta.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.kosta.spring.model.CarVO;
import com.kosta.spring.model.MockService;
/*
 * AbstractCommandController
 * ::
 * 폼에 입력된 값을 받아서 vo에 자동으로 주입하고
 * 값이 주입된 vo를 Controller에 hasing하는 기능을 가지고 있는 Controller
 * ::
 * vo 객체가 자동으로 Controller에 바인딩
 */
public class CarController extends AbstractCommandController {
	private MockService mockService;
	
	public CarController(MockService mockService) {
		super();
		this.mockService = mockService;
		this.setCommandClass(CarVO.class);
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException e)
			throws Exception {
		/*String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		
		CarVO vo = new CarVO(model, price);*/
		CarVO vo = (CarVO)command;
		System.out.println("Command Value :: "+vo);
		
		String carInfo = mockService.registerCar(vo);
		return new ModelAndView("car_result", "carInfo", carInfo);
	}
	
}
