package com.funtalk.controller;

import com.funtalk.service.SmsService;
import com.funtalk.utils.Result;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiSmsController {

    private static Logger logger = Logger.getLogger(ApiSmsController.class);

    @Autowired
    SmsService smsService;

    @RequestMapping("/api/sendphone")
    @ResponseBody
    public Result receiveSmsTask(@RequestBody JSONObject reqjson){

        String[] mobileArray;
        Result  result=new Result(1,"OK");

        String clientId="",phoneNumbers= "",content="",reqSeq="",notifyUrl="",smsType="";


        try{
            clientId        = reqjson.getString("clientid");
            phoneNumbers    = reqjson.getString("mobile");
            smsType         = reqjson.getString("smstype");
            content         = reqjson.getString("content");
            reqSeq          = reqjson.getString("reqseq");
            notifyUrl       = reqjson.getString("notifyurl");

        }catch(JSONException e){

            result.setCode(2);
            result.setMsg("Json报文格式错误");
            return result;

        }

        if (phoneNumbers!=null &&phoneNumbers!=""){

            mobileArray= phoneNumbers.split(",");

            if(mobileArray.length>500){
                result.setCode(2);
                result.setMsg("单次请求号码个数超过500!");

            }else{

            int  nums= smsService.savaTask(reqjson);

               if(nums==mobileArray.length){

                  result.setCode(1);
                  result.setMsg("接收成功!");

               }else{

                  result.setCode(2);
                  result.setMsg("接收失败,请重新传输!");
               }
           }

        }else {

            result.setCode(2);
            result.setMsg("号码字段为空!");
        }

        return result;

    }


}
