package model;

import org.springframework.web.multipart.MultipartFile;

public class UploadDataVO {
	private String userName;
	//폼의 이름이 변수명이 되도록 한다!!
	//반드시 빈으로 등록해서 사용
	private MultipartFile uploadFile; //폼의 이름이 변수명이 되도록 한다!!
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	
}
