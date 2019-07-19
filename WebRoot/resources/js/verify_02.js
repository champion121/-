(function($) {

	$.fn.MyBlurNotNull = function(options){
		var settings = $.extend({
			inputId:"#className",
			error:"* 班级名字不能为空"
			
		} , options || {});
		
		$(settings.inputId).blur(function(){
			var value = this.value;
				if (value.trim() === "") {
					$(this).css("border", "1px solid red");
					$(this).nextAll("span").css("color", "red").css(
							"margin-left", "5px").html(settings.error);
				} else {
					$(this).css("border", "");
					$(this).nextAll("span").html("");
				}
		});
	}
	
	$.fn.MyVerifyNotNull = function(options){
			options = options ? options : [];
			var isSuccess = true;
			for(var i = 0 ; i < options.length;i++){
				var inputObj = $(options[i].inputId);
				var value = inputObj.val();
				if(value.trim() === ""){
					$(inputObj).css("border", "1px solid red");
					$(inputObj).nextAll("span").css("color", "red").css(
							"margin-left", "5px").html(options[i].error);
					isSuccess = false;
				}else {
					$(inputObj).css("border", "");
					$(inputObj).nextAll("span").html("");
				}
			}
			return isSuccess;
	}
})(jQuery)