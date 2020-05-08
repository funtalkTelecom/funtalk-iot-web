(function(){
	new TipBox({type:'load', str:"初始化信息...", setTime:1000,
		callBack:function(){
            getAcct();
	}});

}());


function getAcct() {

    var custname = document.getElementById("custname").value;

    $.ajax({
        type: "POST",
        url:  "../acctAction!acctInfoByCustname.action",
        data: { custname:custname, workno: sessionStorage.workno },
        dataType : "json",
        success: function( json ){

            console.log("-------->"+json);
            ul = JSON.parse( json.acctLists );
            $("#i_accttable tbody").html("");
            for(var i in ul){
                var custname = escape(ul[i].custname);

                $("#i_accttable tbody").append("<tr>"+
                    "<td align=\"center\">"+ul[i].custname+"</td>"+
                    "<td>"+ul[i].acctid+"</td>"+
                    "<td>"+ul[i].depositname+"</td>"+
                    "<td>"+ul[i].limitmoney+"</td>"+
                    "<td>"+ul[i].availmoney+"</td>"+
                    "<td>"+ul[i].createdate+"</td>"+
                    "</tr>"  );
            }

            console.log("---page---"+json.page+"------allpages-----"+json.allPage);


          //  showAcctsByPage(json.allPage,json.page);   最多一级嵌套 ，否则像这种调用页面报错，pagination is not a function；

            $('.pagination').jqPagination({
                link_string :  '/?page={page_number}',
                current_page: json.page,
                max_page :  json.allPage,
                page_string : '当前第{current_page}页,共{max_page}页',
                paged : function( page ) {

                    var custname = document.getElementById("custname").value;

                    $.ajax({
                        type: "POST",
                        url:  "../acctAction!acctInfoByCustname.action",
                        data: { custname:custname, workno: sessionStorage.workno,page : page },
                        dataType : "json",
                        success: function( json ){

                            console.log("-------->"+json);
                            ul = JSON.parse( json.acctLists );
                            $("#i_accttable tbody").html("");
                            for(var i in ul){
                                var custname = escape(ul[i].custname);

                                $("#i_accttable tbody").append("<tr>"+
                                    "<td align=\"center\">"+ul[i].custname+"</td>"+
                                    "<td>"+ul[i].acctid+"</td>"+
                                    "<td>"+ul[i].depositname+"</td>"+
                                    "<td>"+ul[i].limitmoney+"</td>"+
                                    "<td>"+ul[i].availmoney+"</td>"+
                                    "<td>"+ul[i].createdate+"</td>"+
                                    "</tr>"  );
                            }
                        },
                        error: function(json){
                            return false;
                        }
                    });
                }
            });
        },
        error: function(json){
            return false;
        }
    });

}


function showAcctsByPage(allpage,currentpage){

    $('.pagination').jqPagination({
        link_string :  '/?page={page_number}',
        current_page: currentpage,
        max_page :  allpage,
        page_string : '当前第{current_page}页,共{max_page}页',
        paged : function( page ) {

            console.log("------page----->"+page);
            $.ajax({
                type: "POST",
                url:  "../acctAction!acctInfoByCustname.action",
                data: { custname:custname, workno: sessionStorage.workno },
                dataType : "json",
                success: function( json ){


                    console.log("-------->"+json);
                    ul = JSON.parse( json.acctLists );
                    $("#i_accttable tbody").html("");
                    for(var i in ul){
                        var custname = escape(ul[i].custname);

                        $("#i_accttable tbody").append("<tr>"+
                            "<td align=\"center\">"+ul[i].custname+"</td>"+
                            "<td>"+ul[i].acctid+"</td>"+
                            "<td>"+ul[i].depositname+"</td>"+
                            "<td>"+ul[i].limitmoney+"</td>"+
                            "<td>"+ul[i].availmoney+"</td>"+
                            "<td>"+ul[i].createdate+"</td>"+
                            "</tr>"  );
                    }
                },
                error: function(json){
                    return false;
                }
            });
        }
    });
}



function acctChargeInit(){
	var Request = new Object();  
	Request = GetRequest();  
	var custname = Request['custname'];

	
	$.ajax({
	    type: "POST",
	    url:  "../acctAction!acctInfoByAccountid.action",
	    data: { cust_name: custname },
	    dataType : "json",  
	    success: function( json ){
	    	ul = JSON.parse( json.acctLists ); 
	    	$("#acctinfo").val("");
	    	var acctinfo = "|";
	    	var accttype = "未知";
	    	var if_valid = "失效";
	    	for(var i in ul){
	    		if(ul[i].accttype=="10"){ accttype = "预存款";}
	    		else if(ul[i].accttype=="11"){ accttype = "保证金";}
	    		else if(ul[i].accttype=="12"){ accttype = "押金";}
	    		if(ul[i].if_valid=="1"){ if_valid = "有效";} 
	    		acctinfo = acctinfo + accttype +","+ul[i].fee+"元,"+if_valid+"|";
	    	}
	    	$("#acctinfo").val( acctinfo );
		},
		error: function(json){ 
			return false;
		}
	}); 
}

