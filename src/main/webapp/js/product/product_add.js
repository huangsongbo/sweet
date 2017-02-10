jQuery(document).ready(function() {
	brandList();
})

function brandList(){
	$.ajax({
		type: "GET",
		datatype: "json",
		url: cPath+"/brands" ,
		timeout: 5000,
		async: false,
		error: function (res) {
			$.teninedialog({
                title:"系统提示",
                content:"系统异常"
            });
		},
		success: function (res) {
			/*console.log(res);*/
			var htmlStr = "";
			for (var index = 0; index < res.length; index++) {
				var item = res[index];
				htmlStr += "<option value=\""+item.id+"\">"+item.name+"</option>";
			}
			console.log(htmlStr);
			$("#AddPageBrandSelect").html(htmlStr);
		}
	});
}