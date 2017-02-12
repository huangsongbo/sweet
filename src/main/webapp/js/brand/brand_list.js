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
						"<td>"+val.description+"</td>" +
								"<td><a onclick=\"brandEdit("+val.id+")\">编辑</a>&nbsp;&nbsp;<a onclick=\"deleteBrandByIdCheck("+val.id+")\">删除</a></td></tr>");
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

/**
 * 删除品牌(点击)
 * @param id
 */
function deleteBrandById(id){
	$.ajax({
		type: "DELETE",
		datatype: "json",
		url:cPath+"/brands/"+id,
		timeout: 5000,
		async: false,
		error: function (request) {
			/*alert(request.responseText);*/
			$.teninedialog({
                title:"系统提示",
                content:request.responseText
            });
		},
		success: function (request) {
			$.teninedialog({
                title:"系统提示",
                content:"删除成功"
            });
			brandList();
		}
	});
}

function deleteBrandByIdCheck(id){
	$.teninedialog({
        title:"系统提示",
        content:"是否删除该条记录?",
        showCloseButton:false,
        otherButtons:["确定","取消"],
        clickButton:function(sender,modal,index){
        	$(this).closeDialog(modal);
            if(index == 0){
            	//确定
            	deleteBrandById(id);
            }else if(index == 1){
            	//取消
            	
            }
        }
    });
}