function tableList(type, listType){
	var url = "";
	if(type == "store"){
		url = cPath + "/jsp/store/jspList.htm"
	}else if(type == "productStore"){
		url = cPath + "/jsp/product/productStoreList.htm"
	}else{
		url=cPath+"/"+type+"Page";
	}
	$.ajax({
		type: "GET",
		datatype: "json",
		url:url ,
		data: "",
		timeout: 5000,
		async: false,
		error: function (request) {
			
		},
		success: function (res) {
			if("list" == listType){
				var startIndex = res.toString().indexOf("<tbody id=\"tableList\" >") + "<tbody id=\"tableList\" >".length;
				console.log("startIndex = " + startIndex);
				var endIndex = res.toString().lastIndexOf("</tbody>");
				console.log("endIndex = " + endIndex);
				console.log(res.toString().substring(startIndex, endIndex));
				$("#tableList").html(res.toString().substring(startIndex, endIndex));
			}else{
				$("#mainTable").html(res);
			}
		}
	});
}