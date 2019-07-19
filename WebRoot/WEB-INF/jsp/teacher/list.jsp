<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>讲师展示页面</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/delete.js"></script>
<script type="text/javascript">
	$(function() {
		// 载入inc 页面 
		$(".admin_link_bar").load("/html/teacher/inc.html");
	});
</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar"></h3>
		<table width="100%" cellspacing="0" cellpadding="0" id="listTable">

			<thead>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>电话</td>
					<td>Email</td>
					<td>薪水</td>
					<td>入职时间</td>
					<td>部门类型</td>
					<td colspan="2">操作</td>
				</tr>
			</thead>
			<tbody>
				<tr th:each="teacher : ${teachers}" align="center">
					<td th:text="${teacher.id}"></td>
					<!-- 姓名可以点击,跳转到show页面,查看学生详细信息 -->
					<td><a class="list_link"
						th:href="@{/teacher/show(id=${teacher.id})}"
						th:text="${teacher.teacher_name}"></a></td>
					<td th:text="${teacher.sex}"></td>
					<td th:text="${teacher.phone}"></td>
                    <td th:text="${teacher.email}"></td>
					<td th:text="${teacher.salary}"></td>
					<td th:text="${teacher.come_time}"></td>
					<td th:text="${teacher.dept.type}"></td>
					<td colspan="2"><a class="list_op"
						th:href="@{/teacher/update(id=${teacher.id})}">编辑</a> <!-- 加上return false ;就会终止 a链接的默认跳转事件 -->
						<a id="delete" class="list_op delete"
						th:href="@{/teacher/delete(id=${teacher.id})}"
						onclick="deleteClick();return false;">删除</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
