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
		}
		//자바스크립트에서 바로 폼으로 입력된 값을 url로 전송하는 기능..
		f.submit();
	}
	var xhr;
	var id, idCheckView;
	function idCheck() { 
		xhr = new XMLHttpRequest();
		id = document.getElementById("id");//폼까지를 변수로 잡았다.
		idCheckView = document.getElementById("idCheckView");
		if(id.value.length<5){//length() 가 아니다
			idCheckView.innerHTML = "<font color=red>ID는 4자 이상!!</font>";
			return; //ajax 기술을 사용하지 않는다..
		}else{
			idCheckView.innerHTML = "<font color=blue>사용가능!!</font>";
			return; //ajax 기술을 사용하지 않는다..
		}
		xhr.onreadystatechange = callback;
		xhr.open("get", "ajaxIdCheck.do?id="+id.value);
		xhr.send(null);		
	}
	function callback() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				var jsonData = JSON.parse(xhr.responseText);
				if(jsonData.flag){
					idCheckView.innerHTML =
						"<font color='red'>사용불가 아이디</font>";
				}else{
					idCheckView.innerHTML =
						"<font color='blue'>사용가능 아이디</font>";
				}
			}
		}
		
	}
</script>
</head>
<body>
<h2 align="center">Register Form....</h2><p>
<form name="regForm" action="register.do" method="post">

ID <input type="text" name="id" onkeyup="idCheck()" id="id">
<span id="idCheckView"></span>
<br><br>

PASS <input type="password" name="password"><br><br>
NAME <input type="text" name="name"><br><br>
ADDRESS <input type="text" name="address"><br><br>
<input type="button" value="회원가입" onclick="checkReg()">  
</form>
</body>
</html>











