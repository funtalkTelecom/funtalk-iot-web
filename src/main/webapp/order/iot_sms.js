var i = 0;
var city_b = "";
$("#iot_city_a").change(
		function() {
			var city_a = $(this)[0].value;
			var tipBox = new TipBox({type:'load',str:"查询中...", setTime:600000, callBack:function(){ }}); 
			$.ajax({
				type : "POST",
				url : "../iotsmsAction!phoneAList.action",
				dataType : "json",
				data : {
					city_a : city_a
				},
				success : function(json) {
					tipBox.close();
					ul = JSON.parse(json.phoneListStr);
					document.getElementById("iot_phone_a").innerHTML = "";
					document.getElementById("iot_phone_a").options
							.add(new Option("请选择发送号码", "0"));
					for ( var i in ul) {
						if(ul[i].service_kind=="8"){
							document.getElementById("iot_phone_a").options
							.add(new Option(" 电信 | "+ul[i].service_id+" | "+ul[i].use_cnt+" | "+ul[i].msg_cnt, ul[i].service_id));
						}else if(ul[i].service_kind=="9"){
							document.getElementById("iot_phone_a").options
							.add(new Option(" 联通 | "+ul[i].service_id+" | "+ul[i].use_cnt+" | "+ul[i].msg_cnt, ul[i].service_id));
						}else if(ul[i].service_kind=="7"){
							document.getElementById("iot_phone_a").options
							.add(new Option(" 移动 | "+ul[i].service_id+" | "+ul[i].use_cnt+" | "+ul[i].msg_cnt, ul[i].service_id));
						}
						
					}
				},
				error : function(json) {
					return false;
				}
			});
		});

$("#iot_city_b").change(	
		function() {
			var city_b = $(this)[0].value;
			OrderInit(1,city_b);
		}
		);

$(".task_commit").click(function(){
	var phone_b = $('input[name="phone_b"]');
	var phone_b_list = [];
	var phone_a_bak = $("#iot_phone_a_bak")[0].value;
	var phone_a = $("#iot_phone_a")[0].value;
	var send_time = $("#send_time").val();
	if(phone_a_bak.length!=0){
		phone_a = phone_a_bak;
	}
	console.log(phone_a);
	for(i in phone_b){
		if(phone_b[i].checked){
			phone_b_list.push(phone_b[i].value);
		}
	}
	if(phone_a!="" && phone_a!="0" && phone_b_list!=null){
		var tipBox = new TipBox({type:'load',str:"任务生成中...", setTime:600000, callBack:function(){ }}); 
		$.ajaxSettings.traditional=true;
		$.ajax({
			type : "POST",
			url : "../iotsmsAction!smsTask.action",
			dataType : "json",
			data : {
				phone_a : phone_a,
				phone_b_list : phone_b_list,
				send_time : send_time
			},
			success : function(json) {
				tipBox.close();
				if (json.state == "0000") {
					new TipBox({
						type : 'success',
						str : '任务生成成功',
						hasBtn : true
					});
				var city_b = $("#iot_city_b").val();
					$.ajax({
					    type: "POST",
					    url:  "../iotsmsAction!addressList.action",
					    data: {page : 1,city_b:city_b}, 
					    dataType : "json",  
					    success: function( json ){   
					    	var ultask = JSON.parse( json.addressListsTask );   
					    	$("#addressListTable tbody").html(""); 
					    	for(var i in ultask){ 
					    		$("#addressListTable tbody").append('<tr><td>'
										+ '<input type="checkbox" name="phone_b" value="'
										+ ultask[i].nid + '">' + '</td>'
										+ '<td>' + ultask[i].phone_b
										+ '</td>' + '<td>'
										+ ultask[i].city_b + '</td>'
										+ '<td>' + ultask[i].msg
										+ '</td></tr>');  
					    	}
					    	
					    	var ultaskinfo = JSON.parse( json.addressLists );   
					    	$("#addressListTable tbody").html(""); 
					    	for(var i in ultaskinfo){ 
					    		$("#addressListTable tbody").append('<tr><td>'
										+ '<input type="checkbox" name="phone_b" value="'
										+ ultaskinfo[i].nid + '">' + '</td>'
										+ '<td>' + ultaskinfo[i].phone_b
										+ '</td>' + '<td>'
										+ ultaskinfo[i].city_b + '</td>'
										+ '<td>' + ultaskinfo[i].msg
										+ '</td></tr>'); 
					    	}  
					    	
					    	showOrdersByPage(json.allPage);
						},
						error: function(json){ 
							return false;
						}
					});  
				}
				if (json.state == "0001") {
					new TipBox({
						type : 'error',
						str : '该号码不是正确的业务号码',
						hasBtn : true
					});
				}
			},
			error : function(json) {
				return false;
			}
		});
	}else{
		new TipBox({
			type : 'error',
			str : '请选择或输入发送号码、接收号码',
			hasBtn : true
		});
	}
});
$("#operators").on("click",'.change', function() {
	var t = Date.now();
	function sleep(d){
		while(Date.now() - t <= d);
	} 
	var operators = $(this)[0].name;
	var tipBox = new TipBox({type:'load',str:"切号中...", setTime:600000, callBack:function(){ }}); 
	$.ajax({
		type : "POST",
		url : "../iotsmsAction!changecard.action",
		dataType : "json",
		data : {operators : operators},
		success : function(json) {
			sleep(5000);
			tipBox.close();
		},
		error : function(json) {
			return false;
		}
	});
});
$(".del_now_use").click(function() {
	var tipBox = new TipBox({type:'load',str:"清除中...", setTime:600000, callBack:function(){ }}); 
	$(".now_use")[0].innerHTML="当前生效卡：";
	$.ajax({
		type : "GET",
		url : "../iotsmsAction!delcard.action",
		dataType : "json",
		success : function(json) {
			tipBox.close();
			if (json.state == "0000") {
				new TipBox({
					type : 'success',
					str : '已清除',
					hasBtn : true
				});
			}else{
				new TipBox({
					type : 'tip',
					str : '系统异常请联系管理员!',
					hasBtn : true
				});
			}
		},
		error : function(json) {
			new TipBox({
				type : 'tip',
				str : '系统异常请联系管理员!',
				hasBtn : true
			});
		}
	});
});


