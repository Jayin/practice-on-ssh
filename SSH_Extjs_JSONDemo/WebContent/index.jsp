<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String extPath = request.getContextPath();
String extBasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+extPath+"/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title id="page-title">Extjs MVC Demo</title>

	<link rel="stylesheet" type="text/css" href="resources/css/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="system/system-icon.css" />
	<script type="text/javascript">
	//域路径
	var extPath = '<%=extPath%>';
	//域名访问路径
	var extBasePath = '<%=extBasePath%>';
	</script>

    <script type="text/javascript" src="js/ext-all.js"></script>
    <script type="text/javascript" src="js/locale/ext-lang-zh_CN.js"></script>
    <script type="text/javascript" src="system/app.js"></script>

</head>
<body>

</body>
</html>
