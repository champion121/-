function mydate(id) {
	jeDate(id, {
		// 背景颜色 , PnColo 当前页面中上个月和下个月的字体颜色
		theme : {
			bgcolor : "#00A1CB",
			pnColor : "#00CCFF"
		},
		// 是否显示农历和节假日
		festival : true,
		minDate : "1900-01-01", // 最小日期
		maxDate : "2099-12-31", // 最大日期
		format : "YYYY-MM-DD hh:mm:ss"
	});
}