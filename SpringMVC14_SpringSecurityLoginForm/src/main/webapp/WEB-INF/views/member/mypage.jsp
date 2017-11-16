<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}">INDEX</a></h1>
<H2>member/mypage page</H2>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="name"/>님, MyPage 환영합니다.!!
</sec:authorize>
</body>
</html>