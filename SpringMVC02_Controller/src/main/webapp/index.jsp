<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Abstract Command Controller Test...::VO 바인딩하기</h2>
<form action="car.do" method="post">
MODEL : <input type="text" name="model"><p>
PRICE : <input type="text" name="price"></p>
<input type="submit" value="자동차등록하기">
</form>
<p><hr>

<!-- CarMultiActionController로 액션을 걸겠다. -->
<form action="testMulti.do" method="post">
	MODEL : <input type="text" name="model"><p>
	PRICE : <input type="text" name="price"></p>
	<input type="hidden" name="mode" value="register">
	<input type="submit" value="자동차등록하기2">
</form>
</body>
</html>