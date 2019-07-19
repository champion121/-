<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<title>班级添加页面</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/common.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.7.2.min.js"></script>
<!-- 点击输入框显示日历表的包 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/jedate/jedate.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jedate/jedate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/date.js"></script>

<!-- 校验 -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/verify.js"></script>

<script type="text/javascript">
	$(function() {
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
		<table width="100%" cellspacing="0" cellpadding="0" id="listTable">
			<form id="form" method="post">
			<thead>
				<tr>
					<td class="title" colspan="2">添加班级</td>
				</tr>
			</thead>
			<tr>
				<td class="rightTd"><label for="className">班级名称:</label></td>
				<td><input class="leftTd" type="text" name="className"
					id="className" placeholder="请输入班级名称" vblur="true" vnotnull="true"
					vnotnullText="* 班级名称不能为空" /><span></span></td>
			</tr>
			<tr>
				<td class="rightTd"><label for="createDate">开班时间:</label></td>
				<td class="leftTd"><input type="datetime" readonly="readonly"
					name="come_time" id="createDate" placeholder="请输入开班时间"
					vnotnull="true" vnotnullText="* 请选择开班时间" /><span></span></td>
			</tr>
			<tr>
				<td class="centerTd" colspan="2" width="200px"><input
					id="submitBtn" type="button" value="添加班级" /> <input type="reset"
					value="重置" /></td>
			</tr>
			</form>
		</table>
	</div>
</body>
</html>
