$(document).ready(function() {
	var id = $("#myId").val();
	$.getJSON("/myInfo",{id:id},function(myInfo){
		$("#myInfo_id").val(myInfo.id);
		$("#myInfo_name").val(myInfo.name);
		$("#myInfo_position").val(myInfo.position);
		$("#myInfo_department").val(myInfo.department);
		$("#myInfo_phone").val(myInfo.phone);
		$("#myInfo_addr").val(myInfo.addr);
		$("#myInfo_email").val(myInfo.email);
		$("#myInfo_birth").val(myInfo.birth);
		$("#myInfo_startdate").val(myInfo.startdate);
		$("#myInfo_emplno").val(myInfo.emplno);
	});
});

function showPw(){
	var pwPopup= window.open("../myPage/pwChange","비밀번호 변경", "width=500,height=350, left=300, top=200, resizable=no");
}