package com.kosta.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.kosta.spring.dao.AuthoritiesDAO;
import com.kosta.spring.dao.MemberDAO;
import com.kosta.spring.service.MemberService;
import com.kosta.spring.util.Constants;
import com.kosta.spring.vo.Authority;
import com.kosta.spring.vo.Member;

public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Autowired
	private PasswordEncoder passwordEncoder; // 빈 설정문서 등록
	@Override
	@Transactional
	public int joinMember(Member member) {
		// 비밀번호 암호화 작업을 진행
		String encodePassword = passwordEncoder.encode(member.getPassword());
		member.setPassword(encodePassword);
		
		memberDAO.insertMember(member);
		
		//권한을 등록
		authoritiesDAO.insertAuthority(new Authority(member.getId(), Constants.ROLE_MEMBER));
		if(member.getUserType().equals("1")) {
			authoritiesDAO.insertAuthority(new Authority(member.getId(), Constants.ROLE_ADMIN));
		}
		return 1;
		
	}

}
