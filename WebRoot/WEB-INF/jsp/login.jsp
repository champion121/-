<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<sf:form action="login" modelAttribute="user" method="post">
		用户名 : <input type="text" name="username" />
		<br>
		密码 : <input type="password" name="password" />
		<br>
		<input type="submit" />
	</sf:form>
	
</body>
</html>