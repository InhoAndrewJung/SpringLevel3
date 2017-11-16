package com.kosta.spring.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kosta.spring.dao.AuthoritiesDAO;
import com.kosta.spring.dao.MemberDAO;
import com.kosta.spring.vo.Authority;
import com.kosta.spring.vo.Member;


@Service //id="memberAuthenticationProvider"
public class MemberAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private AuthoritiesDAO  authoritiesDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * ����ڰ� ȭ�鿡�� �α����� �����ϸ� �Ʒ��� �޼ҵ尡 ����ȴ�.
	 * �Ű����� : ������ �ʿ��� ���� - Authentication(����ڰ� �Է��� ID,PASSWORD�� ����Ǿ� �ִ�)
	 * ���ϰ� : ������ ������ ���� Authentication
	 * 
	 * ��� : ���ڰ����� ���޵� Authentication��ü�� �޾� ����ó���� �� �� ������ ������ 
	 * 	      Authentication�� ��Ƽ� �����Ѵ�.
	 */
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		//1. �Ķ���ͷ� ���޹��� Authentication ��ü�� ����ó���� �������� ������ null�� ����
		if(!supports(auth.getClass())){
			return null;
		}
		
		//2. ������ٸ�, �μ��� �޴� user������ ������ ��� �����ϴ��� üũ(id check)
		
		String id = auth.getName();
		Member member = memberDAO.selectMemberById(id);
		
		if(member==null){// ID�� ���°��
			throw new UsernameNotFoundException(id+"�� ���� ȸ���Դϴ�.");//spring exception
		}
		
		//3.id�� �����ϸ� ��й�ȣ ��
		String password = (String)auth.getCredentials();//��й�ȣ
		
		if(!passwordEncoder.matches(password, member.getPassword())){
			throw new BadCredentialsException("�н����� �����Դϴ�.");
		}
		
	    ////////////    ������� �Դٸ� ������ ������  ///////////////// 
		//4. id, password ��ΰ� ��ġ�ϸ� Authentication�� ���� ����.
		// ������� ������ ��ȸ : �ϳ��� ����ڴ� �������� ������ ����.
		List<Authority> list = 
				authoritiesDAO.selectAuthorityByUserName(id);
		
		if(list.isEmpty()){
			//�ƹ� ������ ���°��....
			throw new UsernameNotFoundException(id+"�� �ƹ� ������ �����ϴ�.");
		}
		
		//db���� ������ �� ������ GrantedAuthority �� ��ȯ�ؾ���.
		List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
		for(Authority authority : list){
			authList.add(new SimpleGrantedAuthority(authority.getRole()));
		}
		//UsernamePasswordAuthenticationToken(Object principal, Object credentials, authorities)
		//UsernamePasswordAuthenticationToken�� Authentication�� �ڽİ�ü
		//�����Ϸ�� ����� UsernamePasswordAuthenticationToken�� �����Ѵ�.
		return new UsernamePasswordAuthenticationToken(member, null, authList);
	}

	/**
	 * �ش� Ÿ���� Authentication��ü�� �̿��ؼ� ���� ó����
	 * �Ҽ� �ִ��� ���θ� �������ִ� �޼ҵ�
	 * */
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}






