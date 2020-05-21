package com.funtalk.service;

import com.funtalk.mapper.*;
import com.funtalk.pay.PayRequest;
import com.funtalk.pay.PayResponse;
import com.funtalk.pay.YstPayStrategy;
import com.funtalk.pojo.*;
import com.funtalk.utils.*;
import com.sprite.ystpay.config.YSTConfig;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Component
public class SmsService {

    @Autowired private TbSTaskAMapper tbSTaskAMapper;
    @Autowired private TbSSmstemplateMapper tbSSmstemplateMapper;
    @Autowired private TbLChargeMapper tbLChargeMapper;
    @Autowired private TbSAcctMapper tbSAcctMapper;
    @Autowired private TbSDepositMapper tbSDepositMapper;
    @Autowired private PayService payService;
    @Autowired private TbOBatchrechargeMapper tbOBatchrechargeMapper;

    Logger logger = Logger.getLogger(SmsService.class);

    // 接口任务
    @Transactional
    public int savaTask(JSONObject reqjson) {

        String clientId = "", phoneNumbers = "", content = "", reqSeq = "", noticeUrl = "", smsType = "";

        String[] mobileArray;
        List<TbSTaskA> subtaskList = new ArrayList<TbSTaskA>();


        try {

            mobileArray = reqjson.getString("mobile").split(",");

            clientId = reqjson.getString("clientid");
            smsType = reqjson.getString("smstype");
            content = reqjson.getString("content");
            reqSeq = reqjson.getString("reqseq");
            noticeUrl = reqjson.getString("notifyurl");


            for (int i = 0; i < mobileArray.length; i++) {

                TbSTaskA subtask = new TbSTaskA();   // tb_s_substask 的state字段默认0(未发送), task_id 自增
                subtask.setTaskSource("31");
                subtask.setCustId(clientId);
                subtask.setPhoneB(mobileArray[i]);
                subtask.setMsg(content);
                subtask.setReqSeq(reqSeq);
                subtask.setNoticeUrl(noticeUrl);

                logger.info("----add-task---receiver--->" + mobileArray[i]);

                subtaskList.add(subtask);
            }

            return tbSTaskAMapper.addTaskBatch(subtaskList);

        } catch (Exception e) {

            return -1;

        }

    }


    // web网页txt文件
    @Transactional
    public Result savaTxtTask(TbSEmployee employee, MultipartFile file) {

        BufferedReader br;
        String s = null;
        int taskCount = 0;
        List<TbSTaskA> subtaskList = new ArrayList<TbSTaskA>();

        if (!file.isEmpty()) {


            try {

                File tempFile = File.createTempFile("tmp", ".txt");

                file.transferTo(tempFile);

                br = new BufferedReader(new FileReader(tempFile));

                while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行

                    logger.info("-------s-utf8----->" + new String(s.getBytes(), "utf-8"));
                    String[] lineData = s.split("\t");

                    TbSTaskA subtask = new TbSTaskA();

                    subtask.setTaskSource("32");
                    subtask.setCustId("LY01A00001");
                    subtask.setPhoneB(lineData[0].trim());
                    subtask.setMsg(lineData[1].trim());
                    subtask.setEmployeeId(employee.getEmployeeId());
                    subtask.setWorkNo(employee.getWorkNo());
                    subtaskList.add(subtask);

                    logger.info("----------->" + lineData[0] + "--------" + lineData[1]);

                }

                if (br != null) br.close();

                tempFile.deleteOnExit();

            } catch (Exception e) {

                e.printStackTrace();
                return new Result(Result.ERROR, "文件格式错误!");

            }
        } else {

            return new Result(Result.ERROR, "文件内容为空!");
        }

        int nums = tbSTaskAMapper.addTaskBatch(subtaskList);

