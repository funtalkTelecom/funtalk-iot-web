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
    <script type="text/javascript" src="${cpath}/static/js/jquery.blockUI.js"></script>

</head>

<body>
<div class="container-fluid">

    <div  style="height:30px"></div>

    <form role="form" class="form-horizontal" id="xlsform" enctype="multipart/form-data">

        <div class="form-group">
            <label class="col-xs-2 col-sm-2 control-label">码号客户</label>
            <div class=" col-xs-4  col-sm-4">

                <select id="custid" name="custid" class="form-control">

                    <c:if test="${ custs==null || fn:length(custs) == 0}">
                        <option value="0">无客户</option>
                    </c:if>
                    <c:if test="${custs!=null && fn:length(custs) > 0}">
                        <c:forEach items="${custs}" var="cust" varStatus="status">
                            <option value="${cust.custId}">${cust.custName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-xs-2 col-sm-2 control-label">产品套餐</label>
            <div class=" col-xs-4  col-sm-4">

                <select id="pckid" name="pckid" class="form-control">

                    <c:if test="${ pcks==null || fn:length(pcks) == 0}">
                        <option value="0">无产品套餐</option>
                    </c:if>
                    <c:if test="${pcks!=null && fn:length(pcks) > 0}">
                        <c:forEach items="${pcks}" var="pck" varStatus="status">
                            <option value="${pck.pkey}">${pck.pvalue}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
        </div>


        <div class="form-group">
            <label class="col-xs-2 col-sm-2 control-label">模板文件</label>
            <div class=" col-xs-4  col-sm-4">
                <p class="help-block"><a href="${cpath}/files/iot_phoneorder.xls"
                                         download="iot_phoneorder.xls">【点击下载Excel模板文件】</a>
                </p>
            </div>
        </div>

        <div class="form-group">
            <label class="col-xs-2 col-sm-2 control-label">上传码号分配</label>

            <div class="col-xs-4  col-sm-4">
                <div class="input-group">
                    <input id='location' class="form-control" onclick="$('#orderfile').click();">
                    <label class="input-group-btn">
                        <input type="button" id="i-check1" value="浏览文件" class="btn btn-success"
                               onclick="$('#orderfile').click();">
                    </label>
                </div>
                <input type="file" name="orderfile" id='orderfile' accept=".xls,.xlsx"
                       onchange="$('#location').val($('#orderfile').val());" style="display: none">

            </div>
        </div>

        <div style="height:100px"></div>

        <div class="form-group">
            <button type="button" class="btn btn-info col-sm-offset-3 col-md-offset-3" onclick="xlsupload()">提交订单
            </button>
        </div>

    </form>


    <div id="progressmain" style="display: none" >
        <div id="progressDiv" class="progress-bar progress-bar-striped active" role="progressbar"
             aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
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

        var formData = new FormData($("#xlsform")[0]); // [0] --- js对象转dom对象

        $.ajax({
            type : "POST",
            url : "${cpath}/accnbr/xlsupload",
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
</script>


</html>