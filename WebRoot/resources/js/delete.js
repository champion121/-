	function deleteClick() {
		var c = confirm("删除之后不可恢复,确定要删除吗?");
		if (c) {
			document.getElementById("delete").href();
		}
	}