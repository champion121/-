(function($) {

	$.fn.MyBlur = function(event) {
		$("input[vblur='true']")
				.blur(
						function(event) {
							var vnotnull = $(this).attr("vnotnull");
							if (vnotnull === "true") {
								var value = this.value;
								if (value.trim() === "") {
									$(this).css("border", "1px solid red");
									var vnotnullText = $(this).attr(
											"vnotnullText") ? $(this).attr(
											"vnotnullText") : "不能为空";
									$(this).nextAll("span").css("color", "red")
											.css("margin-left", "5px").html(
													vnotnullText);
									return;
								} else {
									$(this).css("border", "");
									$(this).nextAll("span").html("");
								}
							}

							var vphone = $(this).attr("vphone");
							if (vphone === "true") {
								var value = this.value;
								var reg = /^1[3578]\d{9}$/;
								if (!reg.test(value.trim())) {
									$(this).css("border", "1px solid red");
									var vphoneText = $(this).attr("vphoneText") ? $(
											this).attr("vphoneText")
											: "请输入11位电话";
									$(this).nextAll("span").css("color", "red")
											.css("margin-left", "5px").html(
													vphoneText);
									return;
								} else {
									$(this).css("border", "");
									$(this).nextAll("span").html("");
								}
							}

							var vemail = $(this).attr("vemail");
							if (vemail === "true") {
								var value = this.value;
								var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
								if (!reg.test(value.trim())) {
									$(this).css("border", "1px solid red");
									var vemailText = $(this).attr("vemailText") ? $(
											this).attr("vemailText")
											: "邮箱格式不正确";
									$(this).nextAll("span").css("color", "red")
											.css("margin-left", "5px").html(
													vemailText);
									return;
								} else {
									$(this).css("border", "");
									$(this).nextAll("span").html("");
								}
							}
						});
	}
	
	$.fn.MyVerify = function(){
		// 保存是否校验成功
		var isSuccess = true;
		// 获取所有需要校验的输入框对象
		var vs = $("input[vnotnull='true'],input[vphone='true'],input[vemail='true']");
		vs.each(function(){
			var vnotnull = $(this).attr("vnotnull");
			if (vnotnull === "true") {
				var value = this.value;
				if (value.trim() === "") {
					$(this).css("border", "1px solid red");
					var vnotnullText = $(this).attr(
							"vnotnullText") ? $(this).attr(
							"vnotnullText") : "不能为空";
					$(this).nextAll("span").css("color", "red")
							.css("margin-left", "5px").html(
									vnotnullText);
					isSuccess = false;
					return;
				} else {
					$(this).css("border", "");
					$(this).nextAll("span").html("");
				}
			}
			
			
			var vphone = $(this).attr("vphone");
			if (vphone === "true") {
				var value = this.value;
				var reg = /^1[3578]\d{9}$/;
				if (!reg.test(value.trim())) {
					$(this).css("border", "1px solid red");
					var vphoneText = $(this).attr("vphoneText") ? $(
							this).attr("vphoneText")
							: "请输入11位电话";
					$(this).nextAll("span").css("color", "red")
							.css("margin-left", "5px").html(
									vphoneText);
					isSuccess = false;
					return;
				} else {
					$(this).css("border", "");
					$(this).nextAll("span").html("");
				}
			}
			
			
			var vemail = $(this).attr("vemail");
			if (vemail === "true") {
				var value = this.value;
				var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				if (!reg.test(value.trim())) {
					$(this).css("border", "1px solid red");
					var vemailText = $(this).attr("vemailText") ? $(
							this).attr("vemailText")
							: "邮箱格式不正确";
					$(this).nextAll("span").css("color", "red")
							.css("margin-left", "5px").html(
									vemailText);
					isSuccess = false;
					return;
				} else {
					$(this).css("border", "");
					$(this).nextAll("span").html("");
				}
			}
		});
		return isSuccess;
	}

})(jQuery)