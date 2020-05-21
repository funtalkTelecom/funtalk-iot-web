<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>乐语通信服务平台</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">

	<link rel="stylesheet" type="text/css" href="${cpath}/static/bootstrap3/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="${cpath}/static/bootstraptable/bootstrap-table.css" />

	<script type="text/javascript" src="${cpath}/static/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="${cpath}/static/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${cpath}/static/bootstraptable/bootstrap-table.js"></script>
	<script type="text/javascript" src="${cpath}/static/bootstraptable/bootstrap-table-zh-CN.js"></script>
	<script type="text/javascript" src="${cpath}/static/js/sweetalert.min.js"></script>
	<script type="text/javascript" src="${cpath}/static/js/qrcode.min.js"></script>


	<style type="text/css">
		.userbadge {
			display: inline-block;
			min-width: 80px;
			padding: 3px 3px;
			font-size: 20px;
			font-weight: bold;
			line-height: 1;
			color: #336699;
			background-color: #ffffff;
			text-align: center;
			white-space: nowrap;
            /* vertical-align: middle;  */
			border-radius: 5px;
		}


     /* 解决数字和字母不能自动换行 */
		p{
			word-break:break-all;
			line-height:40px;
		}

    /*	.table>thead>tr>th { text-align: center;}  */

		.table {table-layout:fixed;}   /*解决table设置width无效的问题*/

		.pagination-info{display:none;}   /*隐藏底部 第xx页到第xx页*/

		</style>

</head>

<body>

<div class="container-fluid">

	<div class="row">

		<div class="col-xs-6 col-sm-6 col-md-6  col-lg-6">
			<div class="container">
			<form role="form"  class="form-horizontal">

			<div class="form-group">
				<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label"></label>
			</div>

			<div class="form-group">
				<label class="label label-info control-label" style="font-size:20px;font-weight:normal;">日发送
					<span class="userbadge">${daycount}</span></label>
				<label class="label label-info control-label
                       col-md-offset-2 col-lg-offset-2" style="font-size:20px;font-weight:normal;">月发送
					<span class="userbadge">${monthcount}</span></label>

			</div>

				<div class="form-group">
					<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label"></label>
				</div>

			<div class="form-group">

				<label class="label label-warning control-label" style="font-size:15px">登录工号</label>&nbsp;&nbsp;
				<label class="control-label" id="tempcontent1" style="font-size:20px">${sessionScope.username}</label>

				<label class="label label-warning control-label
				       col-md-offset-2 col-lg-offset-2" style="font-size:15px">工号余额</label>&nbsp;&nbsp;
				<label class="control-label" id="tempcontent2" style="font-size:20px">${deposit}</label><label>&nbsp;&nbsp;元</label>
			</div>
			<div class="form-group" style="margin-top:100px;">
                <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label"></label>
            </div>
            <div class="form-group">
					<div class="input-group col-md-offset-2 col-lg-offset-2 col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<div class="input-group-addon">充值金额:</div>
						<input type="text" class="form-control" id="chargeinput"
                               maxlength="8"  style="text-align:right;font-size:26px;font-weight:400;"
                               onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
                               onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" >
						<div class="input-group-addon">元</div>
					</div>
			</div>

                <div class="col-lg-offset-4 col-md-offset-4" style="margin-top: 50px;">
                    <button type="button" class="btn btn-primary col-xs-2 col-sm-2 col-md-2 col-lg-2" onclick="recharge()">提&nbsp;&nbsp;交</button>
                </div>

			</form>

				<%--<button class="btn btn-primary" data-toggle="modal" data-target="#chargeModal">
					开始演示模态框
				</button>--%>

				<!-- 模态框(Modal)-->
				<div class="modal fade" id="chargeModal" tabindex="-1" role="dialog"
					 aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">--%>
									<%--&times;--%>
								<%--</button>--%>
								<h3 class="modal-title" id="title3"></h3>
								<h5 class="modal-title" style="line-height:50px;" id="title5"></h5>
								<input type="hidden" name="modalChargeId" id="modalChargeId" value="" />

								<%--		<div class="alert alert-info" role="alert">
								</div>--%>

							</div>
							<div class="modal-body">
								<%--qrcode.js显示二维码是用canvas画的,下面div需要设置width,且和qrcode图片一样宽,才能居中显示--%>
								<div  id="qrcontent" style="height:300px;width:250px; margin: 0 auto">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal" onclick="paystatecheck('0')">取消付款
								</button>
								<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="paystatecheck('1')">已付款</button>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>

		<div class="col-xs-6 col-sm-6 col-md-6  col-lg-6">

			<%--<div id="toolbar"></div>--%>

			<table id="data-table" data-toggle="table" class="table table-striped">
				<thead> <tr></tr> </thead>
			</table>

		</div>

	</div>
