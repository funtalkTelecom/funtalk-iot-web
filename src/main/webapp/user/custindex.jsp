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
	<link rel="stylesheet" type="text/css" href="${cpath}/static/css/jqpagination.css" />
	<script type="text/javascript" src="${cpath}/static/js/jquery.jqpagination.js"></script>

</head>
<body>
	
	<form class="form-inline definewidth m20"  action=""  >
    客户名称：
    <input id="custname"  type="text"  class="abc input-default"  placeholder="请输入工号名进行查询">&nbsp;&nbsp;
    <button id="btuser"  type="button" class="btn btn-primary" onclick="getcust()">查询客户</button>&nbsp;&nbsp;
    <a href='${cpath}/user/custadd.jsp'><button id="bt_adduser" type="button" class="btn btn-success"  >新增客户</button></a>

	<input type="hidden" id="savecustname">

	</form>
	
	<table id="usertable" class="table table-bordered table-hover definewidth m10">
    	<thead>
    	<tr>
			<th>公司名称</th>
			<th>营业执照</th>
			<th>地址</th>
			<th>联系人</th>
			<th>联系人电话</th>
			<th>创建时间</th>
			<th>是否有效</th>
			<th>操作</th>
    	</tr>
    	</thead>
    	<tbody></tbody> 	
	</table>

	<div id="wrapper" >
		<div class="gigantic pagination">
		    <a href="#" class="first" data-action="first"  >&laquo;</a>
		    <a href="#" class="previous" data-action="previous"  >&lsaquo;</a>
		    <input id="pageinfo"  type="text"  readonly="readonly"  />
		    <a href="#" class="next" data-action="next"  >&rsaquo;</a>
		    <a href="#" class="last" data-action="last"  >&raquo;</a>
		</div>
	</div>
</body>

<script>

    // 初始化加载用户列表
    function getcust(){

        $("#savecustname").attr("value", $("#custname").val().trim());

        var custname=$("#savecustname").val();

        $.ajax({
            type: "POST",
            url:  "${cpath}/cust/getcustlist",
            data: { page : 1, custname:custname},
            dataType : "json",
            success: function( json ){

                showtable(json.msg.data);
                showusersbypage(json.msg.totalno);
            },
            error: function(json){
                return false;
            }
        });
    };

    function showusersbypage(allpage){

        var custname=$("#savecustname").val();

        $('.pagination').jqPagination({
            link_string :  '/?page={page_number}&custname='+custname,
            max_page :  allpage,
            paged : function( page ) {
                $.ajax({
                    type: "POST",
                    url:  "${cpath}/cust/getuserlist",
                    data: { page : page ,username: username},
                    dataType : "json",
                    success: function( json ){

                        showtable(json.msg.data);
                    },
                    error: function(json){
                        return false;
                    }
                });
            }
        });
    }


    function showtable(jsonlist) {

        ul = eval(jsonlist);
        $("#usertable tbody").html("");

        for(var i in ul){
            var custname,status;
            if(ul[i].ifValid==1){ status='有效';}else{ status='失效';}

            $("#usertable tbody").append("<tr>"+
                "<td>"+ul[i].custName+"</td>"+
                "<td>"+ul[i].idCode+"</td>"+
                "<td>"+ul[i].address+"</td>"+
                "<td>"+ul[i].contacts+"</td>"+
                "<td>"+ul[i].contactsNum+"</td>"+
                "<td>"+ul[i].createDate+"</td>"+
                "<td>"+status+"</td>" +
                "<td><a href='#' onclick=\"editCustInit('"  +ul[i].custId+"')\">编辑</a></td></tr>");
        }
    }

    function editCustInit(custId){
        window.location.href="${cpath}/cust/findCust?custId="+custId;
	}

    getcust();

</script>
</html> 