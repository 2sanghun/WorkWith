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
			<div style="flex: 2" id="memberData_simple">
				<div id="memberManage_search">
					<select name="department" id="member_department">
						<option value="total">부서</option>
						<option value="총무팀">총무팀</option>
						<option value="인사팀">인사팀</option>
						<option value="기획팀">기획팀</option>
						<option value="영업팀">영업팀</option>
						<option value="회계팀">회계팀</option>
					</select> <select name="position" id="member_position">
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
					</select> <input type="text" name="name" id="member_name" placeholder="이름">
					<input type="button" id="member_search" value="검색">
				</div>
				<div id="member_simpleData">
					<table>
					</table>
				</div>
			</div>

			<div style="flex: 3" id="memberData_detail"></div>

		</div>

		<div id="signupManage" style="display: none">
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
					<input type="button" id="signup_search" value="검색">
				</div>
				<div id="signup_simpleData">
					<table>
					</table>
				</div>
			</div>

			<div style="flex: 3" id="signupData_detail"></div>

		</div>

		<div id="quitManage" style="display: none">
			<div style="flex: 2" id="quitData_simple">
				<div id="quitManage_search">
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
					<input type="button" id="quit_search" value="검색">
				</div>
				<div id="quit_simpleData">
					<table>
					</table>
				</div>
			</div>

			<div style="flex: 3" id="quitData_detail"></div>

		</div>

	</div>
</body>
</html>