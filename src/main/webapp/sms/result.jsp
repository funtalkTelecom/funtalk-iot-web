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

	<div class="form-group">
		<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label"></label>
	</div>
	<form class="form-inline">
		<div class="form-group">
			<label for="tempcontent">短信内容</label>&nbsp;&nbsp;
			<input type="text" class="form-control" id="tempcontent">&nbsp;&nbsp;
		</div>
		<div class="form-group">
			<label  for="taskstatus">任务状态</label>&nbsp;&nbsp;
			<select id="taskstatus" name="taskstatus"  class="form-control">
				    <option value="all">所有记录</option>
				    <option value="0">未发送</option>
				    <option value="1">发送中..</option>
				    <option value="2">发送成功</option>
				    <option value="3">发送失败</option>
			</select>
		</div>
		&nbsp;&nbsp;<button type="button" class="btn btn-info" onclick="tableInit()">查&nbsp;&nbsp;询</button>

	</form>

	    <div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12  col-lg-12">
			<table id="data-table" data-toggle="table" class="table table-striped">
				<thead> <tr></tr> </thead>
			</table>

		</div>

	</div>
</div>
	
</body>

<script>

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

            url: "${cpath}/sms/getworknosmslist", //请求后台的URL(*)
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
                    field: 'taskId',
                    visible:false
                },{
                    field: 'phoneB',
                    title: '对方号码',
                    halign : 'center',
                    align:  'left',
                    width: '10%'
                },{
                    field: 'msg',
                    title: '短信内容',
                    halign : 'center',
                    align:  'left',
                    width: '60%'
                }, {
                    field: 'workNo',
                    title: '提交工号',
                    align:  'center',
                    width: '10%'
                },{
                    field: 'state',
                    title: '任务状态',
                    align:  'center',
                    width: '10%',
                    formatter: transferstate
				},{
                    field: 'phoneA',
                    title: '发送号码',
                    halign: 'center',
                    align:  'left',
                    width: '10%'
                },{
                    field: 'sendTime',
                    title: '发送时间',
                    align:  'center',
                    width: '10%'
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
               params.tempcontent =$("#tempcontent").val().trim();
               params.taskstatus = $("#taskstatus").val().trim();
        return params;
    }

    function transferstate(value,row) {

        if (value == "-1")   return '<mark><strong>仍未审核</strong></mark>';
        if (value == "-2")   return '<div  style=color:red><mark><strong>审核未通过</strong></mark></div>';
        if (value == "-3")   return '<button type="button" class="btn btn-info" onclick="sendsms(\''+row.taskId+'\')">审过,发送?</button>';
        if (value == "0")    return '<div  style=color:green><mark><strong>发送中...</strong></mark></div>';
        if (value == "1")    return '<div  style=color:green><mark><strong>发送中...</strong></mark></div>';
        if (value == "2")    return '<div  style=color:green><mark><strong>发送成功</strong></mark></div>';
        if (value == "3")    return '<div  style=color:red><mark><strong>发送失败</strong></mark></div>';

    }

    function sendsms(taskId) {

        $.ajax({

            type: "post",
            url : "${cpath}/sms/savecheckstatus",
            data: {"taskids":taskId,"status":0},
            dataType : "json",
            success: function(json){

                if (json.code=="200"){

                    swal({title:"已添加到发送队列中",icon: "success",closeOnClickOutside: false});
                    tableInit();
                }
                if (json.code=="300") {
                    swal({title:"任务添加发送队列失败",text:json.msg,icon: "error",closeOnClickOutside: false});
                }
            },
            error: function(){
                swal({title:"错误提醒",text:"服务器产生异常",icon: "error",closeOnClickOutside: false});

            }
        });

    }


</script>


</html>