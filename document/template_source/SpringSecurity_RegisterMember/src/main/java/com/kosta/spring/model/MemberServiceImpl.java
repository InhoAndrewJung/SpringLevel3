package com.kosta.spring.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosta.spring.util.Constants;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	/*
	 * 비밀번호 암호화를 위한 객체를 주입받는다 
	 */
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Override
	public MemberVO findMemberById(String id) {		
		return memberDAO.findMemberById(id);
	}

	@Override
	public List<String> getAddressList() {		
		return memberDAO.getAddressList();
	}

	@Override
	public List<MemberVO> findMemberListByAddress(String address) {		
		return memberDAO.findMemberListByAddress(address);
	}

	@Override
	public MemberVO login(MemberVO memberVO) {
		return memberDAO.login(memberVO);
	}

	@Override
	public int getMemberCount() {
		return memberDAO.getMemberCount();
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}
    @Transactional
	@Override
	public void registerMember(MemberVO vo) {
    	//비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(vo.getPassword());
        vo.setPassword(encodedPassword);
		memberDAO.registerMember(vo);		
		
		//권한등록
		/*AuthorityVO authority=new AuthorityVO(vo.getId(),"ROLE_MEMBER");
		memberDAO.registerRole(authority);*/
		authoritiesDAO.insertAuthority(new AuthorityVO(vo.getId(), Constants.ROLE_MEMBER));
		if(vo.getUserType().equals("1")) {
			authoritiesDAO.insertAuthority(new AuthorityVO(vo.getId(), Constants.ROLE_ADMIN));
		}			
	}

	@Override
	public String idcheck(String id) {
		int count=memberDAO.idcheck(id);
		return (count==0) ? "ok":"fail"; 	
	}

	@Override
	public List<AuthorityVO> selectAuthorityByUsername(String username) {
		
		return authoritiesDAO.selectAuthorityByUserName(username);
	}

	
}
