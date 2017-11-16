package com.kosta.spring.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.spring.dao.MemberDAO;
import com.kosta.spring.vo.Member;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sqlSession;
	@Override
	public Member selectById(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memberMapper.selectById",id);
	}

	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.insert("memberMapper.insertMember", member);
	}

}
