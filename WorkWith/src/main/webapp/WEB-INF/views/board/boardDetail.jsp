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
<script type="text/javascript" src="../../../resources/js/detail.js"></script>
<script type="text/javascript"
	src="../../../resources/js/writeAttach.js"></script>
<link rel="stylesheet" href="../../../resources/css/boardDetail.css"
	type="text/css">

</head>
<body>
	<%@ include file="../main/header.jsp"%>
	<div id="container">
		<form id="form">
			<input type="hidden" name="bno" value="${detail.bno}">
			<table border="1">
				<tr class="tr1">
					<td colspan="4"><c:choose>
							<c:when test="${id != detail.id}">
								<input type="text" name="title" id="title"
									value="${detail.title}" readonly>
							</c:when>
							<c:otherwise>
								<input type="text" name="title" id="title"
									value="${detail.title}">
							</c:otherwise>
						</c:choose> <span id="regdate"> ${detail.regdate}</span></td>
				</tr>
				<tr class="tr1">
					<td colspan="4">
						<div class="side">
							<span class="title_name">${detail.name}</span> <span
								class="title_position">${detail.position}</span>
						</div>

						<div class="side_right">
							조회 수 <span class="title_cnt">${detail.cnt}</span>
						</div>
					</td>
				</tr>

				<tr>
					<td colspan="4"><c:choose>
							<c:when test="${id != detail.id}">
								<textarea id="uploadResult" readonly
									style="min-height: 500px; min-width: 500px; height: auto;"></textarea>
							</c:when>
							<c:otherwise>
								<textarea id="uploadResult" contentEditable="true"
									style="min-height: 500px; min-width: 500px; height: auto;"></textarea>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
			<div class="upload_file">
				<c:choose>
					<c:when test="${id == detail.id}">
						<div id="uploadlist_1">
							<span class="uploadlist">첨부된 파일 목록</span><br>
							<div id="uploadlist">
								<ul id="atfile"></ul>
								<ul id="atimg"></ul>
							</div>
						</div>
						<!-- 업로드하기 전 확인 목록 -->
						<div class="form-group uploadDiv">
							<span class="uploadlist">첨부할 파일 목록</span>
							<div id="uploadResult2"></div>
							<label> 파일 첨부 <input type="file" name="uploadFile"
								id="uploadFile" hidden="" multiple>
							</label> <input type="button" value="파일 업로드" id="addfile">
							<div id="lookImage"></div>
						</div>
						<span class="modifybtn_box"> <input type='button'
							value='수정' id="modify"> <input type="submit" value="삭제"
							onclick="if(!confirm('삭제 하시겠습니까?')){return false}"
							formaction="/detail/remove" class="remove">
						</span>
					</c:when>
					<c:when test="${id != detail.id}">
						<div id="AttachList_other">
							<span class="uploadlist">첨부 파일 목록</span>
							<div id="down">
								<ul id="downfile"></ul>
								<ul id="downimg"></ul>
							</div>
						</div>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${position.equals('사장') || position.equals('부사장')}">
						<span class="modifybtn_box"> <input type="submit"
							value="삭제"
							onclick="if(!confirm('${detail.name}님의 게시물을 삭제 하시겠습니까?')){return false}"
							formaction="/detail/remove" class="remove">
						</span>
					</c:when>
				</c:choose>
			</div>
		</form>
	</div>
	<%@ include file="../main/footer.jsp"%>

</body>
</html>