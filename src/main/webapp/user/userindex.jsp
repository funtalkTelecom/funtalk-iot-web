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
    用户名称：
    <input id="username"  type="text"  class="abc input-default"  placeholder="请输入工号名进行查询">&nbsp;&nbsp;
    <button id="btuser"  type="button" class="btn btn-primary" onclick="getuser()">查询工号</button>&nbsp;&nbsp;
    <a href='${cpath}/user/toadduser'><button id="bt_adduser" type="button" class="btn btn-success"  >新增工号</button></a>

	<input type="hidden" id="saveusername">

	</form>
	
	<table id="usertable" class="table table-bordered table-hover definewidth m10">
    	<thead>
    	<tr>
	        <th>员工工号</th>
	        <th>员工姓名</th>
	        <th>创建时间</th>
			<th>所属客户</th>
	        <th>是否有效</th>
	        <th>最后登录时间</th>
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
    function getuser(){

        $("#saveusername").attr("value", $("#username").val().trim());

        var username=$("#saveusername").val();

        $.ajax({
            type: "POST",
            url:  "${cpath}/user/getuserlist",
            data: { page : 1, username:username},
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

        var username=$("#saveusername").val();

        $('.pagination').jqPagination({
            link_string :  '/?page={page_number}&username='+username,
            max_page :  allpage,
            paged : function( page ) {
                $.ajax({
                    type: "POST",
                    url:  "${cpath}/user/getuserlist",
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

            custname=ul[i].custname;
            if(typeof(custname)=="undefined") custname="";

            $("#usertable tbody").append("<tr>"+
                "<td>"+ul[i].workNo+"</td>"+
                "<td>"+ul[i].employeeName+"</td>"+
                "<td>"+ul[i].createTime+"</td>"+
                "<td>"+ custname+"</td>"+
                "<td>"+status+"</td>"+
                "<td>"+ul[i].lastLoginTime+"</td>"+
                "<td><a href='#' onclick=\"editUserInit('"  +ul[i].employeeId+"')\">编辑</a></td></tr>");

        }
    }
    function editUserInit(employeeId){
        window.location.href="${cpath}/user/findUser?employeeId="+employeeId;
    }
    getuser();

</script>
</html> 