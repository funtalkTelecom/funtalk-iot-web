// 初始化加载客户列表 
(function(){   
	new TipBox({type:'load', str:"加载中..", setTime:1000, callBack:function(){ 
		$.ajax({
		    type: "POST",
		    url:  "../custAction!tocCustList.action",
		    data: { workno : sessionStorage.workno , page : 1 },
		    dataType : "json",  
		    success: function( json ){     
		    		ul = JSON.parse( json.custLists ); 
			    	$("#i_custtable tbody").html(""); 
			    	for(var i in ul){
			    		$("#i_custtable tbody").append("<tr><td>"+ul[i].telA+"</td>"+
															    				"<td>"+ul[i].telX+"</td>"+
															    				"<td>"+ul[i].product_name+"</td>"+
															    				"<td>"+ul[i].custname+"</td>"+
															    				"<td>"+ul[i].idcode+"</td>"+
															    				"<td>"+ul[i].idaddress+"</td>"+
															    				"<td>"+ul[i].pay_amount+"</td>"+
															    				"<td>"+ul[i].opensubid+"</td>"+
															    				"<td>"+ul[i].operdate+"</td></tr>");   
			    	}
			    	showCustsByPage( json.allPage ); 
			},
			error: function(json){ 
				return false;
			}
		}); 
	}}); 
	   
}());   

function showCustsByPage(allpage) {    
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			$.ajax({
			    type: "POST",
			    url:  "../custAction!tocCustList.action",
			    data: { workno : sessionStorage.workno , page : page },
			    dataType : "json",  
			    success: function( json ){     
			    	ul = JSON.parse( json.userLists ); 
			    	$("#i_custtable tbody").html(""); 
			    	for(var i in ul){
			    		$("#i_custtable tbody").append("<tr><td>"+ul[i].telA+"</td>"+
															    				"<td>"+ul[i].telX+"</td>"+
															    				"<td>"+ul[i].product_name+"</td>"+
															    				"<td>"+ul[i].custname+"</td>"+
															    				"<td>"+ul[i].idcode+"</td>"+
															    				"<td>"+ul[i].idaddress+"</td>"+
															    				"<td>"+ul[i].pay_amount+"</td>"+
															    				"<td>"+ul[i].opensubid+"</td>"+
															    				"<td>"+ul[i].operdate+"</td></tr>");    
			    	}
				},
				error: function(json){ 
					return false;
				}
			}); 
		}
	});   
}  

function getTocCust(){
	var custname = document.getElementById("custname").value;   
	new TipBox({type:'load',str:"加载中..",setTime:1000,callBack:function(){ 
		$.ajax({
		    type: "POST",
		    url:  "../custAction!toccustQuery.action",
		    data: { workno: sessionStorage.workno , page : 1 , cust_name: custname },
		    dataType : "json",  
		    success: function( json ){     
		    		ul = JSON.parse( json.custLists ); 
			    	$("#i_custtable tbody").html(""); 
			    	for(var i in ul){
			    		$("#i_custtable tbody").append("<tr><td>"+ul[i].telA+"</td>"+
																    				"<td>"+ul[i].telX+"</td>"+
																    				"<td>"+ul[i].product_name+"</td>"+
																    				"<td>"+ul[i].custname+"</td>"+
																    				"<td>"+ul[i].idcode+"</td>"+
																    				"<td>"+ul[i].idaddress+"</td>"+
																    				"<td>"+ul[i].pay_amount+"</td>"+
																    				"<td>"+ul[i].opensubid+"</td>"+
																    				"<td>"+ul[i].operdate+"</td></tr>");   
			    	} 
			},
			error: function(json){ 
				return false;
			}
		}); 
	}});  
}
