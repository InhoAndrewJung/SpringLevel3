<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h2>수정된 회원의 정보입니다..</h2></center><p>
아이디 : ${sessionScope.vo.id }<p>
패스워드 : ${sessionScope.vo.password }<p>
이  름 : ${sessionScope.vo.name }<p>
주  소 : ${sessionScope.vo.address}<p>

<hr>
<a href="index.jsp">다시 홈으로</a>
</body>
</html>