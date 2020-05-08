$(document).ready(function(){  
	var year = new Date().getFullYear();
	var month = ("0" + (new Date().getMonth() + 1)).slice(-2);
	var day = ("0" + ( new Date().getDate() )).slice(-2);
	var stat_month = year + "-" + month + "-" + day;
	$("#stat_month").val( stat_month );   
});

//  
function getCallInfo(){
	var str = $("#stat_month").val().split("-"); 
	var statmonth = str[0]+str[1];
	var statday = str[2];  
	var workno = sessionStorage.workno;
	if( statmonth=="" ){
		new TipBox({type:'tip', str:'请选择查询日期', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}else if( statmonth.length<6 ){
		new TipBox({type:'tip', str:'输入日期不正确', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}  
	$.ajax({
	    type: "POST",
	    url:  "../callInfoAction!callInfoList.action",
	    data: { page: 1, workno: sessionStorage.workno , statmonth: statmonth, statday: statday },
	    dataType : "json",  
	    success: function( json ){    
	    	// alert("json.callInfoLists=" + json.callInfoLists );
	    	// alert("json.allPage=" + json.allPage ); 
	    	ul = JSON.parse( json.callInfoLists );  
	    	if(ul.length==0){
	    		new TipBox({type:'tip', str:'查询无结果', clickDomCancel:true, setTime:0, hasBtn:true} ); 
	    		return false;
	    	}
	    	$("#callinfotable tbody").html(""); 
	    	var recUrl = "";
	    	for(var i in ul){ 
	    		if( ul[i].recordUrl != "" ) { recUrl= "<a href='"+ul[i].recordUrl+"' target='_blank'>录音</a>"; } else{ recUrl = ""; }
	    		$("#callinfotable tbody").append("<tr><td>"+ul[i].requestId+"</td>"+
												    				"<td>"+ul[i].gathertype+"</td>"+
												    				"<td>"+ul[i].gmonth+"</td>"+
												    				"<td>"+ul[i].gday+"</td>"+
												    				"<td>"+ul[i].custname+"</td>"+ 
												    				"<td>"+ul[i].productname+"</td>"+
												    				"<td>"+ul[i].telA+"</td>"+
												    				"<td>"+ul[i].telX+"</td>"+
												    				"<td>"+ul[i].telB+"</td>"+
												    				"<td>"+ul[i].telC+"</td>"+
												    				"<td>"+ul[i].calltype+"</td>"+
												    				"<td>"+ul[i].starttime+"</td>"+
												    				"<td>"+ul[i].releasetime+"</td>"+
												    				"<td>"+ul[i].diffminute+"</td>"+
												    				"<td>"+ul[i].fee+"</td>"+
												    				"<td>"+recUrl+"</td></tr>");      
	    	}  
	    	showCallInfoByPage( json.allPage );
		},
		error: function(json){ 
			return false;
		}
	});   
}

function showCallInfoByPage( allpage ){
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			var str = $("#stat_month").val().split("-"); 
			var statmonth = str[0]+str[1];
			var statday = str[2];  
			var workno = sessionStorage.workno;
			if( statmonth=="" ){
				new TipBox({type:'tip', str:'请选择查询日期', clickDomCancel:true, setTime:0, hasBtn:true} ); 
				return false;
			}else if( statmonth.length<6 ){
				new TipBox({type:'tip', str:'输入日期不正确', clickDomCancel:true, setTime:0, hasBtn:true} ); 
				return false;
			}  
			
			$.ajax({
			    type: "POST",
			    url:  "../callInfoAction!callInfoList.action",
			    data: { page: page, workno: sessionStorage.workno , statmonth: statmonth, statday: statday },
			    dataType : "json",  
			    success: function( json ){    
			    	// alert("json.callInfoLists=" + json.callInfoLists );
			    	// alert("json.allPage=" + json.allPage ); 
			    	ul = JSON.parse( json.callInfoLists );  
			    	if(ul.length==0){
			    		new TipBox({type:'tip', str:'查询无结果', clickDomCancel:true, setTime:0, hasBtn:true} ); 
			    		return false;
			    	}
			    	var recUrl = "";
			    	for(var i in ul){ 
			    		if( ul[i].recordUrl != "" ) { recUrl= "<a href='"+ul[i].recordUrl+"' target='_blank'>录音</a>"; } else{ recUrl = ""; }
			    		$("#callinfotable tbody").append("<tr><td>"+ul[i].requestId+"</td>"+
														    				"<td>"+ul[i].gathertype+"</td>"+
														    				"<td>"+ul[i].gmonth+"</td>"+
														    				"<td>"+ul[i].gday+"</td>"+
														    				"<td>"+ul[i].custname+"</td>"+ 
														    				"<td>"+ul[i].productname+"</td>"+
														    				"<td>"+ul[i].telA+"</td>"+
														    				"<td>"+ul[i].telX+"</td>"+
														    				"<td>"+ul[i].telB+"</td>"+
														    				"<td>"+ul[i].telC+"</td>"+
														    				"<td>"+ul[i].calltype+"</td>"+
														    				"<td>"+ul[i].starttime+"</td>"+
														    				"<td>"+ul[i].releasetime+"</td>"+
														    				"<td>"+ul[i].diffminute+"</td>"+
														    				"<td>"+ul[i].fee+"</td>"+
														    				"<td>"+recUrl+"</td></tr>");        
			    	} 
				},
				error: function(json){ 
					return false;
				}
			});  
		}
	});    
}