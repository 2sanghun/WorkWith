$(document).ready(function() {
	$("#myBoard_time").on("change", function() {
		var period = $("#myBoard_time").val();
		window.location.replace("/myPage/myBoard?period=" + period);
	});
	selected_period = $("#selected_period").val();
	if(selected_period==""){
		$("#myBoard_time").val("total").prop("selected", true);
	}else{
		$("#myBoard_time").val(selected_period).prop("selected", true);
	}
});