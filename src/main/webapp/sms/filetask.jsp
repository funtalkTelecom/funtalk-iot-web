<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>乐语通信服务平台</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">

	<%@include file="/includes/cssfile.jsp"%>
	<%@include file="/includes/jsfile.jsp"%>

</head>
<body>

	<form id="txtform" class="form-inline definewidth m20" enctype="multipart/form-data">
		<table>
			<tr>
				<td style="font-size: 14pt;">任务分配：</td>
			</tr>
			<tr>
				<td>下载模版：<a href="${cpath}/files/iot_sms_txt.txt"
					download="iot_sms_txt.txt">下载txt导入模板文件</a>
				</td>
			</tr>
			<tr>
				<td style="color: red;">txt请从此处上传(B)：<input type="file" id="txtfile" name="txtfile">
				</td>
				<td><button type="button" class="btn btn-primary" onclick="txtupload()">文件上传</button>
				</td>
			</tr>
		</table>
	</form>
		<form id="xlsform" class="form-inline definewidth m20" enctype="multipart/form-data">
		<table>
			<tr>
				<td>下载模版：<a href="${cpath}/files/iot_sms_xls.xls"
					download="iot_sms_xls.xls">下载xls导入模板文件</a>
				</td>
			</tr>
			<tr>
				<td style="color: red;">xls请从此处上传(B)：<input type="file" id="xlsfile" name="xlsfile">
				</td>
				<td><button type="button" class="btn btn-primary" onclick="xlsupload()">文件上传</button>
				</td>
			</tr>
		</table>
	</form>

</body>
<!-- 页面主处理js -->

<script>

    function txtupload() {

        if ($("#txtfile").val() == "") {

            swal("请选择需要导入的文本文件!");
            return false;
        }
        var formData = new FormData($("#txtform")[0]);

        $.ajax({
            type : "POST",
            url : "${cpath}/sms/txtupload",
            processData : false,
            contentType : false,
            data : formData,
            dataType : "json",
            success : function(json) {

                if (json.code=="200") {
                    swal({title:"任务生成成功",icon: "success",closeOnClickOutside: false});
                }
                if (json.code=="300") {
                    swal({title:"任务提交失败",text:json.msg,icon: "error",closeOnClickOutside: false});
                }
            },
            error : function(json) {
                swal({title:"系统错误",icon: "error",closeOnClickOutside: false});
            }
        });

    }


    function xlsupload() {

        if ($("#xlsfile").val() == "") {
            swal("请选择需要导入的EXCEL文件!");
            return false;
        }

        var formData = new FormData($("#xlsform")[0]); // [0] --- js对象转dom对象

        //部分参数上传
        // var fd = new FormData();  // 创建js对象
        // fd.append("name",$(ad_name_input).val());
        // fd.append("ad",$("#ad_file_input")[0].files[0]);  // 添加type=file的参数

 /*       var tipBox = new TipBox({
            type : 'load',
            str : "任务生成中...",
            setTime : 600000,
            callBack : function() {
            }
        });*/

        $.ajax({
            type : "POST",
            url : "${cpath}/sms/xlsupload",
            processData : false,
            contentType : false,
            data : formData,
            dataType : "json",
            success : function(json) {

                if (json.code=="200") {
                    swal({title:"任务生成成功",icon: "success",closeOnClickOutside: false});
                }

                if (json.code=="300") {
                    swal({title:"任务提交失败",text:json.msg,icon: "error",closeOnClickOutside: false});
                }
            },
            error : function(json) {
                swal({title:"系统错误",icon: "error",closeOnClickOutside: false});
            }
        });

    }

</script>
</html>