</div>
	
</body>

<script>


    function paystatecheck(state) {

        var modalChargeId =$("#modalChargeId").val();

        $.ajax({
            type : "POST",
            url : "${cpath}/accnbr/queryrecharge",
            data: {"chargeId":modalChargeId,"state":state},
            dataType : "json",
            success : function(json) {

                if (json.code=="200") {
                    // swal({title:json.msg,icon: "success",closeOnClickOutside: false});
                    tableInit();
                }

                if (json.code=="310"){

                    swal({title:"登录超时,3秒后返回登录页面...", icon: "warning", timer: 3000, closeOnClickOutside: false
                    }).then(() => {window.open(res.msg,'_parent');});

                }
            },
            error : function(json) {

                swal({title:"系统错误",icon: "error",closeOnClickOutside: false});
            }
        });


    }

/*	function paid() {

        tableInit();  //表格初始化

        $.ajax({
            type: "post",
            url : "${cpath}/deposit/queryallbalance",
            dataType : "json",
            success: function(json){

                if (json.code=="200"){
                    $("#tempcontent2").text(json.msg);
                }
            },
            error: function(){ console.log("---queryallbalance  error!----");  }
        });


    }*/

    var intervalId;
    var count=0;

    function recharge(){

        var chargeinput=$("#chargeinput").val().trim();

        if (chargeinput==""){
            swal({title: "请输入充值金额", icon: "info"}).then(() => {$("#chargeinput").focus();});
            return false;
        }

       // $('#chargeModal').modal('show');

        $.ajax({
            type: "post",
            url : "${cpath}/sms/recharge",
            data: {"amount": chargeinput},
            dataType : "json",
            success: function(json){

                if (json.code=="200"){

                    $("#qrcontent").empty();
                    $("#title3").empty();
                    $("#title5").empty();

                    $("#modalChargeId").val(json.msg.chargeId);

                    $("#title3").append("充值工号:"+json.msg.workNo+",支付金额【"+json.msg.amount+"元】");
                    $("#title5").append("充值流水号:"+json.msg.chargeId+",请使用<font size='5' color='red'>微信</font>扫码支付！");

                    var qrcode = new QRCode("qrcontent", {
                        text: json.msg.payUrl,
                        width: 250,
                        height:250,
                        colorDark: "pink",
                        colorLight: "#ffffff",
                        correctLevel: QRCode.CorrectLevel.H
                    });

                    chargeId=json.msg.chargeId;

                    $('#chargeModal').modal('show');


                    //setTimeout 执行一次  setinterval 多次执行
            /*        window.setTimeout(
                        function () {
                            intervalId = window.setInterval(
                                function() {
                                    if (count >=10)  clearInterval(intervalId);
									    console.log("-------chargeid-------" + json.msg.chargeId);
                                    $.ajax({
                                      type: "post",
                                      url : "${cpath}/sms/querypay",
                                      data: {"chargeId":json.msg.chargeId},
                                      dataType : "json",
                                      success: function(json){
                                        if (json.code=="200"  &&  json.msg !="1"){
                                            $('#chargeModal').modal('hide');
                                            clearInterval(intervalId);
                                            if (json.msg == "2") {  swal({title: "支付成功", icon: "success"}); }
                                            if (json.msg == "3") {  swal({title: "支付失败", icon: "error"});  }
                                        }
                                    },
                                    error: function(){ console.log("---query payment error!----");  }
                                    });
                              count++;
                            },3000)
                        }
                        ,15000);*/
                }
                if (json.code=="300") {
                    $("#qrcontent").append("生成二维码失败!");
                    $('#chargeModal').modal('show');

                }


                if (json.code=="310"){

                    swal({title:"登录超时,3秒后返回登录页面...", icon: "warning", timer: 3000, closeOnClickOutside: false
                    }).then(() => {window.open(res.msg,'_parent');});

                }

            },
            error: function(){
                $("#qrcontent").append("生成二维码失败!");
            }
        });

	}


    $('#chargeModal').on('hidden.bs.modal', function (event) {

        $("#modalChargeId").val("");
        //tableInit();

    });

    //run before show
  /*  $('#myModal').on('show.bs.modal', function () {

    });*/

  /*
  //run after show
  $('#myModal').on('shown.bs.modal', function () {
      alert("完全显示模态框");
  });
  //run before hiding
  $('#myModal').on('hide.bs.modal', function () {
      alert("隐藏模态框");
  });
  //run after hiding
  $('#myModal').on('hidden.bs.modal', function () {
      alert("完全隐藏模态框");
  });
*/
/*
    $(".modal").on('show.bs.modal', function(){
        var $this = $(this);
        var $modal_dialog = $this.find('.modal-body');
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $this.css('display', 'block');
        $modal_dialog.css({'margin-top': 0});
        $modal_dialog.css({'margin-left': auto});

    });*/


 /*   $("#qrcontent").css({
        position: "relative",
        left: ($(".modal-body").width() - $("#qrcontent").outerWidth())/2,
        top: ($(".modal-body").height() - $("#qrcontent").outerHeight())/2
    });*/



    var $table = $('#data-table');

    $(window).resize(function () {
        $table.bootstrapTable('resetView');         //防止表头与表格不对齐
    });

    $(function () {
        "use strict";  //使用严格模式
        tableInit();  //表格初始化
        $table.bootstrapTable('hideLoading');//隐藏加载
    });

    function tableInit() {
        //先销毁表格
        $table.bootstrapTable('destroy');
        //再初始化表格  默认参数参考bootstrap-table.js  var DEFAULTS
        $table.bootstrapTable({

            url: "${cpath}/sms/getchargelog", //请求后台的URL(*)
            method: "POST",  //请求方式  默认get
            contentType: "application/x-www-form-urlencoded",//请求内容类型
            dataType: "json",     //返回的数据类型
            //dataField: "msg.data",    //从返回的json中取msg字段 msg=[{},{},{}]
            responseHandler:dealreturn,
            striped: true,        //是否显示行间隔色
            cache: false,         //是否使用缓存
            //toolbar: "#toolbar", //指定工具栏
            showRefresh: true,   //显示刷新按钮
            showToggle: true,    //切换显示样式
            search: true,       //是否显示搜索
            pagination: true,   //是否显示分页
            clickToSelect: true,      //是否启用点击选中行
            minimumCountColumns: 2,    //最少要显示的列数
            showColumns: true,         //显示隐藏列
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页
            pageSize: 10,               //每页的记录行数
            pageNumber: 1,             //初始化加载第1页，默认第1页
            pageList: "[10,15]",  //可供选择的每页的行数
            paginationFirstText: "首页",
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            paginationLastText: "末页",
            buttonsClass: 'btn',      //按钮样式
            iconSize: 'pager',        //分页器class
			showLoading:false,
            queryParams: queryParams,  //查询条件
          //  onCheck:rowselect,

            //表头
            columns: [   {
                field: 'deCode',
                title: '充值类型',
                halign : 'center',
                align:  'center',
                width: '20%',
                formatter: function (value,row) {

                    if (value == '11') return '现金';
                    else return '赠款';
                }

            }, {
                field: 'amount',
                title: '充值金额(元)',
                halign : 'center',
                align:  'right',
                width: '20%'
            }, {
                field: 'chargeType',
                title: '支付方式',
                halign : 'center',
                align:  'center',
                width: '20%',
                formatter: function (value,row) {
                    if (value == '1') return '微信';
                    else if (value=='2')  return '支付宝';
                    else if (value=='3') return '银联';
                    else return '其它';
                }
            },{
                field: 'createTime',
                title: '充值时间',
                align:  'center',
                width: '40%'
            }],
            onLoadSuccess: function (res) {//可不写
                console.log(res);
            }, onLoadError: function () {
                return "加载失败了!";
            }, formatLoadingMessage: function () {
                return "拼命加载中";
            }, formatNoMatches: function () {
                return '无符合条件的记录';
            }
        })
    }

    function dealreturn(res) {

      $table.bootstrapTable('hideLoading');//隐藏加载

       if (res.code=="200"){

          return {"total":res.msg.totalsize,"rows": res.msg.data }

        }else if (res.code=="310"){

        swal({title:"登录超时,3秒后返回登录页面...", icon: "warning", timer: 3000, closeOnClickOutside: false
        }).then(() => {window.open(res.msg,'_parent');});

	  }
    }

    function queryParams(params) {

		// bootstraptable默认传递的参数 search=&order=asc&offset=0&limit=5    offset查询起始行，此插件不传递pageno
		// 如果有额外查询参数,按如下格式在此添加
        /*     params.search =this.search;
               params.nowpage = this.pageNumber;         //第几页：指定跳转
               params.pagesize =this.limit;
        */

        return params;
    }


</script>


</html>