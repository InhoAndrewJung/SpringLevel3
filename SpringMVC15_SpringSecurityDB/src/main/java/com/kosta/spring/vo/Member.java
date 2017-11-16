package com.kosta.spring.vo;

public class Member {
	private String id;
	private String password;
	private String name;
	private String email;
	
	//추가
	private String userType;

	public Member(String id, String password, String name, String email, String userType) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.userType = userType;
	}

	public Member() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", userType="
				+ userType + "]";
	}	
}
