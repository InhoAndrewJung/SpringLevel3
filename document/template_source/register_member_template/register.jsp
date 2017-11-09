<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkReg() {
		var f = document.regForm;
		if(f.id.value==""){
			alert("아이디를 입력하세여");
			return;
		}else if(f.password.value==""){
			alert("패스워드를 입력하세여");
			return;
		}else if(f.name.value==""){
			alert("이름을 입력하세여");
			return;
		}else if(f.address.value==""){
			alert("주소를 입력하세여");
			return;
		}else if(f.idFlag.value==""){
			alert("아이디 중복체크를 하세여");
			return;
		}
		//자바스크립트에서 바로 폼으로 입력된 값을 url로 전송하는 기능..
		f.submit();
	}
	function idCheck() { //중복확인 버튼 눌렀을때 자동호출되는 함수
		var cid=  document.regForm.id.value;
		if(cid==""){
			alert("아이디 입력해서 중복확인 하쇼!!");
		}else{
			window.open("member.do?command=idcheck&id="+cid, "", "resizable=no,toolbar=no,width=200, height=200");
		}
	}
</script>
</head>
<body>
<h2 align="center">Register Form....</h2><p>
<form name="regForm" action="member.do" method="post">
<input type="hidden" name="command" value="register">
ID <input type="text" name="id">
<input type="button" value="중복확인" onclick="idCheck()"><br><br>
<input type="hidden" name="idFlag" value="">
PASS <input type="password" name="password"><br><br>
NAME <input type="text" name="name"><br><br>
ADDRESS <input type="text" name="address"><br><br>
<input type="button" value="회원가입" onclick="checkReg()">  
</form>
</body>
</html>











