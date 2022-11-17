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
<link rel="stylesheet" href="../../../resources/css/header.css"
	type="text/css">
<script type="text/javascript" src="/resources/js/header.js"></script>

</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String position = (String) session.getAttribute("position");
		String department = (String) session.getAttribute("department");
		if (id == null | position == null | department == null) {
			out.println("<script>alert('로그인 해주세요.')</script>");
			out.println("<script>location.href='/main/login';</script>");
		} else {
	%>
	<header>
		<div class="logo">
			<h1>
				<a href="../board/board">WorkWith</a>
			</h1>
		</div>
		<nav>
			<a href="../board/write"> <input type="button" value="글쓰기"
				class="headerbtn_write"></a>
			<c:choose>
				<c:when test="${position.equals('사장') || position.equals('부사장')}">
					<!-- 직책이 사장, 부사장일 경우 마이페이지 대신 관리자 버튼 -->
					<input type="button" value="인사관리" class="headerbtn_mypage"
						onclick="showManage()">
				</c:when>
			</c:choose>
			<input type="button" value="결재" class="headerbtn_mypage"
				onclick="showPayment()"> <input type="button"
				id="myPage_toggle" value="내 정보" class="headerbtn_mypage">
			<div id="myPage" style="display: none;">
				<%@ include file="../myPage/myInfo.jsp"%></div>
			<a href="../main/logout"> <input type="button" value="로그아웃"
				class="headerbtn"></a>
			<%
				}
			%>
		</nav>
	</header>
</body>
</html>