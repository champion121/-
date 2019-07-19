<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!	DOCTYPE html>
<head>
<meta charset="UTF-8" />

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/menu.css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".navTitle").click(function() {
			$(this).parent("ul").toggleClass("navSelected");
			$(this).next("li").toggle(500);
			// 			$(this).next("li").slideToggle(500);
			// 			$(this).next("li").fadeToggle(500);
		});
	});
</script>
</head>
<body>
	<div id="left">
		<ul class="navMenu">
			<h3 class="navTitle">
				<span class="navTilteTxt">班级管理</span>
			</h3>
			<li class="navChild"><a href="<%=request.getContextPath() %>/classes/list" target="main">班级信息管理</a></li>
		</ul>
		<ul class="navMenu">
			<h3 class="navTitle">
				<span class="navTilteTxt">部门管理</span>
			</h3>
			<li class="navChild"><a href="<%=request.getContextPath() %>/dept/list" target="main">部门信息管理</a></li>
		</ul>
		<ul class="navMenu">
			<h3 class="navTitle">
				<span class="navTilteTxt">讲师管理</span>
			</h3>
			<li class="navChild"><a href="<%=request.getContextPath() %>/teacher/list" target="main">讲师信息管理</a></li>
		</ul>
		<ul class="navMenu">
			<h3 class="navTitle">
				<span class="navTilteTxt">学生管理</span>
			</h3>
			<li class="navChild"><a href="<%=request.getContextPath() %>/student/list" target="main">学生信息管理</a></li>
		</ul>

	</div>
</body>
</html>