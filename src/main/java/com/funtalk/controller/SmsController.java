package com.funtalk.controller;

import com.funtalk.pojo.*;
import com.funtalk.service.SmsService;
import com.funtalk.utils.Page;
import com.funtalk.utils.Result;
import com.funtalk.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.*;

@Controller
public class SmsController {

    Logger logger =Logger.getLogger(SmsController.class);

    @Autowired
    SmsService smsService;

    @RequestMapping("/sms/txtupload")
    @ResponseBody
    public Result txtFileUpload(HttpServletRequest request,@RequestParam("txtfile") MultipartFile file){

        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");
        Result result= smsService.savaTxtTask(user,file);

        return  result;

    }

    @RequestMapping("/sms/xlsupload")
    @ResponseBody
    public Result exeFileUpload(HttpServletRequest request,@RequestParam("xlsfile") MultipartFile file){

        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");
        Result result=smsService.savaExcelTask(user,file);

         return  result;

    }

/*    @RequestMapping("/tosend")
    public String toSendSms(HttpServletRequest request, Model model){

        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        List<TbSSmstemplate> list=smsService.getCustTemplates(user.getWorkNo());

        model.addAttribute("templates",list);
        return  "/sms/send";

    }*/


    @RequestMapping("/sms/save")
    @ResponseBody
    public Result saveSms(HttpServletRequest request){

        String receiver=request.getParameter("smsreceiver");
        String content=request.getParameter("smscontent");
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        Result result=smsService.saveOneSmsTask(user,receiver,content);

        return  result;

    }


    @RequestMapping("/sms/validateReceiver")
    @ResponseBody
    public Result validateReceiver(String smsreceiver){


        Result result=smsService.validateReceiver(smsreceiver);

        return  result;

    }

    @RequestMapping("/sms/gettemplate")
    @ResponseBody
    public Result getTemplate( Map<String,Object> map, HttpServletRequest request,
                                   @RequestParam String search,
                                   @RequestParam(value="offset",required=false,defaultValue="0") Integer offset,
                                   @RequestParam(value="limit",required=false,defaultValue="5") Integer limit){

        logger.info("----search-------->"+search);
        logger.info("----offset-------->"+offset);
        logger.info("----limit-------->"+limit);

        Result result = new Result();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        paramMap.put("search",search);
        paramMap.put("offset",offset);
        paramMap.put("limit",limit);
        paramMap.put("workno",user.getWorkNo());

        Page<TbSSmstemplate> page = smsService.getCustTemplates(paramMap);

        result.setCode(Result.OK);
        result.setMsg(page);

        return result;

    /*    String jsonarr="{\"total\": 8,\"rows\":[{\"id\": 1,\"templatecontent\":\"$，截至$月$日，您已逾期$天，逾期金额：$元。逾期行为将会对您的人行等征信记录产生不良的影响，请重视并积极妥善与我司协商解决您的逾期欠款，我司也会尽量协助您解决可能的困难，维护您的信用记录。为避免进一步的影响请立即还款或联系我司电话：$。\",\"templatetype\":\"催缴\"}, " +
                "{\"id\": 2,\"templatecontent\":\"$，至$月$日您已逾期$天，应还$元。其中$欠款$元，请在$还款。如果还有其余招联欠款，请在招联APP还款，若有疑问请咨询客服4000012222。我司即将临时冻结您的账户，逾期未还还将可能上报中国人民银行个人征信系统，请尽快还款。如已还款，无需理会。\",\"templatetype\":\"营销\"}," +
                "{\"id\": 3,\"templatecontent\":\"$，至$月$日您已超过还款日$天，应还金额：$元，为避免您的中国人民银行个人征信系统征信记录进一步恶化而影响您的日常银行借贷、出行、就业、子女教育等生活，请尽快还款，如已还款，无需理会。\",\"templatetype\":\"催缴\"}," +
                "{\"id\": 4,\"templatecontent\":\"$，截至$月$日，您已逾期$天，逾期金额：$元。逾期行为将会对您的人行等征信记录产生不良的影响，请重视并积极妥善与我司协商解决您的逾期欠款，我司也会尽量协助您解决可能的困难，维护您的信用记录。为避免进一步的影响请立即还款或联系我司电话：$。\",\"templatetype\":\"验证码\"}," +
                "{\"id\": 5,\"templatecontent\":\"$，至$月$日您已超过还款日$天，应还金额：$元，为避免您的中国人民银行个人征信系统征信记录进一步恶化而影响您的日常银行借贷、出行、就业、子女教育等生活，请尽快还款，如已还款，无需理会。\",\"templatetype\":\"验证码\"}," +
                "{\"id\": 6,\"templatecontent\":\"$，截至$月$日，您已逾期$天，逾期金额：$元。逾期行为将会对您的人行等征信记录产生不良的影响，请重视并积极妥善与我司协商解决您的逾期欠款，我司也会尽量协助您解决可能的困难，维护您的信用记录。为避免进一步的影响请立即还款或联系我司电话：$。\",\"templatetype\":\"催缴\"}," +
                "{\"id\": 7,\"templatecontent\":\"$，至$月$日您已超过还款日$天，应还金额：$元，为避免您的中国人民银行个人征信系统征信记录进一步恶化而影响您的日常银行借贷、出行、就业、子女教育等生活，请尽快还款，如已还款，无需理会。\",\"templatetype\":\"催缴\"}," +
                "{\"id\": 8,\"templatecontent\":\"$，截至$月$日，您已逾期$天，逾期金额：$元。逾期行为将会对您的人行等征信记录产生不良的影响，请重视并积极妥善与我司协商解决您的逾期欠款，我司也会尽量协助您解决可能的困难，维护您的信用记录。为避免进一步的影响请立即还款或联系我司电话：$。\",\"templatetype\":\"验证码\"}] }";

        return jsonarr;*/

    }


