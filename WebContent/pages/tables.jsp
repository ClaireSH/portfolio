<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript" src="/portfolio/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/portfolio/js/essential.js"></script>

<title>Cover ME</title>



</head>

<body>
	
		<div id="wrapper">
			<div id="myheader"></div>
			<!-- Page Content -->

			<div id="page-wrapper">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">질문편집</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">질문답변목록</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<table width="100%" class="table table-striped table-bordered table-hover container">
									<col width="5%">
									<col width="15%">
									<col width="45%">
									<col width="35%">
									<thead>
										<tr>
											<th>#</th>
											<th>분류</th>
											<th>질문</th>
											<th>답변</th>
										</tr>
									</thead>
									<tbody>

										<tr class="gradeU">
											<td id="num">H01</td>
											<td id="type">취미생활</td>
											<td id="question">취미가뭐야?</td>
											<td id="answer">내가 좋아하는 건...</td>
										</tr>
										
										<tr class="gradeU">
											<td id="num">H02</td>
											<td id="type">취미생활</td>
											<td id="question">어떤 계기로 하게 되었어?</td>
											<td id="answer">내가 좋아하는 건...</td>
										</tr>
										
										<tr class="gradeU">
											<td id="num">H03</td>
											<td id="type">취미생활</td>
											<td id="question">다른 취미는 뭐가 있어?</td>
											<td id="answer">내가 좋아하는 건...</td>
										</tr>
										
										<tr class="gradeU">
											<td id="num">H04</td>
											<td id="type">취미생활</td>
											<td id="question">취미를 직업으로 삼을 수 있다고 생각해?</td>
											<td id="answer">내가 좋아하는 건...</td>
										</tr>
										

	<div id="wrapper">
		<div id="myheader"></div>
		<!-- Page Content -->

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">질문편집</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">최근 질문과 답변</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<form action="" method="get">

									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>#</th>
												<th>질문</th>
												<th>답변</th>
												<th>유형</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="qnalist" begin="0" end="2" step="1" status="incre">
												<tr>
													<td >${num}</td>
													<td>${question}</td>qnano
													<td><div class="editCell" id="cell${num}" value="${answer}">${answer}</div></td>
													<td>${title}</td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
									<div style="text-align: center;">
										<input type="button" id="btn_edit" class="btn btn-danger" value="수정"> <input type="button" id="btn_reset" class="btn btn-warning" value="초기화">
									</div>
								</form>
								<script>
								
								function makeEvent(id){
									$("'#'+id").dblclick(function() {
										var vv = $("'#'+id").val()
										$("'#'+id").parent().append('<input type="text" name="editedAnswer" value="'+vv+'"><input type="hidden" name="selector" value="'+id.substring(1,)+'">');
										$("'#'+id").remove();
										alert('삭제2');
									});
	
								}
								
																</script>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
			</div>

		</div>
	</div>
	<!-- /.col-lg-6 -->

	<!-- 아직 안 씀
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Basic Table
                        </div>
                        /.panel-heading
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Jacob</td>
                                            <td>Thornton</td>
                                            <td>@fat</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Larry</td>
                                            <td>the Bird</td>
                                            <td>@twitter</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            /.table-responsive
                        </div>
                        /.panel-body
                    </div>
                    /.panel
                </div>
                /.col-lg-6
            </div>
            /.row
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Striped Rows
                        </div>
                        /.panel-heading
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Jacob</td>
                                            <td>Thornton</td>
                                            <td>@fat</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Larry</td>
                                            <td>the Bird</td>
                                            <td>@twitter</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            /.table-responsive
                        </div>
                        /.panel-body
                    </div>
                    /.panel
                </div>
                /.col-lg-6
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Bordered Table
                        </div>
                        /.panel-heading
                        <div class="panel-body">
                            <div class="table-responsive table-bordered">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Jacob</td>
                                            <td>Thornton</td>
                                            <td>@fat</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Larry</td>
                                            <td>the Bird</td>
                                            <td>@twitter</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            /.table-responsive
                        </div>
                        /.panel-body
                    </div>
                    /.panel
                </div>
                /.col-lg-6
            </div>
            /.row
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Hover Rows
                        </div>
                        /.panel-heading
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Jacob</td>
                                            <td>Thornton</td>
                                            <td>@fat</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Larry</td>
                                            <td>the Bird</td>
                                            <td>@twitter</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            /.table-responsive
                        </div>
                        /.panel-body
                    </div>
                    /.panel
                </div>
                /.col-lg-6
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Context Classes
                        </div>
                        /.panel-heading
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="success">
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr class="info">
                                            <td>2</td>
                                            <td>Jacob</td>
                                            <td>Thornton</td>
                                            <td>@fat</td>
                                        </tr>
                                        <tr class="warning">
                                            <td>3</td>
                                            <td>Larry</td>
                                            <td>the Bird</td>
                                            <td>@twitter</td>
                                        </tr>
                                        <tr class="danger">
                                            <td>4</td>
                                            <td>John</td>
                                            <td>Smith</td>
                                            <td>@jsmith</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            /.table-responsive
                        </div>
                        /.panel-body
                    </div>
                    /.panel
                </div>
                /.col-lg-6
            </div>
            /.row
        </div>
        /#page-wrapper

    </div>
    /#wrapper -->




	<!-- jQuery -->
	<script src="/portfolio/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/portfolio/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="/portfolio/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="/portfolio/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="/portfolio/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="/portfolio/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="/portfolio/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			/*    $('#dataTables').dataTable({
			      "sPaginationType" : "full_numbers",
			      "bProcessing" : false,
			      "bServerSide" : false,
			      "sAjaxSource" : "selectQNA",
			      "bJQueryUI" : true,
			      "aoColumns" : [ {
			         "mData" : "#"
			      }, {
			         "mData" : "분류"
			      }, {
			         "mData" : "질문"
			      }, {
			         "mData" : "답변"
			      } ]
			   }); */
		});
	</script>

</body>

</html>