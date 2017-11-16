package com.kosta.spring.dao;

import java.util.List;

import com.kosta.spring.vo.Authority;

public interface AuthoritiesDAO {
/*
 * selectAuthorityByUserName, insertAuthority
 */
	List<Authority> selectAuthorityByUserName(String username);
	int insertAuthority(Authority authority);
}
