package com.funtalk.outerface.neusoft.paymentBank;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class PaymentBankClient {
	
	private static Logger log  = Logger.getLogger(PaymentBankClient.class);
	private static PaymentBankSOAPSoapBindingStub stub;
	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

	static {
		try {
			stub = (PaymentBankSOAPSoapBindingStub)new PaymentBank_ServiceLocator().getPaymentBankSOAP();
			stub.setTimeout(40000);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("PaymentBankClient init error: ", e);
		}
	}
	
	protected static String getRandomStr(int length) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < length ; i++) {
			sb.append(r.nextInt(9));
		}
		return sb.toString();
	}
	
	private static void preHandleRequest(PaymentBankRequest request) {
		String timeStr = FORMAT.format(new Date());
		if(request.getBankFlowNumber()==null){
			request.setBankFlowNumber( getRandomStr(6)+timeStr);
		}
		request.setIfContinue(false);
		request.setNotifyDate(timeStr);
		request.setRequestId( getRandomStr(10)+timeStr );
		request.setServiceKind(8);
		request.setSystemId("iot-web");
	}
	
	public static PaymentBankResponse pay(PaymentBankRequest request) {
		try {
			preHandleRequest(request);
			StringBuffer sbf = new StringBuffer();
			sbf.append("[");
			sbf.append("BankFlowNumber="+request.getBankFlowNumber());
			sbf.append("BankId="+request.getBankId());
			sbf.append("NotifyDate="+request.getNotifyDate());
			sbf.append("PayFee="+request.getPayFee());
			sbf.append("RequestId="+request.getRequestId());
			sbf.append("ServiceId="+request.getServiceId());
			sbf.append("ServiceKind="+request.getServiceKind());
			sbf.append("SystemId="+request.getSystemId());
			sbf.append("]");
//			System.out.println(sbf.toString());
			log.info("发送充值数值:"+sbf.toString());
			return stub.execute(request); 
		} catch(Exception e) {
			e.printStackTrace();
			log.error("boss pay error: ", e);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		PaymentBankRequest request = new PaymentBankRequest();
		
		request.setPayFee(1L); // 精确到分
		request.setServiceId("17020116999"); // 手机号
		request.setBankId("9811");
		String timeStr = FORMAT.format(new Date());
		request.setBankFlowNumber(timeStr + getRandomStr(6));
		request.setIfContinue(false);
		request.setNotifyDate(timeStr);
		request.setRequestId(timeStr + getRandomStr(10));
		request.setServiceKind(8);
		request.setSystemId("iot-web");
		request.setBankFlowNumber("20200330100901637137");
		PaymentBankResponse response = pay(request); 
		
		//[BankFlowNumber=20150106170708808410BankId=9800NotifyDate=20150106170708PayFee=10000RequestId=201501061707087008681382ServiceId=17090040321ServiceKind=8SystemId=funtalk-miao]
		
		System.out.println("response-code====" + response.getResultCode());
		System.out.println("response-info====" + response.getResultInfo());
	}
	
}
