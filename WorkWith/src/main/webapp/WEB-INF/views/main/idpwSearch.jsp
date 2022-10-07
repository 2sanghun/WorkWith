<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<link rel="stylesheet" href="../../../resources/css/idpwSearch.css"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="../../../resources/js/searchCheck.js"></script>
</head>
<body>
	<div id="background">
		<div id="container">
			<div class="loginsession">
				<h1 id="logincss">아이디/비밀번호 찾기</h1>
				<br> <input type="radio" name="찾기" checked="checked"
					onclick="search_check(1)"> <label>아이디 찾기 </label> <input
					type="radio" name="찾기" onclick="search_check(2)"> <label>비밀번호
					찾기</label>

				<form action="/header/idsearch" method="post" id="searchId">
					<input type="text" name="name" maxlength='10' class="box" placeholder="이름를 입력해주세요"><br> 
					<input type="text" name="emplno" maxlength='11' placeholder="사원번호를 입력해주세요" class="box"> <br>
					<input type="submit" value="확인" class="basic_btn">
					<a href="../main/login">
					<input type="button" value="취소" class="basic_btn"></a>
				</form>
				<br>
				<form action="/header/pwsearch" method="post" id="searchPw" style="display: none">
					<input type="text" name="id" id="idchk" placeholder="아이디를 입력해주세요" class="box"><br> 
					<input type="text" name="email" placeholder="이메일을 입력해주세요" class="box"><br> 
					<input type="submit" value="확인" class="basic_btn">
					<a href="../main/login">
				<input type="button" value="취소" class="basic_btn"></a>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>