    @RequestMapping("/sms/getauditsms")
    @ResponseBody
    public Result getAuditSms( Map<String,Object> map, HttpServletRequest request,
                               @RequestParam String tempcontent,
                               @RequestParam String submitter,
                               @RequestParam(value="offset",required=false,defaultValue="0") Integer offset,
                               @RequestParam(value="limit",required=false,defaultValue="5") Integer limit){

        logger.info("----tempcontent-------->"+tempcontent);
        logger.info("----submitter-------->"+submitter);

        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");


        Result result = new Result();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("tempcontent",tempcontent);
        paramMap.put("submitter",submitter);
        paramMap.put("offset",offset);
        paramMap.put("limit",limit);
        paramMap.put("custId",user.getCustId());

        Page<TbSTaskA> page = smsService.getAuditSms(paramMap);

        result.setCode(Result.OK);
        result.setMsg(page);

        return result;

    }

    // 此方法给前端两个页面使用,主管审核,业务员发送
    @RequestMapping("/sms/savecheckstatus")
    @ResponseBody
    public Result saveCheckStatus( Map<String,Object> map, HttpServletRequest request,
                               @RequestParam String taskids,
                               @RequestParam String status){

        String[] statusArray={"-3","-2","0"};
        logger.info("----taskids-------->"+taskids);
        logger.info("----status-------->"+status);

        if (taskids == null || "".equals(taskids))
            return new Result(Result.WARM_ERROR,"后台接收taskid为空!");

        if (status == null|| !Arrays.asList(statusArray).contains(status))
            return new Result(Result.WARM_ERROR,"后台接收任务状态超出范围!");

        Map<String,Object> paramMap = new HashMap<String,Object>();
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        paramMap.put("tasklist",taskids.split(","));
        paramMap.put("status",status);
        paramMap.put("workno",user.getWorkNo());

        Result result = smsService.saveCheckStatus(paramMap);

        return result;

    }


