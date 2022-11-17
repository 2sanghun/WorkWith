<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../../../resources/js/manage.js"></script>
<link rel="stylesheet" href="../../../resources/css/manage.css"
	type="text/css">
</head>
<body>
	<div id=container_memberManage>

		<span id="memberManage_button">인사관리</span> <span
			id="signupManage_button">회원가입 허가</span> <span id="quitManage_button">퇴사자</span>

		<div id="memberManage" style="display: flex">
			<%@ include file="../manage/memberManage.jsp"%>
		</div>
		
		<div id="signupManage" style="display: none">
			<%@ include file="../manage/signupManage.jsp"%>
		</div>
		
		<div id="quitManage" style="display: none">
			<%@ include file="../manage/quitManage.jsp"%>
		</div>
	</div>
</body>
</html>