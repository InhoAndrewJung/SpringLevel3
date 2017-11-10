<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		var f=confirm("로그아웃 하시겠습니까?");
		if(f)
			location.href="logout.do";
	}
</script>
</head>
<body>
<!-- 로그인 상태 여부에 따라서 보여지는 내용을 달리 가져갈 것이다. -->
<c:choose>
	<c:when test="${sessionScope.vo==null}">
		<a href="register_ajax.jsp">회원 가입 하기</a><br><br>
		<a href="login.jsp">로그인 하기</a><br><br>
	</c:when>
	<c:otherwise>
		${sessionScope.vo.name}님, 로그인 상태입니다.^^<p><br>
		<a href="javascript:logout()">로그 아웃 하기</a><br><br>
		<a href="update.jsp">내 정보 수정하기</a><br><br>
		<a href="getAddressKind.do">주소로 회원 검색 하기</a><br><br>
		
	</c:otherwise>
</c:choose>
</body>
</html>





























