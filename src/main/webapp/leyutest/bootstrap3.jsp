<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet"   href="${cpath}/static/bootstrap3/css/bootstrap.min.css">

    <style>
        .start{padding: 40px 20px}

    </style>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top"  role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">Project Name</a>
        </div>

        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Content</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="start">
        <h1>Bootstrap starter template</h1>
        <p class="lead">欢迎来到乐语通信！！</p>
    </div>


<form  role="form" class="form-horizontal">

    <fieldset disabled></fieldset>    <!--  将内部所有元素禁用  -->
    <div class="form-group  has-success has-feedback">
      <!--  <label class="sr-only">用户名</label>  -->
        <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">用户名</label>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
        <input type="text" class="form-control" placeholder="请输入用户名">
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">密码</label>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
        <input type="password" class="form-control" placeholder="请输入密码">
        </div>
    </div>

     <div class="checkbox  col-xs-offset-2 col-sm-offset-2 col-md-offset-2  col-lg-offset-2">
        <label>
            <input type="checkbox"   value="">苹果
        </label>
         <label>
             <input type="checkbox"  value="">橘子
         </label>
     </div>

    <div class="radio col-xs-offset-2 col-sm-offset-2 col-md-offset-2  col-lg-offset-2">
        <label>
            <input type="radio" name="opsradio" checked>男
        </label>
        <label>
            <input type="radio" name="opsradio" >女
        </label>
    </div>
    <div class="form-group">
        <label class="col-xs-2 col-sm-2 control-label">职位</label>
       <div class=" col-xs-4  col-sm-4">
      <select class="form-control ">
        <option>工程师</option>
        <option>项目经理</option>
        <option>总经理</option>
      </select>
    </div>
    </div>

    <!-- <img src="../Images/pic1.jpg" class="img-rounded"> -->
    <!-- 下拉菜单要求jquery1.9及以上 -->
    <div class="form-group">
    <div class="dropdown col-sm-offset-2">
    <button id="dropdown1" class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown">
        下拉菜单<span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdown1">
        <li><a href="#" role="menuitem">语文</a></li>
        <li><a href="#" role="menuitem">数学</a></li>
        <li><a href="#" role="menuitem">英文</a></li>
        <li><a href="#" role="menuitem">物理</a></li>
    </ul>
    </div>
    </div>

    <div class="form-group">
    <div class=" col-sm-offset-2">
        <button class="btn bg-info">sign in</button>
    </div>
    </div>

    <div class="form-group">
    <div class="btn-group col-sm-offset-2">
        <button type="button" class="btn btn-default">left</button>
        <button type="button" class="btn btn-default">middle</button>
        <button type="button" class="btn btn-default">right</button>
    </div>
    </div>


    <div class="form-group">
        <div class="btn-group col-sm-offset-2">
            <button  class="btn btn-info btn-sm" type="button">下拉菜单</button>
            <button id="dropdown12" class="btn btn-info btn-sm dropdown-toggle" type="button" data-toggle="dropdown">
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdown12">
                <li><a href="#" role="menuitem">语文2</a></li>
                <li><a href="#" role="menuitem">数学2</a></li>
                <li><a href="#" role="menuitem">英文2</a></li>
                <li><a href="#" role="menuitem">物理2</a></li>
            </ul>
    </div>
    </div>


    <div class="form-group row">
    <div class="col-sm-offset-2 col-sm-4">

        <div class="input-group">
           <span class="input-group-btn">      <!-- 添加button ,span的class=input-group-btn-->
            <button  class="btn btn-info " type="button">下拉菜单</button>
            <button id="dropdown14" class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown">
                <span class="caret"></span> <!-- 三角形小图片-->
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdown12">
                <li><a href="#" role="menuitem">语文2</a></li>
                <li><a href="#" role="menuitem">数学2</a></li>
                <li><a href="#" role="menuitem">英文2</a></li>
                <li><a href="#" role="menuitem">物理2</a></li>
            </ul>
           </span>
           <input type="text" class="form-control">
           <span class="input-group-addon">.00</span>
        </div>
    </div>
    </div>


    <div class="form-group row">
        <div class="col-sm-offset-2 col-sm-4">
            <div class="input-group">
           <span class="input-group-addon">
               <input type="checkbox">      <!-- 可以添加button 如此，span 的class=input-group-btn-->
           </span>
                <span class="input-group-addon">$</span>
                <input type="text" class="form-control">
                <span class="input-group-addon">.00</span>
            </div>
        </div>
    </div>



    <div class="form-group has-success has-feedback">
        <label class="control-label col-sm-2" for="inputSuccess3">Input with success</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="inputSuccess3" aria-describedby="inputSuccess3Status">
            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
            <span id="inputSuccess3Status" class="sr-only">(success)</span>
        </div>
    </div>
    <div class="form-group has-success has-feedback">
        <label class="control-label col-sm-2" for="inputGroupSuccess2">Input group with success</label>
        <div class="col-sm-4">
            <div class="input-group">
                <span class="input-group-addon">@</span>
                <input type="text" class="form-control" id="inputGroupSuccess2" aria-describedby="inputGroupSuccess2Status">
            </div>
            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
            <span id="inputGroupSuccess2Status" class="sr-only">(success)</span>
        </div>
    </div>

</form>

</div>

</body>

<script src="../bootstrap3/js/jquery.min.js"></script>
<script src="../bootstrap3/js/bootstrap.min.js"></script>

</html>