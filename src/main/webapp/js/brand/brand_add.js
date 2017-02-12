jQuery(document).ready(function() {
	$("#brand_add_form").validate({
		rules:{
			name:{required:true}
		},
		messages:{
			name:{required:"请输入品牌名称"}
		},
		submitHandler: function (form) {
			/*alert("提交成功");*/
			saveBrand();
        },
        errorPlacement: function(error, element) {
            error.appendTo(element.parent());  
        }
	});
})

/**
 * 保存品牌
 */
function saveBrand(){
	$.ajax({
		type: "POST",
		datatype: "json",
		url: cPath+"/brands" ,
		data: $("#brand_add_form").serialize(),
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
			/*alert("保存成功");*/
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
	$("#brand_add_form_name").val("");
	$("#brand_add_form_description").val("");
}