$(document).ready(function() {
	paybutton_click("paymentRequest")
	// 결재 요청 버튼 클릭
	$("#paymentRequest_button").on("click", function() {
		paybutton_click("paymentRequest");
	})

	// 결재 요청 현황 버튼 클릭
	$("#paymentRequestStatus_button").on("click", function() {
		paybutton_click("paymentRequestStatus");

	})

	// 결재 버튼 클릭
	$("#payment_button").on("click", function() {
		paybutton_click("payment");

	})

	// 결재 내력 버튼 클릭
	$("#paymentDetails_button").on("click", function() {
		paybutton_click("paymentDetails");

	})
});

// 결재 관련 버튼 클릭 함수
function paybutton_click(button) {
	var a = [ "paymentRequest", "paymentRequestStatus", "payment",
			"paymentDetails" ];
	for (let i = 0; i < a.length; i++) {
		if (a[i] === button) {
			a.splice(i, 1);
			i--;
		}
	}

	$("#" + button)[0].style.display = "flex";
	$("#" + button + "_button")[0].style.background = "red";
	$("#" + button + "_button")[0].style.paddingBottom = "10px";
	
	for (let i = 0; i < a.length; i++) {
		$("#" + a[i])[0].style.display = "none";
		$("#" + a[i] + "_button")[0].style.background = "white";
		$("#" + a[i] + "_button")[0].style.paddingBottom = "0px";
	}
}
