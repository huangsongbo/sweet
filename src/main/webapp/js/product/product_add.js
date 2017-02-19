jQuery(document).ready(function() {
	// 下拉品牌
	brandList();
	// 提交数据(保存)
	$("#product_add_form").validate({
		rules:{
			name:{required:true}
		},
		messages:{
			name:{required:"请输入商品名称"}
		},
		submitHandler: function (form) {
			/*alert("提交成功");*/
			saveProduct();
        },
        errorPlacement: function(error, element) {
            error.appendTo(element.parent());  
        }
	});
})

/**
 * 下拉品牌
 */
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
			htmlStr += "<option value=\"\">未选择</option>";
			for (var index = 0; index < res.length; index++) {
				var item = res[index];
				htmlStr += "<option value=\""+item.id+"\">"+item.name+"</option>";
			}
			console.log(htmlStr);
			$("#AddPageBrandSelect").html(htmlStr);
		}
	});
}

/**
 * 保存品牌
 */
function saveProduct(){
	$.ajax({
		type: "POST",
		datatype: "json",
		url: cPath+"/products" ,
		data: $("#product_add_form").serialize(),
		timeout: 5000,
		async: false,
		error: function (res) {
			/*alert("保存失败");*/
			$.teninedialog({
                title:"系统提示",
                content:"保存失败"
            });
		},
		success: function (res) {
			$.teninedialog({
                title:"系统提示",
                content:"保存成功"
            });
			$("#brand_add_model").modal("hide");
			brandList();
			clearInfo();
		}
	});
}

/**
 * 清楚新增页面的信息
 */
function clearInfo(){
	$("#product_add_form_name").val("");
	$("#product_add_form_hkd").val("");
	$("#product_add_form_description").val("");
}