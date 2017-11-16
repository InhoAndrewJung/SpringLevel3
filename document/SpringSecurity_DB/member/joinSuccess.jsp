<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Member Information</h2>
	<table style="width:600px; border-bottom-width: 1px;">
		<tr>
			<td width="100">ID</td>
			<td>${requestScope.member.id}</td>
		</tr>
		<%-- <tr>
			<td width="100">PASSWORD</td>
			<td>${requestScope.member.password}</td>
		</tr> --%>
		<tr>
			<td width="100">NAME</td>
			<td>${requestScope.member.name}</td>
		</tr>
		<tr>
			<td width="100">EMAIL</td>
			<td>${requestScope.member.email}</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath }">메인으로</a>
</body>
</html>