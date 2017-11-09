package com.kosta.spring.model.impl;

import java.util.List;

import com.kosta.spring.model.MyProductDAO;
import com.kosta.spring.model.MyProductService;
import com.kosta.spring.model.MyProductVO;

public class MyProductServiceImpl implements MyProductService {
	private MyProductDAO myProductDAO;
	
	public void setMyProductDAO(MyProductDAO myProductDAO) {
		this.myProductDAO = myProductDAO;
	}

	@Override
	public void insertMyProduct(MyProductVO vo) {
		myProductDAO.insertMyProduct(vo);
		
	}

	@Override
	public List<MyProductVO> findByProductName(String name) {
		
		return myProductDAO.findByProductName(name);
	}

	@Override
	public List<MyProductVO> findByProductMaker(String name) {
		// TODO Auto-generated method stub
		return myProductDAO.findByProductMaker(name);
	}

}
