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
		.glyphicon-ok {
			margin-left: 10px;
			color:green;
			font-size:15px;
		}
		.glyphicon-remove {
			margin-left: 10px;
			color:red;
			font-size:15px;
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

			<form role="form"  class="form-horizontal">

			<div class="form-group">
				<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label"></label>
			</div>
			<div class="form-group">
				<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">接收号码:</label>
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<input type="text" class="form-control  input-block-level" id="receiver" name="receiver" placeholder="请输入用户号码">
				</div>
				<span  id="validatesms" style="text-align: center;line-height:30px;"></span>
			</div>

				<div class="jumbotron">
					<div class="container">

						<h3 style="text-align:center;font-size: 30px;color: #6c79fc; margin-top: 0px;margin-bottom: 20px">编辑短信</h3>

						<div id="smscontent"></div>

					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<button type="button" class="btn btn-info col-sm-offset-3  col-md-offset-3  col-lg-offset-3" onclick="previewsms()">短信预览</button>
						<button type="button" class="btn btn-primary col-sm-offset-2 col-md-offset-2 col-lg-offset-2" onclick="sendsms()">提交任务</button>
					</div>
				</div>

			</form>
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

            url: "${cpath}/sms/gettemplate", //请求后台的URL(*)
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
            pageSize: 5,               //每页的记录行数
            pageNumber: 1,             //初始化加载第1页，默认第1页
            pageList: "[5,10]",  //可供选择的每页的行数
            paginationFirstText: "首页",
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            paginationLastText: "末页",
            buttonsClass: 'btn',      //按钮样式
            iconSize: 'pager',        //分页器class
			showLoading:false,
            queryParams: queryParams,  //查询条件
            onCheck:rowselect,

            //表头
            columns: [   {
                field: 'temId',
                radio: true,
                width: '5%',
            }, {
                field: 'temContent',
                title: '模板内容',
                halign : 'center',
                align:  'left',
                width: '85%'
            }, {
                field: 'temType',
                title: '类别',
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

		// bootstraptable默认传递的参数 search=&order=asc&offset=0&limit=5    offset查询起始行，此插件不传递pageno
		// 如果有额外查询参数,按如下格式在此添加
        /*     params.search =this.search;
               params.nowpage = this.pageNumber;         //第几页：指定跳转
               params.pagesize =this.limit;
        */

        return params;
    }


    $('#data-table').on('load-success.bs.table',function(data){


        //默认选择第一行  下面两种方式都能选择第一行,但第一个会触发onCheck事件;

        $("#smscontent").empty();

        var allTableData = $table.bootstrapTable('getData');
        if (allTableData!=undefined && allTableData.length>0){
            $('#data-table').bootstrapTable('check',0);
		}

        //$('#data-table input:radio:first').attr('checked', 'checked');

    });

    function rowselect(row,element){

        var rows=$("#data-table").bootstrapTable('getSelections');

        if(!rows||rows.length==0){
            swal({title:"请选择短信模板",icon: "info",closeOnClickOutside: false});
            return;
        }

        $("#smscontent").empty();

        var str="<p style='text-align:left;font-size: 15px'>";
        var paramid="";
        var smsarr=rows[0].temContent.trim().split("$");

        if (smsarr.length>1) {
            for (var i = 0; i < smsarr.length - 1; i++) {
                paramid = "smsparam" + (i + 1);
                str +=  smsarr[i] + "&nbsp;&nbsp;<input type='text' style='width: 120px;height: 25px'  id=" + paramid + " >&nbsp;&nbsp;";
            }

            str+=smsarr[smsarr.length-1];

        }else{
            str=rows[0].temContent.trim();
        }

            str+="</p>";

        $("#smscontent").append(str);

    }


    function operateFormatter (value, row, index) {
        var result = '<button class="btn  btn-action" title="激活USBKEY认证" onclick=""><i class="glyphicon glyphicon-pencil"></i></button>'
        return result;
    }



    function sendsms() {

        var smsreceiver=$("#receiver").val().trim();

        if (smsreceiver==""){
            swal({title: "对方号码为空,不能提交", icon: "info"}).then(() => {$("#receiver").focus();});
			return;
        }

        if(!$("#validatesms").hasClass("text-success")){
            swal({title: "对方号码今天已发送,不能再次发送", icon: "info"}).then(() => {$("#receiver").focus();});
            return;
		}

        var rows=$("#data-table").bootstrapTable('getSelections');

        if(!rows||rows.length==0){
            swal({title:"提取短信内容失败",icon: "info",closeOnClickOutside: false});
            return;
        }

        var smscontent="";
        var smsarr=rows[0].temContent.trim().split("$");  // 如果没有参数,则smsarr.length=1;

        if (smsarr.length>1) {

            for (var i = 0; i < smsarr.length - 1; i++) {
                smscontent += smsarr[i].trim() + $("input[id=smsparam" + (i + 1) + "]").val();
            }

            smscontent+=smsarr[smsarr.length-1];
        }else{
            smscontent=rows[0].temContent.trim();
        }

 		$.ajax({
                    type: "post",
                    url : "${cpath}/sms/save",
					data: {"smsreceiver":smsreceiver,"smscontent": smscontent},
                    dataType : "json",
                    success: function(json){

                        if (json.code=="200"){
                            swal({title:"任务添加成功",icon: "success",closeOnClickOutside: false});
                        }
                        if (json.code=="300") {
                            swal({title:"任务添加失败",text:json.msg,icon: "error",closeOnClickOutside: false});
                        }
                    },
                    error: function(){
                        swal({title:"错误提醒",text:"服务器产生异常",icon: "error",closeOnClickOutside: false});

                    }
         });

    }


    function previewsms(){

        var smsreceiver=$("#receiver").val().trim();
        var rows=$("#data-table").bootstrapTable('getSelections');
        if(!rows||rows.length==0){
            swal({title:"请选择短信模板",icon: "info",closeOnClickOutside: false});
            return;
        }

        var smscontent="";
        var smsarr=rows[0].temContent.trim().split("$");  // 如果没有参数,则smsarr.length=1;

        if (smsarr.length>1) {

            for (var i = 0; i < smsarr.length - 1; i++) {
                smscontent += smsarr[i].trim() + $("input[id=smsparam" + (i + 1) + "]").val();
            }

            smscontent+=smsarr[smsarr.length-1];

        }else {

            smscontent=rows[0].temContent.trim();  // 解决不需要编辑模板的展示
		}

        swal("对方号码:"+smsreceiver,"短信内容:"+smscontent,{closeOnClickOutside: false});

    }


    $("#receiver").focusin(function() {

        $("#validatesms").empty();
        $("#validatesms").removeClass();
    });

    $("#receiver").focusout(function() {

        var receiver=$(this).val().trim();

        if (receiver !=undefined && receiver !=""){

            $.ajax({
                type: "post",
                url : "${cpath}/sms/validateReceiver",
                data: {"smsreceiver":receiver},
                dataType : "json",
                success: function(jsonObj){

                    if (jsonObj.code=="200") {
                        $("#validatesms").addClass("h4 text-success");
                        $("#validatesms").html("<strong>可以发送!</strong>");
                       // $("#validatesms").addClass("glyphicon glyphicon-ok");
                    } else {
                      //  $("#validatesms").addClass("glyphicon glyphicon-remove");
                        $("#validatesms").addClass("h4 text-danger");
                        $("#validatesms").html("<strong>今天已经发送!</strong>");

                    }
                },
                error: function(){
                    swal({title:"系统错误!",icon: "error",closeOnClickOutside: false});
                }
            });
		}

    });


   // TableInit();
   // getTemplate();

</script>


</html>