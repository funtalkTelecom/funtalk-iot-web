(function(){     
	document.getElementById( "axb_template").style.visibility= "hidden";  
	document.getElementById( "ax_template").style.visibility= "hidden";
}());   

function select_phonetype(){    
	var phone_type = $("#phone_type option:selected").val();	 
	if( phone_type=="AX" ){ 
		document.getElementById( "axb_template").style.visibility= "hidden";  
		document.getElementById( "ax_template").style.visibility= "visible"; 
	}else if( phone_type=="AXB" ){
		document.getElementById( "ax_template").style.visibility= "hidden";  
		document.getElementById( "axb_template").style.visibility= "visible"; 
	}
}

function upload_number(){
	var use_type = $("#use_type option:selected").val();	 
	if(use_type=="X" || use_type=="" || typeof(use_type) == "undefined" ){
		new TipBox({type:'tip', str:'请选择导入的客户类型', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}  
	
	var phone_type = $("#phone_type option:selected").val();	 
	if(phone_type=="0" || phone_type=="" || typeof(phone_type) == "undefined" ){
		new TipBox({type:'tip', str:'请选择导入的号码类型', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}   
	
	if($("#filename").val()==""){
		new TipBox({type:'tip', str:'请选择需要导入的号码文件', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}    
      
	var formData = new FormData( $("#form_phonenumber")[0] ); 
	formData.append( "filetype", phone_type+"_NUMBER" ); 
	formData.append( "workno", sessionStorage.workno );
	formData.append( "usetype", use_type );
	
	var tipBox = new TipBox({type:'load',str:"号码导入中...", setTime:600000, callBack:function(){ }}); 
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
	    		new TipBox({type:'success', str:'号码导入成功', hasBtn:true});    
	    	} else if(json.result=="0"){
	    		new TipBox({type:'error',str:'导入的文件中未查询到数据,请核查后重新导入',hasBtn:true});
	    	} else if(json.result=="2"){
	    		new TipBox({type:'error',str:'导入的文件中有重复号码或库中已存在,请核查后重新导入',hasBtn:true});
	    	} else if(json.result=="-3"){
	    		new TipBox({type:'error',str:'文件格式不支持,请使用模板进行导入',hasBtn:true});
	    	} else if(json.result=="-4"){
	    		new TipBox({type:'error',str:'文件中存在汉字字符, 请删除后重新导入',hasBtn:true});
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
