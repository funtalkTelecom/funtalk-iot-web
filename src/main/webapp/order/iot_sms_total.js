function showOrdersByPage(allpage) {  
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page) {  
			OrderInit(page);
		}
	});   
}  


var OrderInit = function(page){  
	var tipBox = new TipBox({type:'load',str:"查询中...", setTime:600000, callBack:function(){ }}); 
	$.ajax({
	    type: "POST",
	    url:  "../iotsmsAction!totalList.action",
	    data: {page : page}, 
	    dataType : "json",  
	    success: function( json ){   
	    	tipBox.close();	    	
	    	var ultaskinfo = JSON.parse( json.addressLists );   
	    	$("#addressListTable tbody").html(""); 
	    	for(var i in ultaskinfo){ 
	    		$("#addressListTable tbody").append('<tr><td>'
						+ ultaskinfo[i].service_id + '</td>'
						+ '<td>' + ultaskinfo[i].use_cnt + '</td>'
						+ '<td>' + ultaskinfo[i].cnt
						+ '</td></tr>'); 
	    	}  
	    	
	    	showOrdersByPage(json.allPage);
		},
		error: function(json){ 
			return false;
		}
	});  
};  
OrderInit(1);