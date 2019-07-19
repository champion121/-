<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<title>部门信息页面</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/common.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		//$(".admin_link_bar").load("/html/dept/inc.html");
	});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar"><jsp:include page="inc.jsp" /></h3>
		<table width="100%" cellspacing="0" cellPadding="0" id="listTable">
			<thead>
				<tr>
					<td class="title" colspan="2">部门信息</td>
				</tr>
			</thead>
			<input type="hidden" name="id" th:value="*{id}" />
			<tr>
				<td class="rightTd">部门类型:</td>
				<td class="leftTd" th:text="${dept.type}"></td>
			</tr>
			<tr>
				<td class="rightTd">创建时间:</td>
				<td class="leftTd" th:text="${dept.come_time}"></td>
			</tr>

			<tr>
				<td class="rightTd">部门成员:</td>
				<td class="leftTd"><a class="list_op"
					each="teacher"
					href="show?id=${teacher.id}"
					text="${teacher.teacher_name}"></a></td>
			</tr>
			<tr>
				<td class="centerTd" colspan="2"><a class="list_op"
					href="update?id=${dept.id}">编辑当前部门</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
