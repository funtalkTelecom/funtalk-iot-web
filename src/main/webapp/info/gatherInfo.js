$(document).ready(function(){  
	var year = new Date().getFullYear();
	var month = ("0" + (new Date().getMonth() + 1)).slice(-2);
	var stat_month = year + "-" + month;
	$("#stat_month").val( stat_month );   
});  

function getGatherInfo(){ 
	var stat_month = $("#stat_month").val().replace("-","");
	var workno = sessionStorage.workno;
	if( stat_month=="" ){
		new TipBox({type:'tip', str:'请选择查询月份', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}else if( stat_month.length<6 ){
		new TipBox({type:'tip', str:'输入月份不正确', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	} 
	
	var gathertype = "";	//$("#gathertype option:selected").val() ;
	var tipBox = new TipBox({type:'load',str:"号码导入中...", setTime:600000, callBack:function(){ }});   
	$.ajax({
	    type: "POST",
	    url:  "../acctSheetAction!acctSheetInfo.action",
	    data: { workno: sessionStorage.workno , statmonth: stat_month, gathertype: gathertype},
	    dataType : "json",  
	    success: function( json ){   
	    	tipBox.close();
	    	ul_acctbookList = JSON.parse( json.accBookLists ); 
	    	ul_callInfoSum = JSON.parse( json.callInfoSum );   
	    	ul_acctList = JSON.parse( json.acctLists ); 
	    	
	    	$("#callInfoSumtable tbody").html(""); 
	    	var gathertype = "其他";
	    	for(var i in ul_callInfoSum){
	    		if( ul_callInfoSum[i].gathertype=='PHONEFEE' ){ gathertype="号码月租"; }
	    		else if( ul_callInfoSum[i].gathertype=='PROD_ORDER' ){ gathertype="产品包订购"; }
	    		else{ gathertype = ul_callInfoSum[i].gathertype; }
	    		$("#callInfoSumtable tbody").append("<tr><td>"+stat_month+"</td>"+
						"<td>"+gathertype+"</td>"+
	    				"<td>"+ul_callInfoSum[i].sumcnt+"</td>"+
	    				"<td>"+ul_callInfoSum[i].sumfee+"</td></tr>"); 
	    	} 
	    	$("#accBooktable tbody").html("");
	    	for(var i in ul_acctbookList){
	    		var booktype ;
	    		if( ul_acctbookList[i].booktype=="1" ){ booktype="语音(分钟)"; } else{ booktype="其他"; }
	    		$("#accBooktable tbody").append("<tr><td>"+stat_month+"</td>"+
													    				"<td>"+ul_acctbookList[i].acctid+"</td>"+
													    				"<td>"+ul_acctbookList[i].bookid+"</td>"+
													    				"<td>"+booktype+"</td>"+
													    				"<td>"+ul_acctbookList[i].balance+"</td>"+
													    				"<td>"+ul_acctbookList[i].effdate+"</td></tr>"); 
	    	} 
		},
		error: function(json){
			tipBox.close();
			return false;
		}
	});   
}