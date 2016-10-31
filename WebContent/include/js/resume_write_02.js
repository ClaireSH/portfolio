//유웅 - resumeManagement.jsp
//이미지 업로드

//$(document).ready(function() {
//	var input = $("#previewImg").val();
//	$("#tabs").tabs();
//	$('#print_page *').attr('disabled', true);
//	// perviewImage();
//});
	
	var academicBgId;
	var adminssionYear;
	var graduationYear;
	var schoolName;
	var major;
	var degree;
	var remarks;
	
window.onload = function(){
	/*전체가 읽힌 다음에 호출이 됌  */
	
	academicBgId =  document.getElementsByName("academicBgId");
	adminssionYear = document.getElementsByName("adminssionYear");
	graduationYear = document.getElementsByName("graduationYear");
	schoolName = document.getElementsByName("schoolName");
	major = document.getElementsByName("major");
	degree = document.getElementsByName("degree");
	
	console.log(academicBgId[0].value);
	console.log(academicBgId[1].value);
	abilityRow("init");
	/*adminssionYearArr = document.getElementsByClassName("adminssionYear0");
	graduationYearArr = document.getElementByClassName("graduationYear0");
	schoolNameArr = document.getElementsByClassName("schoolName0");
	majorArr = document.getElementsByClassName("major0");
	degreeArr = document.getElementsByClassName("degree0");
	remarksArr = document.getElementsByClassName("remarks0");
	
	console.log(adminssionYearArr);
	
	for(var index in adminssionYearArray){
		console.log(adminssionYearArr[index].value);
	}
	
	abilityRow(btn)*/
	
}
	

function previewImage(input, target) {
	if (input.files && input.files[0]) {
		var image = new Image; // Image 객체 생성
		var reader = new FileReader();
		reader.onload = function(e) {
			// 선택된 파일 이미지의 src를 image src에 입력
			image.src = e.target.result;
			// var size = input.filesize;
			/*
			 * //image의 가로, 세로 길이 제한 가능 if(image.width >100 || image.height
			 * <50){ alert('100*50 사이즈 까지의 이미지만 첨부해주시기 바랍니다.'); }
			 */
			$('#' + target).attr('src', image.src);
		}
		reader.readAsDataURL(input.files[0]); // File을 읽어 dataURL형식 문자열로 저장
	}
}

// 등록 유효성
function check() {
	var jpnName = document.getElementById('jpnName');
	var name = document.getElementById('name');
	var upload = document.getElementById('upload');
	var nation = document.getElementById('nation');
	var year = document.getElementById('year');
	var month = document.getElementById('month');
	var day = document.getElementById('day');
	var spouse = document.getElementById('spouse');
	var gender = document.getElementById('gender');
	var jpnAddr = document.getElementById('jpnAddr');
	var addr = document.getElementById('addr');
	var intro = document.getElementById('intro');
	var previewImg = document.getElementById('previewImg');
	var lngType = sessionStorage.getItem("lngType");

	if (name.value == '') {
		
			alert('이름을 입력해주시기 바랍니다');
		
		name.focus();

		return false;
	}

	/*
	 * if (jpnName.value == '') {
	
			alert('이름 일어표기를 입력해주시기 바랍니다');
		
		jpnName.focus();

		return false;
	}

	if (previewImg.value == '') {
	
			alert('사진파일을 업로드 해주시기 바랍니다');
		
		previewImg.focus();

		return false;
	}

	if (year.value.length != 4) {
		
			alert('네 자리로 입력해 주세요');
	
		year.focus();

		return false;
	}

	if (month.value.length != 2) {
		
			alert('두 자리로 입력해 주세요');
		
		month.focus();

		return false;
	}

	if (day.value.length != 2) {
		
			alert('두 자리로 입력해 주세요');
		
		day.focus();

		return false;
	}

	if (isNaN(year.value) || isNaN(month.value) || isNaN(day.value)) {
		
			alert('숫자만 입력 가능합니다');
		
		year.focus();

		return false;
	}

	if (intro.value == null) {
		$('#resume_check').attr("class", "alert alert-danger");
		
			document.getElementById("resume_check").innerHTML = "자기소개를 입력해주시기 바랍니다";
		
		document.getElementById("resume_check").style.display = "block";
		intro.focus();
		return false;
	}

	if ($('#mbr_pic').val() != null) {
		$('#file1').attr("value", "upload");
	}

	if ($('#upload').val() != "") {
		$('#file1').attr("value", "upload");
	}

	if ($('#portfolio').val() != "") {
		$('#file2').attr("value", "portfolio");
	}
	if ($('#dvd').val() != "") {
		$('#file3').attr("value", "dvd");
	}*/

	return true;
}

