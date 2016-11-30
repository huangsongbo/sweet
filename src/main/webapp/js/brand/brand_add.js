jQuery(document).ready(function() {
	$("#brandForm").validate({
		rules:{
			name:{required:true}
		},
		messages:{
			name:{required:"请输入品牌名称"}
		},
		submitHandler: function (form) {
			//saveBrand();
			alert("提交成功");
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
		data: $("#brandForm").serialize(),
		timeout: 5000,
		async: false,
		error: function (res) {
			//alert(res);
		},
		success: function (res) {
			//alert("保存成功");
		}
	});
}