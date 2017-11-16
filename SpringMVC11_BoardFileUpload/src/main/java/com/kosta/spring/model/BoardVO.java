package com.kosta.spring.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	//PASSWORD는 제외했따. 대신에 ID가 들어있다.
	private int no;
	private String title;
	private String content;
	private int count;
	private String writeDate; //w_date
	
	//
	private MemberVO  memberVO;
	
	//fileUpload부분 필드를 추가
	private String orgfilename;
	private String newfilename;
	//input type=file name=uploadFile ->Front단의 인풋 폼의 이름과 변수명과 동일해야한다.
	//->springFramework기능이기때문에 Bean 설정문서에 등록해야한다!!
	private MultipartFile uploadFile;

	public BoardVO(int no, String title, String content, int count, String writeDate, MemberVO memberVO) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
		this.memberVO = memberVO;
	}

	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String content, int count, String writeDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
	}

	public String getOrgfilename() {
		return orgfilename;
	}

	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content=" + content + ", count=" + count + ", writeDate="
				+ writeDate + ", memberVO=" + memberVO + "]";
	}	
}














