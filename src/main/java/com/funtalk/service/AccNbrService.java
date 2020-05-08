package com.funtalk.service;

import com.funtalk.mapper.TbLChargeMapper;
import com.funtalk.mapper.TbOAccnbrMapper;
import com.funtalk.mapper.TbOBatchrechargeMapper;
import com.funtalk.mapper.TbOBatchsubMapper;
import com.funtalk.pay.PayRequest;
import com.funtalk.pay.PayResponse;
import com.funtalk.pay.YstPayStrategy;
import com.funtalk.pojo.*;
import com.funtalk.utils.Page;
import com.funtalk.utils.Result;
import com.funtalk.utils.StringUtil;
import com.funtalk.utils.Utils;
import com.sprite.ystpay.api.object.req.NativeQueryRequest;
import com.sprite.ystpay.api.object.res.NativeQueryResponse;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.*;

@Component
public class AccNbrService {

    Logger logger = Logger.getLogger(AccNbrService.class);

    @Autowired   TbOAccnbrMapper tbOAccnbrMapper;
    @Autowired   TbOBatchrechargeMapper  tbOBatchrechargeMapper;
    @Autowired   TbOBatchsubMapper  tbOBatchsubMapper;
    @Autowired   TbLChargeMapper  tbLChargeMapper;

    @Autowired private PayService payService;

    // web网页xls文件
    @Transactional
    public Result savaExcel(String custId,String pckId,MultipartFile file){

        int batchNum=0,allNum=0;
        String realPckId="";
        BigDecimal realPrice=null;
        POIFSFileSystem fs = null;
        List<TbOAccnbr> tbOAccnbrList = new ArrayList<TbOAccnbr>();


        if (pckId!=null && !pckId.equals("0") && pckId.split("-").length>0){

            realPckId= pckId.split("-")[0];
            realPrice= new BigDecimal(pckId.split("-")[1]);
        }


        try {

            fs = new POIFSFileSystem(file.getInputStream());
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet hssfSheet = wb.getSheetAt(0);

            if (hssfSheet != null) {

                //遍历excel,从第二行开始 即 rowNum=1,逐个获取单元格的内容,然后进行格式处理,最后插入数据库
                for( int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){

                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);

                    HSSFCell phoneCell = hssfRow.getCell(0);
                    phoneCell.setCellType(phoneCell.CELL_TYPE_STRING);

                    String phone = phoneCell.getStringCellValue().trim();
                   // String phone = Utils.formatXlsCell( hssfRow.getCell(0)).trim();

                    if ((phone != null && phone.length() != 0)) {
                        TbOAccnbr tbOAccnbr = new TbOAccnbr();
                        tbOAccnbr.setAccNbr(phone);
                        tbOAccnbr.setBelongType("1");
                        tbOAccnbr.setBelongId(custId);
                        tbOAccnbr.setIfValid("1");
                        tbOAccnbr.setState("2HA");
                        tbOAccnbr.setPakId(realPckId);
                        tbOAccnbr.setPakPrice(realPrice);

                        tbOAccnbrList.add(tbOAccnbr);
                    }

                    if (tbOAccnbrList.size()==100){

                        batchNum= tbOAccnbrMapper.addBatchOrder(tbOAccnbrList);
                        allNum+=100;
                        tbOAccnbrList.clear();
                    }
                }

            }else{
                return  new Result(Result.ERROR,"读取Excel文件内容错误!");
            }

        }catch(Exception e){
            e.printStackTrace();
            return  new Result(Result.ERROR,"读取Excel文件内容错误!");
        }

        if (tbOAccnbrList.size() > 0) {
            batchNum = tbOAccnbrMapper.addBatchOrder(tbOAccnbrList);
            allNum += tbOAccnbrList.size();
        }

