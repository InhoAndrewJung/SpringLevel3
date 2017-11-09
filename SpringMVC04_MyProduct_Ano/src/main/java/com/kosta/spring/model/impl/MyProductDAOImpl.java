package com.kosta.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.spring.model.MyProductDAO;
import com.kosta.spring.model.MyProductVO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public int insertMyProduct(MyProductVO vo) {
		int result = sqlSession.insert("myProductMapper.insertMyProduct", vo);
		System.out.println("INSERT PRODUC...OK..."+result+" ROW!!");
		return result;
	}

	@Override
	public List<MyProductVO> findByProductName(String name) {
		
		return sqlSession.selectList("myProductMapper.findByProductName",name);
	}

	@Override
	public List<MyProductVO> findByProductMaker(String name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("myProductMapper.findByProductMaker",name);
	}

}
