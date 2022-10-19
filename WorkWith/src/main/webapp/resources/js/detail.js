$(document).ready(function() {
	detailList()
	/* 첨부파일 공격에 대비하기 위한 업로드 파일 확장자 제한
		.exe, .zip, .alz 등	-> 첨부 못하게
		특정 크기 이상의 파일 		-> 첨부 못하게
	 */
	// 함수 선언
	// 정규식을 이용하여 확장자 제한
	var reg = new RegExp("(.*?)\.(exe|zip|alz)$");
	// 최대 크기를 설정하여 그 이상이면 제한
	var maxSize = 5242880	// 5MB
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
	
	
	// 파일 전송버튼(id="addfile")을 클릭하면
	$("#addfile").on("click",function(e){
		e.preventDefault();
		
		var inputFile = $("input[name='uploadFile']");
		if(!inputFile.val()){
			alert("파일을 선택해 주세요.");
		}else{
			// 파일 업로드 관련 로직 처리
			var formData = new FormData();
			var bnoValue = $("input[name='bno']").val();
			// console.log(inputFile);
			var files = inputFile[0].files;		
			for(var i=0; i<files.length; i++){
				// 함수 호출(checkExtension)
				if(!checkExtension(files[i].name, files[i].size)){
					return false;
				}
				// .jsp 의 파일선택을 통해 선택한 파일들을 form태그에 추가
				formData.append("uploadFile", files[i]);
			}
		
			// ajax를 통해서 UploadController에 파일 관련 데이터 전송.
			$.ajax({
				type : "post",
				url : "/uploadAjaxAction",
				data : formData,
				contentType : false,
				processData : false,
				dataType : "json",
				success : function(result){
					var input = "";
					var atlist = [];
					$(result).each(function(i, obj){	// result가 배열이면 each(for) i가 인덱스 번호, obj[i]
						var listdata = {"fileName":obj.fileName,"uuid":obj.uuid,"uploadPath":obj.uploadPath,"image":obj.image,"bno":bnoValue}
						atlist.push(listdata);
					})
					addAttach(atlist);
					alert("첨부되었습니다.");
					$("#uploadResult2").html("");
					detailList();
				}
			})
		}
	})
	
   	// 수정 버튼을 클릭하면
	// 이미 존재하는 태그에 이벤트를 처리하고 
	// 나중에 동적으로 생기는 태그들에 대해서 파라미터 형식으로 지정(이벤트 델리게이트)
	$("#modify").on("click", function(e){ 
	  
		// 글 번호를 수집해서    
		var bnoValue = $("input[name='bno']").val();
		
		// 글 내용을 수집해서 
		var contentValue = $("#uploadResult").val();
		   	 
		// 글 제목을 수집해서 
		var titleValue = $("input[name='title']").val();
	
		// 글 수정을 하기 위한 함수 호출(글번호, 글내용, 글제목 )		   
		modifyboard({bno:bnoValue,content:contentValue,title:titleValue});
	}) // 글 수정
})

function attachremove(i){ // 첨부파일 삭제를 하기 위한 함수 선언 	
	var attachlist={uuid:$("#AttachFile"+i).val()};
	$("#AttachList"+i).remove();
	if(confirm("이 파일을 삭제하겠습니까?")){
		$.ajax({
			type: "delete",
			url:"/attach/remove",
			data:JSON.stringify(attachlist),
			contentType:"application/json; charset=utf-8",
			success: function(result){
				if(result=="success"){
					alert("삭제되었습니다"); 
				}
			}	
		})	
	}
}

function detailList(){
	var bno=$("input[name='bno']").val();
	$.getJSON("/attachlist",{bno:bno},function(attachlist){
		var str=attachlist[0].content;
		var atfile = "";
		var atimg = "";
		$(attachlist).each(function(i,attach){
			// 만약 image결과가 true면
			if(attach.image){
				var filePath = encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName);
			    atimg += "<li id='AttachList"+i+"'><input type='text' id='AttachFile"+i+"' value='"+attach.uuid+"' hidden>" 
			    		+ "<a href='/download?fileName="+filePath+"'><img src='/display?fileName="+filePath+"'></a><input type='button' value='삭제' onclick='attachremove("+i+");'></li>";
			}else if(attach.fileName==null){
			}else{// 그렇지 않으면
				var filePath = encodeURIComponent(attach.uploadPath+"/"+attach.uuid+"_"+attach.fileName);
				atfile += "<li id='AttachList"+i+"'><input type='text' id='AttachFile"+i+"' value='"+attach.uuid+"' hidden>"
			    		+ "<a href='/download?fileName="+filePath+"'><img src='../../../resources/image/folder.png' style='width:30px; height:30px'>"+attach.fileName+"</a><input type='button' value='삭제' onclick='attachremove("+i+");'></li>";
			}
		})
		$("#uploadResult").val(str); 
		$("#atfile").html(atfile); 
		$("#atimg").html(atimg);

	})
	
}


function modifyboard(board){ // 글 수정을 하기 위한 함수 선언
   $.ajax({    
      type:"put",
      url:"/detail/modify",  
      data:JSON.stringify(board), 
      contentType:"application/json; charset=utf-8",
      success: function(result){
         if(result=="success"){
            alert("글이 수정되었습니다");
            detailList();
         }
      }   
      })
}

function addAttach(addattach){
	$.ajax({ 
		type:"POST",
		url:"/board/addAttach",
		data:JSON.stringify(addattach),
		dataType:'json',
		contentType:"application/json; charset=utf-8",
		success: function(result){
			alert("성공");
			if(result=="success"){
				alert("파일 첨부 되었습니다.")
				detailList();
			}
		}
	})
}

