jQuery(document).ready(function() {
	productList();
})

function productList(){
	$.ajax({
		type: "GET",
		datatype: "json",
		url:cPath+"/products" ,
		data: "",
		timeout: 5000,
		async: false,
		error: function (request) {
			
		},
		success: function (res) {
			$("#tableList").html("");
			$.each(res,function(index,val){
				$("#tableList").append("<tr><td>"+(index+1)+"</td><td>"+val.name+"</td>" +
						"<td>"+val.brand.name+"</td>" +
						"<td>"+val.hkd+"</td><td>"+val.description+"</td><td><a onclick=\"productEdit("+val.id+")\">编辑</a></td></tr>");
			});
		}
	});
}

/**
 * 打开编辑产品页面
 * @param id
 */
function productEdit(id){
	$.ajax({
		type: "GET",
		datatype: "json",
		url:cPath+"/products/"+id,
		timeout: 5000,
		async: false,
		error: function (request) {
			alert(request.responseText);
		},
		success: function (request) {
			console.log(request);
			$("#product_edit_id").val(request.id);
			$("#product_edit_name").val(request.name);
			$("#product_eidt_hkd").val(request.hkd);
			$("#product_eidt_description").val(request.description);
			$("#product_edit_form_brand_select").val(request.brand.id);
			$("#product_edit_model").modal("show");
		}
	});
}

/**
 * 下拉品牌
 * @param value 默认选项
 * @param selectId selectId
 */
function brandSelect(value, selectId){
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
			htmlStr += "<option value=\"\">未选择</option>";
			for (var index = 0; index < res.length; index++) {
				var item = res[index];
				if(value != null && value == item.id){
					htmlStr += "<option value = \""+item.id+"\" selected = \"selected\">"+item.name+"</option>";
				}else{
					htmlStr += "<option value=\""+item.id+"\">"+item.name+"</option>";
				}
			}
			/*console.log(htmlStr);*/
			/*$("#product_add_form_brand_select").html(htmlStr);*/
			$("#"+selectId).html(htmlStr);
		}
	});
}