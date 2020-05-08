function showDealersByPage(allpage) {  
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			$.ajax({
			    type: "POST",
			    url:  "../dealerAction!dealerList.action",
			    data: { workno : sessionStorage.workno , page : page },
			    dataType : "json",  
			    success: function( json ){     
			    	ul = JSON.parse( json.dealerLists ); 
			    	$("#dealertable tbody").html(""); 
			    	for(var i in ul){ 
			    		var status;
			    		if(ul[i].if_valid==1){ status='有效'; }else{ status='失效'; }
			    		$("#dealertable tbody").append("<tr><td>"+ul[i].dealerid+"</td>"+
			    				"<td>"+ul[i].dealername+"</td>"+ 
			    				"<td>"+ul[i].cityname+"</td>"+
			    				"<td>"+ul[i].dealertype+"</td>"+
			    				"<td>"+ul[i].create_date+"</td>"+
			    				"<td>"+ul[i].create_workno+"</td>"+
			    				"<td>"+ul[i].d_idcard+"</td>"+
			    				"<td>"+ul[i].d_idaddr+"</td>"+
			    				"<td>"+ul[i].contact_phone+"</td>"+
			    				"<td>"+status+"</td>"+ 
			    				"<td><a href='#' onclick=\"editDealerInit('"  +ul[i].dealerid+"','"
			    																					   +ul[i].dealername+"','"
			    																					   +ul[i].cityname+"','"
			    																					   +ul[i].dealertype+"','"
			    																					   +ul[i].d_idcard+"','"
			    																					   +ul[i].d_idaddr+"','"
			    																					   +ul[i].contact_phone+"','"
			    																					   +status+"')\">编辑</a>&nbsp&nbsp&nbsp&nbsp&nbsp" +
			    						"<a href='dealerpay.html?dealerid="+ul[i].dealerid+"'>充值</a></td></tr>");
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
function DealerInit(){  
	$.ajax({
	    type: "POST",
	    url:  "../dealerAction!dealerList.action",
	    data: { workno : sessionStorage.workno , page : 1 },
	    dataType : "json",  
	    success: function( json ){    
	    	ul = JSON.parse( json.dealerLists ); 
	    	$("#dealertable tbody").html(""); 
	    	for(var i in ul){ 
	    		var status;
	    		if(ul[i].if_valid==1){ status='有效'; }else{ status='失效'; }
	    		$("#dealertable tbody").append("<tr><td>"+ul[i].dealerid+"</td>"+
	    				"<td>"+ul[i].dealername+"</td>"+ 
	    				"<td>"+ul[i].cityname+"</td>"+
	    				"<td>"+ul[i].dealertype+"</td>"+
	    				"<td>"+ul[i].create_date+"</td>"+
	    				"<td>"+ul[i].create_workno+"</td>"+
	    				"<td>"+ul[i].d_idcard+"</td>"+
	    				"<td>"+ul[i].d_idaddr+"</td>"+
	    				"<td>"+ul[i].contact_phone+"</td>"+
	    				"<td>"+status+"</td>"+ 
	    				"<td><a href='#' onclick=\"editDealerInit('"  +ul[i].dealerid+"','"
	    																					   +ul[i].dealername+"','"
	    																					   +ul[i].cityname+"','"
	    																					   +ul[i].dealertype+"','"
	    																					   +ul[i].d_idcard+"','"
	    																					   +ul[i].d_idaddr+"','"
	    																					   +ul[i].contact_phone+"','"
	    																					   +status+"')\">编辑</a>&nbsp&nbsp&nbsp&nbsp&nbsp" +
	    						"<a href='dealerpay.html?dealerid="+ul[i].dealerid+"'>充值</a></td></tr>");  
	    	}
	    	showDealersByPage(json.allPage);
		},
		error: function(json){ 
			return false;
		}
	});  
}; 

//按查询条件查询单代理商
function getDealer(){  
	var dealername = document.getElementById("dealername").value;  
	if( dealername!="" ){
		$.ajax({
		    type: "POST",
		    url:  "../dealerAction!dealerQuery.action",
		    data: { workno : sessionStorage.workno , dealername : dealername },
		    dataType : "json",  
		    success: function( json ){    
		    	ul = JSON.parse( json.dealerLists ); 
		    	$("#dealertable tbody").html(""); 
		    	for(var i in ul){ 
		    		var status;
		    		if(ul[i].if_valid==1){ status='有效'; }else{ status='失效'; }
		    		$("#dealertable tbody").append("<tr><td>"+ul[i].dealerid+"</td>"+
		    				"<td>"+ul[i].dealername+"</td>"+ 
		    				"<td>"+ul[i].cityname+"</td>"+
		    				"<td>"+ul[i].dealertype+"</td>"+
		    				"<td>"+ul[i].create_date+"</td>"+
		    				"<td>"+ul[i].create_workno+"</td>"+
		    				"<td>"+ul[i].d_idcard+"</td>"+
		    				"<td>"+ul[i].d_idaddr+"</td>"+
		    				"<td>"+ul[i].contact_phone+"</td>"+
		    				"<td>"+status+"</td>"+ 
		    				"<td><a href='#' onclick=\"editDealerInit('"  +ul[i].dealerid+"','"
		    																					   +ul[i].dealername+"','"
		    																					   +ul[i].cityname+"','"
		    																					   +ul[i].dealertype+"','"
		    																					   +ul[i].d_idcard+"','"
		    																					   +ul[i].d_idaddr+"','"
		    																					   +ul[i].contact_phone+"','"
		    																					   +status+"')\">编辑</a>&nbsp&nbsp&nbsp&nbsp&nbsp" +
		    				"<a href='dealerpay.html?dealerid="+ul[i].dealerid+"'>充值</a></td></tr>");    
		    	}    
		    	showDealersByPage(1);
			},
			error: function(json){ 
				return false;
			}
		}); 
	} else {
		DealerInit();
	}  
}

function dealerAddInit(){ 
	$.ajax({
	    type: "POST",
	    url:  "../sysAction!sysCityList.action",
	    data: { },
	    dataType : "json",  
	    success: function( json ){    
	    	ul = JSON.parse( json.cityLists );  
	    	for(var i in ul){  
	    		document.getElementById("citycode").options.add(new Option( ul[i].city_name, ul[i].city_code ));  
	    	}
		},
		error: function(json){ 
			return false;
		}
	}); 
	
	$.ajax({
	    type: "POST",
	    url:  "../sysAction!sysParamList.action",
	    data: { 	param_key : "SERVICE_KIND"  },
	    dataType : "json",  
	    success: function( json ){    
	    	ul = JSON.parse( json.paramLists );  
	    	for(var i in ul){ 
	    		document.getElementById("dealertype").options.add(new Option( ul[i].param_desc, ul[i].param_val ));   
	    	} 
		},
		error: function(json){ 
			return false;
		}
	}); 
}

//新增代理商
function addDealer(){  
	var dealername = document.getElementById("dealername").value;
	var citycode = $("#citycode option:selected").val();
	var dealertype = $("#dealertype option:selected").val(); 
	var d_idcard = document.getElementById("d_idcard").value;
	var d_idaddr = document.getElementById("d_idaddr").value; 
	var status = document.getElementById("status").checked; 
	var contact_phone = document.getElementById("contact_phone").value;  
	
	if(status==true){ status = "1"; } else{ status = "0"; } 
	new TipBox({type:'load', str:"处理中...", setTime:1000, callBack:function(){  
	$.ajax({
	    type: "POST",
	    url:  "../dealerAction!dealerAdd.action",
	    data: { 	workno:sessionStorage.workno , dealername:dealername,
	    			citycode:citycode , dealeraccttype:dealertype, d_idcard:d_idcard,
	    			d_idaddr:d_idaddr , status:status, contact_phone:contact_phone  },
	    dataType : "json",  
	    success: function( json ){    
	    	if( json.chargeresult == "1" ){  
	    	    new TipBox({type:'success',str:'新建成功', hasBtn:true}); 
	    	} else if( json.chargeresult == "2" ){
	    		new TipBox({type:'tip', str:'名称重复,请更换代理商名称', hasBtn:true});
	    	} else {
	    		new TipBox({type:'error', str:'新建失败', hasBtn:true});
	    	}
		},
		error: function(json){ 
			return false;
		}
	});  
	}}); 
}

// 代理商充值页面初始化
function dealerPayInit(){  
	var Request = new Object();  
	Request = GetRequest();  
	$.ajax({
	    type: "POST",
	    url:  "../dealerAction!dealerPayInit.action",
	    data: { workno : sessionStorage.workno , dealerid : Request['dealerid'] },
	    dataType : "json",  
	    success: function( json ){    
	    	ul = JSON.parse( json.dealerPayInfo );  
	    	for(var i in ul){ 
	    		document.getElementById("dealerid").value = ul[i].dealerid;
	    		document.getElementById("dealername").value = ul[i].dealername;
	    		document.getElementById("dealeracctinfo").value += ul[i].dealeracctinfo+"      ";
	    	}   
		},
		error: function(json){ 
			return false;
		}
	});  
}
 
function dealerCharge(){
	var dealerid = $("#dealerid").val();   
	var dealeraccttype = $("#dealeraccttype option:selected").val() ; 
	var amount = $("#amount").val();  
	if( amount<100 ){
		new TipBox({type:'tip',str:'输入金额不能小于100',hasBtn:true}); 
		return false;
	}
	new TipBox({type:'load', str:"处理中...", setTime:1000, callBack:function(){  
		$.ajax({
		    type: "POST",
		    url:  "../dealerAction!dealerCharge.action",
		    data: { workno : sessionStorage.workno , dealerid : dealerid, 
		    	dealeraccttype : dealeraccttype, amount : amount },
		    dataType : "json",  
		    success: function( json ){     
		    	if(json.chargeresult == "1"){ 
		    		document.getElementById("dealeracctinfo").value = "";
		    		dealerPayInit();
		    	    new TipBox({type:'success',str:'充值成功',hasBtn:true}); 
		    	} else{
		    		new TipBox({type:'error', str:'充值失败', hasBtn:true});
		    	}
			},
			error: function(json){ 
				return false;
			}
		});  
	}}); 
}

function editDealerInit(dealerid, dealername, cityname, dealertype, d_idcard, d_idaddr, contact_phone, status){     
	var dealername = escape(dealername);
	var cityname = escape(cityname);
	var dealertype = escape(dealertype);
	var d_idcard = escape(d_idcard);
	var d_idaddr = escape(d_idaddr);
	var contact_phone = escape(contact_phone);
	var status = escape(status);  
	window.location.href = 'dealeredit.html?dealerid='+dealerid+'&dealername='+dealername
									+'&cityname='+cityname +'&dealertype='+dealertype
									+'&d_idcard='+d_idcard +'&d_idaddr='+d_idaddr+'&contact_phone='+contact_phone+'&status='+status ; 
}

function dealerUpdate(){
	var dealerid = document.getElementById("dealerid").value;
	var dealername = document.getElementById("dealername").value; 
	var d_idcard = document.getElementById("d_idcard").value;
	var d_idaddr = document.getElementById("d_idaddr").value; 
	var status = document.getElementById("status").checked; 
	var contact_phone = document.getElementById("contact_phone").value;
	
	new TipBox({type:'load', str:"更新中...", setTime:1000, callBack:function(){  
		$.ajax({
		    type: "POST",
		    url:  "../dealerAction!dealerUpdate.action",
		    data: { workno:sessionStorage.workno, dealerid:dealerid, dealername:dealername, 
		    	d_idcard:d_idcard, d_idaddr:d_idaddr, status:status, contact_phone:contact_phone },
		    dataType : "json",  
		    success: function( json ){     
		    	if(json.chargeresult == "1"){  
		    	    new TipBox({type:'success',str:'更新成功',hasBtn:true}); 
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
