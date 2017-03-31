jQuery(document).ready(function() {
	// 下拉品牌
	brandSelect(null, "product_add_form_brand_select");
	// 提交数据(保存)
	$("#product_add_form").validate({
		rules:{
			name:{required:true}
		},
		messages:{
			name:{required:"请输入商品名称"}
		},
		submitHandler: function (form) {
			saveProduct();
        },
        errorPlacement: function(error, element) {
            error.appendTo(element.parent());  
        }
	});
})

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
			$("#product_add_model").modal("hide");
			tableList("productStore", "list");
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
	$("#product_add_form_brand_select").val("-1");
}