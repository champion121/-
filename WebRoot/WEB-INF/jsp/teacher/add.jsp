<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>讲师添加页面</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>

<!-- 日历时间插件 -->
<script type="text/javascript" src="/js/jedate/jedate.js"></script>
<script type="text/javascript" src="/js/date.js"></script>
<link rel="stylesheet" type="text/css" href="/js/jedate/jedate.css" />
<!-- ztree -->
<script type="text/javascript" src="/js/ztree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/js/ztree/tledu.ztree.js"></script>
<link rel="stylesheet" type="text/css" href="/js/ztree/zTreeStyle.css" />
<!-- 校验 -->
<script type="text/javascript" src="/js/verify.js"></script>
<script type="text/javascript">
	$(function() {
		$(".admin_link_bar").load("/html/teacher/inc.html");
		mydate("#createDate");

		$.fn.mytree({
			inputId : "#dept_id",
			inputName : "#dept_type",
			divId : "#menuContentDept",
			zreeId : "#treeDemoDept",
			url:"treeDept"
		});
		
		$.fn.MyBlur();
		$("#submitBtn").click(function(){
				if($.fn.MyVerify()){
					$("#form").submit();
				}
		});
	});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar"></h3>
		<table width="100%" cellspacing="0" cellpadding="0" id="listTable">
			<thead>
				<tr>
					<td class="title" colspan="2">添加讲师</td>
				</tr>
			</thead>
			<form th:action="@{/teacher/add}" th:object="${teacherDto}"
				method="post" id="form">
				<tr>
					<td class="rightTd"><label for="teacher_name">姓名:</label></td>
					<td class="leftTd"><input id="teacher_name" type="text"
						name="teacher_name" placeholder="请输入讲师名称" vblur="true" vnotnull="true"  vnotnullText="* 讲师姓名不能为空" /><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="sex">性别:</label></td>
					<td class="leftTd"><input type="radio" name="sex" value="男"  checked="checked" />男<input
						type="radio" name="sex" value="女" />女</td>
				</tr>
				<tr>
					<td class="rightTd"><label for="phone">电话:</label></td>
					<td class="leftTd"><input id="phone" type="text" name="phone"
						placeholder="请输入联系电话"   vblur="true" vphone="true" vphoneText="* 请输入正确的电话号码" vnotnull="true" vnotnullText="* 电话号码不能为空" /><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="email">Email:</label></td>
					<td class="leftTd"><input id="email" type="text" name="email"
						placeholder="请输入电子邮箱" vblur="true"  vemail="true"  vemailText="* 请输入正确的邮箱"  vnotnull="true" vnotnullText="* 邮箱不能为空"  /><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="salary">薪水:</label></td>
					<td class="leftTd"><input id="salary" type="text"
						name="salary" placeholder="请输入薪水" vblur="true" vnotnull="true"  vnotnullText="* 薪水不能为空" /><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="dept_type">所属部门:</label></td>
					<td class="leftTd"><input id="dept_type" type="text"
						readonly="readonly"  placeholder="请选择部门"  vnotnull="true"  vnotnullText="* 请选择部门" /><input type="hidden"  id="dept_id" name="dept_id" /><span></span></td>
							<div id="menuContentDept" class="menuContent"
						style="display: none; position: absolute; background: #eee; z-index: 999; border: 1px solid #eee; border-radius: 5px;">
						<ul id="treeDemoDept" class="ztree"
							style="margin-top: 0; width: 160px;"></ul>
					</div>
				</tr>
				<tr>
					<td class="rightTd"><label for="createDate">入职时间:</label></td>
					<td class="leftTd"><input type="text" id="createDate"
						readonly="readonly" name="come_time" placeholder="请输入入职时间"   vnotnull="true"  vnotnullText="* 请选择入职时间"  /><span></span></td>
				
				</tr>
				<tr>
					<td class="centerTd" colspan="2" width="200px"><input
						type="button"  id="submitBtn" value="添加讲师" /> <input type="reset" value="重置" /></td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>
