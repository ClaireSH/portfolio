$(document).ready(function() {
	
	var sex=$('#sex').val();
	if(sex==0){
		document.getElementById("gender1").checked=true;
	}else{
		document.getElementById("gender2").checked=true;
	}
	
	$('#ok1').click(function() {
		
		 
		 
			
		 if($("input[name=attachFile1]")[0].files[0]!=null&&$("input[name=attachFile2]")[0].files[0]!=null){
			 var filename1 = document.getElementById('resumeVO.mbr_portfolio').value;
				if (filename1) {
				    var startIndex = (filename1.indexOf('\\') >= 0 ? filename1.lastIndexOf('\\') : filename1.lastIndexOf('/'));
				    var filename = filename1.substring(startIndex);
				    if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
				        filename = filename.substring(1);
				    }
				
				    var extention=filename.split(".");
				  
				    if (extention.length > 2){
				    	alert("파일명에 . 을 넣을 수 없습니다.");
				    	return false;
				    }
				    
				    if(extention[1].toLowerCase()!="zip"){
				    	alert("올바른 포트폴리오 형식이 아닙니다. zip파일을 올려주세요");
				    	return false;
				    }
				}
				 document.getElementById("spinner").style.display="inline-block";
				 document.getElementById("alert").innerHTML = "동영상을 올리는중입니다...";
			 var size = $("input[name=attachFile1]")[0].files[0].size;
			 var size2 = $("input[name=attachFile2]")[0].files[0].size;
			  if(size>104857600){
				  alert("동영상 파일 크기가 100MB가 넘습니다. ");
				  return false;
			  }
			  if(size2>104857600){
				  alert("포트폴리오 파일 크기가 100MB가 넘습니다. ");
				  return false;
			  }
			 var formData = new FormData();
			  	
			 formData.append("attachFile1", $("input[name=attachFile1]")[0].files[0]);
			 $.ajax({
				    url: 'upload.action',
				    data: formData,
				    processData: false,
				    contentType: false,
				    type: 'POST',
				    success: function(data){
				
				    	  document.getElementById("ncd").value=data;
				    	  var formData2 = new FormData();  	
					  	  formData2.append("attachFile2", $("input[name=attachFile2]")[0].files[0]);
					  	 document.getElementById("alert").innerHTML = "파일을 올리는중입니다...";
				    	 $.ajax({
					  	    url: 'upload2.action',
					  	    data: formData2,
					  	    processData: false,
					  	    contentType: false,
					  	    type: 'POST',
					  	    success: function(data){
					  	    	
				  	        document.getElementById("ncd2").value=data;
				  	      var resumeForm = document.getElementById('resumeForm');
				  	 		resumeForm.action = "resumeRegister";
				  	 		resumeForm.submit();
				    	
				    },error:function(edata){
			  	  		alert("zip 파일이 아닙니다.");
			  	  		
			  	  	  } 
				  });
			 },error:function(edata){
			  		alert("동영상 파일이 아닙니다.");
			  		
			 }
			});
		 }else if($("input[name=attachFile2]")[0].files[0]!=null&&$("input[name=attachFile2]")[0].files[0]!=""){
			 var filename1 = document.getElementById('resumeVO.mbr_portfolio').value;
				if (filename1) {
				    var startIndex = (filename1.indexOf('\\') >= 0 ? filename1.lastIndexOf('\\') : filename1.lastIndexOf('/'));
				    var filename = filename1.substring(startIndex);
				    if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
				        filename = filename.substring(1);
				    }
				
				    var extention=filename.split(".");
				    
				    if (extention.length > 2){
				    	alert("파일명에 . 을 넣을 수 없습니다.");
				    	return false;
				    }
					  
				    if(extention[1].toLowerCase()!="zip"){
				    	alert("올바른 포트폴리오 형식이 아닙니다. zip파일을 올려주세요");
				    	return false;
				    }
				}
			 var size2 = $("input[name=attachFile2]")[0].files[0].size;
			  if(size2>104857600){
				  alert("포트폴리오 파일 크기가 100MB가 넘습니다. ");
				  return false;
			  }
			 var formData2 = new FormData();  	
		  	  formData2.append("attachFile2", $("input[name=attachFile2]")[0].files[0]);
	  	      
	    	 $.ajax({
		  	    url: 'upload2.action',
		  	    data: formData2,
		  	    processData: false,
		  	    contentType: false,
		  	    type: 'POST',
		  	    success: function(data){
		  	    	
	  	 		       document.getElementById("ncd2").value=data;
	  	 		    var resumeForm = document.getElementById('resumeForm');
		  	 		resumeForm.action = "resumeRegister";
		  	 		resumeForm.submit();
		  	    },error:function(edata){
		  	  		alert("zip 파일이 아닙니다.");
		  	  		
		  	  	  } });
		  
		 }else if($("input[name=attachFile1]")[0].files[0]!=null&&$("input[name=attachFile1]")[0].files[0]!=""){
			 var size = $("input[name=attachFile1]")[0].files[0].size;
			 if(size>104857600){
				  alert("동영상 파일 크기가 100MB가 넘습니다. ");
				  return false;
			  }
			 document.getElementById("spinner").style.display="inline-block";
			 document.getElementById("alert").innerHTML = "동영상을 올리는중입니다...";
			 var formData = new FormData();
			  	
			 formData.append("attachFile1", $("input[name=attachFile1]")[0].files[0]);
		  
			 $.ajax({
				    url: 'upload.action',
				    data: formData,
				    processData: false,
				    contentType: false,
				    type: 'POST',
				    success: function(data){
				    	 document.getElementById("ncd").value=data;
				    	 var resumeForm = document.getElementById('resumeForm');
				  	 		resumeForm.action = "resumeRegister";
				  	 		resumeForm.submit();
				    },error:function(edata){
			  	  		alert("동영상 파일이 아닙니다.");
			  	  		
			  	  	  } });}else{
			  	  		
			  	 	      var resumeForm = document.getElementById('resumeForm');
			  	 		resumeForm.action = "resumeRegister";
			  	 		resumeForm.submit();
	}
});
	 
	 $('#admit').click(function() {
		 
		 if($("input[name=attachFile1]")[0].files[0]!=null&&$("input[name=attachFile2]")[0].files[0]!=null){
			 var filename1 = document.getElementById('resumeVO.mbr_portfolio').value;
				if (filename1) {
				    var startIndex = (filename1.indexOf('\\') >= 0 ? filename1.lastIndexOf('\\') : filename1.lastIndexOf('/'));
				    var filename = filename1.substring(startIndex);
				    if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
				        filename = filename.substring(1);
				    }
				
				    var extention=filename.split(".");
				    
				    if (extention.length > 2){
				    	alert("파일명에 . 을 넣을 수 없습니다.");
				    	return false;
				    }
					  
				    if(extention[1].toLowerCase()!="zip"){
				    	alert("올바른 포트폴리오 형식이 아닙니다. zip파일을 올려주세요");
				    	return false;
				    }
				}
				document.getElementById("spinner").style.display="inline-block";
				 document.getElementById("alert").innerHTML = "동영상을 올리는중입니다...";
			 var formData = new FormData();
			  	
			 formData.append("attachFile1", $("input[name=attachFile1]")[0].files[0]);
			 $.ajax({
				    url: 'upload3.action',
				    data: formData,
				    processData: false,
				    contentType: false,
				    type: 'POST',
				    success: function(data){
				
				    	  document.getElementById("ncd").value=data;
				    	  var formData2 = new FormData();  	
					  	  formData2.append("attachFile2", $("input[name=attachFile2]")[0].files[0]);
					  	
						 document.getElementById("alert").innerHTML = "파일을 올리는중입니다...";
				    	 $.ajax({
					  	    url: 'upload2.action',
					  	    data: formData2,
					  	    processData: false,
					  	    contentType: false,
					  	    type: 'POST',
					  	    success: function(data){
					  	    	
				  	        document.getElementById("ncd2").value=data;
				  	      var resumeForm = document.getElementById('resumeForm');
				  		resumeForm.action = "updateResume";
				  		resumeForm.submit();
				    	
				    },error:function(edata){
			  	  		alert("zip 파일이 아닙니다.");
			  	  		
			  	  	  } 
				  });
			 },error:function(edata){
			  		alert("동영상 파일이 아닙니다.");
			  		
			 }
			});
		 }else if($("input[name=attachFile2]")[0].files[0]!=null&&$("input[name=attachFile2]")[0].files[0]!=""){
			 var filename1 = document.getElementById('resumeVO.mbr_portfolio').value;
				if (filename1) {
				    var startIndex = (filename1.indexOf('\\') >= 0 ? filename1.lastIndexOf('\\') : filename1.lastIndexOf('/'));
				    var filename = filename1.substring(startIndex);
				    if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
				        filename = filename.substring(1);
				    }
				
				    var extention=filename.split(".");
				    
				    if (extention.length > 2){
				    	alert("파일명에 . 을 넣을 수 없습니다.");
				    	return false;
				    }
				    
				    if(extention[1].toLowerCase()!="zip"){
				    	alert("올바른 포트폴리오 형식이 아닙니다. zip파일을 올려주세요");
				    	return false;
				    }
				}
			 var formData2 = new FormData();  	
		  	  formData2.append("attachFile2", $("input[name=attachFile2]")[0].files[0]);
	  	      
	    	 $.ajax({
		  	    url: 'upload2.action',
		  	    data: formData2,
		  	    processData: false,
		  	    contentType: false,
		  	    type: 'POST',
		  	    success: function(data){
		  	    	
	  	 		       document.getElementById("ncd2").value=data;
	  				      var resumeForm = document.getElementById('resumeForm');
	  					resumeForm.action = "updateResume";
	  					resumeForm.submit();
		  	    },error:function(edata){
		  	  		alert("zip 파일이 아닙니다.");
		  	  		
		  	  	  } });
		  
		 }else if($("input[name=attachFile1]")[0].files[0]!=null&&$("input[name=attachFile1]")[0].files[0]!=""){
			 document.getElementById("spinner").style.display="inline-block";
			 document.getElementById("alert").innerHTML = "동영상을 올리는중입니다...";
			 var formData = new FormData();
			  	
			 formData.append("attachFile1", $("input[name=attachFile1]")[0].files[0]);
		  
			 $.ajax({
				    url: 'upload.action',
				    data: formData,
				    processData: false,
				    contentType: false,
				    type: 'POST',
				    success: function(data){
				    	 document.getElementById("ncd").value=data;
				    	 var resumeForm = document.getElementById('resumeForm');
				    		resumeForm.action = "updateResume";
					  		resumeForm.submit();
				    },error:function(edata){
			  	  		alert("동영상 파일이 아닙니다.");
			  	  		
			  	  	  } });}else{
		  var resumeForm = document.getElementById('resumeForm');
	  		resumeForm.action = "updateResume";
	  		if(checkForm()==true)
	  		resumeForm.submit();
	}
});
	 
	 
	 
	 
}); 