var timer = setInterval(function(){
	$.ajax({
		type : "GET",
		url : "../iotsmsAction!getcard.action",
		dataType : "json",
		success : function(json) {
			var ul = JSON.parse(json.cardinfo);
			if(ul[0].iccid!=""){
				$(".now_use")[0].innerHTML="当前生效卡："+ul[0].iccid+"&nbsp;&nbsp;信号强度："+ul[0].signalLevel;
				console.log(ul[0].iccid);
			}
		},
		error : function(json) {
			return false;
		}
	});
}, 10000);
// 初始化
(function() {
	// iot_sms发送号码地市列表
	$.ajax({
		type : "GET",
		url : "../iotsmsAction!cityAList.action",
		dataType : "json",
		success : function(json) {			
			ul = JSON.parse(json.phoneListStr);
			console.log(ul);
			document.getElementById("iot_city_a").innerHTML = "";
			document.getElementById("iot_city_a").options.add(new Option(
					"请选择发送号码地市", "0"));
			document.getElementById("iot_city_a").options.add(new Option("全部",
					"all"));
			for ( var i in ul) {
				document.getElementById("iot_city_a").options.add(new Option(
						ul[i].city_a, ul[i].city_a));
			}
		},
		error : function(json) {
			return false;
		}
	});
	// iot_sms接收号码列表
//	$.ajax({
//				type : "GET",
//				url : "../iotsmsAction!phoneBList.action",
//				dataType : "json",
//				success : function(json) {
//					ul = JSON.parse(json.phoneListStr);
//					for ( var i in ul) {
//						$("#addressListTable tbody")
//								.append(
//										'<tr><td>'
//												+ '<input type="checkbox" name="phone_b" value="'
//												+ ul[i].nid + '">' + '</td>'
//												+ '<td>' + ul[i].phone_b
//												+ '</td>' + '<td>'
//												+ ul[i].city_b + '</td>'
//												+ '<td>' + ul[i].msg
//												+ '</td></tr>');
//					}
//				},
//				error : function(json) {
//					return false;
//				}
//			});

	// iot_sms接收号码地市列表
	$.ajax({
		type : "GET",
		url : "../iotsmsAction!cityBList.action",
		dataType : "json",
		success : function(json) {
			ul = JSON.parse(json.phoneListStr);
			document.getElementById("iot_city_b").innerHTML = "";
			document.getElementById("iot_city_b").options.add(new Option(
					"请选择接收号码地市", "0"));
			document.getElementById("iot_city_b").options.add(new Option("全部",
					"all"));
			for ( var i in ul) {
				document.getElementById("iot_city_b").options.add(new Option(
						ul[i].city_b, ul[i].city_b));
			}
		},
		error : function(json) {
			return false;
		}
	});
	$.ajax({
		type : "GET",
		url : "../iotsmsAction!getcard.action",
		dataType : "json",
		success : function(json) {
			var ul = JSON.parse(json.cardinfo);
			if(ul[0].iccid!=""){
				$(".now_use")[0].innerHTML="当前生效卡："+ul[0].iccid+"&nbsp;&nbsp;信号强度："+ul[0].signalLevel;
				console.log(ul[0].iccid);
			}
		},
		error : function(json) {
			return false;
		}
	});
}());

