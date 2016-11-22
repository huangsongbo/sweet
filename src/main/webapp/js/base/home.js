function tableList(type){
	var url=cPath+"/"+type+"Page";
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
			$("#mainTable").html(res);
		}
	});
}