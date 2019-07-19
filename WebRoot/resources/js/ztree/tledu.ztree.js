(function($) {

	$.fn.mytree = function(options) {
		var settings = $.extend({
			inputId : "#citySel",
			inputName : "#citySel",
			divId : "#menuContent",
			zreeId : "#treeDemo",
			url : "treeDept",
			setting : {
				view : {
					// 双击是否打开文件夹
					dblClickExpand : true,
					// 是否选择多个
					selectedMulti : false
				},
				data : {
					// 简单数据模式
					simpleData : {
						enable : true,
						idKey : "id",
						pIdKey : "pid",
						rootPId : -1
					}
				},
				callback : {
					// 点击元素之前触发的事件
					// 如果该方法返回false,就不会再去执行onClick事件
					beforeClick : beforeClick,
					onClick : onClick
				}
			}
		}, options || {});

		// 点击ztree节点之前触发,如果返回false,onClick事件就不再执行
		function beforeClick(treeId, treeNode) {
			var check = (treeNode && !treeNode.isParent);
			if (!check) {
				return check;
			}
		}
		// 点击ztree节点的时候,并且beforeClick方法返回为true的时候触发
		function onClick(e, treeId, treeNode) {
			$(settings.inputName).val(treeNode.name);
			$(settings.inputId).val(treeNode.id);
			hideMenu();
		}
		// 显示ztree
		function showMenu() {
			var cityObj = $(settings.inputName);
			// 获取元素到文档的距离
			var cityOffset = $(settings.inputName).offset();
			// 设置显示ztree数据的位置
			$(settings.divId).css(
					{
						left : cityOffset.left + cityObj.width() + "px",
						top : cityOffset.top + cityObj.height()
								- ($(settings.divId).height() / 2) + "px"
					}).slideDown("fast");

		}
		// 隐藏ztree
		function hideMenu() {
			$(settings.divId).fadeOut("fast");
		}

		/**
		 * 点击ztree展示内容以外的区域的时候 隐藏ztree
		 */
		$(document).click(function(event) {
			// 获取输入框对象和ztree显示框对象
			var con = $(settings.inputName + "," + settings.zreeId);
			// 第一个 判断点击的不是这两个对象中的任意一个
			// 丢二个 判断点击的不是ztree内容中的任意一个
			if (!con.is(event.target) && con.has(event.target).length === 0) {
				hideMenu();
			}
		});
		/**
		 * 对输入框绑定获得焦点事件,获得焦点就显示ztree内容
		 */
		$(settings.inputName).focus(showMenu);

		/**
		 * ajax请求
		 */
		$.ajax({
			url:settings.url,
			success:function(data){
				$.fn.zTree.init($(settings.zreeId), settings.setting, data);
				
			},
			error:function(){
				alert("加载失败")
			}
		});
	}

})(jQuery);