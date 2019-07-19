<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<title>欢迎访问学生管理系统</title>
</head>
<frameset rows="110,*" frameborder="0">
	<frame src="<%=request.getContextPath() %>/resources/html/admin/top.jsp" name="top" />
	<frameset cols="164,*">
		<frame src="<%=request.getContextPath() %>/resources/html/admin/menu.jsp" name="menu" />
		<frame src="<%=request.getContextPath() %>/resources/html/admin/main.jsp" name="main" />
	</frameset>
</frameset>
</html>