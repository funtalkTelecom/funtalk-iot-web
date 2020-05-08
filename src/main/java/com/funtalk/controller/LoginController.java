package com.funtalk.controller;

import com.funtalk.pojo.TbSEmployee;
import com.funtalk.pojo.TbSMenu;
import com.funtalk.service.LoginService;
import com.funtalk.utils.Result;
import com.funtalk.utils.captcha.Captcha;
import com.funtalk.utils.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class LoginController {


	@Autowired
	private LoginService loginService;

	@RequestMapping("/")
	public String redirectIndex(HttpServletRequest request) {
		return "login";
	}


	@RequestMapping("/userLogin")
	@ResponseBody//响应体
	public ModelAndView loginVertify(HttpServletRequest request){

		String username       =request.getParameter("username");
		String password       =request.getParameter("password");
		String captcha        =request.getParameter("captcha");
		String sessionCaptcha =(String) request.getSession().getAttribute("code");

		request.getSession().removeAttribute("code");
		request.getSession().setAttribute("username",username);

		if (sessionCaptcha==null||!sessionCaptcha.equals(captcha))
		return new ModelAndView("/login").addObject("errormsg","验证码错误");

		TbSEmployee user=loginService.getUser(username);

		if (user != null  &&  password !=null  &&  user.getWorkPwd() != null
			&&	user.getWorkPwd().equals(DigestUtils.md5DigestAsHex(password.trim().getBytes()) )){

			user.setWorkPwd("");
			request.getSession().setAttribute("user",user);
			request.getSession().setMaxInactiveInterval(1800);  // session 有效时间60s

			return new ModelAndView("redirect:/main");
		}else
			return new ModelAndView("/login").addObject("errormsg","用户名或密码错误");

	}


	@GetMapping("/main")
	public ModelAndView index(HttpServletRequest request) {
		return new ModelAndView("/main");
	}


	@RequestMapping("/menuList")
	@ResponseBody
	public Result getMenuList(HttpServletRequest request){

		String username=(String) request.getSession().getAttribute("username");
		System.out.println("----workno------>"+username);

		List<TbSMenu>  userMenuList =loginService.getUserMenu(username);

		//return   new Result(Result.OK, JsonUtil.arrayToJson(userMenuList));
		return  new Result(Result.OK,userMenuList);

	}

	@RequestMapping("/getCapcha")
	public String verifyCode(HttpServletRequest request, HttpServletResponse response){

		HttpSession session = request.getSession();
		String code="";

		Captcha cha=new SpecCaptcha();
		char[] shu=cha.alphas();

		for(int i=0;i<shu.length;i++){
			code+=shu[i]+"";
		}

		Captcha captcha = new SpecCaptcha(125,45,4,shu);// gif格式动画验证码

		try {

			ServletOutputStream out =response.getOutputStream();
			captcha.out(response.getOutputStream());
			session.setAttribute("code", code);
			out.flush();
			out.close();

		}catch (Exception e){

			e.printStackTrace();
		}

		return null;
	}
	
}
