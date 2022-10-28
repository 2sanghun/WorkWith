$(document).ready(function() {
	$("#myPage_toggle").on("click", function() {
		$("#myPage").toggle();
	});
});

function showManage(){
	var managePopup= window.open("../manage/memberManage","인사관리", "width=500,height=500, left=300, top=200");
}

function showPayment(){
	var paymentPopup= window.open("../payment/payment","전자 결재", "width=500,height=500, left=300, top=200");
}