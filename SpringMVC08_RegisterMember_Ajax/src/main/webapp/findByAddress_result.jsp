<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h2>동일한 주소로 검색한 회원의 정보들입니다...</h2></center><p>

${param.address}에 사는 사람은    ${fn:length(requestScope.memList)} 명 입니다.
<table border="2">
	<c:forEach items="${requestScope.memList}" var="vo">
		<tr>
			<td>${vo.id}</td>
			<td>${vo.name}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>


















