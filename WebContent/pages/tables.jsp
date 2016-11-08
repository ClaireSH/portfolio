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

<script>
function sendRow(index,qna,answer) {
	$('#Myquestion').val(qna);
	var ms = $('#Myquestion2').val(answer);
	console.log(ms);
	
}
</script>

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
				<div class="col-lg-6">
					<div class="panel panel-green">
						<div class="panel-heading">최근 질문과 답변</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<form action="updateAnswer" method="get">

									<table  class="table table-striped table-hover">
										<thead>
											<tr>
												<th>#</th>
												<th>유형</th>
												<th>질문</th>
												<th>답변</th>
											</tr>
										</thead>
										<tbody>

											<s:iterator value="qnaList" var="qna" status="incre" begin="0" end="">

												<input type="hidden" name="qnaList[${incre.index}].questionId" value="${questionId}" />
												<input type="hidden" name="qnaList[${incre.index}].questionType" value="${questionType}" />
												<input type="hidden" name="qnaList[${incre.index}].question" value="${question}" />

												<tr>
													<td>${questionId}</td>
													<td>${questionType}</td>
													<td>${question}</td>
													<td>
													<a href="#" class="btn btn-info" onclick="javascript:sendRow('${questionId}','${question}','${answer}');">수정</a></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
									<div style="text-align: center;">
										<input type="submit" id="btn_edit" class="btn btn-danger" value="수정" /> <input type="button" id="btn_reset" class="btn btn-warning" value="초기화">
									</div>
								</form>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<div class="col-lg-6">

					<div class="panel panel-green">
						<div class="panel-heading">
							<i class="fa fa-clock-o fa-fw"></i> 답변편집
						</div>
						<div class="panel-body">
							<div style="overflow: hidden; margin: 10px 0;">
								<input type="text" class="form-control" id="Myquestion" disabled="disabled" placeholder="수정할 답변을 클릭하세요" style="width: 100%; float: left;">
							</div>
							<!-- 글내용 -->
							<p>
							<div class="wrap" style="margin: 10px 0;">
								<textarea id="Myquestion2" name="textarea" class="form-control" rows="19"></textarea>
							</div>
							</p>


							<div style="text-align: center; margin: 10px 0;">
								<button type="button" class="btn  btn-warning" onclick="javascript:submitsheet();">시트저장</button>
								<a class="btn  btn-success" href="#writepage">새글쓰기</a>
							</div>
						</div>

					</div>
					<!--섹션.끝-->

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