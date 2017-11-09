package com.kosta.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.spring.model.MyProductDAO;
import com.kosta.spring.model.MyProductService;
import com.kosta.spring.model.MyProductVO;

@Service
public class MyProductServiceImpl implements MyProductService {
	@Autowired
	private MyProductDAO myProductDAO;
	

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
