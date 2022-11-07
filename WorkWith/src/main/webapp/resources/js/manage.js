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
			member += "<tr onclick='detail(\""+memberList.id+"\","+memberList.quit+")'>" +
					"<td><input type='text' name='department' value='"+memberList.department+"' readonly></td>" +
					"<td><input type='text' name='name' value='"+memberList.name+"' readonly></td>" +
					"<td><input type='text' name='position' value='"+memberList.position+"' readonly></td>"
		})
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
			var phone = memberDetail[0].phone.split("-")
			var email = memberDetail[0].email.split("@")
			var addr = memberDetail[0].addr.split("/")
			
			// 퇴사하지 않은 사원
			if(is_quit==0){
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
				$("#quitDetail_email1").val(email[0]);
				$("#quitDetail_email2").val("@"+email[1]);
				$("#quitDetail_phone1").val(phone[0]);
				$("#quitDetail_phone2").val(phone[1]);
				$("#quitDetail_phone3").val(phone[2]);
				$("#quitDetail_birth").val(memberDetail[0].birth);
				$("#quitDetail_addr1").val(addr[0]);
				$("#quitDetail_addr2").val(addr[1]);
				$("#quitDetail_addrDetail").val(addr[2]);
				$("#quitDetail_addrExtra").val(addr[3]);
			}
	});
}