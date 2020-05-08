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


    <!-- 模态框(Modal)-->
    <div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title" id="title3">不通过原因</h3>
                </div>
                <div class="modal-body">
                    <form>
                        <input type="hidden" id="batchid" value="">
                        <textarea id="checkmark" class="form-control" rows="3" placeholder="提交的什么垃圾东东....赶紧改！！！！"></textarea>
                    </form>

                </div>

            <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal"
                            onclick="submitcheck()">提交</button>
            </div>
          </div>
        </div>
    </div>

</div>
</body>
<script type="text/javascript">


    function xlsupload() {

        if ($("#location").val() == "") {
            swal("请选择需要导入的EXCEL文件!");
            return false;
        }

        var formData = new FormData($("#xlsform")[0]); // [0] --- js对象转dom对象

        $.ajax({
            type : "POST",
            url : "${cpath}/accnbr/dealerRechargeFileUpload",
            processData : false,
            contentType : false,
            data : formData,
            dataType : "json",
            success : function(json) {

                if (json.code=="200") {
                    swal({title:json.msg,icon: "success",closeOnClickOutside: false});
                }

                if (json.code=="400") {
                    swal({title:"任务提交失败",text:json.msg,icon: "error",closeOnClickOutside: false});
                }
            },
            error : function(json) {
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
                width: '20%',
                formatter:function(value, row, index){

                    return "<a href='${cpath}"+row.filePath + row.fileServerName+"' download='"
                             +row.fileDbName+"'>"+row.fileDbName+"</a>";
                }
            },{
                field: 'createTime',
                title: '上传时间',
                halign: 'center',
                align:  'center',
                width: '15%'
            },{
                field: 'rechargeNum',
                title: '总条数',
                halign : 'center',
                align:  'right',
                width: '8%'
            },{
                field: 'rechargeAmount',
                title: '总金额(元)',
                halign : 'center',
                align:  'right',
                width: '8%'
            },{
                field: 'employeeName',
                title: '提交人',
                align:  'center',
                width: '15%'
            },{
                field: 'rechargeState',
                title: '充值状态',
                align:  'center',
                width: '10%',
                formatter:  function(value,row,index) {

                    if (row.checkState == "1") {

                        if( row.payState !="1"){
                            return  '未付款';
                        }else {

                            if( row.rechargeState =="0"){  return  '已付款,正在充值中...'; }
                            if( row.rechargeState =="2"){  return  '已付款,正在充值中...'; }
                            if( row.rechargeState =="1"){  return  '结束,全部成功'; }
                            if( row.rechargeState =="-1"){ return  '结束,全部失败'; }
                            if( row.rechargeState =="-2"){ return  '结束,部分失败'; }

                        }
                    }

                }
            },{
                field: 'checkState',
                title: '审核状态',
                align:  'center',
                width: '10%',
                formatter: function(value,row,index) {

                    if (value == "0")   return '<strong>未审核</strong>';
                    if (value == "-1")   return '<strong>不通过</strong>';
                    if (value == "1")   return '<strong>通过</strong>';


                }
            },{
                field: 'audit',
                title: '审核',
                align:  'center',
                width: '15%',
                //events: operateEvents,
                formatter:   function (value, row, index) {

                    if(row.checkState ==0){
                        return [
                            '<button id="checkok" type="button" class="btn btn-info" onclick="submitcheck('+row.batchId+',\'1\')">通过</button>&nbsp;&nbsp;',
                            '<button id="checkfalse" type="button" class="btn btn-danger"' +
                            ' data-toggle="modal" data-target="#checkModal" data-id='+row.batchId+'>不通过</button>'
                        ].join('');
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
         params.check ='1';
        //params.taskstatus = $("#taskstatus").val().trim();
        return params;
    }

    window.operateEvents = {
        'click #checkok': function (e,value,row,index) {  submitcheck(row.taskId,'1','');  },
        'click #checkfalse': function (e,value,row,index) {  $('#checkModal').modal('show');  }
    }


    $('#checkModal').on('show.bs.modal', function (event) {

        var button = $(event.relatedTarget) // 触发事件的按钮
        var batchId = button.data('id') // 解析出data-id内容 如果是data-xxx,则 button.data('xxx');
        var modal = $(this); //get modal itself
        //modal.find('.modal-body input').val(recipient)
        $("#batchid").val(batchId);
    });

    $('#checkModal').on('hidden.bs.modal', function (event) {

        $("#batchid").val("");
    });



    function submitcheck(batchid,state,mark) {


        if (state != '1'){

            batchid=$("#batchid").val();
            state= '-1';
            mark=$("#checkmark").val();
        }

        $.ajax({

            type: "post",
            url : "${cpath}/accnbr/savecheckstatus",
            data: {"batchId":batchid,"state": state,"mark":mark },
            dataType : "json",
            success: function(json){

                if (json.code=="200"){
                    swal({title:json.msg,icon: "success",closeOnClickOutside: false});
                    tableInit();
                 }

                if (json.code=="300") {
                    swal({title:json.msg,icon: "error",closeOnClickOutside: false});
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