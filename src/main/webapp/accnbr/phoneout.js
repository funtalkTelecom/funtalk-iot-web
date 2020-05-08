// 初始化加载客户列表 
(function(){ 
	// 获取号码归属地市接口
	$.ajax({
	    type: "POST",
	    url:  "../phoneAction!phoneCityList.action",
	    data: { workno : sessionStorage.workno },
	    dataType : "json",  
	    success: function( json ){     
    		ul = JSON.parse( json.phoneCityListStr );  
    		document.getElementById("cityList").innerHTML = "";
	    	document.getElementById("cityList").options.add(new Option( "请选择号码地市", "0" ));  
	    	for(var i in ul){  
	    		document.getElementById("cityList").options.add(new Option( ul[i].city_name, ul[i].city_code ));  
	    	}  
		},
		error: function(json){ 
			return false;
		}
	}); 
	
	// 获取所有代理商接口
	$.ajax({
	    type: "POST",
	    url:  "../dealerAction!dealerQueryByWorkno.action",
	    data: { page:1, workno:sessionStorage.workno },
	    dataType : "json",  
	    success: function( json ){    
	    	ul = JSON.parse( json.dealerLists );   
	    	document.getElementById("dealerid").options.add(new Option( "请选择", "0" ));  
	    	for(var i in ul){ 
	    		document.getElementById("dealerid").options.add(new Option( ul[i].dealername, ul[i].dealerid ));   
	    	} 
		},
		error: function(json){ 
			return false;
		}
	});   
   
}()); 

function filtDealer(){  
	$.ajax({
	    type: "POST",
	    url:  "../dealerAction!dealerQuery.action",
	    data: { dealername: document.getElementById("search_dealer").value, workno:sessionStorage.workno },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.dealerLists );   
	    	document.getElementById("dealerid").options.length=0; 
	    	document.getElementById("dealerid").options.add(new Option( "请选择", "0" )); 
	    	for(var i in ul){ 
	    		document.getElementById("dealerid").options.add(new Option( ul[i].dealername, ul[i].dealerid ));   
	    	} 
		},
		error: function(json){ 
			return false;
		}
	});
}

function getCustInfo(){ 
	var dealerid = $("#dealerid option:selected").val();   
	$.ajax({
	    type: "POST",
	    url:  "../custAction!custListByDealerid.action",
	    data: { dealerid: dealerid },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.custLists );   
	    	document.getElementById("cust_id").options.length=0; 
	    	for(var i in ul){ 
	    		document.getElementById("cust_id").options.add(new Option( ul[i].cust_name, ul[i].cust_id ));   
	    	} 
		},
		error: function(json){ 
			return false;
		}
	});  
} 

function getPhoneList(){  
	var phone_type = $("#phone_type option:selected").val();	 
	if( phone_type=="0" ){
		new TipBox({type:'tip', str:'请选择号码类型', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}
	var citycode = $("#cityList option:selected").val();	
	if(citycode=="0") { citycode="%"; }
	
	$.ajax({
	    type: "POST",
	    url:  "../phoneAction!phoneList.action",
	    data: { workno:sessionStorage.workno , page:1, phone_type:phone_type, use_type:'0', citycode:citycode },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.phoneListStr ); 
	    	$("#phonetable tbody").html(""); 
	    	for(var i in ul){ 
	    		var status;
	    		if(ul[i].status==0){ status='可用'; } else if(ul[i].status==1){ status='已用'; } else if(ul[i].status==2){ status='失效'; }
	    		$("#phonetable tbody").append("<tr><td><input value='"+ul[i].phone_number+"' name='phones' type='checkbox' /></td>"+
	    				"<td>"+ul[i].phone_type+"</td>"+
	    				"<td>"+ul[i].city_name+"</td>"+
	    				"<td>"+ul[i].phone_number+"</td>"+
	    				"<td>"+status+"</td></tr>"  );    
	    	}
	    	showPhonesByPage(json.allPage, phone_type); 
		},
		error: function(json){ 
			return false;
		}
	}); 
} 

function showPhonesByPage(allpage, phone_type) {    
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			$.ajax({
			    type: "POST",
			    url:  "../phoneAction!phoneList.action",
			    data: { workno : sessionStorage.workno , page:page , phone_type:phone_type, use_type:'0'},
			    dataType : "json",  
			    success: function( json ){     
			    	ul = JSON.parse( json.phoneListStr ); 
			    	$("#phonetable tbody").html(""); 
			    	for(var i in ul){ 
			    		var status;
			    		if(ul[i].status==0){ status='可用'; } else if(ul[i].status==1){ status='已用'; } else if(ul[i].status==2){ status='失效'; }
			    		$("#phonetable tbody").append("<tr><td><input value='"+ul[i].phone_number+"' name='phones' type='checkbox' /></td>"+
			    				"<td>"+ul[i].phone_type+"</td>"+
			    				"<td>"+ul[i].city_name+"</td>"+
			    				"<td>"+ul[i].phone_number+"</td>"+
			    				"<td>"+status+"</td></tr>"  );     
			    	}
				},
				error: function(json){ 
					return false;
				}
			}); 
		}
	});   
}  

function select_all(){ 
	var state = $("#select_all").prop("checked");  
	$("input[name='phones']").prop( "checked", state ); 
}  

function phone_out(){
	var use_type = $("#use_type option:selected").val();	  
	var cust_id = $("#cust_id option:selected").val();	 
	if( cust_id=="0" || typeof(cust_id) == "undefined"  ){
		new TipBox({type:'tip', str:'请选择分配客户', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}
	
	var phoneobjs = document.getElementsByName("phones"); 
	var check_val = []; 
    for( k in phoneobjs ){ if(phoneobjs[k].checked){ check_val.push( "'"+phoneobjs[k].value+"'"); } }   
    var selected_phone_list = check_val.join(",");
    if(selected_phone_list==""){
    	new TipBox({type:'tip', str:'请勾选分配号码', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
    } 
    
    // 调用号码分配action  获取到的号码列表selected_phone_list格式为 '18189950001', '18189950002', '18189950003' 
    $.ajax({
	    type: "POST",
	    url:  "../phoneAction!phoneOut.action",
	    data: { workno:sessionStorage.workno, phone_number:selected_phone_list, cust_id: cust_id, use_type:use_type },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.phoneListStr ); 
	    	if( json.result=="1" ){
	    		new TipBox({type:'success',str:'号码分配成功', hasBtn:true});
	    		getPhoneList();
	    	} else{
	    		new TipBox({type:'error',str: json.result,hasBtn:true});
	    	}
		},
		error: function(json){ 
			return false;
		}
	}); 
    
} 
 
 