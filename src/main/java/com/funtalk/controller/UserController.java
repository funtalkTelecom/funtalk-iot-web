package com.funtalk.controller;

import com.funtalk.pojo.TbSBillMode;
import com.funtalk.pojo.TbSCust;
import com.funtalk.pojo.TbSEmployee;
import com.funtalk.pojo.TbSMenu;
import com.funtalk.service.ModeService;
import com.funtalk.service.UserService;
import com.funtalk.utils.Page;
import com.funtalk.utils.Result;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private ModeService modeService;

	@RequestMapping("/getuserlist")
	@ResponseBody
	public Object getUsers(Map<String,Object> map, HttpServletRequest request,
			@RequestParam(value="username",required=false,defaultValue="") String username,
			@RequestParam(value="page",required=false,defaultValue="1")   Integer pageno,
			@RequestParam(value="pagesize",required=false,defaultValue="15")  Integer pagesize){

		Result result = new Result();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

		paramMap.put("username",username);
		paramMap.put("pageno",pageno);
		paramMap.put("pagesize",pagesize);
		paramMap.put("workno",user.getWorkNo());

		Page<TbSEmployee> page = userService.queryPage(paramMap);

		result.setCode(Result.OK);
		result.setMsg(page);

		return result;
	}


    @RequestMapping("/toadduser")
    public String toSendSms(HttpServletRequest request, Model model){

        List<TbSMenu> menuList=userService.getMemu();

        List<TbSCust> custList=userService.getCust();

        model.addAttribute("menus",menuList);
        model.addAttribute("custs",custList);

        return  "/user/adduser";

    }

    @RequestMapping("/validateworkno")
    @ResponseBody
    public Result validateWorkNo(@RequestParam(value="wrokno",defaultValue="") String wrokNo){

        List<TbSEmployee> employeeList=userService.validateWorkNo(wrokNo);
        if (employeeList.size()>0)
            return  new Result(Result.WARM_ERROR,"账号已存在!");
        return  new Result(Result.OK,"账号可以创建!");

    }

	@RequestMapping("/saveworkno")
	@ResponseBody
	public Result saveWorkNo(TbSEmployee employee){


		JSONObject json = new JSONObject();
		logger.debug("---->" + json.fromObject(employee).toString());

		int saveWorkNo=userService.saveWorkNo(employee);


		logger.info("-----insert return---->"+saveWorkNo);
		if (saveWorkNo>0)
		    return  new Result(Result.OK,"账户创建成功!");
		else
			return  new Result(Result.WARM_ERROR,"账户创建失败!");

	}
	@RequestMapping("/updateworkno")
	@ResponseBody
	public Result updateWorkNo(TbSEmployee employee){

		JSONObject json = new JSONObject();
		logger.debug("---->" + json.fromObject(employee).toString());

		if (!"".equals(employee.getWorkPwd())) {
			employee.setWorkPwd(DigestUtils.md5DigestAsHex(employee.getWorkPwd().getBytes()));
		}
		int saveWorkNo=userService.updateUserInfo(employee);


		logger.info("-----insert return---->"+saveWorkNo);
		if (saveWorkNo>0)
			return  new Result(Result.OK,"账户更新成功!");
		else
			return  new Result(Result.WARM_ERROR,"账户更新失败!");

	}
	@RequestMapping("/findUser")
	public String findUser(@RequestParam("employeeId") String employeeId,Model model){

		List<String> userMenus=userService.selectIds(employeeId);
		List<TbSCust> custList=userService.getCust();
		List<TbSMenu> menuList=userService.getMemu();
		model.addAttribute("menus",menuList);
		model.addAttribute("user",userService.getById(employeeId));
		model.addAttribute("custs",custList);
		model.addAttribute("usermenus",userMenus);

		List<TbSBillMode>  tbSBillModes =modeService.selectEPMode(employeeId);
		//model.addAttribute("mode", tbSBillModes.size()>0 ? tbSBillModes.get(0) :"");
		model.addAttribute("mode",  tbSBillModes.size()>0 ? tbSBillModes.get(0) :"");

		return "user/userup";
	}


}
