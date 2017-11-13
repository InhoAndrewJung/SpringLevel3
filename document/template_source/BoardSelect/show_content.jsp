<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table cellpadding="5">
		<tr>
		   <td>
		   	    <table width="550">
					<tr>
						<td><b>글번호 : ${requestScope.bvo.no} |
							   타이틀 : ${requestScope.bvo.title}</b>
						<hr style="color: #6691BC; border-style: dotted; margin: 0">
						</td>
					</tr>
					<tr>
						<td>작성자 :  ${requestScope.bvo.memberVO.name} |
							작성일시 : ${requestScope.bvo.writeDate}
							Count : ${requestScope.bvo.count}
						</td>
					</tr>
					<tr>
						<td>
						<hr style="color: #6691BC; margin: 0">
						<pre>${requestScope.bvo.content}</pre>					
						</td>
					</tr>
					<tr>
						<td valign="middle">
						<a href="list.do">
						<img alt="전체글목록" src="../img/list_btn.jpg" border="0">
						</a>
						
						<!-- 현재 로긴한 사람이 자신의 글을 볼때는 삭제, 수정 버튼이 보여지도록
						     현재 로긴한 사람의 id가 게시글의 id와 동일할때만..해당 글을 삭제,수정
						     ::
						     삭제, 수정은 반드시 팝엉창을 띄워서 정말~~할래? 삭제, 수정되도록 로직을 작성
						    삭제...command=delete/Controller...list
						-->
						<c:if test="${requestScope.bvo.memberVO.id==sessionScope.mvo.id }">
							<img alt="삭제" src="../img/delete_btn.jpg" border="0" onclick="deleteBoard()">
							<img alt="수정" src="../img/modify_btn.jpg" border="0" onclick="updateBoard()">
						</c:if>
						</td>
					</tr>
				</table> 	
			</td>
		</tr>
	</table>	
</body>
</html>






























