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
<script type="text/javascript" src="../../../resources/js/uploadAjax.js"></script>
<script type="text/javascript"
	src="../../../resources/js/writeAttach.js"></script>
<link rel="stylesheet" href="../../../resources/css/write.css"
	type="text/css">

</head>
<body>
	<%@ include file="../main/header.jsp"%>
	<div id="container">
		<form action="/board/write" id="form" method="post">
			<div id="top">
				<h1 id="writecss">글 쓰기</h1>
			</div>
			<div id="mid">
				<table>
					<tr>
						<td>
							<div id="select">
								<select name="category">
									<option value="총무">총무</option>
									<option value="인사">인사</option>
									<option value="기획">기획</option>
									<option value="영업">영업</option>
									<option value="회계">회계</option>
									<c:choose>
										<c:when
											test="${position.equals('사장') || position.equals('부사장')}">
											<option value="공지">공지</option>
										</c:when>
									</c:choose>
								</select>
							</div>
						</td>
						<td><input type="text" name="title" id="uploadtitle"
							placeholder="제목을 입력하세요" maxlength="40"></td>
					</tr>
				</table>

				<textarea id="uploadResult" contentEditable="true"
					style="min-height: 500px; min-width: 500px; height: auto;"></textarea>
				<table>
					<tr>
						<td><label> 파일첨부 <input type="file" name="uploadFile"
								id="uploadFile" hidden="" multiple>
						</label>
						<div id="lookImage"></div></td>
						<td style="text-align: left"><div id="uploadResult2"></div></td>
					</tr>
				</table>
				<div id="button">
					<input type="button" id="uploadBtn" value="작성" class="button">
					<a href="/board/board"><input type="button" value="취소"
						class="button"></a>
				</div>
			</div>
			<div id="bottom"></div>
		</form>
		<%@ include file="../main/footer.jsp"%>
	</div>
</body>
</html>