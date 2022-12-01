$(document).ready(function() {
	$("#myPage_toggle").on("click", function() {
		$("#myPage").toggle();
	});
});

function showManage(){
	var managePopup= window.open("../manage/manage","인사관리", "width=1100,height=800, left=200, top=100");
}

function showPayment(){
	var paymentPopup= window.open("../payment/paymentPage","전자 결재", "width=1100,height=800, left=250, top=150");
}