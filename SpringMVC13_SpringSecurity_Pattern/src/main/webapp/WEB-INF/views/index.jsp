<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>spring security index page II.</h1>
<c:choose>
	<c:when test="${not empty pageContext.request.userPrincipal}"><!-- 인증하고 들어왔다면 -->
		<h2>
			<b>
				<sec:authorize access="isAuthenticated()">
					<sec:authentication property="name"/>, Welcome!!<!-- getName : 인증했던 아이디가 출력됨 -->
				</sec:authorize>
			</b>
		</h2>
	</c:when>
	<c:otherwise>
		<h2>
			<b>
				Guest Welcome!!
			</b>
		</h2>
	</c:otherwise>
</c:choose>
</body>
</html>