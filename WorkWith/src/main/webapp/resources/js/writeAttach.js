$(document).ready(function() {
	// 이미지 파일을 바로 표시하는 함수 작성
	// reader가 이미지 파일을 읽도록 하고 reader가 이미지 파일(a)을 읽으면 expression이라는 id를 가진 img태그에
	// src 속성을 부여해 선택한 이미지 파일을 표시함.
	function setImageFromFile(a, expression) {
		if (a) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$(expression).attr('src', e.target.result);
			}
			reader.readAsDataURL(a);
		}
	}
	 
	$('input[name="uploadFile"]').change(function() {
		var str="";
		var lookImage="";
		// 이미지 파일이 아닐경우 image폴더에 있는 이미지를 표시, 이미지 파일이 경우 이미지 태그를 만들고 id를 준다. 이때
		// src는 주지 않는데 위의 setImageFromFile을 사용하기 위함.
		// 위의 결과를 str에 저장하고 id가 uploadResult2인 태그에 넣어준다.
		for(var i=0;i<this.files.length;i++){
			var fileName = this.files[i].name;
			var fileType = this.files[i].name;
			fileType = fileType.slice(fileType.indexOf(".")+1).toLowerCase();
			if(fileType !="jpg" && fileType !="png" && fileType != "gif" && fileType !="bmp"){
			     str+="<span><img src='../../../resources/image/folder.png' style='width:30px; height:30px'>"+fileName+"</span>";
			}else{
				str +="-<span onmouseover='lookImage("+i+")' onmouseout='notImage("+i+")'>"+fileName+"</span><br>";
				lookImage +="<img id='imageArea"+i+"' style='width:200px; height:100px; display:none'>";
			}
		}
		$("#uploadResult2").html(str);
		$("#lookImage").html(lookImage);
		// 위에서 id를 준 이미지 파일을 바로 보이게 하는 반복문
		for(var i=0; i<this.files.length;i++){
			fileType = this.files[i].name;
			fileType = fileType.slice(fileType.indexOf(".")+1).toLowerCase();
			if(fileType =="jpg" || fileType =="png" || fileType == "gif" || fileType =="bmp"){
				setImageFromFile(this.files[i], '#imageArea'+i);
			}else{continue;}
		}
	});		
})

function lookImage(i){
	var a = $("#imageArea"+i)
	a.show();
}

function notImage(i){
	var a = $("#imageArea"+i)
	a.hide();
}