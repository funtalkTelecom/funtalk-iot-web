function editProductPageInit( productId ){ 
	
	$.ajax({
	    type: "POST",
	    url:  "../productAction!productInfoById.action",
	    data: { workno: sessionStorage.workno, productid: productId },
	    dataType : "json",  
	    success: function( json ){     
    		ul = JSON.parse( json.productLists );  
    		
    		$("#productId").html( ul.productId );
    		$("#productName").val( ul.productName ); 
    		
    		$("#monthFee").val( ul.monthFee );
    		$("#voiceCnt").val( ul.voiceCnt );
    		$("#overdueFee").val( ul.overdueFee );
    		$("#phone_monthfee").val( ul.phone_monthfee ); 
    		
    		if( ul.autoOrder=="1" ){ $("#autoOrder").attr("checked",true); } else{ $("#autoOrder").attr("checked",false); }
    		if( ul.recording=="1" ){ $("#recording").attr("checked",true); } else{ $("#recording").attr("checked",false); }
    		  
    		$("#ax_display").val( ul.ax_display ); 
    		
    		var array_axb = ul.axb_display.split(",");
    		if(array_axb[0]=="1") { $("#axb_a_display").attr("checked",true); } else{ $("#axb_a_display").attr("checked",false); }
    		if(array_axb[1]=="1") { $("#axb_b_display").attr("checked",true); } else{ $("#axb_b_display").attr("checked",false); } 
    		
    		$("#productDesc").val( ul.productDesc );
    		$("#productEffDate").html( ul.effDate ); 
    		
    		if( ul.if_valid=="1" ){ $("#if_valid").attr("checked",true); } else{ $("#if_valid").attr("checked",false); }
    		 
		},
		error: function(json){ 
			return false;
		}
	});  
}

function editProduct(){
	var productid = $("#productId").html();
	var productName =  $("#productName").val();
	var monthFee = $("#monthFee").val();
	var voiceCnt = $("#voiceCnt").val();
	var overdueFee = $("#overdueFee").val();
	var phone_monthfee = $("#phone_monthfee").val(); 
	
	var autoOrder = "";
	if($("#autoOrder").prop("checked")==true){ autoOrder="1"; }else{ autoOrder="0"; } 
	var recording = "";
	if($("#recording").prop("checked")==true){ recording="1"; }else{ recording="0"; } 
	var axb_a_display = "";
	var axb_b_display = "";
	if($("#axb_a_display").prop("checked")==true){ axb_a_display="1"; }else{ axb_a_display="0"; } 
	if($("#axb_b_display").prop("checked")==true){ axb_b_display="1"; }else{ axb_b_display="0"; } 
	var productDesc = $("#productDesc").val(); 
	var if_valid = "";
	if($("#if_valid").prop("checked")==true){ if_valid="1"; }else{ if_valid="0"; } 
	var ax_display = $("#ax_display").val();
	
	if( productName == "" ){
		new TipBox({type:'tip',str:'产品名称不能为空',hasBtn:true}); 
		return false;
	}
	if( monthFee == "" ){
		new TipBox({type:'tip',str:'月租费不能为空',hasBtn:true}); 
		return false;
	}
	if( voiceCnt == "" ){
		new TipBox({type:'tip',str:'包内分钟数不能为空',hasBtn:true}); 
		return false;
	}
	if( overdueFee == "" ){
		new TipBox({type:'tip',str:'超出计费不能为空',hasBtn:true}); 
		return false;
	}
	 
	$.ajax({
	    type: "POST",
	    url:  "../productAction!editProduct.action",
	    data: { workno: sessionStorage.workno, productid:productid, productName: productName, 
	    	monthFee: monthFee, voiceCnt: voiceCnt, overdueFee: overdueFee, phone_monthfee: phone_monthfee,
	    	autoOrder: autoOrder, recording: recording, axb_a_display: axb_a_display, 
	    	axb_b_display: axb_b_display, productDesc: productDesc, if_valid: if_valid, ax_display:ax_display },
	    dataType : "json",  
	    success: function( json ){  
	    	if(json.result == "1"){  
	    	    new TipBox({type:'success',str:'更新成功',hasBtn:true}); 
	    	} else if(json.result == "2"){
	    		new TipBox({type:'error',str:'产品名称重复',hasBtn:true}); 
	    	} else{
	    		new TipBox({type:'error', str:'新建失败', hasBtn:true});
	    	}
		},
		error: function(json){ 
			return false;
		}
	});   
}
