function showUsersByPage(allpage) {    
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page ) {   
			$.ajax({
			    type: "POST",
			    url:  "../userAction!userList.action",
			    data: { workno : sessionStorage.workno , page : page },
			    dataType : "json",  
			    success: function( json ){     
			    	ul = JSON.parse( json.userLists ); 
			    	$("#usertable tbody").html(""); 
			    	for(var i in ul){
			    		var status;
			    		if(ul[i].if_valid==1){ status='有效'; }else{ status='失效'; }
			    		$("#usertable tbody").append("<tr><td>"+ul[i].employeeid+"</td>"+
							    				"<td>"+ul[i].employeename+"</td>"+
							    				"<td>"+ul[i].workno+"</td>"+
							    				"<td>"+ul[i].cityname+"</td>"+
							    				"<td>"+ul[i].create_workno+"</td>"+ 
							    				"<td>"+ul[i].create_date+"</td>"+
							    				"<td>"+ul[i].dealername+"</td>"+
							    				"<td>"+ul[i].e_idcard+"</td>"+
							    				"<td>"+ul[i].e_idaddr+"</td>"+
							    				"<td>"+ul[i].contact_phone+"</td>"+
							    				"<td>"+status+"</td>"+
							    				"<td>"+ul[i].last_login_time+"</td>"+
							    				"<td><a href='#' onclick=\"editUserInit('"  +ul[i].userid+"','"
												   +ul[i].username+"','"
												   +ul[i].workno+"','"
												   +ul[i].workpwd+"','" 
												   +ul[i].cityname+"','"
												   +ul[i].dealername+"','"
												   +ul[i].e_idcard+"','"
												   +ul[i].e_idaddr+"','"
												   +ul[i].contact_phone+"','"
												   +status+"')\">编辑</a></td></tr>");      
			    	}
				},
				error: function(json){ 
					return false;
				}
			}); 
		}
	});   
	
}  

// 初始化加载用户列表
function UserInit(){  
	$.ajax({
	    type: "POST",
	    url:  "../userAction!userList.action",
	    data: { workno : sessionStorage.workno , page : 1 },
	    dataType : "json",  
	    success: function( json ){    
	    	ul = JSON.parse( json.userLists ); 
	    	$("#usertable tbody").html(""); 
	    	for(var i in ul){ 
	    		var status;
	    		if(ul[i].if_valid==1){ status='有效'; }else{ status='失效'; }
	    		$("#usertable tbody").append("<tr><td>"+ul[i].employeeid+"</td>"+
	    				"<td>"+ul[i].employeename+"</td>"+
	    				"<td>"+ul[i].workno+"</td>"+
	    				"<td>"+ul[i].cityname+"</td>"+
	    				"<td>"+ul[i].create_workno+"</td>"+ 
	    				"<td>"+ul[i].create_date+"</td>"+
	    				"<td>"+ul[i].dealername+"</td>"+
	    				"<td>"+ul[i].e_idcard+"</td>"+
	    				"<td>"+ul[i].e_idaddr+"</td>"+
	    				"<td>"+ul[i].contact_phone+"</td>"+
	    				"<td>"+status+"</td>"+
	    				"<td>"+ul[i].last_login_time+"</td>"+
	    				"<td><a href='#' onclick=\"editUserInit('"  +ul[i].employeeid+"','"
																						   +ul[i].employeename+"','"
																						   +ul[i].workno+"','"
																						   +ul[i].workpwd+"','" 
																						   +ul[i].cityname+"','"
																						   +ul[i].dealername+"','"
																						   +ul[i].e_idcard+"','"
																						   +ul[i].e_idaddr+"','"
																						   +ul[i].contact_phone+"','"
																						   +status+"')\">编辑</a></td></tr>");    
	    	}
	    	showUsersByPage(json.allPage);
		},
		error: function(json){ 
			return false;
		}
	}); 
}; 

//按查询条件查询单用户
function getUser(){ 
	var username = document.getElementById("username").value;  
	if( username!="" ){
		$.ajax({
		    type: "POST",
		    url:  "../userAction!userQuery.action",
		    data: { workno : sessionStorage.workno , username : username },
		    dataType : "json",  
		    success: function( json ){    
		    	ul = JSON.parse( json.userLists ); 
		    	$("#usertable tbody").html(""); 
		    	for(var i in ul){ 
		    		var status;
		    		if(ul[i].if_valid==1){ status='有效'; }else{ status='失效'; }
		    		$("#usertable tbody").append("<tr><td>"+ul[i].employeeid+"</td>"+
		    				"<td>"+ul[i].employeename+"</td>"+
		    				"<td>"+ul[i].workno+"</td>"+
		    				"<td>"+ul[i].cityname+"</td>"+
		    				"<td>"+ul[i].create_workno+"</td>"+ 
		    				"<td>"+ul[i].create_date+"</td>"+
		    				"<td>"+ul[i].dealername+"</td>"+
		    				"<td>"+ul[i].e_idcard+"</td>"+
		    				"<td>"+ul[i].e_idaddr+"</td>"+
		    				"<td>"+ul[i].contact_phone+"</td>"+
		    				"<td>"+status+"</td>"+
		    				"<td>"+ul[i].last_login_time+"</td>"+
		    				"<td><a href='#' onclick=\"editUserInit('"  +ul[i].employeeid+"','"
																							   +ul[i].employeename+"','"
																							   +ul[i].workno+"','"
																							   +ul[i].workpwd+"','" 
																							   +ul[i].cityname+"','"
																							   +ul[i].dealername+"','"
																							   +ul[i].e_idcard+"','"
																							   +ul[i].e_idaddr+"','"
																							   +ul[i].contact_phone+"','"
																							   +status+"')\">编辑</a></td></tr>");  
		    	}    
		    	showUsersByPage(1);
			},
			error: function(json){ 
				return false;
			}
		}); 
	} else {
		UserInit();
	}  
}

