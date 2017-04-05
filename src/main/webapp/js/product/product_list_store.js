jQuery(document).ready(function() {
	/*productStoreList();*/
})

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
			htmlStr += "<option value=\"-1\">未选择</option>";
			for (var index = 0; index < res.length; index++) {
				var item = res[index];
				if(value != null && value == item.id){
					htmlStr += "<option value = \""+item.id+"\" selected = \"selected\">"+item.name+"</option>";
				}else{
					htmlStr += "<option value=\""+item.id+"\">"+item.name+"</option>";
				}
			}
			$("#"+selectId).html(htmlStr);
		}
	});
}

/**
 * 编辑产品在各门店的价格
 * @param productId
 */
function productStoreInfoEdit(productId){
	$.ajax({
		type: "GET",
		datatype: "json",
		url:cPath+"/jsp/product/productStoreInfoEdit?id="+productId,
		timeout: 5000,
		async: false,
		error: function (request) {
			alert(request.responseText);
		},
		success: function (request) {
			
		}
	});
}