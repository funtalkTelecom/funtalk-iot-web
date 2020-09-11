package com.funtalk.utils;

import com.funtalk.utils.pinganUtils.MD5;
import com.funtalk.utils.pinganUtils.TLinxUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PayUtil {

    private static Logger log = LoggerFactory.getLogger(PayUtil.class);

    public static String getSign(Object object, String key) {
        JSONObject json = JSONObject.fromObject(object);
        json.remove("sign");
        String stra = "";

        try {
            stra = TLinxUtil.sort(json);
        } catch (Exception var5) {
            log.error("加密排序异常", var5);
        }

        stra = stra + "&key=" + key;
        log.info("--------beforemd5-------------" + stra);
        return MD5.MD5Encode(stra).toUpperCase();
    }

    public static String getMapSign(Map<String,Object> map,String key){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + key;
        log.info("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        log.info("Sign Result:" + result);
        return result;
    }
}
