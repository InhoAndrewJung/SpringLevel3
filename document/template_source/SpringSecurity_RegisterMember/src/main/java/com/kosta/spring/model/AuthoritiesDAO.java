package com.kosta.spring.model;
/*
 * insertAuthority
 * selectAuthorityByUserName
 */

import java.util.List;

public interface AuthoritiesDAO {
	int insertAuthority(AuthorityVO authority);
	List<AuthorityVO> selectAuthorityByUserName(String username);
}
