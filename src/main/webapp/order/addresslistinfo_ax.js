function ax_upload(){  
	if($("#filename").val()==""){
		new TipBox({type:'tip', str:'请选择需要导入的(AX)通讯录文件', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}
	
	var formData = new FormData( $("#form_ax")[0] ); 
	formData.append( "filetype", "AX" ); 
	formData.append( "workno", sessionStorage.workno );
	 
	var tipBox = new TipBox({type:'load',str:"文件导入中...", setTime:600000, callBack:function(){ }}); 
	$.ajax({
	    type: "POST",
	    url:  "../fileUploadAction!uploadAction.action",  
	    processData : false,
	    contentType : false, 
	    data: formData,
	    dataType : "jsonp", 
	    jsonp: "jsoncallback",
	    success: function( json ){   
	    	tipBox.close();  
	    	if(json.result=="1"){
	    		new TipBox({type:'success',str:'文件导入成功',hasBtn:true}); 
	    	} else if(json.result=="0"){
	    		new TipBox({type:'error',str:'导入的文件中未查询到数据,请核查后重新导入',hasBtn:true});
	    	} else if(json.result=="2"){
	    		new TipBox({type:'error',str:'导入的文件中有重复号码或库中已存在,请核查后重新导入',hasBtn:true});
	    	} else if(json.result=="-3"){
	    		new TipBox({type:'error',str:'文件格式不支持,请使用模板进行导入',hasBtn:true});
	    	} else{
	    		new TipBox({type:'tip',str:'系统异常请联系管理员!',hasBtn:true});
	    	} 
		},
		error: function(json){  
			tipBox.close();
			new TipBox({type:'error',str:'系统异常请联系管理员!',hasBtn:true});
		}
	});     
}
 
function select_all(){ 
	var state = $("#select_all").prop("checked");  
	$("input[name='phones']").prop( "checked", state ); 
}  

function getAXInfo(){
	$.ajax({
	    type: "POST",
	    url:  "../orderAction!addressAXList.action",
	    data: { workno : sessionStorage.workno },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.addressLists );  
    		$("#addressListAXTable tbody").html(""); 
    		var status;
	    	for(var i in ul){ 
	    		if( ul[i].status=="1" ){ status="成功"; } else { status="失败"; }
	    		$("#addressListAXTable tbody").append("<tr>" +
	    											"<td>"+ul[i].al_a+"</td>" +
	    											"<td>"+ul[i].al_x+"</td>" +
	    											"<td>"+status+"</td>" +
	    											"<td>"+ul[i].subid+"</td></tr>");
	    	}
		},
		error: function(json){ 
			return false;
		}
	});  
}