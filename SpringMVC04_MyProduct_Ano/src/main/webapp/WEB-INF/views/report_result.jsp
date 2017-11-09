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
<h2><b>AOP를 이용한 검색어 통계결과표 보기</b></h2>
<table border="2" bgcolor="pink" width="60%" align="center">
	<tr>
		<td>랭 킹</td><td>검색어</td><td>조회수</td>
	</tr>
	<c:forEach var="result" items="${list}" >
	<!-- resultType을 hashmap으로 지정했을때 key에 해당하는 값이 칼럼명으로 들어온다
		 이 때 대문자로 하는 것을 주의하자
	 -->
		<tr>
		<td>${result.RANKING}</td>
		<td>${result.WORD}</td>
		<td>${result.CNT}</td>
		</tr>
	</c:forEach><!-- controller에서 바인딩한 이름이 들어감  -->
</table>
</body>
</html>