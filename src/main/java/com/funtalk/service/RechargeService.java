package com.funtalk.service;

import com.funtalk.outerface.neusoft.paymentBank.PaymentBankRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Service - 充值记录服务类
 * 
 * @author Funtalk IT Group
 * @version 3.0
 */
@Component
public class RechargeService {

    private Logger log = Logger.getLogger(RechargeService.class);
    

    /* 调用BOSS充值接口 */
 //   public void doBankCharge(ChargeLog chargeLog, BigDecimal effectiveAmount,Boolean isBack)
/*
    {
    	log.info("开始充值·················");
        PaymentBankRequest bossRequest = null;
        try {
        	if(chargeLog.getType().equals(ChargeLog.Type.voucher)){
        		chargeLog.setPaymentAmount(effectiveAmount);
        	}
        	log.info("充值金额："+chargeLog.getPaymentAmount());
			if (chargeLog != null && !chargeLog.getStatus().equals(ChargeLog.Status.success) &&chargeLog.getPaymentAmount().compareTo(effectiveAmount) == 0 )
			{
				BossArea ba = chargeLog.getBossArea();
				//20161020 BOSS电信自建系统上线 1700100、1700117、1700477三个号段仍需调用原有电信充值接口，其余号段全部调用BOSS接口
				//20161109 联通电信号码全部调用BOSS
				//20161124统一调用BOSS
//			    BossArea bossArea = bossAreaDao.findByPrefix(chargeLog.getPhone().substring(0, 7), true);
		        log.info("正在调用boss充值接口,[phone=" + chargeLog.getPhone() + ",sn=" + chargeLog.getSn() + "]");
		        bossRequest = new PaymentBankRequest();
		        //充值卡获取金额
		        //20150821 微信支付 充值打折:不取实际支付金额
		        if(ChargeLog.Type.wechat.equals(chargeLog.getType())){
		        	bossRequest.setPayFee(chargeLog.getAmount().multiply(new BigDecimal(100)).longValue()); // 精确到分
		        }else{
		        	bossRequest.setPayFee(chargeLog.getPaymentAmount().multiply(new BigDecimal(100)).longValue()); // 精确到分
		        }			     
		        bossRequest.setServiceId(chargeLog.getPhone()); // 手机号
		        //20150605扩展微信充值
		        if(chargeLog.getType()!=null&&chargeLog.getType().equals(Type.bank)){
		        	bossRequest.setBankId(BossCongfigInfo.BANK_BANKID);
		        }else if(chargeLog.getType()!=null&&chargeLog.getType().equals(Type.wechat)){
		        	bossRequest.setBankId(BossCongfigInfo.WECHAT_BANKID);
		        }else{
		        	bossRequest.setBankId(BossCongfigInfo.VOUCHER_BANKID);
		        }			        
		        PaymentBankResponse response = PaymentBankClient.pay(bossRequest);
		        chargeLog.setTransactionID(bossRequest.getBankFlowNumber());
		        if(response!=null&&response.getResultCode()!=null){
		        	log.info("doPhoneCharge: code = " + response.getResultCode() + ", info=" + response.getResultInfo());
			        chargeLog.setResult(response.getResultInfo());
			        if ("0".equals(response.getResultCode())||"0000".equals(response.getResultCode())||("-1".equals(response.getResultCode())&&response.getResultInfo().contains("缴费流水已经存在")))
			        {
			        	try {
							String cityCode=areaStandardCodeDao.findAreaCode("2", ba.getName());
							if(cityCode==null)cityCode="";
							String businessOpertor=null;
							String pluginId=null;
//							Payment pament=paymentDao.findByChargeLogId(chargeLog.getId());
							Payment pament=paymentDao.findSuccessByChargeLog(chargeLog.getId(), Payment.Status.success);
							if(pament!=null){
								pluginId=pament.getPaymentPluginId();
							}
							
							if(chargeLog.getType().equals(Type.bank)){
								if(ba!=null&&ba.getType().equals(BossArea.Type.CTCC)){
									businessOpertor=CongfigInfo.MiaoTelecomBack;
								}else{
									businessOpertor=CongfigInfo.MiaoUnionBack;
								}
								
							}else if(chargeLog.getType().equals(Type.voucher)){
								if(ba!=null&&ba.getType().equals(BossArea.Type.CTCC)){
									businessOpertor=CongfigInfo.MiaoTelecomCharge;
								}else{
									businessOpertor=CongfigInfo.MiaoUnionCharge;
								}
								
								pluginId=CongfigInfo.cardCode;
							}else if(chargeLog.getType().equals(Type.wechat)){
								if(ba!=null&&ba.getType().equals(BossArea.Type.CTCC)){
									businessOpertor=CongfigInfo.MiaoTelecomBack;
								}else{
									businessOpertor=CongfigInfo.MiaoUnionBack;
								}
								pluginId=CongfigInfo.wechatCode;
							}
							log.info("start charge union sn:"+chargeLog.getSn()+"date:"+chargeLog.getCreateDate()+"aoument"+chargeLog.getPaymentAmount()+"citycode:"+cityCode+"bussnessopear:"+businessOpertor);
							String json = PostRetailsalesClient.postRetailsalesCharge(chargeLog.getSn(), chargeLog.getCreateDate(), chargeLog.getPaymentAmount()+"", cityCode, businessOpertor,chargeLog.getCardNo());
							log.info("charge union "+json);
							Order order=new Order();
							order.setSn(chargeLog.getSn());
							String json1 = SalesCollectionClient.salesCollection(order,pluginId);
							log.info("金立零售导购收款接口返回信息为：【" + json1 + "】");
							PostReturnInfo postReturnInfo = JsonUtils.toObj(json, PostReturnInfo.class);
							PostReturnInfo postReturnInfo1 = JsonUtils.toObj(json1, PostReturnInfo.class);
							chargeLog.setStatus(ChargeLog.Status.success);
							if ("1".equals(postReturnInfo.getJL_State())&&"1".equals(postReturnInfo1.getJL_State())){
							 	 chargeLog.setResult("充值成功");
								//20150401记录金力失败状态
								chargeLog.setJinliStatus(JinLi_Status.jinli_success);								 	 
							}else{
							    chargeLog.setResult("生成收货单或者导购单失败:"+postReturnInfo.getJL_ERR()+";"+postReturnInfo1.getJL_ERR());
							    chargeLog.setJinliStatus(JinLi_Status.jinli_error);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							//20150401记录金力失败状态
							chargeLog.setJinliStatus(JinLi_Status.jinli_error);
				            chargeLog.setStatus(ChargeLog.Status.success);
				            chargeLog.setResult("金力生成收货单或者导购单失败");
				            log.error("充值=====金力生成收货单或者导购单失败:"+chargeLog.getSn()+e.toString());
						}
			        }
			        else
			        {
			            chargeLog.setStatus(ChargeLog.Status.error);
			            chargeLog.setResult("充值失败:"+chargeLog.getResult());

			        }
		        }else{
		        	log.info("接收boss返回值为空");
		            chargeLog.setStatus(ChargeLog.Status.error);
		            chargeLog.setResult("充值失败:连接BOSS系统失败或接收BOSS系统返回值为空,请尝试重新补充!");
		        }

		        chargeLogDao.merge(chargeLog);

			}else{
				log.info("判断失败未调充值接口············");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("充值异常："+e.toString());
			//20150106记录BOSS充值流水号
			if(bossRequest!=null){
				chargeLog.setTransactionID(bossRequest.getBankFlowNumber());
			}
            chargeLog.setStatus(ChargeLog.Status.error);
            chargeLog.setResult("充值失败:连接BOSS或电信系统失败,请尝试重新补充!");
            chargeLogDao.merge(chargeLog);
		}
    }
*/

}