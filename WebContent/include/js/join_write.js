var duplId = false;

	$('document').ready(function(){
		
		var today = new Date(); 
		var toyear = parseInt(today.getFullYear()); 
		var start = toyear - 5;
		var end = toyear - 100; 
 		var y = "";
 		
		for (i=start;i>=end;i--) y += ("<option>" +i+"</option>"); 
		$("#year").html(y);
		
		var m = "";
		for (i=1;i<=12;i++) m += ("<option>" +i+"</option>"); 
		$("#month").html(m); 

		var d = "";
		for (i=1;i<=31;i++) d += ("<option>" +i+"</option>");
		$("#day").html(d); 
	
		
	});//ready
	
	function check_Id(){		

		var userid= $('#userid').val();
		var pattern= /[~!@#$%^&*\()\-=+_']/gi;
		
		// 입력한 아이디의 길이가 6자리 보다 자거나 20자리 보다 클 경우
		if(userid.length < 6 || userid.length > 20) {
			alert("아이디는 6자리 이상 20자리 이하 입니다.");
			$('#member_Id').focus();
			return false;
		}
		
		if(pattern.test(userid)){ // 특수문자 패턴체크
			alert("특수문자는 사용하실 수 없습니다.");
			$('#userid').focus();
		}else {
			$.ajax({//아이디중복체크
				url:'../society_member/memberIdCheck.action',
				async: false ,
				type:'post',
				dataType:'json',
				data:{member_Id:userid},
				success:function(json){
					var idcheck= json.idCheck;
					if(idcheck == 0){
						alert("이미 사용 중인 아이디입니다.");
						$('#userid').focus();
									
					}else if(idcheck > 0){
						alert("사용할 수 있는 아이디입니다.");
						duplId = true;
					}
				}//success	
				
			});//ajax
		}//else	
	}
	
	function idChanged() {
		duplId = false;
	}
	
	function joinMember() {	
		var f = document.form1;
		var member_Id = document.getElementById("userid").value;
		var userpw = document.getElementById("userpw").value;
		var userpw0 = document.getElementById("userpw0").value;
		var username = document.getElementById("username").value;
		
		var year = document.getElementById("year").value;
		var month = document.getElementById("month").value;
		var day = document.getElementById("day").value;
		
		var email = document.getElementById("email").value;
		var phone = document.getElementById("tel").value;
		
		var masterN = document.getElementById("masterN").value;

		var pattern= /[~!@#$%^&*\()\-=+_']/gi;
		
		//생년월일 조합
		if(month<10) month = "0"+month;
		if(day < 10) day = "0"+day;
		var birthday = year + month + day;	
		$('#birthday').val(birthday);
		
		if(!duplId){
			alert("아이디 중복확인을 해주세요");
			$('#member_Id').focus();
			return false;
		}
		
		// 입력한 아이디의 길이가 6자리 보다 자거나 20자리 보다 클 경우
		if(member_Id.length < 6 || member_Id.length > 20) {
			alert("아이디는 6자리 이상 20자리 이하 입니다.");
			$('#member_Id').focus();
			return false;
		}
		
		// 입력한 패스워드의 길이가 8자리 보다 자거나 20자리 보다 클 경우
		if(userpw.length<8 || userpw.length>20) {
			alert("패스워드는 8자리 이상 20자리 이하 입니다.");
			$('#member_Id').focus();
			return false;
		}	
		
		// 패스워드를 입력하지 않았을 경우
		if (userpw.length < 1) {
			alert("패스워드를 입력해주세요");
			$('#userpw').focus();
			return false;
		}
		
		// 입력한 패스워드 한글입력, 유효성 검사
		if (!userpw.match(/([a-zA-Z].*[0-9])|([0-9].*[a-zA-Z])/)) {
			alert("패스워드는 영어, 숫자 조합입니다.");
			$('#userpw').focus();
			return false;
		}	
	
		// 이름
		if (username.length < 1) {
			alert("이름이 입력되지 않았습니다.");
			$('#username').focus();
			return false;
		}	
		
		// 이름
	 	if(pattern.test(username)){
	 		alert("특수문자는 사용하실 수 없습니다.");
			$('#username').focus();
			return false;
		}
		
		// 이름
		if(username.match(/([0-9])/)){
			alert("이름에 숫자는 사용하실 수 없습니다.");
			$('#username').focus();
			return false;
		}
		
		//  email
		if (email.length < 1) {
			alert("이메일을 입력해주세요");
			$('#email').focus();
			return false;
		}
		
		//이메일 형식 체크
		var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
		if (!email.match(regExp)){
			alert("이메일형식에 맞지 않습니다.");
			$('#email').focus();
			return false;
		}
		
		//  입력한 휴대폰번호 체크
		if (phone.length < 1) {
			alert("휴대폰 번호를 입력해주세요.");
			$('#tel').focus();
			return false;
		}
		
		//입력한 휴대폰번호 숫자 체크(국제규격 정규식)
		var phoneRegex = /^(?:(?:\(?(?:00|\+)([1-4]\d\d|[1-9]\d?)\)?)?[\-\.\ \\\/]?)?((?:\(?\d{1,}\)?[\-\.\ \\\/]?){0,})(?:[\-\.\ \\\/]?(?:#|ext\.?|extension|x)[\-\.\ \\\/]?(\d+))?$/i;
		if(!phone.match(phoneRegex)){
			alert("휴대폰 번호는 숫자만 입력가능합니다.");
			$('#tel').focus();
			return false;
		}
		
		if(masterN.length < 1){
			alert("기수 번호를 입력해주세요");
			$('#masterN').focus();
			return false;
		}
		
		if(!masterN.match(/([0-9])/)){
			alert("기수는 숫자만 입력가능합니다.");
			$('#masterN').focus();
			return false;
		}
		
		var confirmText = '';
		confirmText = '입력된 정보로 가입하시겠습니까?';
		if (confirm(confirmText)) {
		    // Save it!
		    //$('#form1').submit();
		} else {
			// Do nothing!
			return false;
		}
	
		return true;
	}

	function setLanguage() {
	}