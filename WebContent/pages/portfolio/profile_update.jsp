<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<!-- 내부참조 -->
<script type="text/javascript" src="/portfolio/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/portfolio/js/essential_2.js"></script>
<script>
function onClick(){
	var form = document.getElementById('updateMemberForm');
	
	
	var userpw 	= document.getElementById("userpw").value;
	var userpw0	= document.getElementById("userpw0").value;
	if(userpw == userpw0){
		
		form.submit();
	}else{
		alert("비밀번호가 일치하지 않습니다.");
	}
	
}
	
</script>
<!-- 내부참조 -->
<link rel="stylesheet" href="/portfolio/include/css/profile_modify.css">
<title>커버미 :: 개인정보 수정</title>
</head>
<body>

	<!-- essential2에서 헤더호출 -->
	<div id="myheader"></div>
	<!-- Page Content -->
	<div id="page-wrapper">
		<!-- 상단 메뉴 -->

		<!-- Page Navigator -->
		<ol class="breadcrumb path" style="background-color: white;">
			<li><a href="/index" onclick="clickMenu('home')">Home</a></li>
			<li class="active">기본정보 관리</li>
		</ol>
		<!--  -->


		<!-- Page Title -->
		<div class="row">
		<div class="page-header" style="border-left: 5px solid #337ab7;">
			<span
				style="font-size: 25px; font-weight: bold; font-family: inherit; margin-left: 1%;">개인정보
				관리</span>
		</div>
		</div>
		
		<div class="panel panel-danger">
			<div class="panel-heading">
				<div class="panel-title">기본정보</div>
			</div>
			<div class="panel-body">
				<s:form id="updateMemberForm" action="updateMember" name="updateForm"
					onsubmit="return joinMember()" method="post"
					style="margin: 0px; padding-bottom: 100px; border-top: none; background: url('') no-repeat center center; background-size: cover;">
					<!-- name 변경 해야함,  col-md(크기) 변경-->
					<fieldset class="width:100%;">
						<ul>
							<li>
								<label for="userid">아이디</label>
								<input type='text' name="memberVo.memberId" maxlength=20 value="${memberVo.memberId}" readonly />
							</li>
							<li>
								<label for="userpw">패스워드</label>
								<input type='password' id="userpw" name="memberVo.password" maxlength=20 />
							</li>
							<li id="pwEnter">
								<label for="userpw0">패스워드 확인</label>
								<input type='password' id="userpw0" name="userpw0" maxlength=20 />
								
							</li>
							<li>
								<label for="username">이름</label>
								<input type='text' id="username" name="memberVo.name" maxlength=20 value="${memberVo.name}" />
							</li>
							<!-- 이부분 Action이랑 연결시켜야함. -->
							<li id="gender">
								<label>성별</label>
								<input type="hidden" id="gender" value="#{memberVo.gender}"/> 
								<input name="memberVo.gender" id="man" type="radio" value="0" />남자
								<input name="memberVo.gender" id="woman" type="radio" value="1" />여자
								<script>
									window.onload = function(){
											var gender = document.getElementById("gender").value;
											var man = document.getElementById("man");
											var woman = document.getElementById("woman");
											if(gender == "0"){
												man.checked = true;
												console.log("0");
											}else{
												woman.checked = true;
												console.log("1");
											}
									}
								</script>
							</li>
							<!-- ---- -->
							<li><label>생년월일</label>
							<select id="years" name="useryear" title="월">
								<script>
									  var myDate = new Date();
									  var year = myDate.getFullYear();
									  for(var i = 1900; i < year+1; i++){
										  if(i == "${useryear}"){
											  document.write('<option selected="selected" value="'+i+'">'+i+'</option>');
										  }
										  else{
											  document.write('<option value="'+i+'">'+i+'</option>');
										  }
										  
									  }
								</script>
							</select>년&nbsp;&nbsp;
							<select id="months" name="usermonth" title="월">
								<script>
									  var month = 12; 
									  for(var i = 1; i < month+1; i++){
										  if(i == "${usermonth}"){
											  document.write('<option selected="selected" value="'+i+'">'+i+'</option>');
										  }
										  else{
											  document.write('<option value="'+i+'">'+i+'</option>');
										  }
										  
									  }
								</script>
							</select>월&nbsp;&nbsp; 
							<select id="days" name="userday" title="일">
								<script>
									  var day = 31;
									  for(var i = 1; i < day+1; i++){
										  if(i == "${userday}"){
											  document.write('<option selected="selected" value="'+i+'">'+i+'</option>');
										  }
										  else{
											  document.write('<option value="'+i+'">'+i+'</option>');
										  }
									  }
								</script>
							</select>일
							</li>
							<li><label>이메일</label> <input type='text'
								placeholder='이메일 주소@도메인' id="email" name="memberVo.email"
								value="${memberVo.email}"></li>
							<li><label>전화번호</label> <input type='text' id="tel"
								name="memberVo.phone" placeholder="숫자만 입력"
								value="${memberVo.phone}"></li>

							<!-- <li><label>마스터 기수</label> <input type='text' id="masterN" name="memberVo.gisu" value=""> 기</li> -->
						</ul>

					</fieldset>

					<input type="hidden" id="birthday" name="memberVo.birth" value="">

					<div id="btnCenter" style="top: 50px;">
						<input type="button" value="수정" onclick="onClick();"/> <input type="reset" value="삭제" />
					</div>
				</s:form>
			</div>
		</div>
	</div>

	<!-- end .container -->
		<div class="footer"></div>
		<!-- end .footer -->
</body>
<script type="text/javascript"
	src="/portfolio/pages/portfolio/js/profile_modify.js"></script>

</html>
