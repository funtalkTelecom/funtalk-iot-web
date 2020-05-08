package com.funtalk.utils;

import com.funtalk.pojo.TbSEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

;


@Component
public class ApiSessionUtil {
    @Autowired
    private RedisUtil redisUtils;
    public static final String JESSION_ID_NAME = "__sessid";
    private Long expire_time= 7200L;

    public static String getApiKey(String key){
        return "egt-kh:api:" + key;
    }

    public String getBaseKey(){
        String token=getTokenStr();
        return getApiKey(token);
    }

    public String getTokenStr(){
        if(RequestContextHolder.getRequestAttributes()==null)return null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getParameter(JESSION_ID_NAME);
    }

    public void saveObject(String apiKey,Object object,long time) {
        if(apiKey == null) return ;
        String key1 = getApiKey(apiKey);
        redisUtils.set(key1,object,time);
    }

    public Object getObject(String apiKey){
        if(apiKey == null) return null;
        String key = getApiKey(apiKey);
        return redisUtils.get(key);
    }
    public void saveOrUpdate(String apiKey, TbSEmployee user) {
        if(apiKey == null) return ;
        String key1 = getApiKey(apiKey);
        redisUtils.set(key1,user,expire_time);
    }
    public void updateExpire(String apiKey) {
        String key1 = getApiKey(apiKey);
        TbSEmployee bean=this.get(getApiKey(apiKey));
        if(bean == null) return ;
        redisUtils.set(key1,expire_time);
    }
    public void delete(String apiKey) {
        String key = getApiKey(apiKey);
        redisUtils.del(key);
    }

    public TbSEmployee get(String apiKey){
        String key = getApiKey(apiKey);
        return (TbSEmployee) (redisUtils.get(key));
    }

}