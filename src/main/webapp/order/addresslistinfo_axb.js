var i = 0;
var phone_type = "AXB";
// 初始化 
(function(){  
	// AXB隐私号X列表
	$.ajax({
	    type: "POST",
	    url:  "../phoneAction!phoneTaskList.action",
	    data: { workno:sessionStorage.workno, phone_type:phone_type },
	    dataType : "json",  
	    success: function( json ){  
	    	ul = JSON.parse( json.phoneListStr ); 
	    	document.getElementById("axb_x").innerHTML = "";
	    	document.getElementById("axb_x").options.add(new Option( "请选择隐私号码", "0" ));  
	    	for(var i in ul){  
	    		document.getElementById("axb_x").options.add(new Option( ul[i].phone_number, ul[i].phone_number ));  
	    	}  
		},
		error: function(json){ 
			return false;
		}
	});    
}()); 


function axb_b_upload(){  
	if($("#filename").val()==""){
		new TipBox({type:'tip', str:'请选择需要导入的通讯录文件(B)', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}    
     
    var axb_x = $("#axb_x option:selected").val();	 
	if(axb_x=="0" || axb_x=="" || typeof(axb_x) == "undefined" ){
		new TipBox({type:'tip', str:'请选择需要分配的隐私号码(X)', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}
	
	var axb_a = $("#axb_a").val();	
	if(axb_a==""){
		new TipBox({type:'tip', str:'请输入主叫号码(A)', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	} else if(axb_a==axb_x){
		new TipBox({type:'tip', str:'主叫号码(A)与隐私号码(X)不能一致', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	} 
	
	var formData = new FormData( $("#form_axb_b")[0] ); 
	formData.append( "filetype", phone_type+"_B" );
	formData.append( "addressAXB_A", axb_a );
	formData.append( "addressAXB_X", axb_x );
	formData.append( "phone_type", phone_type );
	formData.append( "workno", sessionStorage.workno );
	 
	var tipBox = new TipBox({type:'load',str:"任务生成中...", setTime:600000, callBack:function(){ }}); 
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
	    		new TipBox({type:'success', str:'任务生成成功', hasBtn:true});   
	    		$("#addressListTable tbody").append("<tr><td>"+ eval(i+1) +"</td>"+
																    				"<td>"+axb_a+"</td>"+
																    				"<td>"+axb_x+"</td>"+
																    				"<td>"+json.impCnt+"</td></tr>");   
	    		i = i+1; 
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
  
 