/**
* setLanguage 
* use $.lang[currentLanguage][languageNumber]
*/
function setLanguage(lngType) {
	if(lngType == 'ko'){
		$('[data-langNum]').each(function() {
		    var $this = $(this); 
		    $this.html(ko[$this.data('langnum')]); 
		  });
	}
	else if(lngType == 'ja'){
		$('[data-langNum]').each(function() {
		    var $this = $(this); 
		    $this.html(ja[$this.data('langnum')]); 
		  });
	}
	setTagValueLng(lngType);
}
function setTagValueLng(){
	
		/* document.getElementById("ok").value = "등록/수정"; */
		document.getElementById("delete").value = "삭제";
	
	
}

function setLanguageFooter(){
	
}
function checkForm() {
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
	
	if(name.value.length>10){
		alert("이름의 길이를 10자 이하로 정해주세요.");
		
		return false;
		
	}

	if (jpnName.value == '') {
		
			alert('이름 일어표기를 입력해주시기 바랍니다');
		
		jpnName.focus();

		return false;
	}
	if(jpnName.value.length>13){
		alert("일문이름의 길이를 13자 이하로 정해주세요.");
		
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

	/*if ($('#mbr_pic').val() != null) {
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

	
function number_filter(str_value){
	return str_value.replace(/[^0-9]/gi, ""); 
	
} 
