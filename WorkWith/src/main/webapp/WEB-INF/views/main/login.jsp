<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
	<div id="container">
		<div class="loginsession">
			<h1 id="logincss">로그인</h1>
			<form action="/main/login" method="post">
				<input type="text" name="id" placeholder="아이디를 입력해주세요"> 
				<input type="password" name="password" placeholder="비밀번호를 입력해주세요"><br>
				<a href="../main/idpwSearch">아이디/비밀번호 찾기</a> 
				<a href="../main/signup">회원가입</a> <br> 
				<input type="submit" value="로그인"> <br>
			</form>
		</div>
	</div>
</body>
</html>