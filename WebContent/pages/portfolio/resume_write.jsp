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
    	  $('input:text').attr('readonly',false);
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

						<!-- <input type="hidden" name="resumeVO.edu_gubun" value="0"> -->

						<tbody>
							<s:iterator value="academicBgList" status="stat">
								<tr>
									
									<td><input type="hidden" name="academicBgId"
										value="<s:property value="academicBgId" />" /></td>
									<td><input type="text" class="form-control"
										id="adminssionYear0" maxlength="11"
										name="academicBgList.adminssionYear"
										value="<s:property value="academicBgList[#stat.index].adminssionYear" />" readonly></td>
									<td><input type="text" class="form-control"
										id="graduationYear0" maxlength="11"
										name="resumeVo.graduationYear"
										value="<s:property value="academicBgList[#stat.index].graduationYear"/>" readonly></td>
									<td colspan="2"><input size="25%" type="text"
										class="form-control" maxlength="30" id="schoolName0"
										name="resumeVo.schoolName" value="academicBgList[#stat.index].schoolName"/>" readonly></td>
									<td colspan="2"><input size="25%" type="text"
										class="form-control" maxlength="30" id="major0"
										name="resumeVo.major" value="academicBgList[#stat.index].major"/>"
										readonly></td>
									<td><input type="text" class="form-control" id="degree0"
										maxlength="20" name="resumeVo.degree"
										value="<s:property value="academicBgList[#stat.index].degree"/>" readonly></td>
									<td><input type="text" class="form-control"
										maxlength="20" name="resumeVo.remarks"
										value="<s:property value="academicBgList[#stat.index].remarks"/>" readonly></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<input type="button" class="btn btn-default"
						onclick="abilityRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="abilityRow(this)" value="-" >
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
						
						<!--s:iterator하고 careerList  -->
						<!-- <input type="hidden" name="resumeVO.edu_seq" class="edu_seq"
							value="17152"> -->
						<input type="hidden" name="careerVO.careerId" value="0">

						<tr>
							<td><input type="text" class="form-control" id="joinYear0"
								maxlength="11" name="careerVO.joinYear" value="" readonly></td>
							<td><input type="text" class="form-control"
								id="retirementYear0" maxlength="11"
								name="careerVO.retirementYeard" value="" readonly></td>
							<td colspan="2"><input size="25%" type="text"
								class="form-control" maxlength="30" id="companyName0"
								name="careerVO.companyName" value="" readonly></td>
							<td colspan="2"><input type="text" class="form-control"
								maxlength="20" id="businessType0" name="careerVO.businessType"
								value="" readonly></td>
							<td><input type="text" class="form-control" id="department0"
								maxlength="20" name="careerVO.department" value="" readonly></td>
							<td><input type="text" class="form-control" id="position0"
								maxlength="20" name="careerVO.position" value="" readonly></td>
						</tr>
					</table>
					<input type="button" class="btn btn-default"
						onclick="careerRow(this)" value="+"> <input type="button"
						class="btn btn-default"  onclick="careerRow(this)" value="-">
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

						<input type="hidden" name="certificateVO.certificateId"
							value="15733">
						<tbody>
							<tr>
								<td><input type="text" class="form-control" id="year0"
									name="certificateVO.year" value="" maxlength="4"
									onkeyup="this.value=number_filter(this.value);" readonly></td>
								<td><input type="text" class="form-control" id="month0"
									name="certificateVO.,month" value="" maxlength="2"
									onkeyup="this.value=number_filter(this.value);" readonly></td>
								<td><input type="text" class="form-control"
									id="certificateName0" name="certificateVO.certificateName"
									value="" maxlength="40" readonly></td>
								<td><input type="text" class="form-control" id="remarks0"
									name="certificateVO.remarks" value="" maxlength="50" readonly></td>
							</tr>



						</tbody>
					</table>
					<input type="button"  class="btn btn-default"
						onclick="licenceRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="licenceRow(this)"value="-">
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



						<input type="hidden" name="projectcareerVo.projectCareerId"
							value="14984">
						<tbody>
							<tr>
								<td><input type="text" class="form-control"
									id="projectName0" name="projectcareerVo.projectName" value=""
									maxlength="30" readonly></td>
								<td><input type="text" class="form-control"
									id="developmentPeriod0"
									name="projectcareerVo.developmentPeriod" value=""
									maxlength="33" readonly></td>
								<td><input type="text" class="form-control" id="duration"
									name="projectcareerVo.duration" value="" maxlength="15"
									readonly></td>
								<td><input type="text" class="form-control" id="language0"
									name="projectcareerVo.language" value="" maxlength="80"
									readonly></td>
								<td><input type="text" class="form-control" id="dbos0"
									name="projectcareerVo.dbos" value="" maxlength="80" readonly></td>
								<td><input type="text" class="form-control" id="etc0"
									name="projectcareerVo.etx" value="" maxlength="80" readonly></td>
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
			type="hidden" id="sex" name="memberVo.gender" value="0">
	</div>
	</div>


	<!-- end .container -->

	<!-- Footer -->
	<div class="footer"></div>
</body>
</html>