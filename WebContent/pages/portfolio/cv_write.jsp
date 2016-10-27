<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Ŀ���� :: �̷¼����� ������</title>
<!-- css -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
<script type="text/javascript" src="/portfolio/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="/portfolio/js/essential_2.js"></script>
	<!-- essential2���� ���ȣ�� -->
	<div id="myheader"></div>
	<!-- Page Content -->
	<div class="container" style="width: 80%;margin-left:15%">
		<!-- ��� �޴� -->

		<!-- Page Navigator -->
		<ol class="breadcrumb path" style="background-color: white;">
			<li><a href="#" onclick="clickMenu('home')">Home</a></li>
			<li class="active">�̷¼� ����</li>
		</ol>
		<!--  -->

		<!-- Page Title -->
		<div class="page-header" style="border-left: 5px solid #ff0000;">
			<span
				style="font-size: 25px; font-weight: bold; font-family: inherit; margin-left: 1%;">�⺻
				�̷¼� ����</span>
		</div>

		<!-- essential2���� �Ǹ޴�ȣ�� -->
		<div id="myheader2"></div>
		<form action="insertResume.action" id="resumeForm" method="post" enctype="multipart/form-data"
			style="width: 100% ;">
			<input type="hidden" name="files" id="file1"> <input
				type="hidden" name="files" id="file2"> <input type="hidden"
				name="files" id="file3">



			<!-- ��� -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">
						<lngtag data-langnum="300">���</lngtag>
					</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="careerTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td data-langnum="301">�Ի�</td>
								<td data-langnum="302">���</td>
								<td colspan="2" data-langnum="303">ȸ���</td>
								<td data-langnum="304">����</td>
								<td colspan="2" data-langnum="305">�μ�</td>
								<td data-langnum="306">����</td>
							</tr>
						</tbody>
						<tbody></tbody>




					</table>
					<input type="button" class="btn btn-default"
						onclick="careerRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="careerRow(this)" value="-">
				</div>
			</div>

			<!-- ����, �ڰ� -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">
						<lngtag data-langnum="500">����, �ڰ�</lngtag>
					</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="licenseTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td><b><lngtag data-langnum="501">��</lngtag></b></td>
								<td><b><lngtag data-langnum="502">��</lngtag></b></td>
								<td width="70%"><b><lngtag data-langnum="503">����/�ڰ�</lngtag></b></td>
								<td><b><lngtag data-langnum="504">���</lngtag></b></td>
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
			<!-- ��ư -->
				<input type="button" id="admit" class="btn btn-default btn-info"
					value="����"> <input type="button" id="delete"
					class="btn btn-default" value="����" onclick="deleteResume()">
			<!-- ��ư.�� -->
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