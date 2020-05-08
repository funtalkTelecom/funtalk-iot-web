function showOrdersByPage(allpage) {  
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			$.ajax({
			    type: "POST",
			    url:  "../orderAction!orderList.action",
			    data: { workno : sessionStorage.workno , page:page , serviceoffer: "101" },
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
			    				"<td>"+ul[i].amount+"</td>"+
			    				"<td>"+ul[i].operdate+"</td>"+ 
			    				"<td>"+status+"</td>"+  btntd );  
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
	    url:  "../orderAction!orderList.action",
	    data: { workno : sessionStorage.workno , page : 1 , serviceoffer: "101" },
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
	    				"<td>"+ul[i].amount+"</td>"+
	    				"<td>"+ul[i].operdate+"</td>"+ 
	    				"<td>"+status+"</td>"+  btntd );  
	    	}
	    	showOrdersByPage(json.allPage);
		},
		error: function(json){ 
			return false;
		}
	});  
}; 

//按查询条件查询订单
function getOrder(){  
	var serviceid = document.getElementById( "serviceid" ).value; 
	var custname = document.getElementById( "custname" ).value;  
}

function orderDeal(reg_num){   
	$.ajax({
	    type: "POST",
	    url:  "../orderAction!orderDeal.action",
	    data: { reg_num:reg_num, workno:sessionStorage.workno , serviceoffer:"101"},
	    dataType : "json",  
	    success: function( json ){  
	    	if(json.orderDealResult == "1" ){
	    		new TipBox({type:'success',str:'订单处理完成!',hasBtn:true}); 
	    		OrderInit();
	    	}else{
	    		new TipBox({type:'error',str:'订单处理失败!'+json.orderDealResult ,hasBtn:true});
	    	} 
		},
		error: function(json){ 
			return false;
		}
	});  
}
  

