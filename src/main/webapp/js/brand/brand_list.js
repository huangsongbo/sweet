jQuery(document).ready(function() {
	brandList();
})

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
						"<td>"+val.description+"</td><td><a href=\"#\">编辑</a></td></tr>");
			});
		}
	});
}