/**
 *
 */

//load_essentials.js
document.write('<link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">');
document.write('<link href="../../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">');
document.write('<link href="../../dist/css/sb-admin-2.css" rel="stylesheet">');
document.write('<link href="../../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">');
document.write('<script type="text/javascript" src="../../include/js/w3data.js"></script>');
document.write('<script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>');

// 페이지별 헤드 & 네비게이터


// document.getElementById("myheader").innerHTML = code;
$(document).ready(function(){ $("#myheader").load("./../../include/navigator.html"); 	 });
