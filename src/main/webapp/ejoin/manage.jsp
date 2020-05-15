<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <%@include file="/includes/cssfile.jsp"%>
    <%@include file="/includes/jsfile.jsp"%>
    <script>
        function selectPort(){
            var IPPorts=document.getElementsByName("IPPorts");
            for(var i in IPPorts){
                var s=IPPorts[i];
                if(s.value.substring(0,s.value.indexOf("-"))==$(this).attr("id")){
                    alert("aa");
                }
            }
        };
        function showDist(){
            document.getElementById("distribute").style.display="block";
            document.getElementById("aDist").style.backgroundColor="lightgrey";
            document.getElementById("recover").style.display="none";
            document.getElementById("aRec").style.backgroundColor="white";
            document.getElementById("initialize").style.display="none";
            document.getElementById("aNew").style.backgroundColor="white";
            document.getElementById("forceChange").style.display="none";
            document.getElementById("aForce").style.backgroundColor="white";
        };
        function showRec(){
            document.getElementById("distribute").style.display="none";
            document.getElementById("recover").style.display="block";
            document.getElementById("initialize").style.display="none";
            document.getElementById("aDist").style.backgroundColor="white";
            document.getElementById("aRec").style.backgroundColor="lightgrey";
            document.getElementById("aNew").style.backgroundColor="white";
            document.getElementById("forceChange").style.display="none";
            document.getElementById("aForce").style.backgroundColor="white";
        };
        function showNew(){
            document.getElementById("distribute").style.display="none";
            document.getElementById("recover").style.display="none";
            document.getElementById("initialize").style.display="block";
            document.getElementById("aDist").style.backgroundColor="white";
            document.getElementById("aRec").style.backgroundColor="white";
            document.getElementById("aNew").style.backgroundColor="lightgrey";
            document.getElementById("forceChange").style.display="none";
            document.getElementById("aForce").style.backgroundColor="white";
        };
        function showForce(){
            document.getElementById("distribute").style.display="none";
            document.getElementById("recover").style.display="none";
            document.getElementById("initialize").style.display="none";
            document.getElementById("aDist").style.backgroundColor="white";
            document.getElementById("aRec").style.backgroundColor="white";
            document.getElementById("aNew").style.backgroundColor="white";
            document.getElementById("forceChange").style.display="block";
            document.getElementById("aForce").style.backgroundColor="lightgrey";
        };

        function distribute(){
            var IPPorts=document.getElementsByName("IPPorts");
            var IPPort=[];
            for(var i in IPPorts){
                if(IPPorts[i].checked){
                    IPPort.push(IPPorts[i].value);
                }
            }
            $.ajax({
                url:'<%=request.getContextPath()%>/ejoin/distribute',
                dataType:'json',
                type:'POST',
                data:{IPPorts:IPPort.join(),cust_id:$("#cust_id").val(),num:$("#num").val()},
                error:function(){
                    alert("error")
                },
                success:function () {
                    alert("分配成功！")
                }
            })


        };

    </script>
</head>
<body>


<div style="width: 2000px;height:1500px">
    <div style="width:60%;height:80px;margin-left:50px;margin-top:10px">
        <div>
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="#">资源管理</a></li>
            <li role="presentation"><a id="aDist" href="#" onclick="showDist()">分配</a></li>
            <li role="presentation"><a id="aRec" href="#" onclick="showRec()">回收</a></li>
            <li role="presentation"><a id="aNew" href="#" onclick="showNew()">新设备写卡</a></li>
            <li role="presentation"><a id="aForce" href="#" onclick="showForce()">手动切卡</a></li>
        </ul>
        </div>
        <div id="forceChange" style="display:none">
            <form action="<%=request.getContextPath()%>/ejoin/forceChange">
                <span style="width:30px;color:dodgerblue;font-size:20px;vertical-align:middle;margin-top: 8px">用户名&nbsp;</span>
                <input class="form-control" style="vertical-align:middle;margin-top: 6px" name="cust_id" type="text">
                <input class="btn btn-default"  type="submit" style="vertical-align:middle" value="手动切卡">
            </form>
        </div>
        <div id="recover" style="display:none">
            <form action="<%=request.getContextPath()%>/ejoin/recover">
            <span style="width:30px;color:dodgerblue;font-size:20px;vertical-align:middle;margin-top: 8px">请输入需要回收的用户名&nbsp;</span>
            <input class="form-control" style="vertical-align:middle;margin-top: 6px" name="cust_id" type="text">
            <input class="btn btn-default" type="submit" style="vertical-align:middle" value="确定">
            </form>
        </div>
        <div id="distribute" style="display:none">

            <div class="input-group" style="height:30px;float: left;font-size:20px">
                <span style="color:dodgerblue;vertical-align:middle">用户名&nbsp;&nbsp;</span>
                <input style="vertical-align:middle;margin-top: 8px" required="required" class="form-control" type="text" id="cust_id">
            </div>
            <div class="input-group" style="height:30px;float: left;font-size:20px;margin-left:10px;vertical-align:middle;">
                <span style="color:dodgerblue;vertical-align:middle">分配卡量&nbsp;&nbsp;</span>
                <input class="form-control" style="vertical-align:middle;margin-top: 8px" required="required" type="text" id="num">
            </div>
            <div style="float: left">
                <span style="width:30px">&nbsp;</span>
                <input class="btn btn-default" type="button" onclick="distribute()" style="vertical-align:middle;heigth:25px" value="确定">
            </div>

        </div>
        <div id="initialize" style="display:none">
            <form action="<%=request.getContextPath()%>/ejoin/recover/pushCard" method="post">
                <span style="width:30px;color:dodgerblue;font-size:20px;vertical-align:middle;margin-top: 8px">请输入新设备ip&nbsp;</span>
                <input class="form-control" style="vertical-align:middle;margin-top: 6px" name="ip" type="text">
                <input class="btn btn-default" type="submit" style="vertical-align:middle" value="确定">
            </form>
        </div>
    </div>
    <div style="width:95%;height:95%;margin:auto" >
        <c:forEach items="${datas}"  var="data">
            <div style="float:left;width:48%;margin: 5px;margin-top:20px;height:auto  ">
                <div style="margin: 3px;border:solid;border-width:1px;height: 400px;padding:3%">
                    <c:forEach items="${data}" var="arr">
                        <div style="float: left;width:12.5%;height:24%">
                            <div>用户名：${arr.cust_id}</div>
                            <div>端口：${arr.port}</div>
                            <div>电话号码：${arr.phone_num}</div>
                            <div><input class="btn btn-default" type="checkbox" name="IPPorts" value="${arr.ip}-${arr.port}"></div>
                        </div>
                    </c:forEach>
                </div>

                <div style="margin-top:10px;text-align:center">
                    <input id="${data.get(0).ip}" type="button" class="btn btn-default" onclick="selectPort()" value="ip:${data.get(0).ip}">
                </div>

            </div>
        </c:forEach>
    </div>
    <input type="button" onclick="select()" class="btn btn-default" value="aaaaa">
</div>
</body>
</html>
