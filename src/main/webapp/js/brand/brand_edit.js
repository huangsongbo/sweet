jQuery(document).ready(function() {
	$("#brand_edit_form").validate({
		rules:{
			name:{required:true}
		},
		messages:{
			name:{required:"请输入品牌名称"}
		},
		submitHandler: function (form) {
			//alert("提交成功");
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
		type: "PUT",
		datatype: "json",
		url: cPath+"/brands" ,
		data: $("#brand_edit_form").serialize(),
		timeout: 5000,
		async: false,
		error: function (res) {
			alert("保存失败");
		},
		success: function (res) {
			alert("保存成功");
			brandList();
			$("#brand_edit_model").modal("hide");
		}
	});
}