        return  new Result(Result.OK,"操作成功,导入【"+allNum+"】条数据.");

    }



    // web网页上传xls充值文件
    @Transactional
    public Result saveBatchRecharge(String custId, String workNo, MultipartFile file){

        try{

            Thread.sleep(2000);

        }catch (Exception e){}


        String state="",path="",fileName="",chargeFileId="",docType="";
        int batchNum=0,allNum=0, rowNum=0;

        RechargeEntity  rEntity=null;
        List<RechargeEntity>  rechargeEntities =new ArrayList<>();

        BigDecimal totalAmount=new BigDecimal("0.00");
        POIFSFileSystem fs = null;


        TbOBatchrecharge  tbOBatchrecharge = new TbOBatchrecharge();
        List<TbOBatchsub> tbOBatchsubList = new ArrayList<TbOBatchsub>();

        fileName = file.getOriginalFilename();
        docType  = fileName.substring(fileName.lastIndexOf("."),fileName.length());

        chargeFileId= tbOBatchrechargeMapper.getTransId("charge_file_id");


        try{

            path = URLDecoder.decode(AccNbrService.class.getClassLoader().getResource("../../").getPath(), "utf-8");

            if (path.startsWith("/C:") || path.startsWith("/D:") )  path=path.substring(1);
            if (path.endsWith("/")) path=path.substring(0,path.length()-1);

            path+="/files/recharge/";

            logger.info("----path----"+path);

            StringUtil.saveFile(file.getInputStream(),path+chargeFileId+docType);

            fs = new POIFSFileSystem(file.getInputStream());
            HSSFWorkbook wb =  new HSSFWorkbook(fs);
            HSSFSheet hssfSheet=wb.getSheetAt(0);

            if(hssfSheet!=null){

                //遍历excel,从第二行开始 即 rowNum=1,逐个获取单元格的内容,然后进行格式处理,最后插入数据库
                for( rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){

                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    hssfRow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    String accnbr = hssfRow.getCell(0).getStringCellValue().trim();
                    String amount = Utils.formatXlsCell(hssfRow.getCell(1));

                    if ((!StringUtil.isEmpty(accnbr)  && !StringUtil.isEmpty(amount))) {

                        TbOBatchsub tbOBatchsub = new TbOBatchsub();
                        tbOBatchsub.setAccNbr(accnbr);
                        tbOBatchsub.setRechargeAmount(new BigDecimal(amount).setScale(2,BigDecimal.ROUND_DOWN));
                        tbOBatchsub.setBelongType("1");
                        tbOBatchsub.setBelongId(custId);

                        tbOBatchsubList.add(tbOBatchsub);

                        totalAmount=totalAmount.add(new BigDecimal(amount).setScale(2,BigDecimal.ROUND_DOWN));

                    }else{
                        return  new Result(Result.ERROR,"上传的文件第"+(rowNum+1)+"行数据内容为空!");
                    }
                }

            }else{

                return  new Result(Result.ERROR,"读取Excel文件sheet错误!");

            }

        }catch(Exception e){

            if (rowNum>=1)
                return  new Result(Result.ERROR,"上传的文件第"+(rowNum+1)+"行数据格式或内容错误!");
            else
                return  new Result(Result.ERROR,"读取Excel文件内容错误!");

        }

        try {

            if (tbOBatchsubList.size() > 0) {

                tbOBatchrecharge.setBelongType("1");
                tbOBatchrecharge.setBelongId(custId);
                tbOBatchrecharge.setWorkNo(workNo);
                tbOBatchrecharge.setFileDbName(fileName);
                tbOBatchrecharge.setFilePath("/files/recharge/");
                tbOBatchrecharge.setFileServerName(chargeFileId + docType);

                logger.info("-------before---insertSelective-----------");

                tbOBatchrechargeMapper.insertSelective(tbOBatchrecharge);

                logger.info("----------BatchId-----------" + tbOBatchrecharge.getBatchId());


                for (int i = 0; i < tbOBatchsubList.size(); i++) {

                    tbOBatchsubList.get(i).setBatchId(tbOBatchrecharge.getBatchId());

                }

                batchNum = tbOBatchsubMapper.addBatchSub(tbOBatchsubList);

                tbOBatchrechargeMapper.updateAmount(tbOBatchrecharge.getBatchId(),batchNum,totalAmount);

            }

        }catch (Exception e){

            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); // 事务回滚
            return  new Result(Result.ERROR,"系统异常,上传失败.");

        }

        List<String> checkList=tbOBatchsubMapper.checkAccnbrValid(tbOBatchrecharge.getBatchId());

        if (checkList.size()>0){

            tbOBatchsubMapper.deleteByBatchId(tbOBatchrecharge.getBatchId());

            logger.info("-----not valid number---------"+StringUtils.join(checkList,","));
            return  new Result(Result.ERROR,"下面号码不归属您,请删除再上传!【"+StringUtils.join(checkList,",")+"】");

        }

        return  new Result(Result.OK,"上传成功,导入"+batchNum+"个号码,充值总金额"+totalAmount.toString()+"元.");


    }


    public  List<ParamData>  getPackageList(){

       return tbOAccnbrMapper.getPackageList();
    }



    public  Page<TbOBatchrecharge> getDealerRechargeList(Map paramMap){

        int offset = (Integer) paramMap.get("offset");
        int limit = (Integer) paramMap.get("limit");

        Page<TbOBatchrecharge> subTaskPage = new Page<TbOBatchrecharge>(offset, null, limit);
        List<TbOBatchrecharge> subTaskList = tbOBatchrechargeMapper.getDealerRechargeList(paramMap);
        // 获取数据的总条数
        int subTaskCount = tbOBatchrechargeMapper.getDealerRechargeListCount(paramMap);

        subTaskPage.setData(subTaskList);
        subTaskPage.setTotalsize(subTaskCount);

        return subTaskPage;

    }

    public Result updateStatus(Map<String, Object> paramMap) {

        int i = tbOBatchrechargeMapper.updateState(paramMap);

        logger.info("---------update status--- result---" + i);

        if (i > 0)
            return new Result(Result.OK, i + "条任务更新成功!");
        else
            return new Result(Result.WARM_ERROR, "任务更新失败!");

    }

    @Transactional
    public Result queryRecharge(Map<String,String> paramMap ) {

        String payStatus="F";

        Map<String,Object> chargeParamMap =new HashMap<>();
        Map<String,Object> batchParamMap =new HashMap<>();

        TbLCharge  tbLCharge;
        TbLChargeExample tbLChargeExample =new TbLChargeExample();
        TbLChargeExample.Criteria criteria1=  tbLChargeExample.createCriteria();
        criteria1.andChargeIdEqualTo(Integer.valueOf(paramMap.get("chargeId")));

        List<TbLCharge> tbLChargeList = tbLChargeMapper.selectByExample(tbLChargeExample);

        if (tbLChargeList.size()>0 && StringUtils.isNotEmpty(tbLChargeList.get(0).getForId()))
            tbLCharge =tbLChargeList.get(0);
        else
            return new Result(Result.OK, "");


        chargeParamMap.put("chargeId",tbLCharge.getChargeId());
        batchParamMap.put("batchId",tbLCharge.getForId());

        if (tbLCharge.getPayStatus()==1 && StringUtils.isNotEmpty(tbLCharge.getSerNum()) ){

            payService.setThirdPayStrategy(YstPayStrategy.getInstance());

            PayResponse payResponse = payService.queryOrderList(new PayRequest(0,"leyu1002","",
                    tbLCharge.getSerNum(),"","","","W",
                    0,"","",""));


            if (payResponse.getResCode() == Result.OK) {

                JSONObject queryRetJson = JSONObject.fromObject(payResponse.getData());   // 取对方返回的 getData()= signature_info

                if (queryRetJson.containsKey("status"))
                    payStatus=queryRetJson.getString("status");

             }

            if ("S".equals(payStatus)){

                chargeParamMap.put("payStatus",2); // 付款成功
                chargeParamMap.put("payTime",new Date());
                chargeParamMap.put("chargeStatus",2); //默认充值成功,代理商批量充值此字段无用

                batchParamMap.put("payState","1");  // 付款成功

            }else if ("0".equals(paramMap.get("state"))){

                chargeParamMap.put("payStatus",4);  // 用户取消
                batchParamMap.put("payState","0");  // 用户可以再次付款
            }else
                return new Result(Result.OK, "");


            tbLChargeMapper.updateState(chargeParamMap);
            tbOBatchrechargeMapper.updateState(batchParamMap);

        }

        return new Result(Result.OK, "");
    }






    public void getBatchDetail(HttpServletResponse response, String batchId,String fileDbName) throws IOException {

        TbOBatchsub tbOBatchsub;

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();

        HSSFCellStyle style = wb.createCellStyle();

        HSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);


        CellStyle errorStyle = wb.createCellStyle();
        errorStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        errorStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        errorStyle.setFont(font);


        TbOBatchsubExample tbOBatchsubExample =new TbOBatchsubExample();
        TbOBatchsubExample.Criteria criteria1= tbOBatchsubExample.createCriteria();
        criteria1.andBatchIdEqualTo(Integer.valueOf(batchId));

        List<TbOBatchsub>  tbOBatchsubList= tbOBatchsubMapper.selectByExample(tbOBatchsubExample);

        HSSFRow hssfRow = sheet.createRow(0);

        HSSFCell cell;

        for (int cellnum = 0; cellnum < 3; cellnum++) {

                sheet.setColumnWidth(cellnum,4000);
                cell = hssfRow.createCell(cellnum);
                cell.setCellStyle(style);
                cell.setCellValue(cellnum==0 ? "手机号码": (cellnum ==1 ? "充值金额": "充值结果"));
        }

        for (int i = 0; i < tbOBatchsubList.size(); i++) {

             tbOBatchsub =tbOBatchsubList.get(i);

             hssfRow = sheet.createRow(i+1);

             for (int cellnum = 0; cellnum < 3; cellnum++) {

                 cell = hssfRow.createCell(cellnum);

                 cell.setCellStyle((cellnum==2 && !"1".equals(tbOBatchsub.getRechargeState())) ? errorStyle:style);

                 cell.setCellValue(cellnum==0 ? tbOBatchsub.getAccNbr():
                            (cellnum ==1 ? tbOBatchsub.getRechargeAmount().toString(): tbOBatchsub.getRechargeMark()));

             }
        }

        fileDbName="充值结果-"+fileDbName;
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileDbName.getBytes("UTF-8"),"iso-8859-1"));
        response.flushBuffer();
        OutputStream outputStream = response.getOutputStream();
        wb.write(response.getOutputStream());
        wb.close();
        outputStream.flush();
        outputStream.close();


    }





}
