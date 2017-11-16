<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>Member Register Form</h2>
<form action="${pageContext.request.contextPath}/member/join" method="post" id="registerFrm">
<!--스프링 4버전에서는 post 전송시 csrf를 무조건 보내야한다.  -->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
	<table style="600px">
		<tr>
			<td width=100>ID</td>
			<td><input type="text" name="id" id="id"></td>
		</tr>
		<tr>
			<td>PASSWORD</td>
			<td><input type="password" name="password" id="password"></td>
		</tr>
		<tr>
			<td>NAME</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td>EMAIL</td>
			<td><input type="text" name="email" id="email"></td>
		</tr>
		
		<tr>
			<td>User Type</td>
			<td>
				<input type="radio" name="userType" value="0" >ROLE_USER
				<input type="radio" name="userType" value="1" >ROLE_ADMIN
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="REGISTER" >
				<input type="reset" value="CLEAR" >
			</td>
		</tr>
	</table>
</form>
</body>
</html>