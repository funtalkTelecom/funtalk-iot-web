package com.funtalk.config.interceptor;

import com.funtalk.utils.Result;
import com.funtalk.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@Component
public class ReqInterceptor implements HandlerInterceptor {

    public final Logger log = LoggerFactory.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {

        request.setAttribute("t_start_time",System.currentTimeMillis());
        String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";


        String basePath = request.getContextPath();
        String allPath = request.getRequestURI();

        System.out.println("--------allPath------->"+allPath+"---bashPath----"+basePath);

        Object user =request.getSession().getAttribute("user");
      //  String no_login="{\"code\":\"401\",\"msg\":\"登录超时或未登录，请登录!\"}";

        if(user == null){

            if (Utils.isAjax(request)) {


                Utils.returnResult(new Result(Result.TIME_OUT, path+"login.jsp"));
                log.info("-----ajax request --- no user,to login----path="+path+"login.jsp");

            }else{

                //方式1  这种方式的问题就是跳不出框架iframe
                // request.setAttribute("errormsg","登录超时,请重新登录!");
                // request.getRequestDispatcher("/").forward(request, response);
                // 方式2   这种方式的问题就是跳不出框架iframe
                // response.sendRedirect(path);  // 这种方式的问题就是跳不出框架iframe
                //  方式3
             /*   response.getWriter().write("<script>" +
                        "    window.top.location='"+path+"login.jsp';" +
                        "</script>");*/

                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<html>");
            //    out.println("<script type='text/javascript' src='/admin/js/jquery.min.js'></script>");
                out.println("<script type='text/javascript' src='"+path+"static/js/sweetalert.min.js'></script>");

                out.println("<script language=javascript> " +
                            "window.onload = function(){" +
                               "swal({ "+
                               "title: '登录超时,3s后返回登录页面...', "+
                               "icon: 'warning', "+
                               "timer: 3000, "+
                               "closeOnClickOutside: false "+
                        "}).then(() => {  "+
                               " window.open('"+path+"login.jsp','_parent'); }); }");

                out.println("</script>");
                out.println("</html>");

                log.info("-----no ajax request --- no user,to login -------");
            }

            return false;
        }

        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Long t_start_time=(Long) request.getAttribute("t_start_time");
        log.info(String.format("请求[%s]耗时[%s]ms",request.getRequestURI(),(System.currentTimeMillis()-t_start_time)));
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) throws Exception {
    }


    private boolean doLoginInterceptor(String path,String basePath){
        path = path.substring(basePath.length());
        Set<String> notLoginPaths = new HashSet<>();
        //设置不进行登录拦截的路径：登录注册和验证码
        notLoginPaths.add("/");
        notLoginPaths.add("/userLogin");

        if(notLoginPaths.contains(path)) return false;
        return true;
    }




}
