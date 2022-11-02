$(document).ready(function() {
	$("#myPage_toggle").on("click", function() {
		$("#myPage").toggle();
	});
});

function showManage(){
	var managePopup= window.open("../manage/memberManage","인사관리", "width=1300,height=800, left=200, top=100");
}

function showPayment(){
	var paymentPopup= window.open("../payment/payment","전자 결재", "width=1300,height=800, left=250, top=150");
}