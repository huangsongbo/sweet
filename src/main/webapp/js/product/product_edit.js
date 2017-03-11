jQuery(document).ready(function() {
	// 下拉品牌
	brandSelect(null, "product_edit_form_brand_select");
	// 提交数据(保存)
	$("#product_edit_form").validate({
		rules:{
			name:{required:true}
		},
		messages:{
			name:{required:"请输入商品名称"}
		},
		submitHandler: function (form) {
			/*alert("提交成功");*/
			updateProduct();
        },
        errorPlacement: function(error, element) {
            error.appendTo(element.parent());  
        }
	});
})

/**
 * 更新产品
 */
function updateProduct(){
	$.ajax({
		type: "PUT",
		datatype: "json",
		url: cPath+"/products" ,
		data: $("#product_edit_form").serialize(),
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
			$("#product_edit_model").modal("hide");
			productList();
		}
	});
}

/**
 * 清楚新增页面的信息
 */
function clearInfo(){

}