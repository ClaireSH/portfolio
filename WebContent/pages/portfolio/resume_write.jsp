<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%-- 	<%@ taglib prefix="s" uri="/struts-tags" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Cover me</title>
<!-- js -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- css -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/portfolio/include/css/resume_write.css">
<!-- 내부 -->
<script type="text/javascript"
	src="/portfolio/include/js/resume_write_01.js"></script>
<script type="text/javascript"
	src="/portfolio/include/js/resume_write_02.js"></script>


</head>
<body>
	<script type="text/javascript" src="/portfolio/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="/portfolio/js/essential_2.js"></script>
	<!-- essential2에서 헤더호출 -->
	<div id="myheader"></div>
	<!-- Page Content -->
	<div class="container" style="width: 80%; margin-left: 15%">
		<!-- 상단 메뉴 -->


		<!-- Page Navigator -->
		<ol class="breadcrumb path" style="background-color: white;">
			<li><a href="/portfolio/pages/main.html"
				onclick="clickMenu('home')">Home</a></li>
			<li class="active">이력서 관리</li>
		</ol>
		<!--  -->

		<!-- Page Title -->
		<div class="page-header" style="border-left: 5px solid #ff0000;">
			<span
				style="font-size: 25px; font-weight: bold; font-family: inherit; margin-left: 1%;">기본
				이력서 관리</span>
		</div>

		<div id="myheader2"></div>
		<!-- 나중에 essential2에 넣자 -->

		<script>
	  $(document).ready(function () {
      $("#btn_toggle").click(function(){
    	  $("#note0,#entrance0,#admission0,#resign0,#company0,#business0,#department0,#position0,#year0,#month0,#license0,#lnote0,#project0,#term0,#taketerm0,#language0,#db0,#etc0,#graduation0,#school0,#major0,#degree0,#note0").attr("readonly",false); //입력가능
		}); 
  		var prev = $(this).prev('input'),
 	    ro   = prev.prop('readonly');
   	    $(this).val(ro ? 'Save' : 'Edit');
 		});
    	  
    	  
    	  
		  
		   
	  
	$('#tab01').removeClass();
      $('#tab02').addClass('active');
      
      
		
