function showOrdersByPage(allpage) {  
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			$.ajax({
			    type: "POST",
			    url:  "../orderAction!orderList.action",
			    data: { workno : sessionStorage.workno , page:page , serviceoffer: "301" },
			    dataType : "json",  
			    success: function( json ){     
			    	ul = JSON.parse( json.orderLists ); 
			    	$("#ordertable tbody").html(""); 
			    	for(var i in ul){ 
			    		var status;
			    		var btntd = "<td></td>";
			    		if(ul[i].status==1){ status='已处理'; }
			    		else{ 
			    			status='待处理'; 
			    			btntd = "<td><button type='button' class='btn btn-primary'  onClick=\"orderDeal('"+ul[i].reg_num+"')\">已处理</button></td>";
			    		}; 
			    		$("#ordertable tbody").append("<tr><td>"+ul[i].reg_num+"</td>"+
			    				"<td>"+ul[i].dealername+"</td>"+ 
			    				"<td>"+ul[i].cityname+"</td>"+
			    				"<td>"+ul[i].ordertype+"</td>"+ 
			    				"<td>"+ul[i].serviceid+"</td>"+ 
			    				"<td>"+ul[i].offername+"</td>"+
			    				"<td>"+ul[i].custname+"</td>"+
			    				"<td>"+ul[i].custcertno+"</td>"+
			    				"<td>"+ul[i].custcertaddr+"</td>"+
			    				"<td>"+ul[i].operdate+"</td>"+
			    				"<td>"+status+"</td>"+ 
			    				"<td><a href='#' onclick=\"getPhoto('"+ul[i].reg_num+"',1)\">查看</a></td>" +
			    				"<td><a href='#' onclick=\"getPhoto('"+ul[i].reg_num+"',2)\">查看</a></td>" +
			    				"<td><a href='#' onclick=\"getPhoto('"+ul[i].reg_num+"',3)\">查看</a></td>" +
			    				"<td><a href='#' onclick=\"getPhoto('"+ul[i].reg_num+"',4)\">查看</a></td>" + btntd );  
			    	}
				},
				error: function(json){ 
					return false;
				}
			}); 
		}
	});   
}  

// 初始化加载代理商列表
function OrderInit(){  
	$.ajax({
	    type: "POST",
	    url:  "../orderAction!addressList.action",
	    data: { workno : sessionStorage.workno , page : 1, AXB_A: "%", seeAll: "1"}, 
	    dataType : "json",  
	    success: function( json ){   
	    	var ultask = JSON.parse( json.addressListsTask );   
	    	$("#taskTable tbody").html(""); 
	    	for(var i in ultask){ 
	    		var status; 
	    		if(ultask[i].status==1){ status='已拨打'; } else{  status='未拨打';  }; 
	    		$("#taskTable tbody").append("<tr><td>"+ultask[i].custid+"</td>"+
	    				"<td>"+ultask[i].custname+"</td>"+ 
	    				"<td>"+ultask[i].phonetype+"</td>"+
	    				"<td>"+status+"</td>"+ 
	    				"<td>"+ultask[i].cnt+"</td></tr>" );  
	    	}
	    	
	    	var ultaskinfo = JSON.parse( json.addressLists );   
	    	$("#taskTableInfo tbody").html(""); 
	    	for(var i in ultaskinfo){ 
	    		var status; 
	    		if(ultaskinfo[i].status==1){ status='已拨打'; } else{  status='未拨打';  }; 
	    		$("#taskTableInfo tbody").append("<tr><td>"+ultaskinfo[i].al_id+"</td>"+
	    				"<td>"+ultaskinfo[i].custid+"</td>"+ 
	    				"<td>"+ultaskinfo[i].phone_type+"</td>"+
	    				"<td>"+ultaskinfo[i].al_a+"</td>"+
	    				"<td>"+ultaskinfo[i].al_x+"</td>"+
	    				"<td>"+ultaskinfo[i].al_b+"</td>"+
	    				"<td>"+status+"</td></tr>" );  
	    	}  
	    	
	    	showOrdersByPage(json.allPage);
		},
		error: function(json){ 
			return false;
		}
	});  
};  
