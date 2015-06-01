<!DOCTYPE html>
<html lang="zh-CN" ng-app="codingolApp">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content=""> 

    <title>Dashboard Template for Bootstrap</title>
  
	<link rel="stylesheet" href="${ProjectPath}/resources/bootstrap-3.3.4/css/bootstrap.css">
	<link rel="stylesheet" href="${ProjectPath}/resources/bootstrap-3.3.4/css/bootstrap-theme.css">
	<link rel="stylesheet" href="${ProjectPath}/resources/common/common.css">
	
	<script src="${ProjectPath}/resources/jquery/jquery-1.11.2.min.js"></script>
	<script src="${ProjectPath}/resources/bootstrap-3.3.4/js/bootstrap.js"></script>
	<script src="${ProjectPath}/resources/jquery-validation/Validform_v5.3.2.js"></script>
	<script src="${ProjectPath}/resources/jquery-upload/vendor/jquery.ui.widget.js"></script>
	<script src="${ProjectPath}/resources/jquery-upload/jquery.iframe-transport.js"></script>
	<script src="${ProjectPath}/resources/jquery-upload/jquery.fileupload.js"></script>
	
	<SCRIPT type="text/javascript">var project = '${ProjectPath}';  
	var form ;
	$(function(){
		$('[codingform]').each(function(){
    		form = $(this).Validform();
    	});
	});
	function valid(){
    	return form.check();
    }
	</SCRIPT>
  </head>
<body>