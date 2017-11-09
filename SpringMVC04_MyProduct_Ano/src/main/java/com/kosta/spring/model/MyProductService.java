package com.kosta.spring.model;

import java.util.List;

public interface MyProductService {
	void insertMyProduct(MyProductVO vo);
	List<MyProductVO> findByProductName(String name);
	List<MyProductVO> findByProductMaker(String name);
}
