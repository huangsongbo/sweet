jQuery(document).ready(function() {
	productList();
})

function productList(){
	$.ajax({
		type: "GET",
		datatype: "json",
		url:cPath+"/products" ,
		data: "",
		timeout: 5000,
		async: false,
		error: function (request) {
			
		},
		success: function (res) {
			$("#tableList").html("");
			$.each(res,function(index,val){
				$("#tableList").append("<tr><td>"+(index+1)+"</td><td>"+val.name+"</td>" +
						"<td>"+val.brand.name+"</td>" +
						"<td>"+val.hkd+"</td><td>"+val.description+"</td><td><a href=\"#\">编辑</a></td></tr>");
			});
		}
	});
}