jQuery(document).ready(function() {
	brandList();
})

/**
 * 品牌列表
 */
function brandList(){
	$.ajax({
		type: "GET",
		datatype: "json",
		url:cPath+"/brands" ,
		data: "",
		timeout: 5000,
		async: false,
		error: function (request) {
			
		},
		success: function (res) {
			$("#tableList").html("");
			$.each(res,function(index,val){
				$("#tableList").append("<tr><td>"+(index+1)+"</td><td>"+val.name+"</td>" +
						"<td>"+val.description+"</td><td><a onclick=\"brandEdit("+val.id+")\">编辑</a>&nbsp;&nbsp;<a href=\"#\">删除</a></td></tr>");
			});
		}
	});
}

/**
 * 品牌编辑页面
 * @param id
 */
function brandEdit(id){
	$.ajax({
		type: "GET",
		datatype: "json",
		url:cPath+"/brands/"+id,
		timeout: 5000,
		async: false,
		error: function (request) {
			alert(request.responseText);
		},
		success: function (request) {
			$("#brand_edit_id").val(request.id);
			$("#brand_edit_name").val(request.name);
			$("#brand_edit_description").val(request.description);
			$("#brand_edit_model").modal("show");
		}
	});
}