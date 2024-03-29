package com.funtalk.config.interceptor;


import com.funtalk.utils.ApiSessionUtil;
import com.funtalk.utils.ReqLimitUtils;
import com.funtalk.utils.Result;
import com.funtalk.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class APIInterceptor implements HandlerInterceptor {
	public final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private ApiSessionUtil apiSessionUtil;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception {

    	request.setAttribute("_t_start_time",System.currentTimeMillis());
		int limitResult= ReqLimitUtils.residualReqNum("interceptor",new ReqLimitUtils.ReqLimit("yes","plat",1L,100,30*60L));//每秒请求超过100次后限制访问30分钟

		if(limitResult<=0){
			Utils.returnResult(new Result(Result.ERROR,"抱歉，您调用接口(API)的请求过于频繁，请稍候再试!"));
			System.out.println("访问接口(API)频率太高，限制访问!");
			return false;
		}

		System.out.println("访问频率正常,允许访问..........");

    /*	boolean _need_login=PowerInterceptor.hasNologin(handler);
		if(_need_login) return true;//有非登陆注解      直接通过
		Consumer user=apiSessionUtil.getConsumer();
//		User user=apiSessionUtil.getUser();
		if(user == null) {
			Utils.returnResult(new Result(3000,"登录超时或未登录，请登录！"));//为避免和代码中的300超时混淆，此处调整为3000为登录超时
			return false;
		}
		//token存在更新过期时间
		this.apiSessionUtil.updateExpire(this.apiSessionUtil.getTokenStr());
		Map<Integer, Object> userPower=new HashMap<>();
		boolean hasPower =PowerInterceptor.hasPower(request,handler,userPower);
		if(!hasPower){
			Utils.returnResult(new Result(Result.NOPOWER,"抱歉，权限不足！"));
			return false;
		}*/
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	Long _t_start_time=(Long) request.getAttribute("_t_start_time");
		log.info(String.format("请求[%s]耗时[%s]ms",request.getRequestURI(),(System.currentTimeMillis()-_t_start_time)));
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) throws Exception {
    }

}