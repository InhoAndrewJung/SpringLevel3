<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- session에서 찾아온 mvo가 null인지 아닌지에 따라서 기능이 달라진다. -->
<c:choose>
	<c:when test="${sessionScope.mvo==null}">
		<script type="text/javascript">
			alert("로그인 실패!!");
			location.href="index.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("${sessionScope.mvo.name}님, 로그인 성공!!");
			location.href="index.jsp";//이번에는 글쓰기가 보일것이다.
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>














