package com.funtalk.utils;

import com.funtalk.utils.pinganUtils.MD5;
import com.funtalk.utils.pinganUtils.TLinxUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
