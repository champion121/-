<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>讲师信息页面</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".admin_link_bar").load("/html/teacher/inc.html");
	});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar"></h3>
		<table width="100%" cellspacing="0" cellPadding="0" id="listTable">
			<thead>
				<tr>
					<td class="title" colspan="2">讲师信息</td>
				</tr>
			</thead>

			<tr>
				<td class="rightTd">姓名:</td>
				<td class="leftTd" th:text="${teacherDto.teacher_name}"></td>
			</tr>
			<tr>
				<td class="rightTd">性别:</td>
				<td class="leftTd" th:text="${teacherDto.sex}"></td>

			</tr>
			<tr>
				<td class="rightTd">电话:</td>
				<td class="leftTd" th:text="${teacherDto.phone}"></td>

			</tr>
			<tr>
				<td class="rightTd">Email:</td>
				<td class="leftTd" th:text="${teacherDto.email}"></td>

			</tr>
			<tr>
				<td class="rightTd">薪水:</td>
				<td class="leftTd" th:text="${teacherDto.salary}"></td>

			</tr>
			<tr>
				<td class="rightTd">入职时间:</td>
				<td class="leftTd" th:text="${teacherDto.come_time}"></td>
			</tr>
			<tr>
				<td class="rightTd">所属部门:</td>
				<td class="leftTd"><a class="list_op"
					th:href="@{/dept/show(id=${teacherDto.dept_id})}"
					th:text="${teacherDto.dept_type}"></a></td>

			</tr>
			<tr>
				<td class="centerTd" colspan="2"><a class="list_op"
					th:href="@{/teacher/update(id=${teacherDto.id})}">编辑当前讲师</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
