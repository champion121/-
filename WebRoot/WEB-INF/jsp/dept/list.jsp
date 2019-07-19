<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<title>部门展示页面</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/common.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/delete.js"></script>
<script type="text/javascript">
	$(function() {
		// 载入inc 页面 
		//$(".admin_link_bar").load("/html/dept/inc.html");
});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar"><jsp:include page="inc.jsp" /></h3>
		<table width="100%" cellspacing="0" cellpadding="0" id="listTable">

			<thead>
				<tr>
					<td>编号</td>
					<td>部门类型</td>
					<td>创建时间</td>
					<td colspan="2">操作</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${depts}" var="dept">
				<tr align="center">
					<td>${dept.id}</td>
					<td><a class="list_link"
						href="show?id=${dept.id}" >${dept.type}</a></td>
					<td ><fmt:formatDate value="${dept.come_time}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td colspan="2"><a class="list_op"
						href="update?d=${dept.id}">编辑</a> <a id="delete"
						class="list_op delete" href="delete?id=${dept.id})}"
						onclick="deleteClick();return false;">删除</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
