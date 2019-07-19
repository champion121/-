<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<title>部门更新页面</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/common.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/jedate/jedate.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jedate/jedate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/date.js"></script>

<!-- 校验 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/verify.js"></script>
<script type="text/javascript">
	$(function() {
		//$(".admin_link_bar").load("/html/dept/inc.html");
		mydate("#createDate");

		// 校验
		$.fn.MyBlur();
		$("#submitBtn").click(function() {
			if ($.fn.MyVerify()) {
				$("#form").submit();
			}
		});
	});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar"><jsp:include page="inc.jsp" /></h3>
		<table width="100%" cellspacing="0" cellPadding="0" id="listTable">
			<thead>
				<tr>
					<td class="title" colspan="2">更新部门</td>
				</tr>
			</thead>
			<form action="update" object="dept" method="post"
				id="form">
				<input type="hidden" name="id" th:value="*{id}" />
				<tr>
					<td class="rightTd"><label for="type">部门类型:</label></td>
					<td class="leftTd"><input id="type" type="text" name="type"
						th:value="*{type}" placeholder="请输入部门名称" vblur="true" vnotnull="true" vnotnullText="* 部门类型不能为空"  /><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="createDate">创建时间:</label></td>
					<td class="leftTd"><input id="createDate" type="text"
						readonly="readonly" name="come_time" value="come_time"
						placeholder="请输入创建时间"  vnotnull="true"  vnotnullText="* 请选择创建时间"  /><span></span></td>
				</tr>
				<tr>
					<td class="centerTd" colspan="2" width="200px"><input
						id="submitBtn" type="button" value="更新部门" /> <input type="reset"
						value="重置" /></td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>
