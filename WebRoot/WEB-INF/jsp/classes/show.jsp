<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/common.css" />
<title>班级信息页面</title>
<script type="text/javascript">
	$(function() {
	});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar">
			<jsp:include page="inc.jsp" /></h3>
		<table cellpadding="0" cellspacing="0" width="100%" id="listTable">

			<thead>
				<tr>
					<td class="title" colspan="2">更新班级</td>
				</tr>
			</thead>
			<input type="hidden" value="${classes.id}" name="id" />
			<tr>
				<td class="rightTd">班级名称:</td>
				<td class="leftTd">${classes.className}</td>
			</tr>
			<tr>
				<td class="rightTd">开班时间:</td>
				<td class="leftTd"><fmt:formatDate value="${classes.come_time}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>

			</tr>
			<tr>
				<td class="rightTd">班级内学生:</td>
				<td class="leftTd"><c:forEach items="${students }"
						var="student">
						<a class="list_op"
							href="<%=request.getContextPath() %>/student/show?id=${student.id}">${student.stu_name}</a>
					</c:forEach></td>
			</tr>
			<tr>
				<td class="centerTd" colspan="2"><a class="list_op"
					href="update?id=${classes.id}">编辑当前班级</a></td>
			</tr>
		</table>
	</div>
</body>
</html>