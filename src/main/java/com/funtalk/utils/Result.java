package com.funtalk.utils;


public class Result {
	public static final int OK			= 200;//正常
	public static final int WARM_ERROR  = 300;//警告信息
	public static final int TIME_OUT	= 310;//会话超时
	public static final int ERROR		= 400;//数据库等可预知的异常
	public static final int NOPOWER		= 250;//权限不足
	public static final int PARAM		= 999;//参数异常

	private int code;
	private Object msg;

	public Result() {
	}

	public Result(int code, Object msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}

}
