<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!	DOCTYPE html>
<head>
<meta charset="UTF-8" />

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/top.css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function exitSystem() {
		window.parent.location.href = "/logout";
	}
</script>
</head>
<body>
	<div id="top">
		<div id="topIntro">
			<img id="img" alt="" src="<%=request.getContextPath() %>/resources/css/img/top_logo.png" width="400px" /> <span
				id="user_operator"> <a href="/" target="_blank">网站首页</a> | <a
				href="/user/showSelf" target="main">查询个人信息</a> | <a
				href="/user/updateSelf" target="main">修改个人信息</a> | <a
				href="/user/updatePwd" target="main">修改密码</a> | <a
				href="javascript:exitSystem()">退出登录</a>
			</span>
		</div>
		<div id="remind">
			<span id="showDate">欢迎进入学生后台管理程序</span>
		</div>
	</div>
</body>
</html>