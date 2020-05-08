<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>乐语通信服务平台</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <link rel="stylesheet" type="text/css" href="${cpath}/static/bootstrap3/css/bootstrap.css"/>

    <script type="text/javascript" src="${cpath}/static/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${cpath}/static/bootstrap3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${cpath}/static/bootstraptable/bootstrap-table.js"></script>
    <script type="text/javascript" src="${cpath}/static/bootstraptable/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript" src="${cpath}/static/js/sweetalert.min.js"></script>
    <script type="text/javascript" src="${cpath}/static/js/qrcode.min.js"></script>
    <script type="text/javascript" src="${cpath}/static/js/jquery.blockUI.js"></script>



    <style type="text/css">
        /* 解决数字和字母不能自动换行 */
        p{
            word-break:break-all;
            line-height:40px;
        }
        /*	.table>thead>tr>th { text-align: center;}  */
        .table {table-layout:fixed;}   /*解决table设置width无效的问题*/


    </style>
</head>

<body>
<div class="container-fluid">

    <div  style="height:30px"></div>

    <%--class="form-horizontal"  class ="form-inline"--%>
    <form role="form"  id="xlsform" enctype="multipart/form-data">

        <div class="row-fluid">
            <div class="col-sm-2 col-md-2" style="text-align: center;" >
              <div class="row"  style="margin-top: 0px;border-top: 0px" >
                 <h4> <label class="label label-primary" style="vertical-align: top;" >下载充值模板文件</label>  </h4>
              </div>
                <div class="row">
                    <a href="${cpath}/files/iot_dealerrecharge.xls"
                       download="iot_dealerrecharge.xls">【点击下载Excel模板文件】</a>
                </div>
            </div>

            <div class="col-sm-6 col-md-6">

                  <%--<h4>--%>
                      <%--<label class="col-sm-2  col-md-2 label label-primary" style="text-align: center;margin-top: 5px">上传文件</label>--%>
                  <%--</h4>--%>

                    <div class="input-group">
                        <label class="input-group-btn">
                            <input type="button" id="i-check" value="上传文件" class="btn btn-primary"
                                   onclick="$('#orderfile').click();">
                        </label>
                        <input id='location' class="form-control"  onclick="$('#orderfile').click();">
                        <label class="input-group-btn">
                            <input type="button" id="i-check1" value="浏  览..." class="btn btn-success"
                                   onclick="$('#orderfile').click();">
                        </label>
                    </div>
                    <input type="file" name="orderfile" id='orderfile' accept=".xls,.xlsx"
                           onchange="$('#location').val($('#orderfile').val());" style="display: none">

            </div>

            <div class="col-sm-2 col-md-2">

                <div class="form-group">
                    <button type="button" class="btn btn-info col-sm-offset-6 col-md-offset-6" onclick="xlsupload()">提交任务
                    </button>
                </div>
            </div>
        </div>

    </form>

    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12  col-lg-12">
            <%--<div id="toolbar"></div>--%>

            <table id="data-table" data-toggle="table" class="table table-striped">
                <thead> <tr></tr> </thead>
            </table>

        </div>

    </div>


    <!-- 模态框(Modal)  关闭键盘退出 框外退出 data-backdrop="static" data-keyboard="false"  -->
    <div class="modal fade" id="chargeModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
<%--                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>--%>
                    <h3 class="modal-title" id="title3"></h3>
                    <h5 class="modal-title" style="line-height:50px;" id="title5"></h5>
                    <input type="hidden" name="modalChargeId" id="modalChargeId" value="" />

                </div>
                <div class="modal-body">
                    <%--qrcode.js显示二维码是用canvas画的,下面div需要设置width,且和qrcode图片一样宽,才能居中显示--%>
                    <div  id="qrcontent" style="height:300px;width:250px; margin: 0 auto">
                    </div>
                </div>
                <div class="modal-footer">
                    		<button type="button" class="btn btn-default" data-dismiss="modal" onclick="paystatecheck('0')">取消付款
                            </button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="paystatecheck('1')">付款完成</button>
                </div>
            </div>
        </div>
    </div>

