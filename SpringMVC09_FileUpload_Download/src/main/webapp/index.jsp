<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">FileUpload & Download Test...</h2>
<!-- 파일 업드로하기 위한 main 페이지의 조건
	1. anker tag로는 안된다. form 태그를 사용해야 한다.
	2. method="post"로 지정
	3. enctype속성을 주고 값으로는 multipart/form-data를 준다
	4. input type="file"
	5. 4번일때 폼의 이름을 반드시 잘 기억
	::
	파일업로드 만큼은 Controller를 작성하기 전에 VO를 먼저 작성할 필요가 있다.
	MultipartFile을 알아야한다.

  -->
<form method="post" action="fileUpload.do" enctype="multipart/form-data">
사용자명 : <input type="text" name="userName"><br>
<input type="file" name="uploadFile"><p>
<Input type="submit" value="FileUpload">
</form>
</body>
</html>