        return new Result(Result.OK, "操作成功,导入" + nums + "条数据.");

    }

    // web网页xls文件
    @Transactional
    public Result savaExcelTask(TbSEmployee employee,MultipartFile file) {

        String state = "";
        POIFSFileSystem fs = null;
        List<TbSTaskA> subtaskList = new ArrayList<TbSTaskA>();

        TbSTaskA task = new TbSTaskA();

        try {

            fs = new POIFSFileSystem(file.getInputStream());
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet hssfSheet = wb.getSheetAt(0);

            if (hssfSheet != null) {


                //遍历excel,从第二行开始 即 rowNum=1,逐个获取单元格的内容,然后进行格式处理,最后插入数据库
                for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {

                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);

                    HSSFCell phoneCell = hssfRow.getCell(0);
                    phoneCell.setCellType(phoneCell.CELL_TYPE_STRING);
                    String phone = phoneCell.getStringCellValue().trim();

                    String msg = Utils.formatXlsCell(hssfRow.getCell(1)).trim();


                    if ((phone != null && phone.length() != 0) && (msg != null && msg.length() != 0)) {

                        TbSTaskA subtask = new TbSTaskA();
                        subtask.setTaskSource("33");
                        subtask.setCustId("LY01A00001");
                        subtask.setPhoneB(phone);
                        subtask.setMsg(msg);
                        subtask.setEmployeeId(employee.getEmployeeId());
                        subtask.setWorkNo(employee.getWorkNo());
                        subtaskList.add(subtask);

                    }
                }

            } else {
                return new Result(Result.ERROR, "读取Excel文件内容错误!");
            }

        } catch (Exception e) {
            return new Result(Result.ERROR, "读取Excel文件内容错误!");
        }


        int nums = tbSTaskAMapper.addTaskBatch(subtaskList);

        return new Result(Result.OK, "操作成功,导入" + nums + "条数据.");

    }

    //web网页单条短信任务
    public Result saveOneSmsTask(TbSEmployee user, String receiver, String content) {

        TbSTaskA subtask = new TbSTaskA();

        subtask.setTaskSource("34");
        subtask.setCustId(user.getCustId());
        subtask.setPhoneB(receiver);
        subtask.setMsg(content);
        subtask.setState("-1");      // -1:待审核  0:审核通过   -2:审核不通过
        subtask.setEmployeeId(user.getEmployeeId());
        subtask.setWorkNo(user.getWorkNo());
        subtask.setCustId(user.getCustId());
        tbSTaskAMapper.insertFromPC(subtask);

        return new Result(Result.OK, "任务添加成功!");

    }

    public Result validateReceiver(String receiver) {

 /*       TbSSubtaskResultExample example = new TbSSubtaskResultExample();
        TbSSubtaskResultExample.Criteria criteria = example.createCriteria();


        Calendar c = Calendar.getInstance();  //得到当前日期和时间
        c.set(Calendar.HOUR_OF_DAY, 0);       //把当前时间小时变成０
        c.set(Calendar.MINUTE, 0);            //把当前时间分钟变成０
        c.set(Calendar.SECOND, 0);            //把当前时间秒数变成０
        c.set(Calendar.MILLISECOND, 0);       //把当前时间毫秒变成０
        Date today = c.getTime();             //创建当天的0时0分0秒一个date对象

        criteria.andPhoneBEqualTo(receiver);
        criteria.andIfSendNotEqualTo("3");  // 3发送失败
        criteria.andSendDateGreaterThanOrEqualTo(today);

        if (tbSSubtaskResultMapper.selectByExample(example).size()>0)
            return  new Result(Result.WARM_ERROR,"今天已经发送!");  */

        if (tbSTaskAMapper.queryrecordcount(receiver) > 0)
            return new Result(Result.WARM_ERROR, "今天已经发送!");

        return new Result(Result.OK, "可以发送!");

    }


    public Page<TbSSmstemplate> getCustTemplates(Map<String, Object> paramMap) {

/*      TbSSmstemplateExample example = new TbSSmstemplateExample();
        TbSSmstemplateExample.Criteria criteria = example.createCriteria();
        criteria.andCustIdEqualTo(custId);
        return tbSSmstemplateMapper.selectByExample(example); */

        int offset = (Integer) paramMap.get("offset");
        int limit = (Integer) paramMap.get("limit");

        Page<TbSSmstemplate> templatePage = new Page<TbSSmstemplate>(offset, null, limit);
        List<TbSSmstemplate> advertList = tbSSmstemplateMapper.getpageQueryByCust(paramMap);
        // 获取数据的总条数
        int count = tbSSmstemplateMapper.queryCount(paramMap);

        templatePage.setData(advertList);
        templatePage.setTotalsize(count);

        return templatePage;

    }

    public Page<TbSTaskA> getAuditSms(Map<String, Object> paramMap) {

        int offset = (Integer) paramMap.get("offset");
        int limit = (Integer) paramMap.get("limit");


        Page<TbSTaskA> subTaskPage = new Page<TbSTaskA>(offset, null, limit);
        List<TbSTaskA> subTaskList = tbSTaskAMapper.getNeedAuditSms(paramMap);
        // 获取数据的总条数
        int subTaskCount = tbSTaskAMapper.getNeedAuditSmsCount(paramMap);

        subTaskPage.setData(subTaskList);
        subTaskPage.setTotalsize(subTaskCount);

        return subTaskPage;

    }


    public Result saveCheckStatus(Map<String, Object> paramMap) {

        int i = tbSTaskAMapper.updateCheckStatus(paramMap);

        logger.info("---------update status--- result---" + i);

        if (i > 0)
            return new Result(Result.OK, i + "条任务更新成功!");
        else
            return new Result(Result.WARM_ERROR, "任务更新失败!");

    }


    public Page<TbSTaskA> getSmsByWorkNo(Map<String, Object> paramMap) {

        int offset = (Integer) paramMap.get("offset");
        int limit = (Integer) paramMap.get("limit");

        Page<TbSTaskA> subTaskPage = new Page<TbSTaskA>(offset, null, limit);
        List<TbSTaskA> subTaskList = tbSTaskAMapper.getSmsByWorkNo(paramMap);
        // 获取数据的总条数
        int subTaskCount = tbSTaskAMapper.getSmsByWorkNoCount(paramMap);

        subTaskPage.setData(subTaskList);
        subTaskPage.setTotalsize(subTaskCount);

        return subTaskPage;

    }

    // 支持按cust_id或者employee_id 或者代理商批量 充值 chargeFor区分
    public Result addChargeLog(TbSEmployee user, String amount, String thirdPayType, int chargeFor,String batchId) {

        int chargeType = 0, transIdMid = 0, acctId = 0, chargeAmount = 0;
        String transIdStart = null, transIdEnd = null, SN = null, orderType="1",
                belongType = null, belongId = null, forId = null;

        Map<String,Object> chargeParamMap =new HashMap<>();
        Map<String,Object> batchParamMap =new HashMap<>();

//        Map<String, Object> data = new HashMap<String, Object>();

        if (StringUtils.isBlank(user.getWorkNo())
                || StringUtils.isBlank(amount)
                || StringUtils.isBlank(thirdPayType)) {

            return new Result(Result.ERROR, "系统错误:前端参数异常!");
        }

        if ("weixin".equals(thirdPayType)) {
            chargeType = 1;
            transIdStart = "wx";
        } else if ("zhifubao".equals(thirdPayType)) {
            chargeType = 2;
            transIdStart = "zfb";
        }

        //chargeFor  1:客户充值 2:工号充值 3:手机号码充值(代理商批量充) 第三种情况,forId不需要赋值;
        if (chargeFor == 1) {
            belongType = "1";
            belongId = user.getCustId();
            forId = user.getCustId();
        } else if (chargeFor == 2) {
            belongType = "2";
            belongId = String.valueOf(user.getEmployeeId());
            forId = String.valueOf(user.getEmployeeId());
        }else if (chargeFor== 3){  // 批量充值 默认放到cust_id

                belongType = "1";
                belongId = user.getCustId();
                orderType ="2"; // 代理商批量充值支付
                forId=batchId;

                batchParamMap.put("batchId",batchId);
        }



        transIdMid = tbLChargeMapper.getTransId("charge_trans_id");
        transIdEnd = String.format("%04d", new Random().nextInt(9999));

        SN = transIdStart + String.valueOf(transIdMid) + transIdEnd;

        chargeAmount = ((Number) (Float.parseFloat(amount) * 100)).intValue();

        //从tb_s_acct表中取有效acct_id
        TbSAcctExample tbSAcctExample = new TbSAcctExample();
        TbSAcctExample.Criteria criteria1 = tbSAcctExample.createCriteria();
        criteria1.andBelongIdEqualTo(belongId);
        criteria1.andBelongTypeEqualTo(belongType);
        criteria1.andIfValidEqualTo("1");
        List<TbSAcct> tbSAccts = tbSAcctMapper.selectByExample(tbSAcctExample);
        if (tbSAccts.size() > 0) acctId = tbSAccts.get(0).getAcctId();

        TbLCharge chargeLog = new TbLCharge();
        chargeLog.setChargeType(chargeType); // 1:微信 2:支付宝 3:银联
        chargeLog.setAcctId(acctId);
        chargeLog.setDeCode("11");
        chargeLog.setPayAmount(chargeAmount);  //数据库中存储单位:分
        chargeLog.setAmount(chargeAmount);
        chargeLog.setPayStatus(1);  // 1:预付单 2:付款成功 3:付款失败
        chargeLog.setChargeStatus(1); // 1:充值中 2:充值成功 3:充值失败 4:已返销
        chargeLog.setChargeFor(chargeFor);  //1:客户充值 2:工号充值 3:手机号码充值(代理商批量充)
        chargeLog.setForId(forId);
        chargeLog.setWorkNo(user.getWorkNo());
        chargeLog.setSerNum(SN);  // 与外部接口交易的流水  A-->B  A生成的流水

        tbLChargeMapper.insert(chargeLog);

        chargeParamMap.put("chargeId",chargeLog.getChargeId());

        logger.info(DateUtil.formatFullDate(new Date()) + "====ammount:" + amount + "元,ChargeId:" + chargeLog.getChargeId() + "---SN--" + SN);
        payService.setThirdPayStrategy(YstPayStrategy.getInstance());

        //没有使用赢商通的流水类;  String requestSequence = com.sprite.ystpay.utils.StringUtils.getRandomSequence();
        // remark 使用SystemParam.get("yst-account") 代替  目前双方协商账户为 leyu1002;
        // amt 暂时修改为 1分 测试用  回调地址暂时使用ngrok生成的临时地址
        // payee: 梧桐靓号小程序APPID
        // payer: 用户在梧桐靓号小程序的openid    qiluwxp 的openid= oGTb-4-HyG2B8DrVWhUdPy4FeawY 测试用；
        PayResponse payResponse = payService.payOrder(
                new PayRequest(chargeAmount, // amt 需要支付金额
                        "", // payee
                        "",//payer,
                        SN, SN,
                        null, orderType,// orderName 区分不同充值类型  2 代理商批量充值支付
                        "YST", chargeAmount,
                        "leyu1002", // 和赢商通约定的账户号,不同业务需要赢商通创建不同的账户号
                        "",
                        //SystemParam.get("domain-full")+"/api/yst-pay-result"));
                        //"http://350fa95f.ngrok.io/api/yst-pay-result"
                        //    http://weixin.funtalk.cn:9080        https://weixin.funtalk.cn:9088
                        "http://weixin.funtalk.cn:9080/iotweb/api/yst-pay-result"));

        if (payResponse.getResCode() == Result.OK) {

            String[] keys = {"requestSequence", "responseSequence", "transSequence", "payUrl", "result", "code"};
            JSONObject ystPrepayRetJson = JSONObject.fromObject(payResponse.getData());   // 取对方返回的 getData()= signature_info

            for (String key : keys) {
                if (!ystPrepayRetJson.containsKey(key) && StringUtils.isBlank(ystPrepayRetJson.getString(key))) {

                    chargeParamMap.put("payStatus",-1);
                    chargeParamMap.put("remark","赢商通支付接口返回参数(缺失或为空)异常:" + key);

                    tbLChargeMapper.updateState(chargeParamMap);

                    return  new Result(Result.ERROR, "系统错误:支付参数异常!");

                }
            }

           if (chargeFor==3){
               batchParamMap.put("payState","2");  // 正在支付中,等待用户扫码支付...
               tbOBatchrechargeMapper.updateState(batchParamMap);
           }

            Map qrPayMap = new HashMap();

            qrPayMap.put("workNo", user.getWorkNo());
            qrPayMap.put("chargeId", chargeLog.getChargeId());
            qrPayMap.put("amount", amount);
            qrPayMap.put("payUrl", ystPrepayRetJson.getString("payUrl"));

            return  new Result(Result.OK, qrPayMap);

        } else {

            chargeParamMap.put("payStatus",-1);
            chargeParamMap.put("remark","赢商通生成扫码数据失败:"+
                    payResponse.getResDesc() == null ? "":
                    payResponse.getResDesc().length() > 80 ?
                            payResponse.getResDesc().substring(0,79):payResponse.getResDesc());

            tbLChargeMapper.updateState(chargeParamMap);

            if (chargeFor==3){
                batchParamMap.put("payState","-1");
                tbOBatchrechargeMapper.updateState(batchParamMap);

            }

            return  new Result(payResponse.getResCode(), payResponse.getResDesc());

        }

    }


    public Result ystPayResult(Map<String, String> params) {

        int payStatus;
        String status="",attach="";

        TbLCharge tbLCharge=null;

        Map<String,Object> batchParamMap =new HashMap();
        Map<String,Object> chargeParamMap =new HashMap();

        logger.info("接收到回调参数：" + params);

        //privateKey 需要改为在数据库中配置  SystemParam.get("ystPayKey")
        String returnSign = PayUtil.getSign(params, YSTConfig.decodePrivateKey(YstPayStrategy.privateKey));

        logger.info("-----local-sign--------：" + returnSign);

        if (returnSign != null && returnSign.equals(params.get("sign"))) {

            String serNum = params.get("req_seq");

            TbLChargeExample example = new TbLChargeExample();
            example.createCriteria().andSerNumEqualTo(serNum);
            example.createCriteria().andPayStatusEqualTo(1);
            List<TbLCharge> chargelist = tbLChargeMapper.selectByExample(example);

            if (chargelist.size() <= 0)
                return new Result(Result.OK, "已处理");

             tbLCharge = chargelist.get(0);

             chargeParamMap.put("chargeId",tbLCharge.getChargeId());
             batchParamMap.put("batchId",tbLCharge.getForId());

                status = params.get("status");
                attach = params.get("attach");

            if (status.contains("S")) {// 支付成功，赢商通会返回state="S"

/*                tbLCharge.setPayStatus(2);  //支付成功
                tbLCharge.setPayTime(new Date());
                tbLCharge.setChargeStatus(2);//充值成功
                tbLChargeMapper.updateByExampleSelective(tbLCharge, example);*/

                if ("2".equals(attach)){   // 代理商批量充值

                    batchParamMap.put("payState","1");
                    tbOBatchrechargeMapper.updateState(batchParamMap);

                }else {

                    TbSDeposit tbSDeposit = new TbSDeposit();
                    tbSDeposit.setBelongType(String.valueOf(tbLCharge.getChargeFor()));  //账本归属：1客户,2工号
                    tbSDeposit.setBelongId(tbLCharge.getForId());  //cust_id或者employee_id
                    tbSDeposit.setAcctId(tbLCharge.getAcctId());
                    tbSDeposit.setDeCode(tbLCharge.getDeCode());
                    tbSDeposit.setAvailMoney(tbLCharge.getAmount());
                    tbSDeposit.setUpdateTime(tbLCharge.getCreateTime());

                    tbSDepositMapper.updateDeposit(tbSDeposit);

                }

                chargeParamMap.put("payStatus",2);
                chargeParamMap.put("payTime",new Date());
                chargeParamMap.put("chargeStatus",2); //充值成功
                tbLChargeMapper.updateState(chargeParamMap);


            } else {

   /*           tbLCharge.setPayStatus(3);  //支付失败
                tbLChargeMapper.updateByExampleSelective(tbLCharge, example);
                */

                chargeParamMap.put("payStatus",3);
                chargeParamMap.put("remark","付款失败");
                tbLChargeMapper.updateState(chargeParamMap);


                if ("2".equals(attach)){
                    batchParamMap.put("payState","2");
                    tbOBatchrechargeMapper.updateState(batchParamMap);

                }

            }

            return new Result(Result.OK, "success");

        } else{

            chargeParamMap.put("payStatus",-2);
            chargeParamMap.put("remark","赢商通回调数据为空或签名验证失败");
            tbLChargeMapper.updateState(chargeParamMap);


            if ("2".equals(attach)){
                batchParamMap.put("batchId",tbLCharge.getForId());
                batchParamMap.put("payState","-2");
                tbOBatchrechargeMapper.updateState(batchParamMap);

            }

            return new Result(Result.ERROR, "验签失败");

        }
    }


    public Result queryPayResult(String chargeId) {

        TbLCharge tbLCharge = null;
        TbLChargeExample example = new TbLChargeExample();
        example.createCriteria().andChargeIdEqualTo(Integer.valueOf(chargeId));
        List<TbLCharge> chargelist = tbLChargeMapper.selectByExample(example);

        if (chargelist.size() > 0) {
            tbLCharge = chargelist.get(0);
            return new Result(Result.OK, tbLCharge.getPayStatus());
        } else {
            return new Result(Result.WARM_ERROR, "没有查询到记录");
        }
    }

    public String getSmsAndDeposit(Map<String, Object> paramMap) {

        return tbSTaskAMapper.getSmsAndDeposit(paramMap);

    }


    public Page<TbLCharge> getChargelogByWorkno(Map<String, Object> paramMap) {

        int offset = (Integer) paramMap.get("offset");
        int limit = (Integer) paramMap.get("limit");

        Page<TbLCharge> chargePage = new Page<TbLCharge>(offset, null, limit);
        List<TbLCharge> chargeList = tbLChargeMapper.getChargelogByWorkno(paramMap);
        // 获取数据的总条数
        int chargeCount = tbLChargeMapper.getChargelogByWorknoCount(paramMap);

        chargePage.setData(chargeList);
        chargePage.setTotalsize(chargeCount);

        return chargePage;

    }


}
