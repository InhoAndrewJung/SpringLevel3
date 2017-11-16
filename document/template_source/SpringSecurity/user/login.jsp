<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2><a href="${pageContext.request.contextPath}">INDEX</a></h2><P>
<h2>user.login.jsp page</h2><p>
<c:choose>
	<c:when test="${not empty pageContext.request.userPrincipal }">
		USER ID :: ${pageContext.request.userPrincipal.name}님 로그인 성공
		<form action="${pageContext.request.contextPath}/j_spring_security_logout" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="submit" value="logout">		
		</form>
	</c:when>
	<c:otherwise>
		logout ,,,, 
	</c:otherwise>
</c:choose>
</body>
</html>