function acctBookInit(){
	var Request = new Object();  
	Request = GetRequest();  
	var custid = Request['custid'];  
	var accountid = Request['accountid'];  
	var custname = Request['custname'];  
	$("#custid").val( custid );
	$("#accountid").val( accountid );
	$("#custname").val( custname );
	
	$.ajax({
	    type: "POST",
	    url:  "../acctAction!acctBookInfoByAccountid.action",
	    data: { accountid: accountid },
	    dataType : "json",  
	    success: function( json ){     
	    	ul = JSON.parse( json.acctBookLists );   
	    	$("#acctbookinfo").val(""); 
	    	var acctbookinfo = "|"; 
	    	var booktype = "未知";
	    	var b_if_valid = "无效";
	    	var a_if_valid = "无效";
	    	for(var i in ul){ 
	    		if( ul[i].booktype=="1" ){ booktype="分钟账本"; }
	    		if( ul[i].b_if_valid=="1" ){ b_if_valid="有效"; }
	    		if( ul[i].a_if_valid=="1" ){ a_if_valid="有效"; } else if(ul[i].a_if_valid=="2"){ a_if_valid="欠费停机"; } 
	    		acctbookinfo = acctbookinfo + "账户状态:" + a_if_valid + " ," 
	    													  + "账本类型:" + booktype +" ,"
	    													  + "账本余量:" + ul[i].balance+" ,"
	    													  + "账本状态:" + b_if_valid+"|" ;
	    	}  
	    	$("#acctbookinfo").val( acctbookinfo );
		},
		error: function(json){ 
			return false;
		}
	}); 
	
	//初始化客户套餐
/*	$.ajax({
	    type: "POST",
	    url:  "../productAction!productListAll.action",
	    data: { workno : sessionStorage.workno, page:1 },
	    dataType : "json",  
	    success: function( json ){     
			ul = JSON.parse( json.productLists );  
			document.getElementById("product").innerHTML = "";
	    	document.getElementById("product").options.add(new Option( "请选择客户的套餐", "0" ));  
	    	for(var i in ul){  
	    		document.getElementById("product").options.add(new Option( ul[i].productName, ul[i].productId ));  
	    	} 
		},
		error: function(json){ 
			return false;
		}
	}); */
} 



function acctOfferOrder(){
	var productId = $("#product option:selected").val();	 
	if(productId=="0" || productId=="" || typeof(productId) == "undefined" ){
		new TipBox({type:'tip', str:'请选择客户套餐', clickDomCancel:true, setTime:0, hasBtn:true} ); 
		return false;
	}
	
	var custid = $("#custid").val(); 
	var accountid = $("#accountid").val();     
	
	$.ajax({
	    type: "POST",
	    url:  "../acctAction!acctBookOrder.action",
	    data: { custid:custid, accountid:accountid, workno: sessionStorage.workno, productid: productId  }, 
	    dataType : "json",  
	    success: function( json ){  
	    	if( json.result == "1" ){  
	    	    new TipBox({type:'success',str:'产品订购成功',hasBtn:true}); 
	    	    acctChargeInit();
	    	    acctBookInit();
	    	} else{
	    		new TipBox({type:'error', str:'产品订购失败:'+json.result, hasBtn:true});
	    	}
		},
		error: function(json){  
			return false;
		}
	});   
}

function prodselect(){
	var productId = $("#product option:selected").val(); 
	if(productId=="0"){ return false;}
	$.ajax({
	    type: "POST",
	    url:  "../productAction!productInfoById.action",
	    data: { workno : sessionStorage.workno, productid: productId },
	    dataType : "json",  
	    success: function( json ){     
    		ul = JSON.parse( json.productLists );   
    		$("#fee").val( ul.monthFee );
    		$("#balance").val( ul.voiceCnt );  
		},
		error: function(json){ 
			return false;
		}
	});  
}

function acctOpen(custid){
	new TipBox({type:'load', str:"执行中...", setTime:1000, callBack:function(){ 
		$.ajax({
		    type: "POST",
		    url:  "../acctAction!acctOpen.action",
		    data: { workno : sessionStorage.workno, custid: custid },
		    dataType : "json",  
		    success: function( json ){     
		    	if( json.result == "1" ){  
		    	    new TipBox( {type:'success', str:'开机成功', hasBtn:true } );   
		    	} else{
		    		new TipBox({type:'error', str:'开机失败:'+json.result, hasBtn:true});
		    	}
			},
			error: function(json){ 
				return false;
			}
		});  
	}});
}


function custpay(){
    var custname = document.getElementById("custname").value;
    window.location.href = 'acctpay.html?custname='+custname;
}