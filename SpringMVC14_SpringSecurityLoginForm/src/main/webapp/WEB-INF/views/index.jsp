<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Spring Security LoginForm III</h2>
<h3>
	<b>
		USER : 사용자 <br>
		MEMBER : 가입된 사용자 <br>
		ADMIN : 관리자 <br>
		
	</b>
</h3>
<h1>
	<c:if test="${not empty pageContext.request.userPrincipal}">
		${pageContext.request.userPrincipal.name}님!! 환영합니다
	</c:if>
</h1><hr>
<h2>USER</h2>
<a href="${pageContext.request.contextPath}/user/main">user/main - 인증없이 접근 가능</a><p>
<a href="${pageContext.request.contextPath}/user/loginForm">user/loginForm - 인증없이 접근 가능</a><p>
<a href="${pageContext.request.contextPath}/user/login">user/login - 인증해야만 접근 가능</a><p>

<h2>ADMIN</h2>
<a href="${pageContext.request.contextPath}/admin/main">admin/main - 인증없이 접근 가능</a><p>

</body>
</html>