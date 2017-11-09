<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h2>로그인한 회원의 정보를 수정합니다..</h2></center><p>
<form name="updateForm" action="member.do" method="post">
<input type="hidden" name="command" value="updateMember">
ID :<input type="text" name="id" value="${sessionScope.vo.id}" readonly="readonly"><br><br>
PASSWORD :<input type="password" name="password" value="${sessionScope.vo.password}"><br><br>
NAME :<input type="text" name="name" value="${sessionScope.vo.name}"><br><br>
ADDRESS :<input type="text" name="address" value="${sessionScope.vo.address}"><br><br>
<input type="submit" value="수정하기">
</form>
</body>
</html>







