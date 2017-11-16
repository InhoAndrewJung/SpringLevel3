package com.kosta.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertAuthority(AuthorityVO authority) {
		return sqlSession.insert("authoritiesMapper.insertAuthority", authority);
	}

	@Override
	public List<AuthorityVO> selectAuthorityByUserName(String username) {
		return sqlSession.selectList("authoritiesMapper.selectAuthorityByUserName", username);
	}

}
