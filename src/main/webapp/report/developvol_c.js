$(document).ready(function(){  
	var year = new Date().getFullYear();
	var month = ("0" + (new Date().getMonth() + 1)).slice(-2);
	var day = ("0" + ( new Date().getDate() )).slice(-2);
	var stat_month = year + "-" + month + "-" + day;
	$("#stat_month").val( stat_month ); 
});

function getReport(){ 
	var str = $("#stat_month").val().split("-");
	var statmonth = str[0]+str[1];
	var statday = str[2];
	var workno = sessionStorage.workno;
	 
	var sum_smsall = 0;
	var sum_smscnt = 0;
	var sum_smzall = 0;
	var sum_smzcnt = 0;
	var sum_pcnt = 0;
	var sum_ocnt = 0;
	var sum_diffm = 0; 
	var sumline = "";
	
	$.ajax({
	    type: "POST",
	    url:  "../reportAction!dayReport803.action",
	    data: { workno: workno, statmonth: statmonth, statday: statday },
	    dataType : "json",  
	    success: function( json ){    
	    	$("#reportTable tbody").html(""); 
	    	ul = JSON.parse( json.dayreport803Str );  
	    	if(ul.length==0){
	    		new TipBox({type:'tip', str:'查询无结果', clickDomCancel:true, setTime:0, hasBtn:true} ); 
	    		return false;
	    	} 
	    	for(var i in ul){   
	    		sum_smsall = parseInt(sum_smsall) + parseInt(ul[i].smsall);
	    		sum_smscnt = parseInt(sum_smscnt) + parseInt(ul[i].smscnt);
	    		sum_smzall = parseInt(sum_smzall) + parseInt( ul[i].smzall );
	    		sum_smzcnt = parseInt(sum_smzcnt) + parseInt(ul[i].smzcnt);
	    		sum_pcnt = parseInt(sum_pcnt) + parseInt(ul[i].pcnt);
	    		sum_ocnt = parseInt(sum_ocnt) + parseInt(ul[i].ocnt);
	    		sum_diffm = parseInt(sum_diffm) + parseInt(ul[i].diffm);  
	    		$("#reportTable tbody").append("<tr><td>"+ul[i].statday+"</td>"+
	    															"<td>"+ul[i].smsall+"</td>"+
	    															"<td>"+ul[i].smscnt+"</td>"+
												    				"<td>"+ul[i].smzall+"</td>"+
												    				"<td>"+ul[i].smzcnt+"</td>"+
												    				"<td>"+ul[i].pcnt+"</td>"+
												    				"<td>"+ul[i].ocnt+"</td>"+
												    				"<td>"+ul[i].diffm+"</td></tr>");      
	    	}
	    	sumline = "<tr><td>合计</td><td>"+sum_smsall+"</td><td>"+sum_smscnt+"</td><td>"+sum_smzall+"</td>" +
	    			"<td>"+sum_smzcnt+"</td><td>"+sum_pcnt+"</td><td>"+sum_ocnt+"</td><td>"+sum_diffm+"</td></tr>";
	    	$("#reportTable tbody").append(sumline);
		},
		error: function(json){ 
			return false;
		}
	});  
	
}

