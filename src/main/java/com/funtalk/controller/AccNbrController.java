package com.funtalk.controller;

import com.funtalk.pojo.ParamData;
import com.funtalk.pojo.TbOBatchrecharge;
import com.funtalk.pojo.TbSCust;
import com.funtalk.pojo.TbSEmployee;
import com.funtalk.service.AccNbrService;
import com.funtalk.service.CustService;
import com.funtalk.service.SmsService;
import com.funtalk.service.UserService;
import com.funtalk.utils.Page;
import com.funtalk.utils.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/accnbr")
public class AccNbrController{

    Logger  logger = Logger.getLogger(AccNbrController.class);

    @Autowired CustService custService;
    @Autowired UserService userService;
    @Autowired AccNbrService  accNbrService;
    @Autowired SmsService  smsService;

    @RequestMapping("/toorderupload")
    public String toOrderUpload(HttpServletRequest request, Model model){

        List<TbSCust> custList=userService.getCust();

        List<ParamData>  pckList= accNbrService.getPackageList();

        model.addAttribute("custs",custList);
        model.addAttribute("pcks",pckList);

        return  "/accnbr/custorder";

    }

    @RequestMapping("/xlsupload")
    @ResponseBody
    public Result txtFileUpload(MultipartHttpServletRequest request){

       // Result result = new Result(Result.OK,"");

        String custid = request.getParameter("custid");//普通表单数据
        String pckId = request.getParameter("pckid");//普通表单数据
        MultipartFile multipartFile = request.getFile("orderfile");//获取文件

        Result result= accNbrService.savaExcel(custid,pckId,multipartFile);

        return  result;

    }


    @RequestMapping("/dealerRechargeFileUpload")
    @ResponseBody
    public Result dealerRechargeFileUpload(MultipartHttpServletRequest request){


        MultipartFile multipartFile = request.getFile("orderfile");//获取文件

        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        Result result= accNbrService.saveBatchRecharge(user.getCustId(),user.getWorkNo(),multipartFile);

        return  result;

    }


    @RequestMapping("/getrechargelist")
    @ResponseBody
    public Result getDealerRechargeList( HttpServletRequest request,
                       @RequestParam(required=false) String check,
                       @RequestParam(value="offset",required=false,defaultValue="0") Integer offset,
                       @RequestParam(value="limit",required=false,defaultValue="5") Integer limit){


        Result result = new Result();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        logger.info("------check------------>"+check);
        paramMap.put("check",check);
        paramMap.put("offset",offset);
        paramMap.put("limit",limit);
        paramMap.put("workno",user.getWorkNo());

        Page<TbOBatchrecharge> page = accNbrService.getDealerRechargeList(paramMap);
        result.setCode(Result.OK);
        result.setMsg(page);

        return result;

    }


    @RequestMapping("/savecheckstatus")
    @ResponseBody
    public Result saveCheckStatus( HttpServletRequest request, @RequestParam String batchId, @RequestParam String state,
                                   @RequestParam(required=false) String mark){

        String[] statusArray={"-1","1","0"};

        if (state == null|| !Arrays.asList(statusArray).contains(state))
            return new Result(Result.WARM_ERROR,"后台接收任务状态超出范围!");

        Map<String,Object> paramMap = new HashMap<String,Object>();
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        paramMap.put("batchId",batchId);
        paramMap.put("checkState",state);
        paramMap.put("mark",mark);

        Result result = accNbrService.updateStatus(paramMap);

        return result;

    }


/*    @RequestMapping("/updaterechargestate")
    @ResponseBody
    public Result updateRechargeState( HttpServletRequest request, @RequestParam String batchId){

        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("batchId",batchId);
        paramMap.put("rechargeState","1");

        Result result = accNbrService.updateStatus(paramMap);

        return result;

    }*/




    @RequestMapping("/payment")
    @ResponseBody
    public Result recharge(HttpServletRequest request,
                           @RequestParam String batchId, @RequestParam String amount){

        Result result=new Result();
        logger.info("--batchId:"+batchId+"----amount:"+amount);
        Map<String,Object> paramMap = new HashMap<String,Object>();
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");
        result = smsService.addChargeLog(user,amount,"weixin",3,batchId);

        return result;
    }

    @RequestMapping(value = "/getbatchdetail", method= RequestMethod.GET)
    public void getBatchDetail(HttpServletResponse response,
                               @RequestParam String batchId, @RequestParam String fileDbName){

        logger.info("--batchId:"+batchId+"----fileDbName:"+fileDbName);

        try {
            accNbrService.getBatchDetail(response, batchId, fileDbName);
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        }

    }

    @RequestMapping("/queryrecharge")
    @ResponseBody
    public Result queryRecharge(HttpServletRequest request,
                           @RequestParam String chargeId, @RequestParam String state){

        Result result;
        logger.info("--chargeId:"+chargeId+"----state:"+state);

        Map<String,String> paramMap = new HashMap<String,String>();

        paramMap.put("chargeId",chargeId);
        paramMap.put("state",state);

        result = accNbrService.queryRecharge(paramMap);

        return result;

    }



}
