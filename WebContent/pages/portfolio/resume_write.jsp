<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%-- 	<%@ taglib prefix="s" uri="/struts-tags" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Cover me</title>
<!-- js -->
<script>
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- css -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- ���� -->
<script type="text/javascript"
	src="/portfolio/include/js/resume_write_01.js"></script>
<script type="text/javascript"
	src="/portfolio/include/js/resume_write_02.js"></script>

<link rel="stylesheet" href="/portfolio/include/css/resume_write.css">

</head>
<body>
	<script type="text/javascript" src="/portfolio/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="/portfolio/js/essential_2.js"></script>
	<!-- essential2���� ���ȣ�� -->
	<div id="myheader"></div>
	<!-- Page Content -->
	<div class="container" style="width: 80%; margin-left: 15%">
		<!-- ��� �޴� -->


		<!-- Page Navigator -->
		<ol class="breadcrumb path" style="background-color: white;">
			<li><a href="../society/index" onclick="clickMenu('home')">Home</a></li>
			<li class="active">�̷¼� ����</li>
		</ol>
		<!--  -->

		<!-- Page Title -->
		<div class="page-header" style="border-left: 5px solid #ff0000;">
			<span
				style="font-size: 25px; font-weight: bold; font-family: inherit; margin-left: 1%;">�⺻
				�̷¼� ����</span>
		</div>

		<div id="myheader2"></div>
		<!-- ���߿� essential2�� ���� -->

		<script type="text/javascript">
	  $(document).ready(function () {
      $('#tab01').removeClass();
      $('#tab02').addClass('active');
      
      var toggle = false; 
      $('#btn_toggle').on('click',function(){
		    var prev = $(this).prev('input'),
		        ro   = prev.prop('readonly');
/* 		    prev.prop('readonly', !ro).focus(); */
		    $(this).val(ro ? '����' : '����');
		});     

/*     	  if(toggle){
    	  $('input:text').attr('readonly','readonly'); 
    	  toggle = false; 
    	  }else{
    		  $('input:text').removeAttr('readonly');
    		  toggle = true; 
    	  } */
      });
	  
      </script>
		<!--  -->

		<form action="insertResume.action" id="resumeForm" method="post"
			enctype="multipart/form-data" style="width: 100%;"
			onsubmit="return insertResume()">
			<input type="hidden" name="files" id="file1"> <input
				type="hidden" name="files" id="file2"> <input type="hidden"
				name="files" id="file3">

			<!-- �⺻���� -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">�⺻����</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td style="width: 12%;">�̸�</td>
								<td><input type="text" class="form-control" maxlength="10"
									id="name" name="memberVO.name" value="" disabled></td>
								<td class="text-center" rowspan="4" style="width: 20%;"><img
									id="previewImg" name="resumeVO.mbr_pic" style="width: 100px;"
									src=""> <input type="file" value="���ε�" id="upload"
									name="upload"
									onchange="previewImage(this,&#39;previewImg&#39;)"
									style="width: 100%;"></td>
							</tr>
							<!-- <tr>
								<td>��̰���</td>
								<td><input readonly type="text" class="form-control"
									maxlength="13" id="jpnName" name="resumeVO.mbr_name_yomi"
									value=""></td>

							</tr> -->
							<tr>
								<td>�������</td>
								<td>
									<div class="form-inline">
										<input type="text" class="form-control" style="width: 25%;"
											maxlength="4" id="year" name="memberVo.useryear" value=""
											disabled> �� <input type="text" class="form-control"
											style="width: 25%;" maxlength="2" id="month"
											name="memberVo.usermonth" value="" disabled> �� <input
											type="text" class="form-control" style="width: 25%;"
											maxlength="2" id="day" name="memberVo.userday" value=""
											disabled> ��
									</div>
								</td>
							</tr>
							<tr>
								<td>����</td>
								<td><label class="radio-inline"> <input
										type="radio" name="memberVO.gender" id="gender1" value="0"
										disabled="">��
								</label> <label class="radio-inline"> <input type="radio"
										name="memberVO.gender" id="gender2" value="1" disabled="">
										��
								</label></td>
							</tr>
							<tr>
								<td>�ּ�</td>
								<td colspan="2"><input readonly type="text"
									class="form-control" id="addr" maxlength="160"
									name="resumeVO.mbr_address" value=""></td>
								<!-- �ּ� ��������..�� -->

							</tr>
							<!-- <tr>
								<td>�ּ� ��̰���</td>
								<td colspan="2"><input readonly type="text" class="form-control" id="jpnAddr" maxlength="250" name="resumeVO.mbr_address_yomi" value=""></td>

							</tr> -->
						</tbody>
					</table>
				</div>
			</div>

			<!-- �з�, ���ñ��� �̼� -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">�з�, ���ñ��� �̼�</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="eduTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td>����</td>
								<td>����</td>
								<td colspan="2">�б�</td>
								<td colspan="2">����</td>
								<td>����</td>
								<td>���</td>
							</tr>
						</tbody>
						<tbody></tbody>

						<input type="hidden" name="academicVO.edu_seq" class="edu_seq"
							value="17151">
						<input type="hidden" name="resumeVO.edu_gubun" value="0">

						<tbody>
							<tr>
								<td><input type="text" class="form-control" id="entrance0"
									maxlength="11" name="resumeVO.edu_term_from" value="" required
									readonly></td>
								<td><input type="text" class="form-control"
									id="graduation0" maxlength="11" name="resumeVO.edu_term_to"
									value="" required readonly></td>
								<td colspan="2"><input size="25%" type="text"
									class="form-control" maxlength="30" id="school0"
									name="resumeVO.edu_school" value="" required readonly></td>
								<td colspan="2"><input size="25%" type="text"
									class="form-control" maxlength="30" id="major0"
									name="resumeVO.edu_major" value="" required readonly></td>
								<td><input type="text" class="form-control" id="degree0"
									maxlength="20" name="resumeVO.edu_degree" value="" required
									readonly></td>
								<td><input type="text" class="form-control" id="note0"
									maxlength="20" name="resumeVO.edu_note" value="" required
									readonly></td>
							</tr>
						</tbody>
					</table>
					<input type="button" class="btn btn-default"
						onclick="abilityRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="abilityRow(this)" value="-">
				</div>
			</div>

			<!-- ��� -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">���</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="careerTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td>�Ի�</td>
								<td>���</td>
								<td colspan="2">ȸ���</td>
								<td>����</td>
								<td colspan="2">�μ�</td>
								<td>����</td>
							</tr>
						</tbody>
						<tbody></tbody>

						<input type="hidden" name="resumeVO.edu_seq" class="edu_seq"
							value="17152">
						<input type="hidden" name="resumeVO.edu_gubun" value="0">

						<tr>
							<td><input type="text" class="form-control" id="entrance0"
								maxlength="11" name="resumeVO.edu_term_from" value="" required
								readonly></td>
							<td><input type="text" class="form-control" id="graduation0"
								maxlength="11" name="resumeVO.edu_term_to" value="" required
								readonly></td>
							<td colspan="2"><input size="25%" type="text"
								class="form-control" maxlength="30" id="school0"
								name="resumeVO.edu_school" value="" required readonly></td>
							<td colspan="2"><input size="25%" type="text"
								class="form-control" maxlength="30" id="major0"
								name="resumeVO.edu_major" value="" required readonly></td>
							<td><input type="text" class="form-control" id="degree0"
								maxlength="20" name="resumeVO.edu_degree" value="" required
								readonly></td>
							<td><input type="text" class="form-control" id="note0"
								maxlength="20" name="resumeVO.edu_note" value="" required
								readonly></td>
						</tr>
					</table>
					<input type="button" class="btn btn-default"
						onclick="careerRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="careerRow(this)" value="-">
				</div>
			</div>

			<!-- ����, �ڰ� -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">����, �ڰ�</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered" id="licenseTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<td><b>��</b></td>
								<td><b>��</b></td>
								<td width="70%"><b>����/�ڰ�</b></td>
								<td><b>���</b></td>
							</tr>
						</tbody>
						<tbody></tbody>

						<input type="hidden" class="license" name="resumeVO.license_seq"
							value="15733">
						<tbody>
							<tr>
								<td><input type="text" class="form-control" id="compJoin0"
									name="resumeVO.license_year" value="" maxlength="4"
									onkeyup="this.value=number_filter(this.value);" required
									readonly></td>
								<td><input type="text" class="form-control" id="compLeave0"
									name="resumeVO.license_month" value="" maxlength="2"
									onkeyup="this.value=number_filter(this.value);" required
									readonly></td>
								<td><input type="text" class="form-control" id="compName0"
									name="resumeVO.license_name" value="" maxlength="40" required
									readonly></td>
								<td><input type="text" class="form-control" id="industry0"
									name="resumeVO.license_etc" value="" maxlength="50" required
									readonly></td>
							</tr>



						</tbody>
					</table>
					<input type="button" class="btn btn-default"
						onclick="licenceRow(this)" value="+"> <input type="button"
						class="btn btn-default" onclick="licenceRow(this)" value="-">
				</div>
			</div>

			<!-- ������Ʈ ��� -->
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">������Ʈ ���</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered table-hove " id="projectTable"
						style="table-layout: fixed; text-align: left;">
						<tbody>
							<tr>
								<th rowspan="2">������Ʈ��</th>
								<th rowspan="2">���߱Ⱓ</th>
								<th rowspan="2">�ҿ�Ⱓ</th>
								<th colspan="3">��ų�о�</th>
							</tr>
							<tr>
								<td>Language</td>
								<td>DB/OS</td>
								<td>�׿�</td>
							</tr>
						</tbody>
						<tbody></tbody>



						<input type="hidden" class="project" name="resumeVO.project_seq"
							value="14984">
						<tbody>
							<tr>
								<td><input type="text" class="form-control" id="compJoin0"
									name="resumeVO.project_name" value="" maxlength="30" required
									readonly></td>
								<td><input type="text" class="form-control" id="compLeave0"
									name="resumeVO.project_term" value="" maxlength="33" required
									readonly></td>
								<td><input type="text" class="form-control" id="compName0"
									name="resumeVO.project_number" value="" maxlength="15" required
									readonly></td>
								<td><input type="text" class="form-control" id="industry0"
									name="resumeVO.project_lang" value="" maxlength="80" required
									readonly></td>
								<td><input type="text" class="form-control" id="cert1"
									name="resumeVO.project_db_os" value="" maxlength="80" required
									readonly></td>
								<td><input type="text" class="form-control" id="cert1"
									name="resumeVO.project_etc" value="" maxlength="80" required
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
				value="����"> <input type="button" id="delete"
				class="btn btn-default" value="�ʱ�ȭ" onclick="deleteResume()">
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