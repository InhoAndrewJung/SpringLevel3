package com.kosta.spring.model;

import java.util.List;

//myproduct.xml의 id값이 추상화된 기능의 이름이 된다.
public interface MyProductDAO {
	int insertMyProduct(MyProductVO vo);
	List<MyProductVO> findByProductName(String name);
	List<MyProductVO> findByProductMaker(String name);
	
}
