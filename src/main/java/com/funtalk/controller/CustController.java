package com.funtalk.controller;

import com.funtalk.pojo.TbSCust;
import com.funtalk.pojo.TbSEmployee;
import com.funtalk.pojo.TbSMenu;
import com.funtalk.service.CustService;
import com.funtalk.service.UserService;
import com.funtalk.utils.Page;
import com.funtalk.utils.Result;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("/cust")
public class CustController {

	private static Logger logger = Logger.getLogger(CustController.class);

	@Autowired
	private CustService custService;


	@RequestMapping("/getcustlist")
	@ResponseBody
	public Object getCusts(Map<String,Object> map, HttpServletRequest request,
			@RequestParam(value="custname",required=false,defaultValue="") String custname,
			@RequestParam(value="page",required=false,defaultValue="1")   Integer pageno,
			@RequestParam(value="pagesize",required=false,defaultValue="15")  Integer pagesize){

		Result result = new Result();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

		paramMap.put("custname",custname);
		paramMap.put("pageno",pageno);
		paramMap.put("pagesize",pagesize);
		paramMap.put("workno",user.getWorkNo());

		Page<TbSCust> page = custService.queryPage(paramMap);

		result.setCode(Result.OK);
		result.setMsg(page);

		return result;
	}

    @RequestMapping("/validatecustname")
    @ResponseBody
    public Result validateCustName(@RequestParam(value="custname",defaultValue="") String custname){

        List<TbSCust> employeeList=custService.validateCustName(custname);
        if (employeeList.size()>0)
            return  new Result(Result.WARM_ERROR,"客户名称已存在!");
        return  new Result(Result.OK,"可以创建!");

    }

	@RequestMapping("/savecustinfo")
	@ResponseBody
	public Result saveCustInfo(TbSCust tbSCust){


		JSONObject json = new JSONObject();
		logger.debug("---->" + json.fromObject(tbSCust).toString());

		int saveCust=custService.saveCustInfo(tbSCust);

		logger.info("-----insert return---->"+saveCust);
		if (saveCust>0)
		    return  new Result(Result.OK,"客户创建成功!");
		else
			return  new Result(Result.WARM_ERROR,"客户创建失败!");

	}
	
}
