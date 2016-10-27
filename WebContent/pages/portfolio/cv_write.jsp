<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>커버미 :: 이력서수정 페이지</title>
<!-- css -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
<script type="text/javascript" src="/portfolio/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="/portfolio/js/essential_2.js"></script>
	<!-- essential2에서 헤더호출 -->
	<div id="myheader"></div>
	<!-- Page Content -->
	<div class="container" style="width: 80%;margin-left:15%">
		<!-- 상단 메뉴 -->

		<!-- Page Navigator -->
		<ol class="breadcrumb path" style="background-color: white;">
			<li><a href="#" onclick="clickMenu('home')">Home</a></li>
			<li class="active">이력서 관리</li>
		</ol>
		<!--  -->

		<!-- Page Title -->
		<div class="page-header" style="border-left: 5px solid #ff0000;">
			<span
				style="font-size: 25px; font-weight: bold; font-family: inherit; margin-left: 1%;">기본
				이력서 관리</span>
		</div>

		<!-- essential2에서 탭메뉴호출 -->
		<div id="myheader2"></div>
		<form action="insertResume.action" id="resumeForm" method="post" enctype="multipart/form-data"
			style="width: 100% ;">
			<input type="hidden" name="files" id="file1"> <input
				type="hidden" name="files" id="file2"> <input type="hidden"
				name="files" id="file3">



			<!-- 경력 -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">
						<lngtag data-langnum="300">경력</lngtag>
					</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="careerTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td data-langnum="301">입사</td>
								<td data-langnum="302">퇴사</td>
								<td colspan="2" data-langnum="303">회사명</td>
								<td data-langnum="304">업종</td>
								<td colspan="2" data-langnum="305">부서</td>
								<td data-langnum="306">직위</td>
							</tr>
						</tbody>
						<tbody></tbody>




					</table>
					<input type="button" class="btn btn-default"
						onclick="careerRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="careerRow(this)" value="-">
				</div>
			</div>

			<!-- 면허, 자격 -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">
						<lngtag data-langnum="500">면허, 자격</lngtag>
					</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="licenseTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td><b><lngtag data-langnum="501">년</lngtag></b></td>
								<td><b><lngtag data-langnum="502">월</lngtag></b></td>
								<td width="70%"><b><lngtag data-langnum="503">면허/자격</lngtag></b></td>
								<td><b><lngtag data-langnum="504">비고</lngtag></b></td>
							</tr>
						</tbody>
						<tbody></tbody>


						<tbody>
							<tr>
								<td><input type="text" class="form-control" id="compJoin0"
									name="resumeVO.license_year" value="" maxlength="4"
									onkeyup="this.value=number_filter(this.value);"></td>
								<td><input type="text" class="form-control" id="compLeave0"
									name="resumeVO.license_month" value="" maxlength="2"
									onkeyup="this.value=number_filter(this.value);"></td>
								<td><input type="text" class="form-control" id="compName0"
									name="resumeVO.license_name" value="" maxlength="40"></td>
								<td><input type="text" class="form-control" id="industry0"
									name="resumeVO.license_etc" value="" maxlength="50"></td>
							</tr>



						</tbody>
					</table>
					<input type="button" class="btn btn-default"
						onclick="licenceRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="licenceRow(this)" value="-">
				</div>
			</div>

			</tbody>
			</table>
<div style="">
			<!-- 버튼 -->
				<input type="button" id="admit" class="btn btn-default btn-info"
					value="수정"> <input type="button" id="delete"
					class="btn btn-default" value="삭제" onclick="deleteResume()">
			<!-- 버튼.끝 -->
</div>

			<input type="hidden" class="license" name="resumeVO.license_seq" value="15733"> <input type="hidden" id="ncd" name="resumeVO.mbr_dvd"> <input type="hidden" id="ncd2" name="resumeVO.mbr_portfolio">
			<input type="hidden" name="resumeVO.resume_seq" value="713">
			<input type="hidden" id="sex" name="memberVo.sex" value="0">
		</form>
	</div>

	<!-- end .container -->
	<!-- Footer -->
	<div class="footer"></div>
</body>
</html>