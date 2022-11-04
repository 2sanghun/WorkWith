$(document).ready(function() {
	// 첫 화면은 인사관리 페이지
	memberManage(0);
	$("#memberManage_button")[0].style.background = "red";
	
	// 인사 관리 버튼 클릭시
	$("#memberManage_button").on("click", function() {
		$("#memberManage")[0].style.display = "flex";
		$("#memberManage_button")[0].style.background = "red";
		$("#signupManage")[0].style.display = "none";
		$("#signupManage_button")[0].style.background = "white";
		$("#quitManage")[0].style.display = "none";
		$("#quitManage_button")[0].style.background = "white";
		memberManage(0);
	})
	
	// 회원가입 허가 버튼 클릭시
	$("#signupManage_button").on("click", function() {
		$("#signupManage")[0].style.display = "flex";
		$("#signupManage_button")[0].style.background = "red";
		$("#memberManage")[0].style.display = "none";
		$("#memberManage_button")[0].style.background = "white";
		$("#quitManage")[0].style.display = "none";
		$("#quitManage_button")[0].style.background = "white";
	})
	
	// 퇴직자 버튼 클릭시 
	$("#quitManage_button").on("click", function() {
		$("#quitManage")[0].style.display = "flex";
		$("#quitManage_button")[0].style.background = "red";
		$("#signupManage")[0].style.display = "none";
		$("#signupManage_button")[0].style.background = "white";
		$("#memberManage")[0].style.display = "none";
		$("#memberManage_button")[0].style.background = "white";
		memberManage(1);
	})
	
	// 퇴직하지 않은 회원의 검색관련 함수
	$("#member_department").on("change", function() {
		memberManage(0);
	});
	
	$("#member_position").on("change", function() {
		memberManage(0);
	});
	
	$("#member_search").on("click",function(){
		var name = $("#member_name").val();
		if(name==""){
			alert("검색어를 입력하세요.");
		}else{
			memberManage(0);
		}
	})
	
	// 퇴직한 회원의 검색관련 함수
	$("#quit_department").on("change", function() {
		memberManage(1);
	});
	
	$("#quit_position").on("change", function() {
		memberManage(1);
	});
	
	$("#quit_search").on("click",function(){
		var name = $("#quit_name").val();
		if(name==""){
			alert("검색어를 입력하세요.");
		}else{
			memberManage(1);
		}
	})
})

// is_quit는 퇴직 여부를 나타내는 매개변수
// 퇴직한 회원의 경우 1을 주고 퇴직하지 않은 회원의 경우 0를 넣어준다.
function memberManage(is_quit) {
	var quit = is_quit;
	if(is_quit==0){
		var department = $("#member_department").val();
		var position = $("#member_position").val();
		var name = $("#member_name").val();
	}else if(is_quit==1){
		var department = $("#quit_department").val();
		var position = $("#quit_position").val();
		var name = $("#quit_name").val();
	}

	$.getJSON("/memberManage", {
		department : department,
		position : position,
		name : name,
		quit : quit
	}, function(memberList) {
		var member = "<tr><td>부서</td><td>이름</td><td>직책</td></tr>";
		$(memberList).each(function(i,memberList){
			member += "<tr><td><input type='text' name='department' value='"+memberList.department+"'></td>" +
					"<td><input type='text' name='name' value='"+memberList.name+"'></td>" +
					"<td><input type='text' name='position' value='"+memberList.position+"'></td>"
		})
		if(is_quit==0){
			$("#member_simpleData table").html(member);
		}else if(is_quit==1){
			$("#quit_simpleData table").html(member);
		}
		
	})
}