window.addEventListener('load', function() {
	// 패스워드
	var pwchk = document.querySelector("#pwchk");
	pwchk.onblur = function() { 
		// (?=.*[문자]) 정규식 패턴은 해당 문자가 필수로 포함되어야 하는 경우에 사용하는 정규식이다.
		var pwreg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
		var pwValue = pwchk.value;
		var pwmsg = document.querySelector("#pwmsg");
		if (pwreg.test(pwValue)) {
			pwmsg.innerHTML = "";
		} else {
			pwmsg.innerHTML = "* 8~16자 영문, 숫자, 특수문자를 사용하세요.";
			pwmsg.style.color = "gray";
		}
	}
	
	// 비밀번호 재확인
	var rechk = document.querySelector("#rechk");
	rechk.onblur = function() {
		var pwValue = pwchk.value;
		var reValue = rechk.value;
		var remsg = document.querySelector("#remsg");
		if (pwValue==reValue) {
			remsg.innerHTML = "";
		} else {
			remsg.innerHTML = "* 비밀번호가 일치하지 않습니다.";
			remsg.style.color = "gray";
		}
	}

})