<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>学生添加页面</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="/js/jedate/jedate.css" />
<script type="text/javascript" src="/js/jedate/jedate.js"></script>
<script type="text/javascript" src="/js/date.js"></script>
<!-- ztree包和样式 -->
<link rel="stylesheet" type="text/css" href="/js/ztree/zTreeStyle.css" />
<script type="text/javascript" src="/js/ztree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/js/ztree/tledu.ztree.js"></script>

<!-- 校验 -->
 <script type="text/javascript" src="/js/verify.js"></script>
<script type="text/javascript">
	$(function() {
		$(".admin_link_bar").load("/html/student/inc.html");
		mydate("#createDate");
		
		// 班级的ztree
		$.fn.mytree({
			inputName : "#classes_name",
			inputId : "#classes_id",
			url : "treeClasses",
			divId : "#menuContentClasses",
			zreeId : "#treeDemoClasses",
		});
		
		// 讲师的ztree
		$.fn.mytree({
			inputName : "#teacher_name",
			inputId : "#teacher_id",
			url : "treeTeacher",
			divId : "#menuContentTeacher",
			zreeId : "#treeDemoTeacher",
		});
		
		// 校验
		$.fn.MyBlur();
		$("#submitBtn").click(function() {
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
					<td class="title" colspan="2">添加学生</td>
				</tr>
			</thead>
			<form th:action="@{/student/add}" th:object="${studentDto}"
				method="post"  id="form">
				<tr>
					<td class="rightTd"><label for="stu_name">姓名:</label></td>
					<td class="leftTd"><input id="stu_name" type="text"
						name="stu_name" placeholder="请输入学生名称"  vblur="true" vnotnull="true" vnotnullText="* 学生姓名不能为空" /><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="sex">性别:</label></td>
					<td class="leftTd"><input type="radio" name="sex" value="男"  checked="checked"/>男<input
						type="radio" name="sex" value="女" />女</td>
				</tr>
				<tr>
					<td class="rightTd"><label for="phone">电话:</label></td>
					<td class="leftTd"><input id="phone" type="text" name="phone"
						placeholder="请输入联系电话" vblur="true" vnotnull="true" vnotnullText="* 电话不能为空" vphone="true"  vphoneText="* 请输入正确的电话号码"  /><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="email">Email:</label></td>
					<td class="leftTd"><input id="email" type="text" name="email"
						placeholder="请输入电子邮箱"  vblur="true" vnotnull="true" vnotnullText="* 邮箱不能为空" vemail="true" vemailText="* 邮箱格式不正确"  /><span></span> </td>
				</tr>
				<tr>
					<td class="rightTd"><label for="qq">QQ:</label></td>
					<td class="leftTd"><input id="qq" type="text" name="qq"
						placeholder="请输入QQ号码" vblur="true" vnotnull="true" vnotnullText="* QQ不能为空" /><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="grades">年级:</label></td>
					<td class="leftTd"><input id="grades" type="text"
						name="grades" placeholder="请输入年级"  vblur="true" vnotnull="true" vnotnullText="* 年级不能为空"/><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="major">专业:</label></td>
					<td class="leftTd"><input id="major" type="text" name="major"
						placeholder="请输入专业" vblur="true" vnotnull="true" vnotnullText="* 专业不能为空" /><span></span></td>
				</tr>
				<tr>
					<td class="rightTd"><label for="school">学校:</label></td>
					<td class="leftTd"><input id="school" type="text"
						name="school" placeholder="请输入学校" vblur="true" vnotnull="true" vnotnullText="* 学校不能为空" /><span></span></td>
				</tr>
				<!-- 班级和老师 我们先自己输入ID,以后再优化 -->
				<tr>
					<td class="rightTd"><label for="classes_name">所在班级:</label></td>
					<td class="leftTd"><input id="classes_name" type="text" readonly="readonly" 
						placeholder="请选择班级" vnotnull="true" vnotnullText="* 请选择班级"  />
					<input type="hidden" id="classes_id" name="classes_id"   /><span></span></td>
					<div id="menuContentClasses"
						style="display: none; border-radius: 5px; position: absolute; background: #eee; z-index: 999; border: 1px solid #999">
						<ul id="treeDemoClasses" class="ztree"
							style="margin-top: 0; width: 160px;"></ul>
					</div>
				</tr>
				<tr>
					<td class="rightTd"><label for="teacher_name">任课老师:</label></td>
					<td class="leftTd"><input id="teacher_name" type="text" readonly="readonly" 
						name="teacher_name" placeholder="请选择老师"  vnotnull="true" vnotnullText="* 请选择讲师" />
					<input type="hidden" id="teacher_id" name="teacher_id"   /><span></span></td>
					<div id="menuContentTeacher"
						style="display: none; border-radius: 5px; position: absolute; background: #eee; z-index: 999; border: 1px solid #999">
						<ul id="treeDemoTeacher" class="ztree"
							style="margin-top: 0; width: 160px;"></ul>
					</div>
				</tr>
				<tr>
					<td class="rightTd"><label for="createDate">入学时间:</label></td>
					<td class="leftTd"><input type="text" readonly="readonly"
						name="come_time" id="createDate" placeholder="请输入入学时间" vnotnull="true"  vnotnullText="* 请选择入学时间"  /><span></span></td>
				</tr>
				<tr>
					<td class="centerTd" colspan="2" width="200px"><input id ="submitBtn"
						type="button" value="添加学生" /> <input type="reset" value="重置" /></td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>