function axb_b_upload() {
	if ($("#filename").val() == "") {
		new TipBox({
			type : 'tip',
			str : '请选择需要导入的文本文件(B)',
			clickDomCancel : true,
			setTime : 0,
			hasBtn : true
		});
		return false;
	}
	var formData = new FormData($("#form_axb_b")[0]);
	var tipBox = new TipBox({
		type : 'load',
		str : "任务生成中...",
		setTime : 600000,
		callBack : function() {
		}
	});
	$.ajax({
		type : "POST",
		url : "../iotsmsAction!FileUpload.action",
		processData : false,
		contentType : false,
		data : formData,
		dataType : "json",
//		jsonp : "jsoncallback",
		success : function(json) {
			tipBox.close();
			if (json.state == "0000") {
				new TipBox({
					type : 'success',
					str : '任务生成成功',
					hasBtn : true
				});

				
			} else if (json.result == "0") {
				new TipBox({
					type : 'error',
					str : '导入的文件中未查询到数据,请核查后重新导入',
					hasBtn : true
				});
			} else if (json.result == "2") {
				new TipBox({
					type : 'error',
					str : '导入的文件中有重复号码或库中已存在,请核查后重新导入',
					hasBtn : true
				});
			} else if (json.result == "-3") {
				new TipBox({
					type : 'error',
					str : '文件格式不支持,请使用模板进行导入',
					hasBtn : true
				});
			}
			else {
				new TipBox({
					type : 'tip',
					str : '系统异常请联系管理员!',
					hasBtn : true
				});
			}
		},
		error : function(json) {
			tipBox.close();
			new TipBox({
				type : 'error',
				str : '系统异常请联系管理员!',
				hasBtn : true
			});
		}
	});

}

function showOrdersByPage(allpage) {  
	$('.pagination').jqPagination({
		link_string :  '/?page={page_number}',
		max_page :  allpage,
		paged : function( page) {  
			var city_b = $("#iot_city_b").val();
			OrderInit(page,city_b);
		}
	});   
}  


var OrderInit = function(page,city_b){  
	var tipBox = new TipBox({type:'load',str:"查询中...", setTime:600000, callBack:function(){ }}); 
	city_b = city_b;
	$.ajax({
	    type: "POST",
	    url:  "../iotsmsAction!addressList.action",
	    data: {page : page,city_b:city_b}, 
	    dataType : "json",  
	    success: function( json ){   
	    	tipBox.close();
	    	var ultask = JSON.parse( json.addressListsTask );   
	    	$("#addressListTable tbody").html(""); 
	    	for(var i in ultask){ 
	    		$("#addressListTable tbody").append('<tr><td>'
						+ '<input type="checkbox" name="phone_b" value="'
						+ ultask[i].nid + '">' + '</td>'
						+ '<td>' + ultask[i].phone_b
						+ '</td>' + '<td>'
						+ ultask[i].city_b + '</td>'
						+ '<td>' + ultask[i].msg
						+ '</td></tr>');  
	    	}
	    	
	    	var ultaskinfo = JSON.parse( json.addressLists );   
	    	$("#addressListTable tbody").html(""); 
	    	for(var i in ultaskinfo){ 
	    		$("#addressListTable tbody").append('<tr><td>'
						+ '<input type="checkbox" name="phone_b" value="'
						+ ultaskinfo[i].nid + '">' + '</td>'
						+ '<td>' + ultaskinfo[i].phone_b
						+ '</td>' + '<td>'
						+ ultaskinfo[i].city_b + '</td>'
						+ '<td>' + ultaskinfo[i].msg
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

/*(function OrderInit(){  
$.ajax({
    type: "POST",
    url:  "../iotsmsAction!addressList.action",
    data: {page : 2}, 
    dataType : "json",  
    success: function( json ){   
    	var ultask = JSON.parse( json.addressListsTask );   
    	$("#addressListTable tbody").html(""); 
    	for(var i in ultask){ 
    		$("#addressListTable tbody").append('<tr><td>'
					+ '<input type="checkbox" name="phone_b" value="'
					+ ultask[i].nid + '">' + '</td>'
					+ '<td>' + ultask[i].phone_b
					+ '</td>' + '<td>'
					+ ultask[i].city_b + '</td>'
					+ '<td>' + ultask[i].msg
					+ '</td></tr>');  
    	}
    	
    	var ultaskinfo = JSON.parse( json.addressLists );   
    	$("#addressListTable tbody").html(""); 
    	for(var i in ultaskinfo){ 
    		$("#addressListTable tbody").append('<tr><td>'
					+ '<input type="checkbox" name="phone_b" value="'
					+ ultaskinfo[i].nid + '">' + '</td>'
					+ '<td>' + ultaskinfo[i].phone_b
					+ '</td>' + '<td>'
					+ ultaskinfo[i].city_b + '</td>'
					+ '<td>' + ultaskinfo[i].msg
					+ '</td></tr>'); 
    	}  
    	
    	showOrdersByPage(json.allPage);
	},
	error: function(json){ 
		return false;
	}
});  
}());*/

/*console.log(1111);
$.ajax({
	type : "POST",
	url : "../iotsmsAction!phoneBList.action",
	dataType : "json",
	data : {
		city_b : city_b
	},
	success : function(json) {
		tipBox.close();
		ul = JSON.parse(json.phoneListStr);
		$("#addressListTable tbody").html("");
		for ( var i in ul) {
			$("#addressListTable tbody")
					.append(
							'<tr><td>'
									+ '<input type="checkbox" name="phone_b" value="'
									+ ul[i].nid + '">' + '</td>'
									+ '<td>' + ul[i].phone_b
									+ '</td>' + '<td>'
									+ ul[i].city_b + '</td>'
									+ '<td>' + ul[i].msg
									+ '</td></tr>');
		}
	},
	error : function(json) {
		return false;
	}
});*/