<div id="progressmain" style="display: none" >
    <div id="progressDiv" class="progress-bar progress-bar-striped active" role="progressbar"
         aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
    </div>
</div>
<%--    <!-- 模态框(Modal)-->
    <div class="modal fade" id="progressModal" tabindex="-1"
         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 100px">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header"></div>
                <div class="modal-body">
                    <div id="progressDiv" class="progress-bar progress-bar-striped active" role="progressbar"  aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                    </div>
                </div>
                <div class="modal-footer"></div>
            </div>
        </div>
    </div>--%>

</div>
</body>
<script type="text/javascript">


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
    
    
    
    function xlsupload() {

        if ($("#location").val() == "") {
            swal("请选择需要导入的EXCEL文件!");
            return false;
        }

        var i = 30;
        var pDiv = setInterval(function(){

            if(i>=100){ clearInterval(pDiv);  }

            $("#progressDiv").width(i+"%");
            $("#progressDiv").html("正在上传中..."+ i+"%");

            // var progressDiv = document.getElementById("progressDiv");
            // progressDiv.style.width = i+"%";
            // progressDiv.innerText ="正在上传中..."+ i+"%";

            i++;

            },300);

        $.blockUI({ message: jQuery("#progressmain"),
                    css: {
                        width: "500",
                        textAlign: "left",
                        backgroundColor: "#fff",
                        border: "1px solid #548B54"
                     }
         });
       //  $('.progressmain').show();
       // $('.progressmain').hide();


        var formData = new FormData($("#xlsform")[0]); // [0] --- js对象转dom对象

        $.ajax({
            type : "POST",
            url : "${cpath}/accnbr/dealerRechargeFileUpload",
            processData : false,
            contentType : false,
            data : formData,
            dataType : "json",
            success : function(json) {

                clearInterval(pDiv);
                $("#progressDiv").width("30%");
                $.unblockUI();

                if (json.code=="200") {
                    swal({title:json.msg,icon: "success",closeOnClickOutside: false});

                    tableInit();
                }

                if (json.code=="400") {
                    swal({title:"任务提交失败",text:json.msg,icon: "error",closeOnClickOutside: false});
                }
            },
            error : function(json) {

                clearInterval(pDiv);
                $("#progressDiv").width("30%");
                $.unblockUI();
                swal({title:"系统错误",icon: "error",closeOnClickOutside: false});
            }
        });



    }


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

            url: "${cpath}/accnbr/getrechargelist", //请求后台的URL(*)
            method: "POST",  //请求方式  默认get
            contentType: "application/x-www-form-urlencoded",//请求内容类型
            dataType: "json",     //返回的数据类型
            //dataField: "msg.data",    //从返回的json中取msg字段 msg=[{},{},{}]
            responseHandler:dealreturn,
            uniqueId: "taskId",
            striped: true,        //是否显示行间隔色
            cache: false,         //是否使用缓存
            //toolbar: "#toolbar", //指定工具栏
            showRefresh: true,   //显示刷新按钮
            showToggle: true,    //切换显示样式
            //search: true,       //是否显示搜索
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
            //onCheck:rowselect,
            clickToSelect:true,
            //表头
            columns: [{
                field: 'batchId',
                visible:false
            },{
                field: 'fileDbName',
                title: '文件名',
                halign : 'center',
                align:  'center',
                width: '25px'
            },{
                field: 'createTime',
                title: '上传时间',
                halign: 'center',
                align:  'center',
                width: '10%'
            },{
                field: 'rechargeNum',
                title: '总条数',
                halign : 'center',
                align:  'right',
                width: '10%'
            },{
                field: 'rechargeAmount',
                title: '总金额(元)',
                halign : 'center',
                align:  'right',
                width: '10%'
            },{
                field: 'checkState',
                title: '审核状态',
                align:  'center',
                width: '10%',
                formatter: function(value,row) {

                    if (value == "0")   return  '未审核';
                    if (value == "-1")  return  '审核不过';
                    if (value == "1")   return  '审核通过';


                }
            },{
                field: 'checkMark',
                title: '审核说明',
                align:  'center',
                width: '20%'
            },{
                field: 'recharge',
                title: '充值状态',
                align:  'center',
                width: '10%',
                formatter: function (item,row,index) {

                    if (row.checkState == "1") {

                        if (row.payState =="2"){

                            return  '正在付款中(等待微信支付通知)';
                        }
                        if( row.payState !="1"){
                            return  '<button id="checkpayment" type="button" class="btn btn-info"' +
                                ' onclick="submitpayment('+row.batchId+','+row.rechargeAmount+')">付款</button>';
                        }else {

                            if( row.rechargeState =="0"){  return  '已付款,正在充值中...'; }
                            if( row.rechargeState =="2"){  return  '已付款,正在充值中...'; }

                            if( row.rechargeState =="1"){

                                return'<button id="b-success" type="button" class="btn btn-success"' +
                                    '><a href=\'${cpath}/accnbr/getbatchdetail?batchId='+row.batchId +
                                    '&fileDbName='+row.fileDbName+'\' style="color:#fff">结束,全部成功</a></button>';
                            }

                            if( row.rechargeState =="-1"){

                                return'<button id="b-allfail" type="button" class="btn btn-info"' +
                                    '><a href=\'${cpath}/accnbr/getbatchdetail?batchId='+row.batchId +
                                    '&fileDbName='+row.fileDbName+'\' style="color:#fff">结束,全部失败</a></button>';

                            }
                            if( row.rechargeState =="-2"){

                                return'<button id="b-partfail" type="button" class="btn btn-info"' +
                                    '><a href=\'${cpath}/accnbr/getbatchdetail?batchId='+row.batchId +
                                    '&fileDbName='+row.fileDbName+'\' style="color:#fff">结束,部分失败</a></button>';
                            }

                        }
                    }

                }
            },{
                field: 'alterBoss',
                title: '取限/强开状态',
                align:  'center',
                width: '10%',
                formatter: function(value,row) {

                 if( row.payState =="1"){
                     if (value == "0")   return  '未处理';
                     if (value == "1")   return  '处理完成';
                     if (value == "2")   return  '正在处理中...';
                 }

                }
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
        //params.check ='0';
        //params.taskstatus = $("#taskstatus").val().trim();
        return params;
    }


    function showdetail(batchid,fileDbName) {

        console.log("--------" +batchid+"-----"+fileDbName);

        $.ajax({

            type: "post",
            url : "${cpath}/accnbr/getbatchdetail",
            data: {"batchId":batchid,"fileDbName": fileDbName},
            dataType : "blob",
            success: function(data){

                var $a = document.createElement('a');
                $a.attr("href", "${cpath}/accnbr/getbatchdetail");
                $("body").append($a);
                $a[0].click();
                $a.remove();

            },
            error: function(){
                swal({title:"错误提醒",text:"服务器产生异常",icon: "error",closeOnClickOutside: false});

            }
        });


    }


    $('#chargeModal').on('hidden.bs.modal', function (event) {

        $("#modalChargeId").val("");
        //tableInit();

    });



    function submitpayment(batchId,amount) {

        $.ajax({

            type: "post",
            url : "${cpath}/accnbr/payment",
            data: {"batchId":batchId,"amount": amount },
            dataType : "json",
            success: function(json){

                if (json.code=="200"){

                    $("#qrcontent").empty();
                    $("#title3").empty();
                    $("#title5").empty();

                    $("#modalChargeId").val(json.msg.chargeId);

                    $("#title3").append("充值工号:"+json.msg.workNo+",支付金额【"+json.msg.amount+"元】");
                    $("#title5").append("充值流水号:"+json.msg.chargeId+",【提醒:请使用<font size='5' color='red'>微信</font>扫码支付,支付完成前请勿关闭此窗口】");

                    var qrcode = new QRCode("qrcontent", {
                        text: json.msg.payUrl,
                        width: 250,
                        height:250,
                        colorDark: "pink",
                        colorLight: "#ffffff",
                        correctLevel: QRCode.CorrectLevel.H
                    });

                    $('#chargeModal').modal('show');

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
                swal({title:"错误提醒",text:"服务器产生异常",icon: "error",closeOnClickOutside: false});

            }
        });



    }




</script>


</html>