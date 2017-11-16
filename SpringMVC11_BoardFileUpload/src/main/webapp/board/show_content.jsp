<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function remove(){
	if(confirm("정말 삭제하시겠습니까?")){		
		location.href="delete.do?no=${bvo.no}&&newfilename=${bvo.newfilename}";
	}
  }
  
function updateBoard(){
	location.href="update.do?no=${bvo.no}";
}
</script>
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
					<c:if test="${bvo.orgfilename!= null}">
					<tr>
						<td><a href="${pageContext.request.contextPath}/fileDown.do?orgfilename=${bvo.orgfilename}&&newfilename=${bvo.newfilename}">첨부파일 : ${bvo.orgfilename }</a>
						</td>
					</tr>
					</c:if>
					<tr>
						<td>
						<hr style="color: #6691BC; margin: 0">
						<pre>${requestScope.bvo.content}</pre>					
						</td>
					</tr>
					<tr>
						<td valign="middle">
						<a href="list.do"><img alt="목록" src="../img/list_btn.jpg"></a>
						<!-- 
						현재 로그인한 사람이 자신의 글을 상세보기로 볼때는
						삭제와 수정버튼이 보여지도록 작성해야한다
						:: session.mvo.id == bvo.id ->로그인한 사람과 글을 작성한 사람과 같다.
						 -->
						 <c:if test="${sessionScope.mvo.id == requestScope.bvo.memberVO.id }">
						<img alt="삭제" src="../img/delete_btn.jpg" onclick="remove()">
						<img alt="수정" src="../img/modify_btn.jpg" onclick="updateBoard()">
						</c:if>
						</td>
					</tr>
				</table> 	
			</td>
		</tr>
	</table>	
</body>
</html>






























