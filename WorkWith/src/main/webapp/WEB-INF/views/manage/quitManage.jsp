<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="Data_simple" id="quitData_simple">

		<div class="manageSearch" id="quitManage_search">
			<select name="department" id="quit_department">
				<option value="total">부서</option>
				<option value="총무팀">총무팀</option>
				<option value="인사팀">인사팀</option>
				<option value="기획팀">기획팀</option>
				<option value="영업팀">영업팀</option>
				<option value="회계팀">회계팀</option>
			</select> <select name="position" id="quit_position">
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
			</select> <input type="text" name="name" id="quit_name" placeholder="이름">
		</div>
		<div class="simpleData" id="quit_simpleData">
			<table>
			</table>
		</div>
	</div>

	<div class="Data_detail" id="quitData_detail">
		<div class="detailData">
			<table>
				<tr>
					<td>사원 번호</td>
					<td><input type="text" class="normal" name="emplno"
						id="quitDetail_emplno" readonly></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" class="normal" name="name"
						id="quitDetail_name" readonly></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" class="normal" name="id"
						id="quitDetail_id" readonly></td>
				</tr>
				<tr>
					<td>부서</td>
					<td><input type="text" class="normal"
						id="quitDetail_department" readonly></td>
				</tr>
				<tr>
					<td>직책</td>
					<td><input type="text" class="normal" id="quitDetail_position"
						readonly></td>
				</tr>
				<tr>
					<td>입사일</td>
					<td><input type="date" class="normal"
						id="quitDetail_startdate" max="9999-12-31" readonly></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="text" class="long" id="quitDetail_email"
						maxlength='50' readonly></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" class="normal" id="quitDetail_phone"
						maxlength='15' readonly></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" id="quitDetail_birth" max="9999-12-31"
						readonly></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" class="long" id="quitDetail_addr1"
						placeholder="주소" readonly><br> <input type="text"
						class="long" id="quitDetail_addrDetail" placeholder="상세주소"
						readonly></td>
				</tr>
				<tr>
					<td>퇴사일</td>
					<td><input type="date" id="quitDetail_enddate"
						max="9999-12-31" readonly></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>