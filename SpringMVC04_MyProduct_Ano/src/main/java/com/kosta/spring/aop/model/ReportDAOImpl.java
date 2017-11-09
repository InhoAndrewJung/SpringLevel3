package com.kosta.spring.aop.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDAOImpl implements ReportDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertReport(String word) throws Exception {
		sqlSession.insert("reportMapper.insertReport",word);
		
	}

	@Override
	public int updateReport(String word) throws Exception {
		sqlSession.update("reportMapper.updateReport", word);
		return 0;
	}

	@Override
	public List selectReport() throws Exception {
		sqlSession.selectList("reportMapper.selectReport");
		return null;
	}
	
}
