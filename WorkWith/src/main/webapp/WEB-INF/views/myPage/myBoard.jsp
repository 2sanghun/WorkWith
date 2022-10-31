<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src=" https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/myBoard.css"
	type="text/css">
<script type="text/javascript" src="../../../resources/js/myBoard.js"></script>
</head>
<body>
	<%@ include file="../main/header.jsp"%>
	<div id="container_myBoard">
		<div id=middle>
			<p id=categorylist>내 글</p>
			<table class="list_table">
				<tr id="tr1">
					<td class="bno">글번호</td>
					<td class="category">카테고리</td>
					<td class="title">제목</td>
					<td class="regdate">작성일</td>
					<td class="cnt"><span>조회수</span></td>
				</tr>
				<!--  for문 시작 -->
				<c:forEach items="${myBoard}" var="myboard">
					<tr>
						<td class="bno">${myboard.bno}</td>
						<td class="category">${myboard.category}</td>
						<td class="title"><a
							href="../board/boardDetail?bno=${myboard.bno}">${myboard.title}</a></td>
						<td class="regdate">${myboard.regdate}</td>
						<td class="cnt">${myboard.cnt}</td>
					</tr>
				</c:forEach>
				<!--  for문 끝 -->
			</table>
			<c:if test="${paging.total == 0}">
				<div id="nodata">
					<p id="nodatah">등록된 게시글이 없습니다.</p>
				</div>
			</c:if>
		</div>
		<div id="search">
			<form id="searchform" action="/myPage/myBoard" method="get">
				<div id="searchAll">
					<input type="hidden" value="${paging.cri.period}"
						id="selected_period"> <select id="myBoard_time"
						class="search" name="period">
						<option value="total">전체기간</option>
						<option value="day">1일</option>
						<option value="week">1주</option>
						<option value="month">1개월</option>
						<option value="sixMonth">6개월</option>
						<option value="year">1년</option>
					</select> <input type="text" name="keyword" class="search" id="query"
						placeholder="검색어를 입력해주세요"> <input type="submit"
						id="searchbtn" value="검색">
				</div>
				<div>
					<input type="hidden" name="pageNum" value="${paging.cri.pageNum}">
					<input type="hidden" name="amount" value="${paging.cri.amount}">
				</div>
			</form>
		</div>
		<div id="paging">
			<div id="pagingArea">
				<!-- prev(이전)이 true이면 이전버튼 활성화 -->
				<c:if test="${paging.prev}">
					<a
						href="/myPage/myBoard?period=${paging.cri.period}&type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.startPage-1}&amount=${paging.cri.amount}"
						class="pageBtn">이전</a>
				</c:if>
				<!-- begin(1)이 end(10) 될 동안 반복(1이 10 될 동안 반복) -->
				<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
					var="num">
					<a
						href="/myPage/myBoard?period=${paging.cri.period}&type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${num}&amount=${paging.cri.amount}"
						id="pageNum">${num}</a>
				</c:forEach>
				<!-- next(다음)이 true이면 다음버튼 활성화 -->
				<c:if test="${paging.next}">
					<a
						href="/myPage/myBoard?period=${paging.cri.period}&type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.endPage+1}&amount=${paging.cri.amount}"
						class="pageBtn">다음</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>