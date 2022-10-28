<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/myInfo.css"
	type="text/css">
<script type="text/javascript" src="/resources/js/myInfo.js"></script>
</head>
<body>
	<input type="text" value="${id }" id="myId" hidden="true">
	<div id="container_myInfo">
		<table>
			<tr>
				<td><span>사원번호</span></td>
				<td><input type="text" class="myInfo" id="myInfo_emplno" readonly>
				</td>
			</tr>
			<tr>
				<td><span>부서</span></td>
				<td><input type="text" class="myInfo" id="myInfo_department" readonly></td>
			</tr>
			<tr>
				<td><span>이름</span></td>
				<td><input type="text" class="myInfo" id="myInfo_name" readonly></td>
			</tr>
			<tr>
				<td><span>직책</span></td>
				<td><input type="text" class="myInfo" id="myInfo_position"readonly></td>
			</tr>
			<tr>
				<td>입사일</td>
				<td><input type="text" class="myInfo" id="myInfo_startdate" readonly></td>
			</tr>
			<tr>
				<td><span>ID</span></td>
				<td><input type="text" class="myInfo" id="myInfo_id" readonly></td>
			</tr>
			<tr>
				<td><span>전화번호</span></td>
				<td><input type="text" class="myInfo" id="myInfo_phone" readonly></td>
			</tr>
			<tr>
				<td><span>주소</span></td>
				<td><input type="text" class="myInfo" id="myInfo_addr" readonly></td>
			</tr>
			<tr>
				<td><span>이메일</span></td>
				<td><input type="text" class="myInfo" id="myInfo_email" readonly></td>
			</tr>
			<tr>
				<td><span>생년월일</span></td>
				<td><input type="text" class="myInfo" id="myInfo_birth" readonly></td>
			</tr>
		</table>
		<a href="../myPage/myBoard">내 글</a>
		<input type="button" id="pwChange_toggle" value="비밀번호 변경" onclick="showPw();">
	</div>
</body>
</html>