<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<title>班级展示页面</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/delete.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/common.css" />
<script type="text/javascript">
	$(function() {
		// 	$(".admin_link_bar").load("/html/classes/inc.html");
	});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar">
			<jsp:include page="inc.jsp" />
		</h3>
		<table cellpadding="0" cellspacing="0" width="100%" id="listTable">
			<thead>
				<tr>
					<td>编号</td>
					<td>班级名称</td>
					<td>开班时间</td>
					<td colspan="2">操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classess}" var="classes">

					<tr align="center">
						<td>${classes.id}</td>
						<td><a href="show?id=${classes.id}" class="list_link">${classes.className}</a></td>
						<td><fmt:formatDate value="${classes.come_time}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td colspan="2"><a href="update?id=${classes.id}"
							class="list_op">编辑</a> <a id="delete"
							href="delete?id=${classes.id}"
							onclick="deleteClick(); return false;" class="list_op delete">删除</a></td>
					</tr>

				</c:forEach>


			</tbody>
		</table>
	</div>
</body>
</html>