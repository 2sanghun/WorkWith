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
		if(memberList.length==0){
			var member = "<tr><td></td><td>사원이 없습니다.</td><td></td></tr>";
		}else{
			var member = "<tr><td>부서</td><td>이름</td><td>직책</td></tr>";
			$(memberList).each(function(i,memberList){
				member += "<tr onclick='detail(\""+memberList.id+"\","+memberList.quit+")'>" +
						"<td><input type='text' name='department' value='"+memberList.department+"' readonly></td>" +
						"<td><input type='text' name='name' value='"+memberList.name+"' readonly></td>" +
						"<td><input type='text' name='position' value='"+memberList.position+"' readonly></td>"
			})
		}
		if(is_quit==0){
			$("#member_simpleData table").html(member);
		}else if(is_quit==1){
			$("#quit_simpleData table").html(member);
		}
		
	})
}

// detail을 수정버튼 클릭 시 다시 호출하고 memberManage의 onclick함수를 간단히하기 위해서 id를 매개변수로 줌.
function detail(thisId,is_quit){
	var id = thisId;
	var quit = is_quit;
	var department = "total";
	var position = "total";
	var name = "";
	$.getJSON("/memberManage", {
		id : id, 
		quit : quit,
		department : department,
		position : position,
		name : name
		}, function(memberDetail){
			console.log(memberDetail[0])
			var addr = memberDetail[0].addr.split("/")
			
			// 퇴사하지 않은 사원
			if(is_quit==0){
				var phone = memberDetail[0].phone.split("-")
				var email = memberDetail[0].email.split("@")
				$("#detail_name").val(memberDetail[0].name);
				$("#detail_id").val(memberDetail[0].id);
				$("#detail_department").val(memberDetail[0].department);
				$("#detail_position").val(memberDetail[0].position);
				$("#detail_startdate").val(memberDetail[0].startdate);
				$("#detail_emplno").val(memberDetail[0].emplno);
				$("#detail_email1").val(email[0]);
				$("#detail_email2").val("@"+email[1]);
				$("#detail_phone1").val(phone[0]);
				$("#detail_phone2").val(phone[1]);
				$("#detail_phone3").val(phone[2]);
				$("#detail_birth").val(memberDetail[0].birth);
				$("#detail_addr1").val(addr[0]);
				$("#detail_addr2").val(addr[1]);
				$("#detail_addrDetail").val(addr[2]);
				$("#detail_addrExtra").val(addr[3]);
			
			// 퇴사한 사원
			}else if(is_quit==1){
				$("#quitDetail_name").val(memberDetail[0].name);
				$("#quitDetail_id").val(memberDetail[0].id);
				$("#quitDetail_department").val(memberDetail[0].department);
				$("#quitDetail_position").val(memberDetail[0].position);
				$("#quitDetail_startdate").val(memberDetail[0].startdate);
				$("#quitDetail_emplno").val(memberDetail[0].emplno);
				$("#quitDetail_email").val(memberDetail[0].email);
				$("#quitDetail_phone").val(memberDetail[0].phone);
				$("#quitDetail_birth").val(memberDetail[0].birth);
				$("#quitDetail_addr1").val(addr[0]+"/"+addr[1]);
				$("#quitDetail_addrDetail").val(addr[2]+addr[3]);
				$("#quitDetail_enddate").val(memberDetail[0].enddate);
			}
	});
}

// 사원 정보 변경 함수
function member_update(){
	var id = $("#detail_id").val();
	var name = $("#detail_name").val();
	var department = $("#detail_department").val()
	var position = $("#detail_position").val()
	var email1 = $("#detail_email1").val()
	var email2 = $("#detail_email2").val()
	var email = email1 + email2;
	var phone1 = $("#detail_phone1").val()
	var phone2 = $("#detail_phone2").val()
	var phone3 = $("#detail_phone3").val()
	var phone = phone1 + "-" + phone2 + "-" + phone3;
	var addr1 = $("#detail_addr1").val()
	var addr2 = $("#detail_addr2").val()
	var addrDetail = $("#detail_addrDetail").val()
	var addrExtra = $("#detail_addrExtra").val()
	var addr = addr1 + "/" + addr2 + "/" + addrDetail + "/" + addrExtra;
	
	$.ajax({
		type : 'post',
		url : "/member_update",
		data : {
			id : id,
			name : name,
			department : department,
			position : position,
			email : email,
			phone : phone,
			addr : addr
		},
		success : function(result) {
			if(result=="success"){
				memberManage(0);
				detail(id,0)
				alert("수정 완료");
			}else{
				alert("수정 실패")
			}
		}
	})
}

// 사원 퇴사 구현
function quitMember(){
	if($("#detail_id").val()==''){
		alert("퇴사시킬 사원을 선택해 주세요.")
		return false;
	}else{
		return confirm("퇴사시키겠습니까?");
	}
}

// submit이 퇴사에 되어있어 엔터누를경우 퇴사가 실행됨
// 엔터의 실행을 막는 함수
function captureReturnKey(e) { 
    if(e.keyCode == 13) 
        return false; 
} 
