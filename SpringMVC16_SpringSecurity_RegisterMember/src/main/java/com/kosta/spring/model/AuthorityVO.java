package com.kosta.spring.model;

public class AuthorityVO {
	private String username;
	private String role;
	
	public AuthorityVO(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}

	public AuthorityVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Authority [username=" + username + ", role=" + role + "]";
	}	
}
