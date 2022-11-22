<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="flex: 2" id="signupData_simple">

		<div id="signupManage_search">
			<select name="department" id="signup_department">
				<option value="total">부서</option>
				<option value="총무팀">총무팀</option>
				<option value="인사팀">인사팀</option>
				<option value="기획팀">기획팀</option>
				<option value="영업팀">영업팀</option>
				<option value="회계팀">회계팀</option>
			</select> <select name="position" id="signup_position">
				<option value="total">직책</option>
				<option value="사원">사원</option>
				<option value="주임">주임</option>
				<option value="대리">대리</option>
				<option value="과장">과장</option>
				<option value="차장">차장</option>
				<option value="부장">부장</option>
				<option value="이사">이사</option>
				<option value="상무">상무</option>
				<option value="전무">전무</option>
				<option value="부사장">부사장</option>
				<option value="사장">사장</option>
			</select> <input type="text" name="name" id="signup_name" placeholder="이름">
		</div>
		<div id="signup_simpleData">
			<table>
			</table>
		</div>
	</div>

	<div style="flex: 3" id="signupData_detail">
		<form action="/signupRefuse" method="post"
			onsubmit="return signupRefuse()"
			onkeydown="return captureReturnKey(event)">
			<input type="hidden" id="signupDetail_password">
			<table>
				<tr>
					<td>사원 번호</td>
					<td><input type="text" name="emplno" id="signupDetail_emplno"
						readonly></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" id="signupDetail_name"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="signupDetail_id" readonly></td>
				</tr>
				<tr>
					<td>부서</td>
					<td><select name="department" id="signupDetail_department">
							<option value="총무팀">총무팀</option>
							<option value="인사팀">인사팀</option>
							<option value="기획팀">기획팀</option>
							<option value="영업팀">영업팀</option>
							<option value="회계팀">회계팀</option>
					</select></td>
				</tr>
				<tr>
					<td>직책</td>
					<td><select name="position" id="signupDetail_position">
							<option value="사원">사원</option>
							<option value="주임">주임</option>
							<option value="대리">대리</option>
							<option value="과장">과장</option>
							<option value="차장">차장</option>
							<option value="부장">부장</option>
							<option value="이사">이사</option>
							<option value="상무">상무</option>
							<option value="전무">전무</option>
							<option value="부사장">부사장</option>
							<option value="사장">사장</option>
					</select></td>
				</tr>
				<tr>
					<td>입사일</td>
					<td><input type="date" name="startdate"
						id="signupDetail_startdate" max="9999-12-31"></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="email" id="signupDetail_email1"
						maxlength='20'> @ <select name="email"
						id="signupDetail_email2">
							<option value="@naver.com">naver.com</option>
							<option value="@daum.net">daum.net</option>
							<option value="@google.com">gmail.com</option>
					</select></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><select name="phone" id="signupDetail_phone1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="019">019</option>
					</select>- <input type="text" name="phone" id="signupDetail_phone2"
						maxlength='4' class="shortbox"
						onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');"> -
						<input type="text" name="phone" id="signupDetail_phone3"
						maxlength='4' class="shortbox"
						onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" name="birth" id="signupDetail_birth"
						max="9999-12-31" readonly></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" id="signupDetail_addr1"
						placeholder="우편번호"> <input type="button" id="addrButton"
						onclick="signupAddr()" value="우편번호 찾기"><br> <input
						type="text" name="addr" id="signupDetail_addr2" placeholder="주소"><br>
						<input type="text" name="addr" id="signupDetail_addrDetail"
						placeholder="상세주소"> <input type="text" name="addr"
						id="signupDetail_addrExtra" placeholder="참고항목"></td>
				</tr>
			</table>
			<input type="button" value="허가" onclick="signupPermit()"><input
				type="submit" value="거절">
		</form>
	</div>

	<!-- 주소 관련 스크립트 -->
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function signupAddr() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var addr = ''; // 주소 변수
							var extraAddr = ''; // 참고항목 변수

							//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								addr = data.roadAddress;
							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								addr = data.jibunAddress;
							}

							// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
							if (data.userSelectedType === 'R') {
								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								// 조합된 참고항목을 해당 필드에 넣는다.
								document
										.getElementById("signupDetail_addrExtra").value = extraAddr;

							} else {
								document
										.getElementById("signupDetail_addrExtra").value = '';
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('signupDetail_addr1').value = data.zonecode;
							document.getElementById("signupDetail_addr2").value = addr;
							// 커서를 상세주소 필드로 이동한다.
							document.getElementById("signupDetail_addrDetail")
									.focus();
						}
					}).open();
		}
	</script>
</body>
</html>