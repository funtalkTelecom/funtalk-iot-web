<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet"  href="${cpath}/static/bootstrap3/css/bootstrap.min.css">
    <script type="text/javascript" src="${cpath}/static/js/jquery-1.8.1.min.js"></script>
    <script src="${cpath}/static/bootstrap3/js/bootstrap.min.js"></script>
    <script>

        $(function(){

            $("#mytab1 a").click(function () {
                console.log("---------");
                $(this).tab("show");
            });

            $("#mytab2 a").click(function () {
                console.log("---------");
                $(this).tab("show");
            });
        })
    </script>
</head>
<body>

<div class="container">
    <ul id="mytab1"  class="nav nav-pills nav-justified" role="tablist">  <!-- tabs展示： nav-tabs   胶囊式展示：nav-pills -->
        <li role="presentation" ><a href="#">home</a> </li>
        <li role="presentation"><a href="#">shandong</a> </li>
        <li role="presentation"><a href="#">beijing</a> </li>
    </ul>


    <ul id="mytab2"  class="nav nav-tabs" role="tablist">  <!-- tabs展示： nav-tabs   胶囊式展示：nav-pills -->
        <li role="presentation" ><a href="#">home</a> </li>
        <li role="presentation"><a href="#">shandong</a> </li>
        <li role="presentation"><a href="#">beijing</a> </li>
    </ul>

</div>



</body>
</html>