function userAddInit(){  
	$.ajax({
	    type: "POST",
	    url:  "../dealerAction!dealerListAll.action",
	    data: { dealername:"" },
	    dataType : "json",  
	    success: function( json ){    
	    	ul = JSON.parse( json.dealerLists );   
	    	for(var i in ul){ 
	    		document.getElementById("dealerid").options.add(new Option( ul[i].dealername, ul[i].dealerid ));   
	    	} 
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
	    data: { dealername:document.getElementById("search_dealer").value },
	    dataType : "json",  
	    success: function( json ){    
	    	ul = JSON.parse( json.dealerLists );   
	    	document.getElementById("dealerid").options.length=0; 
	    	for(var i in ul){ 
	    		document.getElementById("dealerid").options.add(new Option( ul[i].dealername, ul[i].dealerid ));   
	    	} 
		},
		error: function(json){ 
			return false;
		}
	});
}

//添加用户
function addUser(){ 
	var workno = document.getElementById("workno").value;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value; 
	var dealerid = $("#dealerid option:selected").val(); 
	var e_idcard = document.getElementById("e_idcard").value;
	var e_idaddr = document.getElementById("e_idaddr").value; 
	var contact_phone = document.getElementById("contact_phone").value; 
	var status = document.getElementById("status").checked;  
	if(status==true){ status = "1"; } else{ status = "0"; } 
	 
	new TipBox({type:'load', str:"处理中...", setTime:1000, callBack:function(){  
		$.ajax({
		    type: "POST",
		    url:  "../userAction!userAdd.action",
		    data: { 	create_workno:sessionStorage.workno , workno:workno, 
		    			username:username, password:password, dealerid:dealerid, 
		    			e_idcard:e_idcard, e_idaddr:e_idaddr , status:status, contact_phone:contact_phone  },
		    dataType : "json",  
		    success: function( json ){    
		    	if( json.result == "1" ){  
		    	    new TipBox({type:'success',str:'新建成功', hasBtn:true}); 
		    	} else if( json.result == "2" ){
		    		new TipBox({type:'tip', str:'员工工号重复, 请更换工号再试', hasBtn:true});
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

function editUserInit(userid, username, workno, workpwd, cityname, dealername, 
		e_idcard, e_idaddr, contact_phone, status){
	var userid = escape(userid);
	var username = escape(username);
	var workno = escape(workno);
	var workpwd = escape(workpwd);
	var cityname = escape(cityname);
	var dealername = escape(dealername);
	var e_idcard = escape(e_idcard);
	var e_idaddr = escape(e_idaddr);
	var contact_phone = escape(contact_phone);
	var status = escape(status);  
	window.location.href = 'useredit.jsp?userid='+userid+'&username='+username
									+'&workno='+workno +'&workpwd='+workpwd
									+'&cityname='+cityname +'&dealername='+dealername 
									+'&e_idcard='+e_idcard +'&e_idaddr='+e_idaddr
									+'&contact_phone='+contact_phone+'&status='+status ;
}

function userUpdate(){  
	var userid = document.getElementById("userid").value;
	var username = document.getElementById("username").value; 
	var password = document.getElementById("workpwd").value;
	var e_idcard = document.getElementById("e_idcard").value; 
	var e_idaddr = document.getElementById("e_idaddr").value; 
	var status = document.getElementById("status").checked; 
	if(status==true){ status = "1"; } else{ status = "0"; } 
	var contact_phone = document.getElementById("contact_phone").value;  
	  
	new TipBox({type:'load', str:"更新中...", setTime:1000, callBack:function(){  
		$.ajax({
		    type: "POST",
		    url:  "../userAction!userUpdate.action",
		    data: { userid:userid, username:username, password:password, 
		    	e_idcard:e_idcard, e_idaddr:e_idaddr, status:status, contact_phone:contact_phone },
		    dataType : "json",  
		    success: function( json ){    
		    	if(json.result == "1"){  
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

