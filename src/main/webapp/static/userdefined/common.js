//拦截所有ajax请求，实现登录超时，重定向  ajax请求返回执行流程：先执行success，再执行error，最后始终执行complete
$.ajaxSetup({
    complete:function(XMLHttpRequest,textStatus){
        //通过XMLHttpRequest取得响应结果
        var res = XMLHttpRequest.responseText;
        try{

            var json = JSON.parse(res);

            if (json.code=="310") {

                swal({
                    title:"登录超时,3秒后返回登录页面...",
                    icon: "warning",
                    timer: 3000,
                    closeOnClickOutside: false
                }).then(() => {
                    window.open(json.msg,'_parent');
            });

            }

            if(json.code=="400"){

                swal({title:"系统错误,请联系管理员!",icon: "error"});
                return false;
            }

        }catch(e){
        }
    }
});