    @RequestMapping("/sms/getworknosmslist")
    @ResponseBody
    public Result getSmsByWorkNo( Map<String,Object> map, HttpServletRequest request,
                               @RequestParam String tempcontent,
                               @RequestParam String taskstatus,
                               @RequestParam(value="offset",required=false,defaultValue="0") Integer offset,
                               @RequestParam(value="limit",required=false,defaultValue="5") Integer limit){

        logger.info("----offset-------->"+offset);
        logger.info("----limit-------->"+limit);
        logger.info("----tempcontent-------->"+tempcontent);
        logger.info("----taskstatus-------->"+taskstatus);

        Result result = new Result();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        paramMap.put("offset",offset);
        paramMap.put("limit",limit);
        paramMap.put("tempcontent",tempcontent);
        paramMap.put("taskstatus",taskstatus);
        paramMap.put("workno",user.getWorkNo());

        Page<TbSTaskA> page = smsService.getSmsByWorkNo(paramMap);
        result.setCode(Result.OK);
        result.setMsg(page);

        return result;

    }

    @RequestMapping("/sms/tocharge")
    public String toSendSms(HttpServletRequest request, Model model){

        Map<String,Object> paramMap = new HashMap<String,Object>();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");
        paramMap.put("employeeid",user.getEmployeeId());

        String  smsSendCount =smsService.getSmsAndDeposit(paramMap);
        String[]  smsArray   =smsSendCount.split("-");

        model.addAttribute("daycount",smsArray[0]);
        model.addAttribute("monthcount",smsArray[1]);

        model.addAttribute("deposit",decimalFormat.format((Number)(Float.parseFloat(smsArray[2]))));
        return  "/sms/charge";

    }

    @RequestMapping("/sms/recharge")
    @ResponseBody
    public Result recharge( Map<String,Object> map, HttpServletRequest request, @RequestParam String amount){

        Result result=new Result();
        logger.info("----amount-------->"+amount);
        Map<String,Object> paramMap = new HashMap<String,Object>();
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");
        result = smsService.addChargeLog(user,amount,"weixin",2,"");

        return result;
    }


    @RequestMapping("/sms/getchargelog")
    @ResponseBody
    public Result getChargelog( Map<String,Object> map, HttpServletRequest request,
                               @RequestParam String search,
                               @RequestParam(value="offset",required=false,defaultValue="0") Integer offset,
                               @RequestParam(value="limit",required=false,defaultValue="5") Integer limit){


        Result result = new Result();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        paramMap.put("search",search);
        paramMap.put("offset",offset);
        paramMap.put("limit",limit);
        paramMap.put("workno",user.getWorkNo());

        Page<TbLCharge> page = smsService.getChargelogByWorkno(paramMap);

        result.setCode(Result.OK);
        result.setMsg(page);

        return result;

    }


    @RequestMapping("/api/yst-pay-result")
    @ResponseBody
    public void ystPayResult(HttpServletRequest request) throws Exception{

        String  notify_return= "<data><result>Y</result><message>成功</message></data>";

        Map<String,String> params =Utils.xmlToMap(Utils.getParamBody(request));

        logger.info("请求来源地址："+Utils.getIpAddress(request));

        Map<String,String> headParams =Utils.getHeadersInfo(request);
        for (Map.Entry<String,String> entry : headParams.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }


        logger.info("接收到回调参数："+params);

        try {
            Result result = smsService.ystPayResult(params);

        }catch (Exception e){

        }

        logger.info("----------------->"+notify_return);

        Utils.renderXml(notify_return);

    }

    @RequestMapping("/sms/querypay")
    @ResponseBody
    public Result queryPayResult(@RequestParam String chargeId) throws Exception{

        Result result = smsService.queryPayResult(chargeId);
        return result;

    }


    @RequestMapping("/api/sms-result-test")
    @ResponseBody
    public void smsResultTest(HttpServletRequest request) throws Exception{


        String  notify_return= "<data><result>Y</result><message>成功</message></data>";



        logger.info("----------------->"+notify_return);

        Utils.renderXml(notify_return);

    }


}
