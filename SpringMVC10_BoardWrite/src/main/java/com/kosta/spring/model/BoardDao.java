package com.kosta.spring.model;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.SQLErrorCodes;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int write(BoardVO bvo)throws SQLException {
		return sqlSession.insert("write", bvo);
	}
	
	
}
