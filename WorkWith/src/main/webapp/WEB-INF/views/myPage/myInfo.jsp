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
	<div id="container_myInfo" style="background: lightgray; height: 400px; width: 300px;">
		<input type="text" value="${id }" id="myId" hidden="true">
		<input type="text" class="myInfo" id="myInfo_id">
		<input type="text" class="myInfo" id="myInfo_name">
		<input type="text" class="myInfo" id="myInfo_position">
		<input type="text" class="myInfo" id="myInfo_department">
		<input type="text" class="myInfo" id="myInfo_phone">
		<input type="text" class="myInfo" id="myInfo_addr">
		<input type="text" class="myInfo" id="myInfo_email">
		<input type="text" class="myInfo" id="myInfo_birth">
		<input type="text" class="myInfo" id="myInfo_startdate">
		<input type="text" class="myInfo" id="myInfo_emplno">
	</div>
</body>
</html>