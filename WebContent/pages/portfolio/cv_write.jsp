<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>커버미 :: 이력서커버</title>
<!-- 내부참조 -->
<script src="/portfolio/js/jquery-3.1.1.min.js"></script>
<script src="/portfolio/js/essential_2.js"></script>
<script src="/portfolio/jQuery-TE_v.1.4.0/jquery-te-1.4.0.min.js" charset="utf-8"></script>
<!--편집-->
<link rel="stylesheet" href="/portfolio/include/css/resume_write.css">
<link rel="stylesheet" href="/portfolio/jQuery-TE_v.1.4.0/jquery-te-1.4.0.css">
<script>
	function submitsheet() {
		var cvtitle = $('#cvtitle').val();
		var content = $('#content').val();
		var cvtag = $("#cate").val()

		$.ajax({
			url : "https://script.google.com/macros/s/AKfycby3sb3tPQqIvznKjnZ3UHXUQdqcWM-PD5WXBJujcVceH6m9piJn/exec",
			data : {
				"제목" : cvtitle,
				"내용" : content,
				"태그" : cvtag
			},
			type : "POST"
		});

		cvtitle = ' ';
		content = ' ';
		cvtitle = ' ';
		console.log('전송완료');

	}
</script>

</head>
<body>
	<div id="wrapper">
		<div id="myheader"></div>

		<!-- Page Content -->
		<div id="page-wrapper">

			<!-- 상단 메뉴 -->

			<!-- Page Navigator -->
			<ol class="breadcrumb path" style="background-color: white;">
				<li><a href="#" onclick="clickMenu('home')">Home</a></li>
				<li class="active">이력서 관리</li>
			</ol>
			<!--  -->

			<!-- Page Title -->


			<div class="row">
				<div class="page-header" style="border-left: 5px solid #337ab7;">
					<span style="font-size: 25px; font-weight: bold; font-family: inherit; margin-left: 1%;">이력서 커버</span>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<form id="resumeForm" method="post" enctype="multipart/form-data" style="width: 100%;">
				<input type="hidden" name="files" id="file1"> <input type="hidden" name="files" id="file2"> <input type="hidden" name="files" id="file3">


				<div class="row">
					<!-- 섹션 -->
					<div class="col-lg-5">

						<div class="panel panel-danger">
							<div class="panel-heading">
								<div class="panel-title">
									<lngtag data-langnum="300"> <i class="fa fa-clock-o fa-fw"></i> My커버</lngtag>
								</div>
							</div>
							<div class="panel-body">


								<link rel="stylesheet" href="/portfolio/plugin/tagInput/bootstrap-tagsinput.css">

								<link rel="stylesheet" href="/portfolio/plugin/tagInput/app.css">


								<div style="text-align: center;">
									<p>
										<button type="button" class="btn btn-outline btn-primary">전체보기</button>
										<button type="button" class="btn btn-outline btn-success">여가생활</button>
										<button type="button" class="btn btn-outline btn-info">대학생활</button>
										<button type="button" class="btn btn-outline btn-danger">일상생활</button>
										<button type="button" class="btn btn-outline btn-warning">개발생활</button>
									</p>
								</div>
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>#</th>
											<th>질문</th>
											<th>답변</th>
										</tr>
									</thead>
									<tbody>

										<s:iterator value="qList" status="incre" begin="0" end="5">
											<tr>
												<td>${questionId}</td>
												<td>${question}</td>
												<td><div class="editCell" id="cell${num}" value="${answer}">${answer}</div></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>


								<!--버튼 -->

							</div>
						</div>
					</div>
					<!--섹션.끝-->
					<!-- 섹션 -->
					<div class="col-lg-7">

						<div class="panel panel-danger">
							<div class="panel-heading">
								<div class="panel-title">
									<i class="fa fa-clock-o fa-fw"></i> 자기소개서
								</div>
							</div>
							<div class="panel-body">
								<div style="overflow: hidden; margin: 10px 0;">
									<input type="text" class="form-control" id="cvtitle" placeholder="버전명을 선택하거나 수정하세요" style="width: 90%; float: left;">
									<div id="counter" style="width: 60px; height: 30px; margin: auto; overflow: hidden;">###</div>
								</div>
								<!-- 글내용 -->
								<p>
								<div class="wrap" style="margin: 10px 0;">
									<textarea id="content" name="textarea" class="jqte-test form-control"></textarea>
								</div>
								</p>
								<input id="cate" type="text" value="취미생활,여가생활" data-role="tagsinput">
								<div style="text-align: center; margin: 10px 0;">
									<button type="button" class="btn  btn-warning" onclick="javascript:submitsheet();">시트저장</button>
									<a class="btn  btn-success" href="#writepage">새글쓰기</a>
								</div>
							</div>

						</div>
						<!--섹션.끝-->

					</div>


					<input type="hidden" class="license" name="resumeVO.license_seq" value="15733"> <input type="hidden" id="ncd" name="resumeVO.mbr_dvd"> <input type="hidden" id="ncd2" name="resumeVO.mbr_portfolio"> <input type="hidden" name="resumeVO.resume_seq" value="713"> <input type="hidden" id="sex" name="memberVo.sex" value="0">
			</form>

		
				<!-- 섹션 -->
				<div class="col-lg-12">

					<iframe src="/portfolio/plugin/horizontal-timeline/timeLine.html" width="100%" height="800px"></iframe>
				</div>
		
		</div>

		<!-- end .container -->
		<!-- Footer -->
		<div class="footer">

			<script src="/portfolio/plugin/tagInput/dist/bootstrap-tagsinput.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/js/rainbow.min.js"></script>
			<script src="/portfolio/plugin/tagInput/app.js"></script>

		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#content').keyup(function(e) {
				var content = $(this).val();
				$(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
				$('#counter').html(content.length + '자');
			});
			$('#content').keyup();

		});
		$('.jqte-test').jqte();
	</script>

	<style type="text/css">
iframe {
	border: none;
}

iframe:focus {
	outline: none;
}

iframe[seamless] {
	display: block;
}
</style>
	<style>
.wrap span {
	position: absolute;
	bottom: 5px;
	right: 5px;
}

#counter {
	background: rgba(255, 0, 0, 0.5);
	border-radius: 0.5em;
	padding: 5px 10px 5px 10px;
	font-size: 1em;
}
</style>
	< /body>
</html>