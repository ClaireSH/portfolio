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
<script src="/portfolio/js/jquery-google-sheet-to-json.min.js"></script>
<link rel="stylesheet" href="/portfolio/jQuery-TE_v.1.4.0/jquery-te-1.4.0.css">
<link rel="stylesheet" href="/portfolio/plugin/tagInput/bootstrap-tagsinput.css">
<link rel="stylesheet" href="/portfolio/plugin/tagInput/app.css">

<script>
	/* 카테고리 선택 ajax */
	$.ajax({
		url : 'allDisplay',
		type : "GET",
		dataType : "json",
		success : function(data) {
			var table = "<table data-role='table' id='table1' data-mode=''>" + "<tr>" + "   <th>#</th>" + "   <th>질문</th>" + "</tr>";

			$(data).each(function(index, item) {

				table += "<tr><td>" + index + 1 + "</td>" + "<td>" + this.question + "</td></tr>";

			});

			table += "</table>";

			$('#table1').html(table);
		},
		error : function(error) {
			alert(error.responseText);
		}
	});

	/* 시트제출 */
	function submitsheet() {
		var cvtitle = $('#cvtitle').val();
		var content = $('#content2').val();
		var cvtag = $("#cate").val();

		$.ajax({
			url : "https://script.google.com/macros/s/AKfycby3sb3tPQqIvznKjnZ3UHXUQdqcWM-PD5WXBJujcVceH6m9piJn/exec",
			data : {
				"제목" : cvtitle,
				"내용" : content,
				"태그" : cvtag
			},
			type : "POST"
		});

		$('#cvtitle').val('');
		$('#content2').val("");//에디터 내용은 안지워지는 문제
		$("#cate").val('');
		alert('저장완료');

	}

	/* 모두 로딩 후 불러옴 */
	$(document).ready(function() {

		// use your spreadsheet id here
		var SPREADSHEET_ID = '1KVnrF3AkZ1Zw6mldTRHLg9WjyqP9vZyr_q9laV-2Lek';
		$.googleSheetToJSON(SPREADSHEET_ID).done(function(rows) {
			// each row is a row of data from the spreadsheet
			//console.log(rows[0].timestamp);

			for (var i = rows.length-1; i >= 0; i--) {

				var date = rows[i].timestamp;
				var tag = rows[i].태그;
				var title = rows[i].제목;
				var contents = rows[i].내용;
				var num = rows[i].전체;

				$('#cvalllist').append('<div id="mycvlist'+i+'"><span id="'+num+'" style="color:gray;font-weight:bold;"><input id="title" type="hidden" value="'+title+'"><input id="content" type="hidden" value="'+contents+'"> [' + date.substring(0, 13) + '] </span> <div style="font-size:24px;font-weight:bold;"><i class="fa fa-file-text" ></i>&nbsp;&nbsp;&nbsp;' + title + '</div><hr></div>')
			
				$('#mycvlist'+i).click(function() {
				var tit = $(this).find('input#title').val();
				var msg = $(this).find('input#content').val(); 
				console.log(tit+'/'+msg);
				$('#cvtitle').val(tit);
				$('#	').val(msg);
			});//click
				
			}//for
			t
		}).fail(function(err) {
			console.log('error!', err);
		});//google sheet 

		var textUrl = 'allDisplay';

		$.ajax({
			url : textUrl,
			type : "GET",
			dataType : "json",
			success : function(data) {
				var table = '';
				$(data.qnaList).each(function(index, item) {
					//table += "<button class='accordion'>"+this.question+"</button>"
					//답변
					table += "<button class='accordion' type='button'>" + "<i class='fa fa-question-circle'></i> [" + this.questionType + "] " + this.question + "</button>" + "<div class='panel'>" + "<br>" + "<p>" + "<i class='fa fa-check-circle fa-fw'></i> " + this.answer + "</p>" + "</div>"
				});
				$('#table1').html(table);

				var acc = document.getElementsByClassName("accordion");
				var i;

				for (i = 0; i < acc.length; i++) {
					acc[i].onclick = function() {
						this.classList.toggle("active");
						this.nextElementSibling.classList.toggle("show");
					}
				}
			}
		});

		$('#sorting').children().on('click', function() {
			var value = $(this).val();

			switch (value) {

			case "all":
				textUrl = 'allDisplay';
				break;
			case "free":
				textUrl = 'displayFreeTime';
				break;
			case "cal":
				textUrl = 'displayUniversityLife';
				break;
			case "life":
				textUrl = 'displayEveryDayLife';
				break;
			case "dev":
				textUrl = 'displayDevelop';
				break;
			}

		});//click
	});//ready
</script>
<style type="text/css">
button.accordion {
	background-color: #eee;
	color: #444;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	border: none;
	text-align: left;
	outline: none;
	font-size: 15px;
	transition: 0.4s;
}

button.accordion.active, button.accordion:hover {
	background-color: #ddd;
}

#table1 div.panel {
	padding: 0 18px;
	display: none;
	background-color: white;
}

#table1 div.panel.show {
	display: block;
}
</style>
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
								<i class="fa fa-user fa-fw"></i> My커버
								<div class="btn-group pull-right">
									<button id="openRow2" type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
										<i class="fa fa-chevron-down"></i>
									</button>
								</div>

							</div>
							<div id="bedge_panel1" class="panel-body">




								<div style="text-align: center;">
									<p id="sorting">
										<button type="button" class="btn btn-outline btn-primary" value='all'>전체보기</button>
										<button type="button" class="btn btn-outline btn-success" value='free'>여가생활</button>
										<button type="button" class="btn btn-outline btn-info" value="cal">대학생활</button>
										<button type="button" class="btn btn-outline btn-danger" value="life">일상생활</button>
										<button type="button" class="btn btn-outline btn-warning" value="dev">개발생활</button>
									</p>
								</div>

								<span id="table1"></span>

								<!--버튼 -->

							</div>
						</div>


						<!--  -->
						<div class="panel panel-danger">
							<div class="panel-heading">
								<i class="fa fa-user fa-fw"></i> My커버
								<div class="btn-group pull-right">
									<button id="openRow22" type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
										<i class="fa fa-chevron-down"></i>
									</button>
								</div>

							</div>
							<div id="bedge_panel2" class="panel-body">
								<div style="text-align: left;">
									<div id="cvalllist"></div>
								</div>

								<span id="table1"></span>

								<!--버튼 -->

							</div>
						</div>
						<!--  -->

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
									<input type="text" class="form-control" id="cvtitle" placeholder="버전명을 선택하거나 작성하세요" style="width: 90%; float: left;">
									<div id="counter" style="width: 60px; height: 30px; margin: 10px; overflow: hidden;">###</div>
								</div>
								<!-- 글내용 -->
								<div class="wrap" style="margin: 10px 0;">
									<textarea id="content2" rows="100" name="textarea" style="height:100%;" class="form-control"></textarea>
								</div>
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

				<!-- 	<iframe src="/portfolio/plugin/horizontal-timeline/timeLine.html" width="100%" height="800px"></iframe> -->
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
			$('#content2').keyup(function(e) {
				var content = $(this).val();
				$(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
				$('#counter').html(content.length + '자');
			});
			$('#content2').keyup();

		});
		$('.jqte-test').jqte();

		/* 박스 토글 */
		//$('#bedge_panel').hide();
		$('#openRow2').click(function() {
			$('#bedge_panel1').slideToggle();
		});
		//$('#bedge_panel').hide();
		$('#openRow22').click(function() {
			$('#bedge_panel2').slideToggle();
		});
	</script>
</body>

</html>