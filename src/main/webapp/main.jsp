<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>

	<title>乐语通信服务平台</title> <!-- 乐语通信服务后台管理系统 -->
	<meta charset="UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta name="description" content="">
	<meta name="keys" content="">
	<meta name="author" content="">

    <%@include file="/includes/cssfile.jsp"%>
    <%@include file="/includes/jsfile.jsp"%>

	<link rel="stylesheet" type="text/css"  href="${cpath}/static/css/dpl-min.css"  />
	<link rel="stylesheet" type="text/css"  href="${cpath}/static/css/bui-min.css"  />
	<link rel="stylesheet" type="text/css"  href="${cpath}/static/css/main.css"  />
	<script type="text/javascript" src="${cpath}/static/js/bui-min.js"></script>
	<script type="text/javascript" src="${cpath}/static/js/main.js"></script>

</head>

<body>
	<div class="header">
	    <div class="dl-title">乐语通信服务平台</div>
	    <div class="dl-log">
	    	欢迎您，<span id="username" class="dl-log-user">${sessionScope.username}</span>
	    	<a href="login.jsp" title="退出系统" class="dl-log-quit">[退出]</a>
	    </div>
	</div>
	<div class="content">
	    <div class="dl-main-nav">
	        <div class="dl-inform"><div class="dl-inform-title"></div></div>
	        <!-- 一级菜单列表 可进行权限关联 -->
	        <ul id="J_Nav"  class="nav-list ks-clear"></ul>
	    </div>
	    <ul id="J_NavContent" class="dl-tab-conten"></ul>
	</div>


</body>


<script>

    (function(){

        $.ajax({
            type: "POST",
            url:  "${cpath}/menuList",
            data: { workno : sessionStorage.workno },
            dataType : "json",
            success: function( json ){

                $("#J_Nav").html("");

                ul = json.msg;

                for(var i in ul){

                    if(ul[i].menuParent=="" && ul[i].menuId=="1"){

                        $("#J_Nav").append("<li class='nav-item dl-selected'><div class='nav-item-inner nav-home'>"
                            +ul[i].menuName+"</div></li>	 ");

                    } else if(ul[i].menuParent==""){

                        $("#J_Nav").append("<li class='nav-item dl-selected'><div class='nav-item-inner nav-order'>"
                            +ul[i].menuName+"</div></li>	 ");
                    }
                }

                // 菜单 初始化
                BUI.use('common/main',function(){
                    var config = [];
                    var conf;
                    var menus = [];
                    var menu;
                    var items = [];
                    var item ;
                    var temp_p_menu_id = "";
                    for(var i in ul){
                        // 新的一级菜单
                        if( ul[i].menuParent=="" ){
                            conf = new Object();
                            conf.id = ul[i].menuId;
                            items = []; //清空数组
                            if(temp_p_menu_id!=ul[i].menuId){
                                menu = new Object();
                                menu.text = ul[i].menuName ;
                                menu.items = items;
                                menus.push(menu);
                                conf.menu = menus;
                                config.push(conf);
                                menus = []; //清空数组
                            }
                            temp_p_menu_id = ul[i].menuId; 		//当前一级菜单留存
                        } else if ( ul[i].menuParent!="" && ul[i].rMenuId!="" ){
                            item = new Object();
                            item.id = ul[i].menuId;
                            item.text = ul[i].menuName;
                            item.href = ul[i].pageLink;
                            items.push(item);
                        }
                    }
                    new PageUtil.MainPage({ modulesConfig : config });
                });
            },
            error: function(json){

                new TipBox({type:'error',str:'系统异常, 请联系管理员',hasBtn:true});
                return false;
            }
        });


    }());

</script>
</html>