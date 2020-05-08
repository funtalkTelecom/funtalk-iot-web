$(document).ready(function(){  
	var year = new Date().getFullYear();
	var month = ("0" + (new Date().getMonth() + 1)).slice(-2);
	var day = ("0" + ( new Date().getDate() )).slice(-2);
	var stat_month = year + "-" + month + "-" + day;
	$("#stat_month").val( stat_month ); 
});

function getReport(){
	var telX = $("#telX").val();
	if(telX==""){
		new TipBox({type:'tip', str:'请输入隐私号码', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}
	var str = $("#stat_month").val().split("-");
	var statmonth = str[0]+str[1];
	var statday = str[2];
	var workno = sessionStorage.workno;
	 
	var summcnt = 0;
	var sumline = "";
	
	$.ajax({
	    type: "POST",
	    url:  "../reportAction!dayReport801.action",
	    data: { workno: workno, statmonth: statmonth, statday: statday, telX: telX },
	    dataType : "json",  
	    success: function( json ){    
	    	$("#reportTable tbody").html(""); 
	    	ul = JSON.parse( json.dayreport801Str );  
	    	if(ul.length==0){
	    		new TipBox({type:'tip', str:'查询无结果', clickDomCancel:true, setTime:0, hasBtn:true} ); 
	    		return false;
	    	} 
	    	for(var i in ul){  
	    		summcnt = parseInt(summcnt) + parseInt(ul[i].diffminute);
	    		$("#reportTable tbody").append("<tr><td>"+ul[i].statmonth+"</td>"+
	    															"<td>"+ul[i].statday+"</td>"+
	    															"<td>"+ul[i].mtype+"</td>"+
												    				"<td>"+ul[i].dealer_name+"</td>"+
												    				"<td>"+ul[i].cust_name+"</td>"+
												    				"<td>"+ul[i].calltype+"</td>"+
												    				"<td>"+ul[i].telA+"</td>"+
												    				"<td>"+ul[i].telX+"</td>"+
												    				"<td>"+ul[i].telB+"</td>"+
												    				"<td>"+ul[i].starttime+"</td>"+ 
												    				"<td>"+ul[i].diffminute+"</td></tr>");      
	    	}
	    	sumline = "<tr><td colspan='10'>合计</td><td>"+summcnt+"</td></tr>";
	    	$("#reportTable tbody").append(sumline);
		},
		error: function(json){ 
			return false;
		}
	});  
	
}

