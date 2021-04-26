function checkForm(frm) {
	console.log(frm);
	
	var userName = frm.username.value.trim();
	var password = frm.password.value.trim();
	var id = frm.id.value.trim();
	var box = frm.box.value;
	var check = frm.check.value;
	
	//	TODO: 추가 검증
	if (userName.length < 3) {
		alert("이름은 2자리 이상의 문자입니다.");
		frm.userName.focus();
	} else if (password.length < 8) {
		alert("비밀번호는 8자리 이상이어야 합니다.");
		frm.password.focus();
	} else if (id.length < 3 ) {
		alert("아이디는 3자리 이상으로 입력해 주세요.");
		frm.id.focus();
	} else if(box != "t"){
		alert("이용약관에 동의해 주세요");
	} else if(check != "t"){
			alert("아이디 중복확인 해주세요");		
	} else {	//	검증 통과
		return true;	//	폼 전송
	}
	
	return false;	//	onsubmit 이벤트에서 true여야 전송
}

	function idcheck(idField, url) {
		console.log("id field:", idField.value);
		
		//	Ajax 호출
		if (idField.value.trim().length == 0) {
			alert("아이디를 입력해 주세요");
			return;
		}
		$.ajax({
			url: url,
			type: "GET",
			dataType: "json",
			data: {
				id: idField.value.trim()
			}, 
			success: function(result) {
				console.log("Result:", result);
				//hidden 필드 check값 변경
				
			if(result.data ==true){
					idField.form.check.value ="f";		
					alert("사용중인 아이디 입니다");
			}else {			
					idField.form.check.value ="t";
					alert("사용할 수 있는 아이디 입니다.");
				}
			},
			error: function(xhr, status, error) {
				console.error("Status:", status);
				console.error("Response:", xhr);
				console.error("Error:", error);
				
				idField.form.check.value ="f";
	
			}		
		});
	}
