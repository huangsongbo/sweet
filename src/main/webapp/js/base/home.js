function tableList(type){
	var url = "";
	if(type == "store"){
		url = cPath + "/jsp/store/jspList.htm"
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
			$("#mainTable").html(res);
		}
	});
}