$(document).ready(function(){  
	var year = new Date().getFullYear();
	var month = ("0" + (new Date().getMonth() + 1)).slice(-2);
	var day = ("0" + ( new Date().getDate() )).slice(-2);
	var stat_month = year + "-" + month;
	$("#indb_date").val( stat_month ); 
});

//初始化
(function() {
	var tipBox = new TipBox({type:'load',str:"查询中...", setTime:600000, callBack:function(){ }}); 
	$.ajax({
	    type: "POST",
	    url:  "../iotsmsAction!getcardid_info.action",
	    data: {statmonth: $("#indb_date").val(),page : 1},
	    dataType : "json",  
	    success: function( json ){    
	    	tipBox.close();
	    	$("#reportTable tbody").html(""); 
	    	ul = JSON.parse( json.phoneListStr );  
	    	console.log(ul);
	    	if(ul.length==0){
	    		new TipBox({type:'tip', str:'查询无结果', clickDomCancel:true, setTime:0, hasBtn:true} ); 
	    		return false;
	    	} 
	    	for(var i in ul){
	    		$("#reportTable tbody").append("<tr><td>"+ul[i].card_id+"</td>"+
	    															"<td>"+ul[i].indb_date+"</td>"+
	    															"<td>"+ul[i].cust_id+"</td>"+
	    															"<td>"+ul[i].valid_date+"</td>"+
												    				"<td>"+ul[i].invalid_date+"</td>"+
												    				"<td>"+ul[i].state+"</td>"+
												    				"<td>"+ul[i].remark+"</td></tr>");      
	    	}
	    	console.log(json.allPage);
	    	showCustsByPage( json.allPage);
		},
		error: function(json){ 
			return false;
		}
	});  
	
}());

function showCustsByPage(allpage) {

/*	var  obj=$('.pagination').jqPagination();
    if(!(typeof obj == "undefined" || obj == null || obj == "")) {

        console.log("----remove------")
        $('.pagination').jqPagination().remove();
    }*/



	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
        current_page : 1,
		max_page :  allpage,
        page_string : '当前第{current_page}页,共{max_page}页',
		paged : function( page ) {

			console.log("------page----->"+page);
            var cust_id = $("#cust_id").val();
            var state = $("#state").val();
            var str = $("#indb_date").val().split("-");
            var statday = str[2];
            var statmonth1 = $("#indb_date").val().slice(0,7);

			$.ajax({
			    type: "POST",
			    url:  "../iotsmsAction!getcardid_info.action",

				data: {statmonth: statmonth1, statday: statday, cust_id: cust_id ,state:state,page:page},
			    dataType : "json",  
			    success: function( json ){    
			    	$("#reportTable tbody").html(""); 
			    	ul = JSON.parse( json.phoneListStr );  
			    	console.log(ul);

			    	for(var i in ul){  
			    		$("#reportTable tbody").append("<tr><td>"+ul[i].card_id+"</td>"+
			    															"<td>"+ul[i].indb_date+"</td>"+
			    															"<td>"+ul[i].cust_id+"</td>"+
			    															"<td>"+ul[i].valid_date+"</td>"+
														    				"<td>"+ul[i].invalid_date+"</td>"+
														    				"<td>"+ul[i].state+"</td>"+
														    				"<td>"+ul[i].remark+"</td></tr>");      
			    	}
				},
				error: function(json){ 
					return false;
				}
			});  
		}
	});
}  


function getCardIdInfo(){
	var tipBox = new TipBox({type:'load',str:"查询中...", setTime:600000, callBack:function(){ }}); 
	var cust_id = $("#cust_id").val();
	var state = $("#state").val();
//	if(cust_id==""){
//		new TipBox({type:'tip', str:'请输入客户编号', clickDomCancel:true, setTime:0, hasBtn:true} ); 
//		return false;
//	}
	
	var str = $("#indb_date").val().split("-");
	var statmonth = str[0]+str[1];
	var statday = str[2];
	var statmonth1 = $("#indb_date").val().slice(0,7);
	var summcnt = 0;
	var sumline = "";
	
	$.ajax({
	    type: "POST",
	    url:  "../iotsmsAction!getcardid_info.action",
	    data: {statmonth: statmonth1, statday: statday, cust_id: cust_id ,state:state,page:1},
	    dataType : "json",  
	    success: function( json ){    
	    	tipBox.close();
	    	$("#reportTable tbody").html(""); 
	    	ul = JSON.parse( json.phoneListStr );  
	    	console.log(ul);

	    	console.log("-----all------->"+json.allPage+"-----page----->"+json.page);

	    	showCustsByPage( json.allPage,json.page);

	    	if(ul.length==0){
	    		new TipBox({type:'tip', str:'查询无结果', clickDomCancel:true, setTime:0, hasBtn:true} );
	    	}
	    	for(var i in ul){  
//	    		summcnt = parseInt(summcnt) + parseInt(ul[i].diffminute);
	    		$("#reportTable tbody").append("<tr><td>"+ul[i].card_id+"</td>"+
	    															"<td>"+ul[i].indb_date+"</td>"+
	    															"<td>"+cust_id+"</td>"+
	    															"<td>"+ul[i].valid_date+"</td>"+
												    				"<td>"+ul[i].invalid_date+"</td>"+
												    				"<td>"+ul[i].state+"</td>"+
												    				"<td>"+ul[i].remark+"</td></tr>");      
	    	}
//	    	sumline = "<tr><td colspan='10'>合计</td><td>"+summcnt+"</td></tr>";
//	    	$("#reportTable tbody").append(sumline);

		},
		error: function(json){ 
			return false;
		}
	});  
	
}

function addCardId(){
	var cust_id_bak = $("#cust_id_bak").val();
	var card_number = $("#card_number").val();
	if(cust_id_bak!=""&&card_number!=""){
		$.ajax({
		    type: "POST",
		    url:  "../iotsmsAction!addcardid.action",
		    data: {cust_id: cust_id_bak, card_number: card_number},
		    dataType : "json",  
		    success: function( json ){    
		    	console.log(json.phoneListStr);
		    	if(json.phoneListStr=='0000'){
		    		console.log("0000");
		    	}  
			},
			error: function(json){ 
				return false;
			}
		});  
	}else{
		new TipBox({type:'tip', str:'请输入客户编号', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}
}