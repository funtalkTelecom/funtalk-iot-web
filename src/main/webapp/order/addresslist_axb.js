function showOrdersByPage(allpage, AXB_A) {  
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			$.ajax({
			    type: "POST",
			    url:  "../orderAction!orderList.action",
			    data: { workno : sessionStorage.workno , page:page , AXB_A: AXB_A },
			    dataType : "json",  
			    success: function( json ){     
			    	ul = JSON.parse( json.addressLists ); 
			    	$("#i_al_ordertable tbody").html("");
			    	for(var i in ul){  
			    		var status; 
			    		var btntd = "<td></td>";
			    		var operresult = "<td></td>";
			    		if(ul[i].al_status==1){ 
			    			status='已经拨打'; 
			    			btntd = "<td>"+status+"</td>";
			    		} else{ 
			    			status='拨打下一个'; 
			    			btntd = "<td><button type='button' class='btn btn-primary' onClick=\"orderDeal(this,'"+ul[i].al_id+"')\">"+status+"</button></td>";
			    		}; 
			    		$("#i_al_ordertable tbody").append("<tr><td>"+ul[i].al_a +"</td>" 
			    															+ "<td>"+ul[i].al_x +"</td>"
			    															+ "<td>"+ul[i].al_b+"</td>" + btntd + operresult +"</tr>");   
			    	}
				},
				error: function(json){ 
					return false;
				}
			}); 
		}
	});   
}  

// 初始化通讯录列表
function OrderInit(){  
	$.ajax({
	    type: "POST",
	    url:  "../orderAction!addressList.action",
	    data: { workno : sessionStorage.workno , page : 1 , AXB_A: "" },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.addressLists ); 
	    	$("#i_al_ordertable tbody").html("");
	    	for(var i in ul){  
	    		var status; 
	    		var btntd = "<td></td>";
	    		var operresult = "<td></td>";
	    		if(ul[i].al_status==1){ 
	    			status='已经拨打'; 
	    			btntd = "<td>"+status+"</td>";
	    		} else{ 
	    			status='拨打下一个'; 
	    			btntd = "<td><button type='button' class='btn btn-primary' onClick=\"orderDeal(  '"+ul[i].al_id+"')\">"+status+"</button></td>";
	    		}; 
	    		$("#i_al_ordertable tbody").append("<tr><td>"+ul[i].al_a +"</td>" 
	    															+ "<td>"+ul[i].al_x +"</td>"
	    															+ "<td>"+ul[i].al_b+"</td>" + btntd + operresult +"</tr>");   
	    	}
	    	showOrdersByPage(json.allPage , "");
		},
		error: function(json){ 
			return false;
		}
	});  
}; 
 
function getAddressListByA(){
	var axb_a = $("#i_address_axb_a").val();
	if(axb_a==""){
		new TipBox({type:'tip', str:'请输入主叫号码(A)进行查询过滤', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}  
	$.ajax({
	    type: "POST",
	    url:  "../orderAction!addressOne.action",
	    data: { workno : sessionStorage.workno, AXB_A: axb_a, seeAll: "0" },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.addressLists ); 
	    	$("#i_al_ordertable tbody").html("");
	    	for(var i in ul){  
	    		var status; 
	    		var btntd = "<td></td>";
	    		var operresult = "<td></td>";
	    		if(ul[i].al_status==1){ 
	    			status='已经拨打'; 
	    			btntd = "<td>"+status+"</td>";
	    		} else{ 
	    			status='拨打下一个'; 
	    			btntd = "<td><button type='button' class='btn btn-primary' onClick=\"orderDeal( '"+ul[i].al_id+"')\">"+status+"</button></td>";
	    		}; 
	    		$("#i_al_ordertable tbody").append("<tr><td>"+json.allPage +"</td><td>"+ul[i].al_a +"</td>" 
	    															+ "<td>"+ul[i].al_x +"</td>"
	    															+ "<td>"+ul[i].al_b+"</td>" + btntd + operresult +"</tr>");   
	    	} 
		},
		error: function(json){ 
			return false;
		}
	});  
}; 
 
function orderDeal(al_id){  
	$.ajax({
	    type: "POST",
	    url:  "../orderAction!createOrder.action",
	    data: { workno: sessionStorage.workno , al_id: al_id },
	    dataType : "json",  
	    success: function( json ){  
	    	if( json.result=="1" ){
	    		getAddressListByA();
	    		new TipBox({type:'success', str:"绑定成功, 可拨打X到B", clickDomCancel:true, setTime:0, hasBtn:true} );  
	    	}else{
	    		new TipBox({type:'tip', str:"绑定失败"+json.result, clickDomCancel:true, setTime:0, hasBtn:true} ); 
	    	}
		},
		error: function(json){ 
			return false;
		}
	 });    
}