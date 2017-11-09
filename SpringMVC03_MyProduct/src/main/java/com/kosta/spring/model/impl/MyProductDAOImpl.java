package com.kosta.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kosta.spring.model.MyProductDAO;
import com.kosta.spring.model.MyProductVO;

public class MyProductDAOImpl implements MyProductDAO{
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

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
