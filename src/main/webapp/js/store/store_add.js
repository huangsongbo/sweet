jQuery(document).ready(function() {
	// 提交数据(保存)
	$("#store_add_form").validate({
		rules:{
			name:{required:true}
		},
		messages:{
			name:{required:"请输入门店名称"}
		},
		submitHandler: function (form) {
			saveStore();
        },
        errorPlacement: function(error, element) {
            error.appendTo(element.parent());  
        }
	});
})

/**
 * 保存品牌
 */
function saveStore(){
	$.ajax({
		type: "POST",
		datatype: "json",
		url: cPath+"/stores" ,
		data: $("#store_add_form").serialize(),
		timeout: 5000,
		async: false,
		error: function (res) {
			$.teninedialog({
                title:"系统提示",
                content:"保存失败"
            });
		},
		success: function (res) {
			tableList("store", "list");
			$("#store_add_model").modal("hide");
			$.teninedialog({
                title:"系统提示",
                content:"保存成功"
            });
			clearInfo();
		}
	});
}

/**
 * 清楚新增页面的信息
 */
function clearInfo(){
	$("#store_add_form_name").val("");
	$("#store_add_form_description").val("");
}