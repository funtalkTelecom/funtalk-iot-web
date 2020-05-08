package com.funtalk.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;


public class JsonUtil {

	public static String objectToJson(Object obj)
	{
		JSONObject json = JSONObject.fromObject(obj);	 
	    String str = json.toString(); 
		return str;
	}
	
	public static String arrayToJson(Object obj)
	{
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray json = JSONArray.fromObject( obj , jsonConfig);
		return json.toString();
	}
	
}
