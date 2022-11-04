$(document).ready(function(){
	// 검색버튼을 클릭하면
	$("#searchbtn").on("click",function(){
		if($("#query").val()==""){
			alert("검색어를 입력해주세요");
			return false;
		}
		// pageNum에 1을 초기화
		$("input[name='pageNum']").val("1");
		// form태그를 submit
		$("#searchform").submit();
	})
	
	// 검색창에서 키보드 입력
	$("#query").keydown(function(keyNum){
		if(keyNum.keyCode == 13){	// 엔터키를 입력 받으면
			// pageNum에 1을 초기화
			$("input[name='pageNum']").val("1");
			// form태그를 submit
			$("#searchform").submit();
		}
	})

})
