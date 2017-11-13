package com.kosta.spring.model;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	public MemberVO login(MemberVO mvo)throws SQLException{
		return sqlSession.selectOne("memberMapper.login",mvo);
	}
}














