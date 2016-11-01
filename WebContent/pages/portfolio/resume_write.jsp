<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>커버미 :: 이력서수정 페이지</title>
<!-- Latest compiled and minified CSS -->
<script type="text/javascript" src="/portfolio/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/portfolio/js/essential_2.js"></script>
<!-- 내부 -->
<script type="text/javascript"
	src="/portfolio/include/js/resume_write_01.js"></script>
<script type="text/javascript"
	src="/portfolio/include/js/resume_write_02.js"></script>

<link rel="stylesheet" href="/portfolio/include/css/resume_write.css">
</head>
<body>
<div id="wrapper">
	<!-- essential2에서 헤더호출 -->
	<div id="myheader"></div>
	<!-- Page Content -->
	<div id="page-wrapper">
	
		<!-- 상단 메뉴 -->


		<!-- Page Navigator -->
		<ol class="breadcrumb path" style="background-color: white;">
			<li><a href="/portfolio/pages/main.html"
				onclick="clickMenu('home')">Home</a></li>
			<li class="active">이력서 관리</li>
		</ol>
		<!--  -->

		<!-- Page Title -->
		<div class="page-header" style="border-left: 5px solid #337ab7;">
			<span
				style="font-size: 25px; font-weight: bold; font-family: inherit; margin-left: 1%;">기본
				이력서 관리</span>
		</div>

		<div id="myheader2"></div>
		<!-- 나중에 essential2에 넣자 -->

		<script type="text/javascript">
	  $(document).ready(function () {
      $('#tab01').removeClass();
      $('#tab02').addClass('active');

      var toggle = false;
      $('#btn_toggle').on('click',function(){
    	  if(toggle){
    	  $('input:text').attr('readonly','readonly');
    	  toggle = false;
    	  }else{
    		  $('input:text').removeAttr('readonly');
    		  toggle = true;
    	  }
      });


      });
      </script>


		<form action="updateResume" id="resumeForm" method="post"
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
									id="name" name="memberVO.name" value="${memberVo.name}"
									disabled></td>
									<!--  -->
									
									
								<!-- <td class="text-center" rowspan="4" style="width: 20%;"><img
									id="previewImg" name="resumeVO.mbr_pic" style="width: 100px;"
									src=""> <input type="file" value="업로드" id="upload"
									name="upload"
									onchange="previewImage(this,&#39;previewImg&#39;)"
									style="width: 100%;"></td> -->
									
									
									
									<!--  -->
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
											maxlength="4" id="year" name="useryear"
											value="${useryear}" disabled> 년 <input
											type="text" class="form-control" style="width: 25%;"
											maxlength="2" id="month" name="usermonth"
											value="${usermonth}" disabled> 월 <input
											type="text" class="form-control" style="width: 25%;"
											maxlength="2" id="day" name="userday"
											value="${userday}" disabled> 일
									</div>
								</td>
							</tr>
							<tr>
								<td>성별</td>
								<td><label class="radio-inline"> <input
										type="radio" name="memberVO.gender" id="gender1" value="${memberVo.gender}"
										disabled>남
								</label> <label class="radio-inline"> <input type="radio"
										name="memberVO.gender" id="gender2" value="1" disabled>
										여
								</label></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
					<!-- 이력서의 기본키, 외래키 정보 -->
					<s:iterator value="academicBgList" status="stat" >
						<input type="hidden" 
						name="academicBgList[<s:property value="%{#stat.index}"/>].academicBgId" 
						value="<s:property value="academicBgId"/>"
						/>
						<input type="hidden" 
						name="academicBgList[<s:property value="%{#stat.index}"/>].resumeId" 
						value="<s:property value="resumeId"/>"
						/>
					</s:iterator>
					
					<s:iterator value="careerList" status="stat" >
						<input type="hidden" 
						name="careerList[<s:property value="%{#stat.index}"/>].careerId" 
						value="<s:property value="careerId"/>"
						/>
						<input type="hidden" 
						name="careerList[<s:property value="%{#stat.index}"/>].resumeId" 
						value="<s:property value="resumeId"/>"
						/>
					</s:iterator>
					
					<s:iterator value="certificateList" status="stat" >
						<input type="hidden" 
						name="certificateList[<s:property value="%{#stat.index}"/>].certificateId" 
						value="<s:property value="certificateId"/>"
						/>
						<input type="hidden" 
						name="certificateList[<s:property value="%{#stat.index}"/>].resumeId" 
						value="<s:property value="resumeId"/>"
						/>
					</s:iterator>
					
					<s:iterator value="projectCareerList" status="stat" >
						<input type="text" 
						name="projectCareerList[<s:property value="%{#stat.index}"/>].projectCareerId" 
						value="<s:property value="projectCareerId"/>"
						/>
						<input type="text" 
						name="projectCareerList[<s:property value="%{#stat.index}"/>].resumeId" 
						value="<s:property value="resumeId"/>"
						/>
					</s:iterator>
					<!--  -->
						
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
						
						<s:iterator value="academicBgList" status="stat" >
						<tbody>
							
							<tr>
								<td>	
									<input type="text" class="form-control" 
									id="adminssionYear0" maxlength="11"
									name="academicBgList[<s:property value="%{#stat.index}"/>].adminssionYear" 
									value="<s:property value="adminssionYear"/>"
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="graduationYear0" maxlength="11" 
									name="academicBgList[<s:property value="%{#stat.index}"/>].graduationYear"
									value="<s:property value="graduationYear"/>" 
									readonly>
								</td>
								<td colspan="2">	
									<input type="text" class="form-control" 
									id="schoolName0" maxlength="30" size="25%"
									name="academicBgList[<s:property value="%{#stat.index}"/>].schoolName" 
									value="<s:property value="schoolName"/>"
									readonly/>
								</td>
								<td colspan="2">
									<input type="text" class="form-control"
									id="major0" maxlength="30" size="25%"
									name="academicBgList[<s:property value="%{#stat.index}"/>].major"
									value="<s:property value="major"/>" 
									readonly>
								</td>
								<td>	
									<input type="text" class="form-control" 
									id="degree0" maxlength="100"
									name="academicBgList[<s:property value="%{#stat.index}"/>].degree" 
									value="<s:property value="degree"/>"
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="remarks0" maxlength="20"
									name="academicBgList[<s:property value="%{#stat.index}"/>].remarks"
									value="<s:property value="remarks"/>" 
									readonly>
								</td>
							</tr>
						</tbody>
						</s:iterator>
						
					</table>
					<!-- 
					<input type="button" class="btn btn-default"
						onclick="abilityRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="abilityRow(this)" value="-" > 
						-->
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
						
						<s:iterator value="careerList" status="stat" >
						<tbody>
						
							<tr>
								<td>	
									<input type="text" class="form-control" 
									id="joinYear0" maxlength="11"
									name="careerList[<s:property value="%{#stat.index}"/>].joinYear" 
									value="<s:property value="joinYear"/>"
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="retirementYear0" maxlength="11" 
									name="careerList[<s:property value="%{#stat.index}"/>].retirementYear"
									value="<s:property value="retirementYear"/>" 
									readonly>
								</td>
								<td colspan="2">	
									<input type="text" class="form-control" 
									id="companyName0" maxlength="30" size="25%"
									name="careerList[<s:property value="%{#stat.index}"/>].companyName" 
									value="<s:property value="companyName"/>"
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="businessType0" maxlength="30" size="25%"
									name="careerList[<s:property value="%{#stat.index}"/>].businessType"
									value="<s:property value="businessType"/>" 
									readonly>
								</td>
								<td colspan="2">	
									<input type="text" class="form-control" 
									id="department0" maxlength="20"
									name="careerList[<s:property value="%{#stat.index}"/>].department" 
									value="<s:property value="department"/>"
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="position0" maxlength="20"
									name="careerList[<s:property value="%{#stat.index}"/>].position"
									value="<s:property value="position"/>" 
									readonly>
								</td>
							</tr>
					
						</tbody>
						</s:iterator>
					</table>
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
						
						<s:iterator value="certificateList" status="stat" >
						<tbody>
							<tr>
								<td>	
									<input type="text" class="form-control" 
									id="year0" maxlength="11"
									name="certificateList[<s:property value="%{#stat.index}"/>].year" 
									value="<s:property value="year"/>"
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="month0" maxlength="11" 
									name="certificateList[<s:property value="%{#stat.index}"/>].month"
									value="<s:property value="month"/>" 
									readonly/>
								</td>
								<td>	
									<input type="text" class="form-control" 
									id="certificateName0" maxlength="40" size="25%"
									name="certificateList[<s:property value="%{#stat.index}"/>].certificateName" 
									value="<s:property value="certificateName"/>"
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="remarks0" maxlength="50" size="25%"
									name="certificateList[<s:property value="%{#stat.index}"/>].remarks"
									value="<s:property value="remarks"/>" 
									readonly/>
								</td>
							</tr>
						</tbody>
						</s:iterator>
					</table>
					<!-- 
					<input type="button"  class="btn btn-default"
						onclick="licenceRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="licenceRow(this)"value="-">
						 -->
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
						
						<s:iterator value="projectCareerList" status="stat" >
						<tbody>
							<tr>
								<td>
									<input type="text" class="form-control" 
									id="projectName0" maxlength="11"
									name="projectCareerList[<s:property value="%{#stat.index}"/>].projectName" 
									value="<s:property value="projectName"/>"
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="developmentPeriod0" maxlength="11" 
									name="projectCareerList[<s:property value="%{#stat.index}"/>].developmentPeriod"
									value="<s:property value="developmentPeriod"/>" 
									readonly/>
								</td>
								<td>	
									<input type="text" class="form-control" 
									id="duration0" maxlength="40" size="25%"
									name="projectCareerList[<s:property value="%{#stat.index}"/>].duration" 
									value="<s:property value="duration"/>"
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="language0" maxlength="50" size="25%"
									name="projectCareerList[<s:property value="%{#stat.index}"/>].language"
									value="<s:property value="language"/>" 
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="dbos0" maxlength="50" size="25%"
									name="projectCareerList[<s:property value="%{#stat.index}"/>].dbos"
									value="<s:property value="dbos"/>" 
									readonly/>
								</td>
								<td>
									<input type="text" class="form-control"
									id="etc0" maxlength="50" size="25%"
									name="projectCareerList[<s:property value="%{#stat.index}"/>].etc"
									value="<s:property value="etc"/>" 
									readonly/>
								</td>
							</tr>

						</tbody>
						</s:iterator>
					</table>
					<!--
					 <input type="button" class="btn btn-default"
						onclick="projectRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="projectRow(this)" value="-">
						 -->
				</div>
			</div>
			
		</form>
		<div style="text-align: center;">
			<!--  onclick="return updateResume()" -->
			<input type="button" id="admit" class="btn btn-default btn-info"
					value="저장" onclick="return updateResume()"> <input type="button" id="btn_toggle"
					class="btn btn-default btn-info" value="수정"> <input
					type="button" id="delete" class="btn btn-default" value="삭제"
					onclick="deleteResume()">
		</div>
		<input type="hidden" id="ncd" name="resumeVO.mbr_dvd"> <input
			type="hidden" id="ncd2" name="resumeVO.mbr_portfolio"> <input
			type="hidden" name="resumeVO.resume_seq" value="713"> <input
			type="hidden" id="sex" name="memberVo.gender" value="0">
	</div>
	</div>


	<!-- end .container -->

	<!-- Footer -->
	<div class="footer"></div>
</body>
</html>