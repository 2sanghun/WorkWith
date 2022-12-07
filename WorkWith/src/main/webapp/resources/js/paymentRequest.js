$(document).ready(function(){
	 
	$('input[name="paymentFile"]').change(function() {
		var str="";
		// 위의 결과를 str에 저장하고 id가 uploadResult2인 태그에 넣어준다.
		for(var i=0;i<this.files.length;i++){
			var fileName = this.files[i].name;
			var fileType = this.files[i].name;
			fileType = fileType.slice(fileType.indexOf(".")+1).toLowerCase();
			if(fileType !="docx" && fileType !="hwp" && fileType != "xlsx" && fileType !="pptx" && fileType !="pdf"){ 
			     alert("문서 파일을 선택해 주세요.");
			     $('input[name="paymentFile"]').val('')
			}else{
				str +="<span>"+fileName+"</span><br>";
			}
		}
		$("#uploadResult2").html(str);
	});		
	
	
	
	/* 
	  	첨부파일 공격에 대비하기 위한 업로드 파일 확장자 제한
		.exe, .zip, .alz 등	-> 첨부 못하게
		특정 크기 이상의 파일 		-> 첨부 못하게
	*/
	// 함수 선언
	// 정규식을 이용하여 확장자 제한
	var reg = new RegExp("(.*?)\.(exe|zip|alz)$");
	// 최대 크기를 설정하여 그 이상이면 제한
	var maxSize = 52428800	// 50MB
	//
	function checkExtension(fileName, fileSize){
		// 파일크기 제한
		// 실제파일의 크기 > 최대 크기
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		
		// 확장자 제한
		// 실제파일명의 확장자와 정규식 비교
		// 정규식이면
		if(reg.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}
		
	// 파일 전송버튼(id="sendBtn")을 클릭하면 
	$("#sendBtn").on("click",function(){
		// 제목과 내용을 유효성 검사
		var title = document.querySelector("#paymentTitle").value;
		var content = $("#paymentCon").val();
		if(title==""){
			alert("제목을 입력하세요.");
			return false;
		};
		if(content==""){
			alert("내용을 입력하세요.");
			return false;
		}
		
		// 파일 업로드 관련 로직 처리
		var formData = new FormData();
		
		var inputFile = $("input[name='paymentFile']");
 
		var files = inputFile[0].files;
		
		console.log(files);
		
		for(var i=0; i<files.length; i++){
			// 함수 호출(checkExtension)
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			
			// .jsp 의 파일선택을 통해 선택한 파일들을 form태그에 추가
			formData.append("paymentFile", files[i]);
		}
		
		// ajax를 통해서 UploadController에 파일 관련 데이터 전송.
		$.ajax({
			type : "post",
			url : "/paymentUpload",
			data : formData,
			contentType : false,
			processData : false,
			dataType : "json",
			success : function(result){
				console.log(result);
				var atlist = [];
				var input = "";
				$(result).each(function(i, obj){	// result가 배열이면 each(for) i가 인덱스 번호, obj[i]
					var listdata = {"fileName":obj.fileName,"uuid":obj.uuid,"uploadPath":obj.uploadPath,"image":obj.image}
					atlist.push(listdata);
				})
				writePost({content:content,title:title,attach:atlist})
			}
		})
	})
	
})

function writePost(board){
	console.log(board);
	$.ajax({ 
		type:"POST",
		url:"/payment",
		data:JSON.stringify(board),
		contentType:"application/json; charset=utf-8",
		success: function(){
			alert("저장 완료")
		}
	})
}