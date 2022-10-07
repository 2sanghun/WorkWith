<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link rel="stylesheet" href="../../../resources/css/login.css"
	type="text/css">
</head>
<body>
	<div id="background">
		<div id="container">
			<div class="loginsession">
				<h1 id="logincss">로그인</h1>
				<form action="/main/login" method="post">
					<input type="text" name="id" placeholder="아이디를 입력해주세요"
						class="textBox"><br> <input type="password"
						name="password" placeholder="비밀번호를 입력해주세요" class="textBox"><br>
					<a href="../main/signup" class="signup_btn">회원가입</a> <a
						href="../main/idpwSearch" class="idpwSearch_btn">아이디/비밀번호 찾기</a><br>
					<input type="submit" value="로그인" class="login_btn"> <br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>