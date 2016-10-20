/**
 * 
 */
$('document').ready(function() {
		var today = new Date();
		var toyear = parseInt(today.getFullYear());
		var start = toyear - 5;
		var end = toyear - 100;
		var y = "";

		for (i = start; i >= end; i--)
			y += ("<option>" + i + "</option>");
		$("#year").html(y);

		var m = "";
		for (i = 1; i <= 12; i++)
			m += ("<option>" + i + "</option>");
		$("#month").html(m);

		var d = "";
		for (i = 1; i <= 31; i++)
			d += ("<option>" + i + "</option>");
		$("#day").html(d);

		var birth = $('#birthday').val();

		var year;
		var month;
		var date;

		year = birth.substring(0, 4);
		month = birth.substring(4, 6);
		date = birth.substring(6, 8);

		$('#year').val(year);
		if (month < 10)
			month = birth.substring(5, 6);
		$('#month').val(month);

		if (date < 10)
			date = birth.substring(7, 8);
		$('#day').val(date);

		var sex = $('#sex').val();
		if (sex == 0) {
			document.getElementById("man").checked = true;
		} else {
			document.getElementById("woman").checked = true;
		}

	});//ready

	function joinMember() {

		var f = document.form1;
		var userpw = document.getElementById("userpw").value;
		var userpw0 = document.getElementById("userpw0").value;
		var username = document.getElementById("username").value;

		var year = document.getElementById("year").value;
		var month = document.getElementById("month").value;
		var day = document.getElementById("day").value;

		var email = document.getElementById("email").value;
		var tel = document.getElementById("tel").value;

		var pattern = /[~!@#$%^&*\()\-=+_]/gi;

		//생년월일 조합
		if (month < 10)
			month = "0" + month;
		if (day < 10)
			day = "0" + day;
		var birthday = year + month + day;
		$('#birthday').val(birthday);

		// 입력한 패스워드의 길이가 8자리 보다 자거나 20자리 보다 클 경우
		if (userpw != null && !userpw == "") {
			if (userpw.length<8 || userpw.length>20) {
				alert("패스워드는 8자리 이상 20자리 이하 입니다.");
				return false;
			}

			// 입력한 패스워드 한글입력, 유효성 검사
			if (!userpw.match(/([a-zA-Z].*[0-9])|([0-9].*[a-zA-Z])/)) {
				alert("패스워드는 영어, 숫자 조합입니다.");
				$('#userpw').focus();
				return false;
			}

		}
		// 이름
		if (pattern.test(username)) {
			alert("특수문자는 사용하실 수 없습니다.");
			$('#username').focus();
			return false;
		}

		// 이름
		if (username.match(/([0-9])/)) {
			alert("이름에 숫자는 사용하실 수 없습니다.");
			$('#username').focus();
			return false;
		}

		// email
		if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))) {
			alert("이메일을 정확하게 기입해주세요");
			$('#email').focus();
			return false;
		}

		//입력한 휴대폰번호 숫자 체크
		if (!tel.match(/([0-9])/)) {
			alert("휴대폰 번호는 숫자만 입력가능합니다.");
			$('#tel').focus();
			return false;
		}

		return true;
	}

	function setLanguage() {

	}