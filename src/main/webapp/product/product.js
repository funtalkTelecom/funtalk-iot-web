// 初始化加载产品列表 
(function(){   
	new TipBox({type:'load',str:"加载中..",setTime:1000,callBack:function(){ 
		$.ajax({
		    type: "POST",
		    url:  "../productAction!productList.action",
		    data: { workno : sessionStorage.workno , page : 1 },
		    dataType : "json",  
		    success: function( json ){    
		    		ul = JSON.parse( json.productLists ); 
			    	$("#productable tbody").html(""); 
			    	var autoOrder;
			    	var recording;
			    	var ax_display;
			    	var axb_display;
			    	for(var i in ul){
			    		if( ul[i].autoOrder=="1" ){ autoOrder="是"; }else{ autoOrder="否";  }
			    		if( ul[i].recording== "1" ){ recording="是"; }else{ recording="否";  }
			    		if( ul[i].axb_display== "0,0" ) { axb_display = "A显示为X,B显示为X"; } 
			    		else if(ul[i].axb_display== "0,1"){ axb_display = "A显示为X,B显示为B"; }
			    		else if(ul[i].axb_display== "1,0"){ axb_display = "A显示为A,B显示为X"; }
			    		else if(ul[i].axb_display== "1,1"){ axb_display = "A显示为A,B显示为B"; }
			    		
			    		if(ul[i].ax_display=="0"){ ax_display = "显示真实号码";} 
			    		else if(ul[i].ax_display=="1"){ ax_display = "显示X号码";}
			    		else if(ul[i].ax_display=="2"){ ax_display = "显示Z号码池中的号码";}
			    		
			    		$("#productable tbody").append("<tr><td>"+ul[i].productId+"</td>"+
			    				"<td>"+ul[i].productName+"</td>"+
			    				"<td>"+ul[i].productType+"</td>"+
			    				
			    				"<td>"+ul[i].monthFee+"</td>"+
			    				"<td>"+ul[i].voiceCnt+"</td>"+
			    				"<td>"+ul[i].overdueFee+"</td>"+ 
			    				"<td>"+ul[i].phone_monthfee+"</td>"+
			    				
			    				"<td>"+autoOrder+"</td>"+
			    				"<td>"+recording+"</td>"+
			    				"<td>"+ax_display+"</td>"+ 
			    				"<td>"+axb_display+"</td>"+ 
			    				
			    				"<td>"+ul[i].effDate+"</td>"+
			    				"<td>"+ul[i].expDate+"</td>"+
			    				"<td>"+ul[i].if_valid+"</td>"+
			    				"<td>"+ul[i].productDesc+"</td>"+  
			    				"<td><a href='#' onclick=\"editProductInit('" + ul[i].productId + "')\">编辑</a></td></tr>");   
			    	}
			    	showProductsByPage(json.allPage); 
			},
			error: function(json){ 
				return false;
			}
		}); 
	}});
}());   

function showProductsByPage(allpage) {    
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			$.ajax({
			    type: "POST",
			    url:  "../productAction!productList.action",
			    data: { workno : sessionStorage.workno , page : page },
			    dataType : "json",  
			    success: function( json ){     
			    	ul = JSON.parse( json.productLists ); 
			    	$("#productable tbody").html(""); 
			    	var autoOrder;
			    	var recording;
			    	var ax_display;
			    	var axb_display;
			    	for(var i in ul){
			    		if( ul[i].autoOrder=="1" ){ autoOrder="是"; }else{ autoOrder="否";  }
			    		if( ul[i].recording== "1" ){ recording="是"; }else{ recording="否";  }
			    		if( ul[i].axb_display== "0,0" ) { axb_display = "A显示为X,B显示为X"; } 
			    		else if(ul[i].axb_display== "0,1"){ axb_display = "A显示为X,B显示为B"; }
			    		else if(ul[i].axb_display== "1,0"){ axb_display = "A显示为A,B显示为X"; }
			    		else if(ul[i].axb_display== "1,1"){ axb_display = "A显示为A,B显示为B"; }
			    		if(ul[i].ax_display=="0"){ ax_display = "显示真实号码";} 
			    		else if(ul[i].ax_display=="1"){ ax_display = "显示X号码";}
			    		else if(ul[i].ax_display=="2"){ ax_display = "显示Z号码池中的号码";}
			    		$("#productable tbody").append("<tr><td>"+ul[i].productId+"</td>"+
			    				"<td>"+ul[i].productName+"</td>"+
			    				"<td>"+ul[i].productType+"</td>"+
			    				
			    				"<td>"+ul[i].monthFee+"</td>"+
			    				"<td>"+ul[i].voiceCnt+"</td>"+
			    				"<td>"+ul[i].overdueFee+"</td>"+
			    				"<td>"+ul[i].phone_monthfee+"</td>"+
			    				
			    				"<td>"+autoOrder+"</td>"+
			    				"<td>"+recording+"</td>"+
			    				"<td>"+ax_display+"</td>"+ 
			    				"<td>"+axb_display+"</td>"+ 
			    				
			    				"<td>"+ul[i].effDate+"</td>"+
			    				"<td>"+ul[i].expDate+"</td>"+
			    				"<td>"+ul[i].if_valid+"</td>"+
			    				"<td>"+ul[i].productDesc+"</td>"+  
			    				"<td><a href='#' onclick=\"editProductInit('" + ul[i].productId + "')\">编辑</a></td></tr>");   
			    	}
				},
				error: function(json){ 
					return false;
				}
			}); 
		}
	});   
}  

function getProduct(){ 
} 

function editProductInit( productId ){    
	window.location.href = 'productedit.html?productId='+productId  ; 
}

function editProductPageInit( productId ){
	$.ajax({
	    type: "POST",
	    url:  "../productAction!productInfoById.action",
	    data: { workno : sessionStorage.workno, productid: productId },
	    dataType : "json",  
	    success: function( json ){     
    		ul = JSON.parse( json.productLists );   
    		document.getElementById('productId').innerHTML = ul.productid;
		},
		error: function(json){ 
			return false;
		}
	});  
}
