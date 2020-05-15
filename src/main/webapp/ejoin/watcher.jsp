<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <%@include file="/includes/cssfile.jsp"%>
    <%@include file="/includes/jsfile.jsp"%>
</head>
<body>
    <div style="margin-top:10px;margin-left:50px;width:2000px ">
        <form action="<%=request.getContextPath()%>/ejoin/queryAll1" method="post">
            <div style="vertical-align:middle;color:dodgerblue;font-size:20px">请输入用户名</div>
            <div class="input-group">
                <input class="form-control" style="height:28px;margin-top:8px;vertical-align:middle" name="cust_id">
                <input class="btn btn-default" type="submit" style="vertical-align:middle;width:50px;vertical-align:middle" value="查询">
            </div>
        </form>

    <div>
        <div>
            <div style="margin-top:10px">
                <span style="font-size:18px">用户名：${cust_id}</span>
            </div>
            <div style="margin-top:10px">
                <span style="font-size:18px">卡量：${total}</span>
            </div>

        </div>
        <div>
            <div style="margin-top:10px">
                <span style="font-size:18px">位置:</span>
            </div>

            <c:forEach items="${IPPort}" var="map">
                <div style="height:80px;width:100%;margin-top:7px">
                    <hr>
                    <div style="font-size:15px;heigth:100%">
                        ip地址：${map.key}
                    </div>
                    <div style="height:100%;width:auto;margin-left:10px;margin-top:10px">
                        <c:forEach items="${map.value}" var="port">
                            <div style="float:left;margin-left:5px;width:100px">端口：${port}</div>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    </div>
</body>
</html>
