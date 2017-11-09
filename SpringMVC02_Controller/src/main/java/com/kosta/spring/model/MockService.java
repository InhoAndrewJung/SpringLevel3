package com.kosta.spring.model;

public class MockService {
	public String registerCar(CarVO car) {
		System.out.println("자동차가 등록되었습니다!!"+car);
		return "자동차 등록 성공!!::모델명"+car.getModel();
	}
}
