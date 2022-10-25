<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../../resources/js/effective_Pw.js"></script>

</head>
<body>
	<h1>비밀번호 변경</h1>
	<form action="/pwChange" method="post" onsubmit="return pwSubmit();">
		<input type="text" name="id" value="${id }" hidden="true">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="nowPw" name="password"></td>
			</tr>
			<tr>
				<td>새로운 비밀번호</td>
				<td><input type="password" id="pwchk" name="newPw"
					maxlength='20'></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td colspan="2"><span id="pwmsg"></span></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="rechk" maxlength='20'></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td colspan="2"><span id="remsg"></span></td>
			</tr>
		</table>
		<input type="submit" value="변경"> <a href="/board/board"><input
			type="button" value="취소"></a>
	</form>
</body>
</html>