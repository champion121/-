<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/error.css" />
<title>发生错误</title>
</head>
<body>
	<div id="error">
		<span>出现错误</span>
	</div>
	<div id="message">
		<span id="errorContainer">${exception.message }</span>
	</div>
	<div id="upPage">
		<a href="javascript:history.go(-1)">返回登录</a>
	</div>
</body>
</html>