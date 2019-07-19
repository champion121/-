<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>学生展示页面</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/delete.js"></script>
<script type="text/javascript">
	$(function() {
		// 载入inc 页面 
		$(".admin_link_bar").load("/html/student/inc.html");
		$("#classesId").change(changeT_C);
		$("#teacherId").change(changeT_C);
		$("#search").click(changeT_C);
		function changeT_C() {
			var searchTitle = $("#searchTitle").val();
			var teacherId = $("#teacherId").val();
			var classesId = $("#classesId").val();
			// 			alert(searchTitle+" : "+teacherId+" : "+classesId)
			if (searchTitle == null || searchTitle.trim() == "") {
				searchTitle = " ";
			}

			var urlPath = "/student/search/" + searchTitle + "/" + classesId
					+ "/" + teacherId;
			window.location = urlPath;
		}
	});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar"></h3>
		<table width="100%" cellspacing="0" cellpadding="0" id="listTable">

			<thead>
				<tr>
					<td colspan="14">搜索学生: <input type="text" name="searchTitle"
						size="30" id="searchTitle" th:value="${searchTitle}"
						placeholder="请输入学生姓名" /> <select name="classesId" id="classesId">
							<option value="0">选择班级</option>
							<option th:each="classes : ${classess}"  th:selected="${classes.id eq classesId}"
								th:text="${classes.className}" th:value="${classes.id}"></option>
					</select> <select name="teacherId" id="teacherId">
							<option value="0">选择讲师</option>
							<option th:each="teacher : ${teachers}" th:selected="${teacher.id eq teacherId}"
								th:text="${teacher.teacher_name}" th:value="${teacher.id}"></option>
					</select> <input type="button" id="search" value="搜索学生" />
					</td>

				</tr>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>电话</td>
					<td>Email</td>
					<td>QQ</td>
					<td>年级</td>
					<td>专业</td>
					<td>学校</td>
					<td>入学时间</td>
					<td>班级</td>
					<td>讲师</td>
					<td colspan="2">操作</td>
				</tr>
			</thead>
			<tbody>
				<tr th:each="student : ${students}" align="center">
					<td th:text="${student.id}"></td>
					<!-- 姓名可以点击,跳转到show页面,查看学生详细信息 -->
					<td><a class="list_link"
						th:href="@{/student/show(id=${student.id})}"
						th:text="${student.stu_name}"></a></td>
					<td th:text="${student.sex}"></td>
					<td th:text="${student.phone}"></td>
					<td th:text="${student.email}"></td>
					<td th:text="${student.qq}"></td>
					<td th:text="${student.grades}"></td>
					<td th:text="${student.major}"></td>
					<td th:text="${student.school}"></td>
					<td th:text="${student.come_time}"></td>
					<td th:text="${student.classes.className}"></td>
					<td th:text="${student.teacher.teacher_name}"></td>
					<td colspan="2"><a class="list_op"
						th:href="@{/student/update(id=${student.id})}">编辑</a> <!-- 加上return false ;就会终止 a链接的默认跳转事件 -->
						<a id="delete" class="list_op delete"
						th:href="@{/student/delete(id=${student.id})}"
						onclick="deleteClick();return false;">删除</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
