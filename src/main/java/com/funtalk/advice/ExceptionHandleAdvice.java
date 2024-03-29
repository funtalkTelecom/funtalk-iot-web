package com.funtalk.advice;


import com.funtalk.utils.Result;
import com.funtalk.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
/ 目前错误页面 还没有完成，ajax请求的异常处理已完成
 */

@ControllerAdvice
public class ExceptionHandleAdvice {

	public final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(ServiceException.class)
	public Object serviceException(Exception e, HttpServletRequest request, HttpServletResponse response){
		long err_no=System.currentTimeMillis();
		String errorInfo = String.format(e.getMessage()+"[错误编号：%s]",err_no);
		log.error(errorInfo,e);
		if(Utils.isAjax(request)){
			Utils.returnResult(new Result(Result.ERROR, errorInfo));
			return null;
		}
		ModelAndView v=new ModelAndView("error");
		v.addObject("errormsg",errorInfo);
		return v;
	}

	@ExceptionHandler(WarmException.class)
	public Object warmException(Exception e, HttpServletRequest request, HttpServletResponse response){
		long err_no=System.currentTimeMillis();
		String errorInfo = e.getMessage();
		log.error(errorInfo,e);
		if(Utils.isAjax(request)){
			Utils.returnResult(new Result(Result.ERROR, errorInfo));
			return null;
		}
		ModelAndView v=new ModelAndView("error");
		v.addObject("errormsg",errorInfo);
		return v;
	}

	@ExceptionHandler(Exception.class)
//	@InitBinder
//	@ModelAttribute
//	@Conditional(WindowsCondition.class)
	public Object exception(Exception e, HttpServletRequest request, HttpServletResponse response){
		long err_no=System.currentTimeMillis();
		String errorInfo = String.format("系统出现错误[错误编号%s]",err_no);
		log.error(errorInfo,e);
		if(Utils.isAjax(request)){
			Utils.returnResult(new Result(Result.ERROR, errorInfo));
			return null;
		}
		ModelAndView v=new ModelAndView("error");
		v.addObject("errormsg",errorInfo);
		return v;
	}
	

}
