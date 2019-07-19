<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>学生信息页面</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".admin_link_bar").load("/html/student/inc.html");
	});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar"></h3>
		<table width="100%" cellspacing="0" cellPadding="0" id="listTable">
			<thead>
				<tr>
					<td class="title" colspan="2">学生信息</td>
				</tr>
			</thead>

			<tr>
				<td class="rightTd">姓名:</td>
				<td class="leftTd" th:text="${studentDto.stu_name}"></td>
			</tr>
			<tr>
				<td class="rightTd">性别:</td>
				<td class="leftTd" th:text="${studentDto.sex}"></td>

			</tr>
			<tr>
				<td class="rightTd">电话:</td>
				<td class="leftTd" th:text="${studentDto.phone}"></td>

			</tr>
			<tr>
				<td class="rightTd">Email:</td>
				<td class="leftTd" th:text="${studentDto.email}"></td>

			</tr>
			<tr>
				<td class="rightTd">QQ:</td>
				<td class="leftTd" th:text="${studentDto.qq}"></td>

			</tr>
			<tr>
				<td class="rightTd">年级:</td>
				<td class="leftTd" th:text="${studentDto.grades}"></td>
			</tr>
			<tr>
				<td class="rightTd">专业:</td>
				<td class="leftTd" th:text="${studentDto.major}"></td>


			</tr>
			<tr>
				<td class="rightTd">学校:</td>
				<td class="leftTd" th:text="${studentDto.school}"></td>

			</tr>
			<tr>
				<td class="rightTd">入学时间:</td>
				<td class="leftTd" th:text="${studentDto.come_time}"></td>

			</tr>
			<tr>
				<td class="rightTd">班级:</td>
				<td class="leftTd"><a class="list_op"
					th:href="@{/classes/show(id=${studentDto.classes_id})}"
					th:text="${studentDto.classes_name}"></a></td>

			</tr>
			<tr>
				<td class="rightTd">老师:</td>
				<td class="leftTd"><a class="list_op"
					th:href="@{/teacher/show(id=${studentDto.teacher_id})}"
					th:text="${studentDto.teacher_name}"></a></td>

			</tr>
			<tr>
				<td class="centerTd" colspan="2"><a class="list_op"
					th:href="@{/student/update(id=${studentDto.id})}">编辑当前学生</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
