$(document).ready(function() {
	$("#signupManage_button").on("click", function() {
		$("#signupManage")[0].style.display = "flex";
		$("#memberManage")[0].style.display = "none";
	})
	$("#memberManage_button").on("click", function() {
		$("#memberManage")[0].style.display = "flex";
		$("#signupManage")[0].style.display = "none";
	})
})