function insertResume() {
	/*var result = check();
	if (result == false)
		return false;*/
	var resumeForm = document.getElementById('resumeForm');
	resumeForm.action = "resumeRegister";
	resumeForm.submit();
}

function deleteResume() {
	var lngType = sessionStorage.getItem("lngType");
	var msg = "";
	
		msg = "정말 삭제하시겠습니까?";
	

	if (!confirm(msg)) {
		return false;
	}
	var resumeForm = document.getElementById('resumeForm');
	resumeForm.action = "deleteResume";
	resumeForm.submit();
}

function updateResume() {
	/*alert("ipdate");
	var result = check();
	if (result == false)
		return false;
    
	
	
	*/
	var resumeForm = document.getElementById('resumeForm');
	resumeForm.action = "updateResume";
	resumeForm.submit();
	return true;
}
function update() {
	/*alert("ipdate2");
	*/check();
	var resumeForm = document.getElementById('resumeForm');
	
	resumeForm.action = "resumeUpdate";
	resumeForm.submit();
	return true;
}

	 

function abilityRow(btn) {
	if (btn.value == '+') {
		var rowCount = $('#eduTable tr').length - 1;
		var content = '';
		content += '<tr>';
		content += '<td><input class="form-control" type="text" maxlength = "11" name="academicBgList' + rowCount + '.adminssionYear" value="${academicBgList[' + rowCount + '].adminssionYear}"  id="entrance' + rowCount + '" >';
		content += '<input vaule= "0" class="form-control" type="hidden" id="edu_gubun" name=""  id="edu_gubun' + rowCount + '" ></td>';
		content += '<td><input class="form-control" type="text" maxlength = "11" name="academicBgList' + rowCount + '.graduationYear" value="${academicBgList[' + rowCount + '].graduationYear}" id="graduation' + rowCount + '"  ></td>';
		content += '<td colspan="2"><input class="form-control" maxlength = "30" name="academicBgList' + rowCount + '.schoolName" value="${academicBgList[' + rowCount + '].schoolName}"  type="text" id="school' + rowCount + '"  ></td>';
		content += '<td colspan="2"><input class="form-control" maxlength = "30" type="text" name="academicBgList[' + rowCount + '].major"  value="${academicBgList[' + rowCount + '].major}"  id="major' + rowCount + '"  ></td>';
		content += '<td><input class="form-control" type="text" maxlength="20" name="academicBgList' + rowCount + '.degree"  value="${academicBgList[' + rowCount + '].degree}" id="degree' + rowCount + '"  ></td>';
		content += '<td><input class="form-control" type="text" maxlength="20" name="academicBgList' + rowCount + '.remarks" value="${academicBgList[' + rowCount + '].remarks}"  id="note' + rowCount + '"  ></td>';
		content += '</tr>';
		$('#eduTable > tbody:last').append(content);
	} else if (btn.value == '-') {
		$('#eduTable > tbody:last > tr:last').remove();
	} else if (btn.value == 'init'){
		var rowMax = academicBgId.length;
		console.log(rowMax);
		//var rowCount = $('#eduTable tr').length - 1;
		for(var i=0;i<rowMax;i++){
			var content = '';
			content += '<tr>';
			content += '<td><input class="form-control" type="text" maxlength = "11" name="academicBgList' + i + '.adminssionYear" value="'+ academicBgId+'"  id="entrance' + i + '" >';
			content += '<input vaule= "0" class="form-control" type="hidden" id="edu_gubun" name=""  id="edu_gubun' + i + '" ></td>';
			content += '<td><input class="form-control" type="text" maxlength = "11" name="academicBgList' + i + '.graduationYear" value="' + graduationYear + '" id="graduation' + i + '"  ></td>';
			content += '<td colspan="2"><input class="form-control" maxlength = "30" name="academicBgList' + i + '.schoolName" value="' + schoolName + '"  type="text" id="school' + i + '"  ></td>';
			content += '<td colspan="2"><input class="form-control" maxlength = "30" type="text" name="academicBgList' + i + '.major"  value="' + major + '"  id="major' + i + '"  ></td>';
			content += '<td><input class="form-control" type="text" maxlength="20" name="academicBgList' + i + '.degree"  value="' + degree + '" id="degree' + i + '"  ></td>';
			content += '<td><input class="form-control" type="text" maxlength="20" name="academicBgList' + i + '.remarks" value="' + remarks + '"  id="note' + i + '"  ></td>';
			content += '</tr>';
		}
		$('#eduTable > tbody:last').append(content);
	}
}

