$(document).ready(function() {
	$("#memberManage_button")[0].style.background = "red";
	
	$("#memberManage_button").on("click", function() {
		$("#memberManage")[0].style.display = "flex";
		$("#memberManage_button")[0].style.background = "red";
		$("#signupManage")[0].style.display = "none";
		$("#signupManage_button")[0].style.background = "white";
		$("#quitManage")[0].style.display = "none";
		$("#quitManage_button")[0].style.background = "white";
	})
	
	$("#signupManage_button").on("click", function() {
		$("#signupManage")[0].style.display = "flex";
		$("#signupManage_button")[0].style.background = "red";
		$("#memberManage")[0].style.display = "none";
		$("#memberManage_button")[0].style.background = "white";
		$("#quitManage")[0].style.display = "none";
		$("#quitManage_button")[0].style.background = "white";
	})

	$("#quitManage_button").on("click", function() {
		$("#quitManage")[0].style.display = "flex";
		$("#quitManage_button")[0].style.background = "red";
		$("#signupManage")[0].style.display = "none";
		$("#signupManage_button")[0].style.background = "white";
		$("#memberManage")[0].style.display = "none";
		$("#memberManage_button")[0].style.background = "white";

	})
})
