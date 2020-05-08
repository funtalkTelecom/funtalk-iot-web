<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <%@include file="/includes/cssfile.jsp"%>
    <%@include file="/includes/jsfile.jsp"%>

</head>
<body>
<form action=""  method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="15%" class="tableleft">公司名称</td>
        <td style="text-align:left"><input  id="custName"  type="text" style="width:400px;"/>&nbsp;&nbsp;<span id="rescustname"></span></td>
    </tr>
    <tr>
        <td width="15%" class="tableleft">营业执照编码</td>
        <td style="text-align:left"><input id="idCode"  type="text" style="width:400px;"/></td>
    </tr>

    <tr>
        <td width="15%" class="tableleft">地址</td>
        <td style="text-align:left"><input  id="address"  type="text" style="width:400px;"/></td>
    </tr>
    <tr>
        <td width="15%" class="tableleft">联系人</td>
        <td style="text-align:left"><input id="contacts" type="text" style="width:300px;"></input>&nbsp;&nbsp;*必填</td>
    </tr>
    <tr>
        <td width="15%" class="tableleft">联系人电话</td>
        <td style="text-align:left"><input id="contactsNum" type="text" style="width:300px;" ></input>&nbsp;&nbsp;*必填</td>
    </tr>
    <tr>
        <td width="15%" class="tableleft">结算方式</td>
        <td style="text-align:left"><input id="mode" name="mode" type="checkbox" value="${mode.m_type}"/>
            公司结算</td>
    </tr>
    <tr>
        <td width="15%" class="tableleft">价格（分）</td>
        <td style="text-align:left"><input id="bill_price" value="${mode.bill_price}" type="text" style="width:300px;" ></input></td>
    </tr>
    <tr>
		<td class="tableleft">是否有效</td>
		<td style="text-align:left"><input id="ifValid"  type="checkbox"   checked="checked" /></td>
	</tr> 
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="button" class="btn btn-primary"  onClick="addcustomer()">保  存</button> &nbsp;&nbsp;&nbsp;
            <button type="button" class="btn btn-success"  onClick="javascript:history.back(-1);">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>

<script>

    $("#custName").focusin(function() {
        $("#rescustname").html('').removeClass();
    });

    $("#custName").focusout(function() {

        var custname=$(this).val().trim();

        if (custname !=undefined && custname !=""){

            $.ajax({
                type: "post",
                url : "${cpath}/cust/validatecustname",
                data: {"custname":custname},
                dataType : "json",
                success: function(jsonObj){

                    if (jsonObj.code=="200") {
                        //&#10004 输出勾号
                        $('#rescustname').html('&#10004').css({"color":"green","font-size":"20px"});

                    } else {
                        $('#rescustname').html(jsonObj.msg).css({"color":"red","font-size":"14px"});

                    }
                },
                error: function(){
                    swal({title:"系统错误!",icon: "error",closeOnClickOutside: false});
                }
            });
        }

    });


    //添加客户
    function addcustomer(){

        var custName   = $("#custName").val().trim();
        var idCode = $("#idCode").val().trim();
        var address = $("#address").val().trim();
        var contacts = $("#contacts").val().trim();
        var contactsNum = $("#contactsNum").val().trim();
        var mode=$("#mode").val().trim();
        var bill_price=$("#bill_price").val().trim();

        if(custName==""){
            swal({ title: "客户名称为空,不能提交!", icon: "info"}).then(() => { $("#custName").focus();});
            return;
        }
        if(idCode==""){
            swal({ title: "营业执照编码为空,不能提交!", icon: "info"}).then(() => { $("#idCode").focus();});
            return;
        }
        if(address==""){
            swal({ title: "地址为空,不能提交!", icon: "info"}).then(() => { $("#address").focus();});
            return;
        }
        if(mode==1&&bill_price==""){
            swal({ title: "价格为空,不能提交!", icon: "info"}).then(() => { $("#address").focus();});
            return;
        }
        var ifValid = $("#ifValid").is(':checked'); //  .get(0).checked;
        if(ifValid==true){ ifValid = "1"; } else{ ifValid = "0"; }

        $.ajax({
            type: "POST",
            url:  "${cpath}/cust/savecustinfo",
            data: { custName:custName,idCode:idCode,address:address,
                    ifValid:ifValid,contactsNum:contactsNum,contacts:contacts
                ,bill_price:bill_price,mode:mode
            },
            dataType : "json",
            success: function( json ){

                if (json.code=="200"){
                    swal({title:"工号添加成功",icon: "success",closeOnClickOutside: false});
                }
                if (json.code=="300") {
                    swal({title:"工号添加失败",text:json.msg,icon: "error",closeOnClickOutside: false});
                }
            },
            error: function(){
                swal({title:"错误提醒",text:"服务器产生异常",icon: "error",closeOnClickOutside: false});
            }
        });
    };
    $("#mode").change(function () {
        var bool=$('#mode').is(":checked");
        if(!bool){
            $("#bill_price").attr("disabled","disabled");
        }else{
            $("#bill_price").attr("disabled",false);
        }
    });
    $(function () {
        var bool=$('#mode').is(":checked");
        if(!bool){
            $("#bill_price").attr("disabled","disabled");
        }else{
            $("#bill_price").attr("disabled",false);
        }
    });
</script>
</html>