/*		 var toggle = false; 
     	  if(toggle){
    	  $('input:text').attr('readonly','readonly'); 
    	  toggle = false; 
    	  }else{
    		  $('input:text').removeAttr('readonly');
    		  toggle = true; 
    	  } */
      });
	  
      </script>
		<!-- action="insertResume.action"   onsubmit="return insertResume()"-->

		<form action="insertResume" id="resumeForm" method="post"
			enctype="multipart/form-data" style="width: 100%;">
			<input type="hidden" name="files" id="file1"> <input
				type="hidden" name="files" id="file2"> <input type="hidden"
				name="files" id="file3">

			<!-- 기본정보 -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">기본정보</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td style="width: 12%;">이름</td>
								<td><input type="text" class="form-control" maxlength="10"
									id="name" name="memberVO.name" value="" disabled></td>
								<td class="text-center" rowspan="4" style="width: 20%;"><img
									id="previewImg" name="resumeVO.mbr_pic" style="width: 100px;"
									src=""> <input type="file" value="업로드" id="upload"
									name="upload"
									onchange="previewImage(this,&#39;previewImg&#39;)"
									style="width: 100%;"></td>
							</tr>
							<!-- <tr>
								<td>요미가나</td>
								<td><input readonly type="text" class="form-control"
									maxlength="13" id="jpnName" name="resumeVO.mbr_name_yomi"
									value=""></td>

							</tr> -->
							<tr>
								<td>생년월일</td>
								<td>
									<div class="form-inline">
										<input type="text" class="form-control" style="width: 25%;"
											maxlength="4" id="year" name="memberVo.useryear" value=""
											disabled> 년 <input type="text" class="form-control"
											style="width: 25%;" maxlength="2" id="month"
											name="memberVo.usermonth" value="" disabled> 월 <input
											type="text" class="form-control" style="width: 25%;"
											maxlength="2" id="day" name="memberVo.userday" value=""
											disabled> 일
									</div>
								</td>
							</tr>
							<tr>
								<td>성별</td>
								<td><label class="radio-inline"> <input
										type="radio" name="memberVO.gender" id="gender1" value="0"
										disabled="">남
								</label> <label class="radio-inline"> <input type="radio"
										name="memberVO.gender" id="gender2" value="1" disabled="">
										여
								</label></td>
							</tr>
							<tr>
								<td>주소</td>
								<td colspan="2"><input type="text" class="form-control"
									id="addr" maxlength="160" name="resumeVO.mbr_address" value=""
									readonly></td>
								<!-- 주소 어케하지..ㅠ -->

							</tr>
							<!-- <tr>
								<td>주소 요미가나</td>
								<td colspan="2"><input readonly type="text" class="form-control" id="jpnAddr" maxlength="250" name="resumeVO.mbr_address_yomi" value=""></td>

							</tr> -->
						</tbody>
					</table>
				</div>
			</div>

			<!-- 학력, 관련교육 이수 -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">학력, 관련교육 이수</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="eduTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td>입학</td>
								<td>졸업</td>
								<td colspan="2">학교</td>
								<td colspan="2">전공</td>
								<td>학위</td>
								<td>비고</td>
							</tr>
						</tbody>
						<tbody></tbody>

						<!-- <input type="hidden" name="resumeVO.edu_gubun" value="0"> -->
						<input type="hidden" name="academicVO.edu_seq" class="edu_seq"
							value="17151">

						<tbody>
							<tr>
								<td><input type="text" class="form-control" id="admission0"
									maxlength="11" name="academicVo.edu_term_from" value="" 
									readonly></td>
								<td><input type="text" class="form-control"
									id="graduation0" maxlength="11" name="resumeVO.edu_term_to"
									value=""  readonly></td>
								<td colspan="2"><input size="25%" type="text"
									class="form-control" maxlength="30" id="school0"
									name="resumeVO.edu_school" value=""  readonly></td>
								<td colspan="2"><input size="25%" type="text"
									class="form-control" maxlength="30" id="major0"
									name="resumeVO.edu_major" value=""  readonly></td>
								<td><input type="text" class="form-control" id="degree0"
									maxlength="20" name="resumeVO.edu_degree" value="" 
									readonly></td>
								<td><input type="text" class="form-control" id="note0"
									maxlength="20" name="resumeVO.edu_note" value="" 
									readonly></td>
							</tr>
						</tbody>
					</table>
					<input type="button" class="btn btn-default"
						onclick="abilityRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="abilityRow(this)" value="-">
				</div>
			</div>

			<!-- 경력 -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">경력</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="careerTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td>입사</td>
								<td>퇴사</td>
								<td colspan="2">회사명</td>
								<td>업종</td>
								<td colspan="2">부서</td>
								<td>직위</td>
							</tr>
						</tbody>
						<tbody></tbody>

						<input type="hidden" name="resumeVO.edu_seq" class="edu_seq"
							value="17152">
						<input type="hidden" name="resumeVO.edu_gubun" value="0">

						<tr>
							<td><input type="text" class="form-control" id="entrance0"
								maxlength="11" name="resumeVO.edu_term_from" value="" 
								readonly></td>
							<td><input type="text" class="form-control" id="resign0"
								maxlength="11" name="resumeVO.edu_term_to" value="" 
								readonly></td>
							<td colspan="2"><input size="25%" type="text"
								class="form-control" maxlength="30" id="company0"
								name="resumeVO.edu_school" value=""  readonly></td>
							<td colspan="2"><input size="25%" type="text"
								class="form-control" maxlength="30" id="business0"
								name="resumeVO.edu_major" value=""  readonly></td>
							<td><input type="text" class="form-control" id="department0"
								maxlength="20" name="resumeVO.edu_degree" value="" 
								readonly></td>
							<td><input type="text" class="form-control" id="position0"
								maxlength="20" name="resumeVO.edu_note" value="" 
								readonly></td>
						</tr>
					</table>
					<input type="button" class="btn btn-default"
						onclick="careerRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="careerRow(this)" value="-">
				</div>
			</div>

			<!-- 면허, 자격 -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">면허, 자격</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="licenseTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td><b>년</b></td>
								<td><b>월</b></td>
								<td width="70%"><b>면허/자격</b></td>
								<td><b>비고</b></td>
							</tr>
						</tbody>
						<tbody></tbody>

						<input type="hidden" class="license" name="resumeVO.license_seq"
							value="15733">
						<tbody>
							<tr>
								<td><input type="text" class="form-control" id="year0"
									name="resumeVO.license_year" value="" maxlength="4"
									onkeyup="this.value=number_filter(this.value);" 
									readonly></td>
								<td><input type="text" class="form-control" id="month0"
									name="resumeVO.license_month" value="" maxlength="2"
									onkeyup="this.value=number_filter(this.value);" 
									readonly></td>
								<td><input type="text" class="form-control" id="license0"
									name="resumeVO.license_name" value="" maxlength="40" 
									readonly></td>
								<td><input type="text" class="form-control" id="lnote0"
									name="resumeVO.license_etc" value="" maxlength="50" 
									readonly></td>
							</tr>



						</tbody>
					</table>
					<input type="button" class="btn btn-default"
						onclick="licenceRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="licenceRow(this)" value="-">
				</div>
			</div>

			<!-- 프로젝트 경력 -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">프로젝트 경력</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered table-hove " id="projectTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<th rowspan="2">프로젝트명</th>
								<th rowspan="2">개발기간</th>
								<th rowspan="2">소요기간</th>
								<th colspan="3">스킬분야</th>
							</tr>
							<tr>
								<td>Language</td>
								<td>DB/OS</td>
								<td>그외</td>
							</tr>
						</tbody>
						<tbody></tbody>



						<input type="hidden" class="project" name="resumeVO.project_seq"
							value="14984">
						<tbody>
							<tr>
								<td><input type="text" class="form-control" id="project0"
									name="resumeVO.project_name" value="" maxlength="30" 
									readonly></td>
								<td><input type="text" class="form-control" id="term0"
									name="resumeVO.project_term" value="" maxlength="33" 
									readonly></td>
								<td><input type="text" class="form-control" id="taketerm0"
									name="resumeVO.project_number" value="" maxlength="15" 
									readonly></td>
								<td><input type="text" class="form-control" id="language0"
									name="resumeVO.project_lang" value="" maxlength="80" 
									readonly></td>
								<td><input type="text" class="form-control" id="db0"
									name="resumeVO.project_db_os" value="" maxlength="80" 
									readonly></td>
								<td><input type="text" class="form-control" id="etc0"
									name="resumeVO.project_etc" value="" maxlength="80" 
									readonly></td>
							</tr>


						</tbody>
					</table>
					<input type="button" class="btn btn-default"
						onclick="projectRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="projectRow(this)" value="-">
				</div>
			</div>
			</tbody>
			</table>
		</form>
		<div style="text-align: center;">
			<!--  onclick="return updateResume()" -->
			<input type="button" id="btn_toggle" class="btn btn-default btn-info"
				value="수정"> <input type="button" id="delete"
				class="btn btn-default" value="초기화" onclick="deleteResume()">
		</div>
		<input type="hidden" id="ncd" name="resumeVO.mbr_dvd"> <input
			type="hidden" id="ncd2" name="resumeVO.mbr_portfolio"> <input
			type="hidden" name="resumeVO.resume_seq" value="713"> <input
			type="hidden" id="sex" name="memberVo.sex" value="0">
	</div>
	</div>


	<!-- end .container -->

	<!-- Footer -->
	<div class="footer"></div>
</body>
</html>