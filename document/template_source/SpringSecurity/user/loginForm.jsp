<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--  
 보안관련 로그인폼 4.XXX 설정
 1.action="j_spring_security_check"
 2.메소드 방식은 당연히 post로
 3.이때마다 hidden을 이용해서 값을 전달
   ${_csrf.parameterName}, ${_csrf.token} 
 4.<form-login>에서 login-processing-url 속성의 기본값은 /j_spring_security_check에서 POST /login으로,
   username-parameter 속성의 기본값은 j_username에서 username으로,
   password-parameter 속성의 기본값은 J_password에서 password로,
   authentication-failure-url 속성의 기본값은 /login?error=1으로 변경되었다.
-->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Login Form</h1>
<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
	ID : <input type="text" name="username"><br><br>
	PASSWORD : <input type="password" name="password"><br><br>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><br><br>
	<input type="submit" value="LOGIN">
</form>
</body>
</html>













