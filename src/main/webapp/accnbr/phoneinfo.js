// 初始化加载产品列表 
(function(){   
	document.getElementById("dealertr").style.visibility="hidden";
	document.getElementById("custtr").style.visibility="hidden";
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
	    data: { page:1 , workno:sessionStorage.workno },
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


function showPhoneInfoByPage(allpage) {    
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			var workno = sessionStorage.workno;   
			var custid = $("#custid option:selected").val();
			var phone_type = $("#phone_type option:selected").val();	 
			var citycode = $("#cityList option:selected").val();	 
			var phone_status = $("#phone_status option:selected").val();	 
			var use_type = $("#use_type option:selected").val();	 
			
			if( custid=="0" || custid=="" || typeof(custid) == "undefined" ){  custid = "%"; }
			if(phone_type=="0") { phone_type="%"; }
			if(citycode=="0")		  { citycode="%"; }
			if(phone_status=="X") { phone_status="%"; }
			if(use_type=="X") { use_type="%"; }
			$.ajax({
			    type: "POST",
			    url:  "../phoneAction!phoneInfoLists.action",
			    data: { 	workno:workno, page:page, phone_type:phone_type, citycode:citycode, 
			    			phone_status:phone_status, use_type:use_type, cust_id:custid },
			    dataType : "json",  
			    success: function( json ){      
			    	var use_type = "";
			    	var status = "";
			    	var if_valid = "";
		    		ul = JSON.parse( json.phoneListStr );  
		    		$("#i_phonetable tbody").html(""); 
			    	for(var i in ul){ 
			    		if(ul[i].use_type=="1"){ use_type = "个人客户"; } else if(ul[i].use_type=="0"){ use_type = "企业客户"; } else{ use_type = "未分配"; }
			    		if(ul[i].status=="0"){ status = "可用"; } else if(ul[i].status=="1"){ status = "已用"; } else if(ul[i].status=="-1"){ status = "临时占用"; } 
			    		if(ul[i].if_valid=="1"){ if_valid = "有效"; } else if(ul[i].if_valid=="0"){ if_valid = "无效"; }else if(ul[i].if_valid=="2"){ if_valid = "停机"; }
			    		$("#i_phonetable tbody").append("<tr><td>"+ul[i].city_name+"</td>"+
			    				"<td>"+use_type+"</td>"+
			    				"<td>"+ul[i].phone_type+"</td>"+
			    				"<td>"+ul[i].phone_number+"</td>"+
			    				"<td>"+ul[i].phone_belong+"</td>"+
			    				"<td>"+status+"</td>"+
			    				"<td>"+if_valid+"</td>"+
			    				"<td>"+ul[i].subid+"</td></tr>");     
			    	}
				},
				error: function(json){ 
					return false;
				}
			}); 
		}
	});   
} 

function phoneinfo(){
	var workno = sessionStorage.workno;   
	var custid = $("#custid option:selected").val();
	var phone_type = $("#phone_type option:selected").val();	 
	var citycode = $("#cityList option:selected").val();	 
	var phone_status = $("#phone_status option:selected").val();	 
	var use_type = $("#use_type option:selected").val();	 
	
	if( custid=="0" || custid=="" || typeof(custid) == "undefined" ){  custid = "%"; }
	if(phone_type=="0") { phone_type="%"; }
	if(citycode=="0")		  { citycode="%"; }
	if(phone_status=="X") { phone_status="%"; }
	if(use_type=="X") { use_type="%"; }
	 
	$.ajax({
	    type: "POST",
	    url:  "../phoneAction!phoneInfoLists.action",
	    data: { 	workno:workno, page:1, phone_type:phone_type, citycode:citycode, 
	    			phone_status:phone_status, use_type:use_type, cust_id:custid },
	    dataType : "json",  
	    success: function( json ){      
	    	var use_type = "";
	    	var status = "";
	    	var if_valid = "";
    		ul = JSON.parse( json.phoneListStr );  
    		$("#i_phonetable tbody").html(""); 
	    	for(var i in ul){ 
	    		if(ul[i].use_type=="1"){ use_type = "个人客户"; } else if(ul[i].use_type=="0"){ use_type = "企业客户"; } else{ use_type = "未分配"; }
	    		if(ul[i].status=="0"){ status = "可用"; } else if(ul[i].status=="1"){ status = "已用"; } else if(ul[i].status=="-1"){ status = "临时占用"; } 
	    		if(ul[i].if_valid=="1"){ if_valid = "有效"; } else if(ul[i].if_valid=="0"){ if_valid = "无效"; }else if(ul[i].if_valid=="2"){ if_valid = "停机"; }
	    		$("#i_phonetable tbody").append("<tr><td>"+ul[i].city_name+"</td>"+
	    				"<td>"+use_type+"</td>"+
	    				"<td>"+ul[i].phone_type+"</td>"+
	    				"<td>"+ul[i].phone_number+"</td>"+
	    				"<td>"+ul[i].phone_belong+"</td>"+
	    				"<td>"+status+"</td>"+
	    				"<td>"+if_valid+"</td>"+
	    				"<td>"+ul[i].subid+"</td></tr>");     
	    	} 
	    	document.getElementById("total_cnt").innerHTML = json.allPage*30 ;  
	    	showPhoneInfoByPage( json.allPage );
		},
		error: function(json){ 
			return false;
		}
	});  
}

function filtDealer(){ 
	$.ajax({
	    type: "POST",
	    url:  "../dealerAction!dealerQuery.action",
	    data: { dealername:document.getElementById("search_dealer").value, workno:sessionStorage.workno },
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
	    	document.getElementById("custid").options.length=0; 
	    	for(var i in ul){ 
	    		document.getElementById("custid").options.add(new Option( ul[i].cust_name, ul[i].cust_id ));   
	    	} 
		},
		error: function(json){ 
			return false;
		}
	});  
} 

function filtCust(){ 
	var dealerid = $("#dealerid option:selected").val(); 
	if( dealerid=="0" ){ 
		new TipBox({type:'tip', str:'请选择归属代理商', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false; }
	$.ajax({
	    type: "POST",
	    url:  "../custAction!custQuery.action",
	    data: { dealerid: dealerid, cust_name: document.getElementById("search_cust").value },
	    dataType : "json",  
	    success: function( json ){    
	    	ul = JSON.parse( json.custLists );   
	    	document.getElementById("custid").options.length=0; 
	    	for(var i in ul){ 
	    		document.getElementById("custid").options.add(new Option( ul[i].cust_name, ul[i].cust_id ));   
	    	} 
		},
		error: function(json){ 
			return false;
		}
	});
}

function useTypeChange(){ 
	var use_type = $("#use_type option:selected").val();  
	if(use_type=="0"){
		document.getElementById("dealertr").style.visibility="visible";
		document.getElementById("custtr").style.visibility="visible"; 
	}else{
		document.getElementById("dealertr").style.visibility="hidden";
		document.getElementById("custtr").style.visibility="hidden";
	}
}

