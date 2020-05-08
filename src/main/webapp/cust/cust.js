// 初始化加载客户列表 
(function(){
	new TipBox({type:'load',str:"加载中..",setTime:1000,callBack:function(){
		$.ajax({
		    type: "POST",
		    url:  "../custAction!custList.action",
		    data: { workno : sessionStorage.workno , page : 1 },
		    dataType : "json",
		    success: function( json ){
		    		ul = JSON.parse( json.custLists );
			    	$("#i_custtable tbody").html("");
			    	for(var i in ul){
			    		$("#i_custtable tbody").append("<tr>"+
			    				"<td>"+ul[i].cust_name+"</td>"+
			    				"<td>"+ul[i].id_code+"</td>"+
			    				"<td>"+ul[i].address+"</td>"+
			    				"<td>"+ul[i].contacts+"</td>"+
			    				"<td>"+ul[i].contacts_num+"</td>"+
                                "<td>"+ul[i].create_date+"</td>"+
			    				"<td>"+ul[i].if_valid+"</td>"+ 
			    				"<td><a href='#' onclick=\"editCustInit('"+ul[i].cust_id+"','"
										+ul[i].cust_name+"','"
							            +ul[i].id_code+"','"
                                        +ul[i].address+"','"
                                        +ul[i].contacts+"','"
                                        +ul[i].contacts_num+"','"
			    						+ul[i].if_valid+"')\">编辑</a></td></tr>");
			    	}
			    	showCustsByPage( json.allPage,json.page);
			},
			error: function(json){ 
				return false;
			}
		}); 
	}}); 
	   
}());   

function showCustsByPage(allpage,currentpage) {
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
        current_page: currentpage,
		max_page :  allpage,
        page_string : '当前第{current_page}页,共{max_page}页',
		paged : function( page ) {


			$.ajax({
			    type: "POST",
			    url:  "../custAction!custList.action",
			    data: { workno : sessionStorage.workno , page : page },
			    dataType : "json",
			    success: function( json ){
			    	ul = JSON.parse( json.custLists );
			    	$("#i_custtable tbody").html("");
			    	for(var i in ul){
                        $("#i_custtable tbody").append("<tr>"+
                            "<td>"+ul[i].cust_name+"</td>"+
                            "<td>"+ul[i].id_code+"</td>"+
                            "<td>"+ul[i].address+"</td>"+
                            "<td>"+ul[i].contacts+"</td>"+
                            "<td>"+ul[i].contacts_num+"</td>"+
                            "<td>"+ul[i].create_date+"</td>"+
                            "<td>"+ul[i].if_valid+"</td>"+
                            "<td><a href='#' onclick=\"editCustInit('"+ul[i].cust_id+"','"
                            +ul[i].cust_name+"','"
                            +ul[i].id_code+"','"
                            +ul[i].address+"','"
                            +ul[i].contacts+"','"
                            +ul[i].contacts_num+"','"
                            +ul[i].if_valid+"')\">编辑</a></td></tr>");
			    	}
				},
				error: function(json){ 
					return false;
				}
			}); 
		}
	});   
}  
  
 
function editCustInit(cust_id, cust_name, id_code, address,contacts,contacts_num, if_valid){
	var cust_id = escape(cust_id); 
	var cust_name = escape(cust_name); 
	var id_code = escape(id_code);
    var address = escape(address);
	var contacts = escape(contacts);
    var contacts_num = escape(contacts_num);
    var status = escape(if_valid);
	window.location.href = 'custedit.html?cust_id='+cust_id+'&cust_name='+cust_name 
						+'&id_code='+id_code +'&address='+address +'&contacts='+contacts +'&contacts_num='+contacts_num
		                +'&status='+status;
}

function custUpdate(){
	var cust_id = document.getElementById("i_custid").value;
	var cust_name = document.getElementById("i_custname").value;
    var id_code = document.getElementById("i_idcode").value;
    var address = document.getElementById("i_address").value;
    var contacts = document.getElementById("i_contacts").value;
    var contacts_num = document.getElementById("i_contactsnum").value;
	var status = document.getElementById("if_valid").checked;


    new TipBox({type:'load', str:"更新中...", setTime:1000, callBack:function(){
		$.ajax({
		    type: "POST",
		    url:  "../custAction!custUpdate.action",
		    data: { cust_id:cust_id, cust_name:cust_name,id_code:id_code,address:address,contacts:contacts,contacts_num:contacts_num,status:status },
		    dataType : "json",  
		    success: function( json ){    
		    	if(json.result == "1"){  
		    	    new TipBox({type:'success',str:'更新成功',hasBtn:true}); 
		    	} else if(json.result == "2"){
		    		new TipBox({type:'error',str:'更新失败客户姓名重复',hasBtn:true}); 
		    	} else{
		    		new TipBox({type:'error', str:'更新失败', hasBtn:true});
		    	}
			},
			error: function(json){  
				return false;
			}
		});  
	}}); 
}

function getCust(){
	var custname = document.getElementById("custname").value;   
	new TipBox({type:'load',str:"加载中..",setTime:1000,callBack:function(){ 
		$.ajax({
		    type: "POST",
		    url:  "../custAction!custsByCustname.action",
		    data: { workno: sessionStorage.workno , page : 1 , cust_name: custname},
		    dataType : "json",
		    success: function( json ){
		    		ul = JSON.parse( json.custLists );
			    	$("#i_custtable tbody").html("");
			    	for(var i in ul){

                        $("#i_custtable tbody").append("<tr>"+
                            "<td>"+ul[i].cust_name+"</td>"+
                            "<td>"+ul[i].id_code+"</td>"+
                            "<td>"+ul[i].address+"</td>"+
                            "<td>"+ul[i].contacts+"</td>"+
                            "<td>"+ul[i].contacts_num+"</td>"+
                            "<td>"+ul[i].create_date+"</td>"+
                            "<td>"+ul[i].if_valid+"</td>"+
                            "<td><a href='#' onclick=\"editCustInit('"+ul[i].cust_id+"','"
                            +ul[i].cust_name+"','"
                            +ul[i].id_code+"','"
                            +ul[i].address+"','"
                            +ul[i].contacts+"','"
                            +ul[i].contacts_num+"','"
                            +ul[i].if_valid+"')\">编辑</a></td></tr>");
			    	}

                showCustsByPage( json.allPage,json.page);
			},
			error: function(json){ 
				return false;
			}
		}); 
	}});  
}
