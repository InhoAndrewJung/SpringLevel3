<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Product Register Form...</h2>
<form action="myProduct1.do">

상품명:<input type="text" name="name"><br><br>
제조사:<input type="text" name="maker"><br><br>
가 격 :<input type="text" name="price"><br><br>
<input type="submit" value="상품등록">
</form><p><hr><p>
++++++++++++++++++++++++++상품명 | 제조사별로 상품검색하기+++++++++++++++++++++++++++++++
<form action="myProduct2.do">	
	상품명으로 검색하기:<Input type="text" name="word">
	<input type="submit" value="검색하기">
</form>
<p><HR>
++++++++++++++++++++++++++++++++++++AOP 구동 부분+++++++++++++++++++++++++++++++++++++++++
<a href="report.do">검색어 랭킹 보기</a>
</body>
</html>