function careerRow(btn) {
	if (btn.value == '+') { 
		var rowCount = $('#careerTable tr').length;
		var content = '';
		content += '<tr>';
		content += '<td><input class="form-control" type="text" name="resumeVO.career_term_from" id="compJoin' + rowCount + '" maxlength = "11"></td>';
		content += '<td><input class="form-control" type="text" name="resumeVO.career_term_to" id="compLeave' + rowCount + '" maxlength = "11" ></td>';
		content += '<td colspan="2"><input class="form-control" name="resumeVO.career_company" type="text" id="compName' + rowCount + '" maxlength = "30" ></td>';
		content += '<td><input class="form-control" type="text" name="resumeVO.career_type" id="industry' + rowCount + '" maxlength = "20" ></td>';
		content += '<td colspan="2"><input class="form-control" name="resumeVO.career_dept" type="text" id="department' + rowCount + '" maxlength = "20" ></td>';
		content += '<td><input class="form-control" type="text" name="resumeVO.career_posion" id="position' + rowCount + '" maxlength = "10" ></td>';
		content += '</tr>';
		$('#careerTable > tbody:last').append(content);
	} else if (btn.value == '-') {
		$('#careerTable > tbody:last > tr:last').remove();
	}
}

function skillRow(btn) {
	if (btn.value == '+') {
		var rowCount = $('#skillTable tr').length;
		var content = '';
		content += '<tr>';
		content += '<td><input type="text" class="form-control" id="cert1" name = "resumeVO.skill_lang" ></td>';
		content += '<td><input type="text" class="form-control" id="cert1" name = "resumeVO.skill_os" ></td>';
		content += '<td><input type="text" class="form-control" id="cert1" name = "resumeVO.skill_db" ></td>';
		content += '<td><input type="text" class="form-control" id="cert1" name = "resumeVO.skill_web" ></td>';
		content += '<td><input type="text" class="form-control" id="cert1" name = "resumeVO.skill_etc" ></td>';
		content += '</tr>';
		$('#skillTable > tbody:last').append(content);
	} else if (btn.value == '-') {
		$('#skillTable > tbody:last > tr:last').remove();
	}
}

function licenceRow(btn) {
	if (btn.value == '+') {
		var rowCount = $('#licenseTable tr').length - 1;
		var content = '';
		content += '<tr>';
		content += '<td><input type="text" class="form-control" id="cert1" maxlength = "4" name = "resumeVO.license_year" onkeyup="this.value=number_filter(this.value);"></td>';
		content += '<td><input type="text" class="form-control" id="acqDate1" maxlength = "2" name = "resumeVO.license_month" onkeyup="this.value=number_filter(this.value);"></td>';
		content += '<td><input type="text" class="form-control" id="pyot1" maxlength = "40" name = "resumeVO.license_name" ></td>';
		content += '<td><input type="text" class="form-control" id="pyot1" maxlength = "50" name = "resumeVO.license_etc"></td>';
		content += '</tr>';
		$('#licenseTable > tbody:last').append(content);
	} else if (btn.value == '-') {
		$('#licenseTable > tbody:last > tr:last').remove();
	}
}

function projectRow(btn) {
	if (btn.value == '+') {
		var rowCount = $('#projectTable tr').length - 1;
		var content = '';
		content += '<tr>';
		content += '<td><input type="text" class="form-control" id="cert1" maxlength = "30" name = "resumeVO.project_name" ></td>';
		content += '<td><input type="text" class="form-control" id="cert1" maxlength = "33" name = "resumeVO.project_term" ></td>';
		content += '<td><input type="text" class="form-control" id="cert1" maxlength = "15" name = "resumeVO.project_number" ></td>';
		content += '<td><input type="text" class="form-control" id="cert1" maxlength = "80" name = "resumeVO.project_lang" ></td>';
		content += '<td><input type="text" class="form-control" id="cert1" maxlength = "80" name = "resumeVO.project_db_os" ></td>';
		content += '<td><input type="text" class="form-control" id="cert1" maxlength = "80" name = "resumeVO.project_etc" ></td>';
		content += '</tr>';
		$('#projectTable > tbody:last').append(content);
	} else if (btn.value == '-') {
		$('#projectTable > tbody:last > tr:last').remove();
	}
}
