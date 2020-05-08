$(document).ready(function(){  
	var year = new Date().getFullYear();
	var month = ("0" + (new Date().getMonth() + 1)).slice(-2); 
	var stat_month = year + "-" + month ;
	$("#stat_month").val( stat_month ); 
	 
	
	//获取所有代理商接口
	$.ajax({
	    type: "POST",
	    url:  "../dealerAction!dealerQueryByWorkno.action",
	    data: { page:1 , workno:sessionStorage.workno },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.dealerLists );   
	    	document.getElementById("dealerid").options.add(new Option( "请选择", "0" ));  
	    	for(var i in ul){ 
	    		document.getElementById("dealerid").options.add(new Option( ul[i].dealername, ul[i].dealerid ));   
	    	} 
		},
		error: function(json){  
			return false;
		}
	});    
	
	document.getElementById("custid").options.add(new Option( "请选择", "0" )); 
	
});
 

function getReport(){ 
	var str = $("#stat_month").val().split("-");
	var statmonth = str[0]+str[1]; 
	var workno = sessionStorage.workno;
	 
	var custid = $("#custid option:selected").val();  
	if( custid=="0" || custid=="" || typeof(custid) == "undefined" ){  custid = ""; }
	  
	var tipBox = new TipBox({type:'load',str:"数据查询中...", setTime:600000, callBack:function(){ }}); 
	$.ajax({
	    type: "POST",
	    url:  "../reportAction!dayReport802.action",
	    data: { workno: workno, statmonth: statmonth, custid: custid },
	    dataType : "json",  
	    success: function( json ){ 
	    	tipBox.close(); 
	    	$("#reportTable tbody").html(""); 
	    	ul = JSON.parse( json.dayreport802Str );  
	    	if(ul.length==0){
	    		new TipBox({type:'tip', str:'查询无结果', clickDomCancel:true, setTime:0, hasBtn:true} ); 
	    		return false;
	    	} 
	    	for(var i in ul){    
	    		$("#reportTable tbody").append("<tr><td>"+ul[i].statmonth+"-"+ul[i].statday+"</td>"+
	    															"<td>"+ul[i].custname+"</td>"+
	    															"<td>"+ul[i].allcnt+"</td>"+
												    				"<td>"+ul[i].diffminute+"</td>"+
												    				"<td>"+ul[i].avgcall+"</td>"+
												    				"<td>"+ul[i].maxcall+"</td>"+
												    				"<td>"+ul[i].mincall+"</td></tr>");      
	    	} 
		},
		error: function(json){ 
			tipBox.close();
			return false;
		}
	});    
	 
} 

function getCustInfo(){ 
	var dealerid = $("#dealerid option:selected").val();  
	$.ajax({
	    type: "POST",
	    url:  "../custAction!custListByDealerid.action",
	    data: { dealerid: dealerid },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.custLists );   
	    	document.getElementById("custid").options.length=0; 
	    	for(var i in ul){ 
	    		document.getElementById("custid").options.add(new Option( ul[i].cust_name, ul[i].cust_id ));   
	    	} 
		},
		error: function(json){ 
			return false;
		}
	});  
} 
