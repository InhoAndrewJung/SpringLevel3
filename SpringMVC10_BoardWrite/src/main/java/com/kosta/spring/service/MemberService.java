package com.kosta.spring.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.spring.model.MemberDao;
import com.kosta.spring.model.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public MemberVO login(MemberVO mvo) throws SQLException{
		return memberDao.login(mvo);
	}

}
