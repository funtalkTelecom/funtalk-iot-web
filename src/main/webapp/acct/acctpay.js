// 初始化加载客户列表 
(function(){

    var Request = new Object();
    Request = GetRequest();
    var custname = Request['custname'];

	$.ajax({
	    type: "POST",
	    url:  "../custAction!custsByCustname.action",
	    data: { workno: sessionStorage.workno , page: 1,cust_name:custname },
	    dataType : "json",
	    success: function( json ){
	    		ul = JSON.parse( json.custLists );
	    		document.getElementById("custname").innerHTML = "";
		    	document.getElementById("custname").options.add(new Option( "请选择客户", "0" ));
		    	for(var i in ul){
		    		document.getElementById("custname").options.add(new Option( ul[i].cust_name, ul[i].cust_id ));
		    	}

		    	detypeul = JSON.parse( json.detypeLists );
		    	document.getElementById("accttype").innerHTML = "";

			    for(var i in detypeul){
                     document.getElementById("accttype").options.add(new Option( detypeul[i].remark, detypeul[i].key_value ));
			    }
		},
		error: function(json){
			return false;
		}
	});  
	   
}()); 

function addAcct(){
	var custid = $("#custname option:selected").val();
	if(custid=="0" || custid=="" || typeof(custid) == "undefined" ){
		new TipBox({type:'tip', str:'请选择客户', clickDomCancel:true, setTime:0, hasBtn:true} );
		return false;
	}
	
	var accttype = $("#accttype option:selected").val();
	
	var if_valid = document.getElementById("if_valid").checked;
	if(if_valid==true){ if_valid = "1"; } else{ if_valid = "0"; }
	
	var fee = $("#fee").val();
	if( fee<100 ){
		new TipBox({type:'tip',str:'输入金额不能小于100',hasBtn:true});
		return false;
	}
	 
	new TipBox({type:'load', str:"更新中...", setTime:1000, callBack:function(){  
		$.ajax({
		    type: "POST",
		    url:  "../acctAction!acctAdd.action", 
		    data: { custid:custid, accttype:accttype, fee:fee, workno:sessionStorage.workno, if_valid:if_valid },
		    dataType : "json",  
		    success: function( json ){    
		    	if(json.result == "1"){
		    	    new TipBox({type:'success',str:'新建账户成功',hasBtn:true});
		    	} else if(json.result == "2"){
		    		new TipBox({type:'error',str:'新建账户失败重复',hasBtn:true});
		    	} else{
		    		new TipBox({type:'error', str: json.result , hasBtn:true});
		    	}
			},
			error: function(json){
				return false;
			}
		});  
	}}); 
}


function acctCharge(){

    var custid = $("#custname option:selected").val();
    if(custid=="0" || custid=="" || typeof(custid) == "undefined" ){
        new TipBox({type:'tip', str:'请选择客户', clickDomCancel:true, setTime:0, hasBtn:true} );
        return false;
    }

    var accttype = $("#accttype option:selected").val();
    if(accttype=="" || typeof(accttype) == "undefined" ){
        new TipBox({type:'tip', str:'请选择账本类型', clickDomCancel:true, setTime:0, hasBtn:true} );
        return false;
    }

    var fee = $("#fee").val();

    var isNum=/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;

    if(!isNum.test(fee)) {
        new TipBox({type:'tip', str:'请输入正确的金额格式', clickDomCancel:true, setTime:0, hasBtn:true} );
        return false;
    }

    $.ajax({
        type: "POST",
        url:  "../acctAction!acctCharge.action",
        data: { custid:custid,  accttype:accttype, fee:fee, workno: sessionStorage.workno  },
        dataType : "json",
        success: function( json ){
            if(json.result == "1"){
                new TipBox({type:'success',str:'账户充值成功',hasBtn:true});

            } else{
                new TipBox({type:'error', str:'账户充值失败', hasBtn:true});
            }
        },
        error: function(json){
            return false;
        }
    });
}
 