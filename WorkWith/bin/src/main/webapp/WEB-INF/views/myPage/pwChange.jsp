<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/pwChange.css"
	type="text/css">
<script type="text/javascript"
	src="../../../resources/js/effective_Pw.js"></script>
</head>
<body>
	<h1>비밀번호 변경</h1>
	<form action="/pwChange" method="post" onsubmit="return pwSubmit();">
		<input type="hidden" name="id" value="${id }">
		<table id="myPw_table">
			<tr>
				<td><input type="password" id="nowPw" class="myPw"
					name="password" placeholder="현재 비밀번호"></td>
			</tr>
			<tr class="blank">
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="password" id="pwchk" class="myPw" name="newPw"
					maxlength='20' placeholder="새 비밀번호"></td>
			</tr>
			<tr class="blank">
				<td colspan="2"><span id="pwmsg"></span></td>
			</tr>
			<tr>
				<td><input type="password" id="rechk" class="myPw"
					maxlength='20' placeholder="새 비밀번호 확인"></td>
			</tr>
			<tr class="blank">
				<td colspan="2"><span id="remsg"></span></td>
			</tr>
		</table>
		<input type="submit" class="myPw_button" value="변경"><input
			type="button" class="myPw_button" value="취소" onclick="window.close()">
	</form>
</body>
</html>