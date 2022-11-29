<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 요청</title>
</head>
<body>
	<input type="hidden" id="request_sendId" value="${id}">
	<input type="hidden" id="request_sendPosi" value="${position}">
	<input type="hidden" id="request_sendDep" value="${department}">
	<input type="hidden" id="request_sendName" value="${name}">
	<table>
		<tr>
			<td><input type="text" name="title" id="paymentTitle"
				placeholder="제목을 입력하세요" maxlength="40"></td>
		</tr>
	</table>

	<textarea id="paymentCon" contentEditable="true"
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
	<div id="seniorList">
		<table>
		</table>
	</div>
	<div id="button">
		<input type="button" id="sendBtn" value="작성" class="button">
		<a href="/board/board"><input type="button" value="취소"
			class="button"></a>
	</div>
</body>
</html>