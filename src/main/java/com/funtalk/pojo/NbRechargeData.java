package com.funtalk.pojo;

import com.funtalk.utils.PayUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class NbRechargeData {

    private String  appKey;
    private String  requestMsg;
    private String  requestType;
    private String  sign;
    private String  timeStamp;
    private String  transactionId;


    public NbRechargeData(String appKey,String requestMsg,String requestType,String timeStamp,String transactionId){

        setAppKey(appKey);
        setRequestMsg(requestMsg);
        setRequestType(requestType);
        setTimeStamp(timeStamp);
        setTransactionId(transactionId);
        setSign(PayUtil.getMapSign(toMap(),appKey));//把签名数据设置到Sign这个属性中

    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getRequestMsg() {
        return requestMsg;
    }

    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
