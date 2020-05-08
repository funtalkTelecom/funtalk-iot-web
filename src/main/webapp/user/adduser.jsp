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
        <td width="10%" class="tableleft">员工工号*</td>
        <td style="text-align:left"><input  id="workno"  type="text"/>&nbsp;&nbsp;<span id="resworkno"></span></td>
    </tr>
    <tr>
        <td class="tableleft">员工姓名</td>
        <td style="text-align:left"><input  id="username"  type="text"/></td>
    </tr>
    <tr>
        <td class="tableleft">密码*</td>
        <td style="text-align:left"><input id="password"  type="text" placeholder="必须包含字母和数字" />
            &nbsp;&nbsp;<span id="respassword"></span></td>
    </tr>
    <tr>
        <td class="tableleft">归属客户</td>
        <td style="text-align:left">
            <select id="custid">

              <c:if test="${ custs==null || fn:length(custs) == 0}">
                <option value="0">无客户</option>
              </c:if>
              <c:if test="${custs!=null && fn:length(custs) > 0}">
                <c:forEach items="${custs}" var="cust"  varStatus="status">
                    <option  value="${cust.custId}">${cust.custName}</option>
                </c:forEach>
              </c:if>
        </select>
    </tr>
    <tr>
        <td class="tableleft">菜单权限</td>

        <td id="menu_list">
        <div style="float:left;text-align:left">
          <c:if test="${ menus==null || fn:length(menus) == 0}">
            <br/><h4>无配置菜单</h4><br/>
          </c:if>

          <c:if test="${menus!=null && fn:length(menus) > 0}">
            <c:forEach items="${menus}" var="menu"  varStatus="status">
                <c:choose>
                    <c:when test="${menu.menuParent==null}">
                        <h5 align="left">${menu.menuName}</h5>
                    </c:when>
                    <c:otherwise>
                        <input name='menus' type='checkbox' value=${menu.menuId}  />&nbsp;&nbsp;${menu.menuName}&nbsp;&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>

          </c:if>
        </div>
        </td>
    </tr>
    <tr>
        <td width="15%" class="tableleft">结算方式</td>
        <td style="text-align:left"><input id="mode" name="mode" type="checkbox" value="${mode.mType}"/>
            工号结算</td>
    </tr>

    <tr>
        <td width="15%" class="tableleft">价格（分）</td>
        <td style="text-align:left"><input id="billprice" value="${mode.billPrice}" type="text" style="width:300px;" ></input></td>
    </tr>
    <tr>
		<td class="tableleft">是否生效</td>
		<td style="text-align:left"><input id="status"  type="checkbox"   checked="checked" /></td>
	</tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="button" class="btn btn-primary"  onClick="addUser()">保  存</button> &nbsp;&nbsp;&nbsp;
            <button type="button" class="btn btn-success"  onClick="javascript :history.back(-1);">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>

<script>

    //添加用户
    function addUser(){

        var workno   = $("#workno").val().trim();
        var username = $("#username").val().trim();
        var password = $("#password").val().trim();
        var mode=$("#mode").val().trim();
        var billprice=$("#billprice").val().trim();

        var mode="1";
        if ($('#mode').is(":checked")){

            if (billprice ==""){
                swal({ title: "工号结算价格为空,不能提交!", icon: "info"}).then(() => { $("#billprice").focus();});
                return;
            }

            mode="2";
        }

        if(workno==""){
          swal({ title: "工号为空,不能提交!", icon: "info"}).then(() => { $("#workno").focus();});
          return;
        }
        if(username==""){
            swal({ title: "姓名为空,不能提交!", icon: "info"}).then(() => { $("#username").focus();});
            return;
        }
        if(password==""){
            swal({ title: "密码为空,不能提交!", icon: "info"}).then(() => { $("#password").focus();});
            return;
        }

        var custid = $("#custid option:selected").val();
        if( custid=="0" || custid=="" || typeof(custid) == "undefined" ){  custid = ""; }

        var status = $("#status").is(':checked'); //  .get(0).checked;
        if(status==true){ status = "1"; } else{ status = "0"; }

        // 增加 菜单权限选择列表
        var menu_value =[];
        $('input[name="menus"]:checked').each(function(){
            menu_value.push($(this).val());
        });
        var menulist = menu_value.join(",");

        $.ajax({
            type: "POST",
            url:  "${cpath}/user/saveworkno",
            data: { workNo:workno,employeeName:username,workPwd:password,
                    ifValid:status,allowMenu:menulist,custId:custid,billMode:mode,billPrice:billprice},
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
    }

    $("#workno").focusin(function() {
        $("#resworkno").html('').removeClass();
    });

    $("#workno").focusout(function() {

        var workno=$(this).val().trim();

        if (workno !=undefined && workno !=""){

            $.ajax({
                type: "post",
                url : "${cpath}/user/validateworkno",
                data: {"wrokno":workno},
                dataType : "json",
                success: function(jsonObj){

                    if (jsonObj.code=="200") {

                        //&#10004 输出勾号
                        $('#resworkno').html('&#10004').css({"color":"green","font-size":"20px"});

                    } else {
                        $('#resworkno').html(jsonObj.msg).css({"color":"red","font-size":"14px"});

                    }
                },
                error: function(){
                    swal({title:"系统错误!",icon: "error",closeOnClickOutside: false});
                }
            });
        }

    });

    $("#password").focusin(function() {

        $("#respassword").html('').removeClass();

    });

    $("#password").focusout(function() {

        var regex1=/^[0-9]+$/;
        var regex2=/^[a-zA-Z]+$/;
        var regex4=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;

   /*     if (regex1.test($("#password").val())) {
            $('#respassword').html("密码不允许只有数字!").css({"color":"red","font-size":"14px"});
            return false;
        }

        if (regex2.test($("#password").val())) {
            $('#respassword').html("密码不允许只有字母!").css({"color":"red","font-size":"14px"});
            return false;
        }*/
        if (!regex4.test($("#password").val())) {
            $('#respassword').html("密码长度范围6-20位,需要由字母和数字组成！").css({"color":"red","font-size":"14px"});
            return false;
        }
    });

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