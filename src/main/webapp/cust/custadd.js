
function filtDealer(){
	$.ajax({
	    type: "POST",
	    url:  "../dealerAction!dealerQuery.action",
	    data: { dealername:document.getElementById("search_dealer").value , workno:sessionStorage.workno },
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

//添加客户
function addCust(){  
	var workno = sessionStorage.workno; 
	var cust_name = document.getElementById("cust_name").value;
    var id_code = document.getElementById("id_code").value;
    var address = document.getElementById("address").value;
    var contacts = document.getElementById("contacts").value;
    var contacts_num = document.getElementById("contacts_num").value;
    var status = document.getElementById("status").checked;

    if( cust_name==""){
		new TipBox({type:'tip', str:'请输入公司名称', clickDomCancel:true, setTime:0, hasBtn:true} );
		return false;
	}
    if( id_code==""){
        new TipBox({type:'tip', str:'请输入公司营业执照', clickDomCancel:true, setTime:0, hasBtn:true} );
        return false;
    }
    if( address==""){
        new TipBox({type:'tip', str:'请输入公司地址', clickDomCancel:true, setTime:0, hasBtn:true} );
        return false;
    }
    if( contacts==""){
        new TipBox({type:'tip', str:'请输入联系人', clickDomCancel:true, setTime:0, hasBtn:true} );
        return false;
    }
    if( contacts_num==""){
        new TipBox({type:'tip', str:'请输入联系人电话', clickDomCancel:true, setTime:0, hasBtn:true} );
        return false;
    }

	if(status==true){ status = "1"; } else{ status = "0"; } 

	 
	new TipBox({type:'load', str:"处理中...", setTime:1000, callBack:function(){  
		$.ajax({
		    type: "POST",
		    url:  "../custAction!custAdd.action",
		    data: { cust_name:cust_name,workno:workno,id_code:id_code,address:address,contacts:contacts,contacts_num:contacts_num,status:status},
		    dataType : "json",  
		    success: function( json ){
		    	if( json.result == "1" ){  
		    	    new TipBox({type:'success',str:'新建成功', hasBtn:true}); 
		    	} else if( json.result == "2" ){
		    		new TipBox({type:'tip', str:'客户姓名重复, 请更换客户姓名再试', hasBtn:true});
		    	} else if( json.result == "9" ){
		    		new TipBox({type:'tip', str:'一个代理商下只能创建一个客户', hasBtn:true});
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
