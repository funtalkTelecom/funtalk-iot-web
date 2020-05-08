package com.funtalk.pay;

import com.funtalk.utils.Result;
import com.sprite.ystpay.api.YSTPayClient;
import com.sprite.ystpay.api.object.req.*;
import com.sprite.ystpay.api.object.res.MinipayResponse;
import com.sprite.ystpay.api.object.res.NativePayResponse;
import com.sprite.ystpay.api.object.res.NativeQueryResponse;
import com.sprite.ystpay.config.YSTConfig;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class YstPayStrategy  implements ThirdPayStrategy {


    private String PAYLIST = "paylist";
    private String ORDERLIST = "order";
    private String ORDERVIEW = "order/view";
    private String PAYORDER = "payorder";
    private String QUERYPAYSTATUS = "paystatus";
    private String PAYCANCEL = "paycancel";
    private String PAYREFUND = "payrefund";

    public static String privateKey = "NTE1NDk5MWd3Rm0zRExpakRwODE1Nw==";

    private static Logger log = LoggerFactory.getLogger(YstPayStrategy.class);

    private static YstPayStrategy payStrategy = null;

    /*public static String getYstUrl(){
        return SystemParam.get("yst_domain_url");
    }
    public static String getYstKey(){
        return SystemParam.get("yst_private_key");
    }*/


    public static YstPayStrategy getInstance() {
        if (payStrategy == null) {
            payStrategy = new YstPayStrategy();
        }
        return payStrategy;
    }


    // 加载接口API和秘钥
    static{
        //以配置文件加载
        //YSTConfig.initYST("D:/Develop/Sprite Workspace/ystpay_sdk/YSTConfig.ini");
        //直接传入配置   YSTConfig.initYST("http://ut.ystpay.cn:8088/ystpay","OTI1OTc4NldKblA5azVpWmRueXM2MTI=");
        YSTConfig.initYST("http://api.ystpay.cn:8880", privateKey);
    }


    public PayResponse payOrder(PayRequest payRequest) {

/*      赢商通 小程序支付 MinipayRequest
        MinipayRequest minipayRequest =new  MinipayRequest();
        MinipayResponse  minipayResponse;


        minipayRequest.setAccount(payRequest.getRemark());  // 双方约定的账户名称
        minipayRequest.setRequestSequence(payRequest.getOrderNo());
        minipayRequest.setTotalFee(payRequest.getAmt());
        minipayRequest.setChannel("W");
        // 梧桐小程序appid:  wx5e709aecf2e862bb
        minipayRequest.setAppID(payRequest.getPayee());
        minipayRequest.setSubOpenid(payRequest.getPayer());    // 用户在appid下的openid
        minipayRequest.setNotifyUrl(payRequest.getAfterUrl());*/


        // 赢商通扫码支付
        NativepayRequest   nativepayRequest= new NativepayRequest();
        NativePayResponse  nativePayResponse =new  NativePayResponse();

        nativepayRequest.setAccount(payRequest.getRemark()); // 双方约定的账户名称
        nativepayRequest.setRequestSequence(payRequest.getOrderNo());
        nativepayRequest.setTotalFee(payRequest.getAmt());
        nativepayRequest.setChannel("W");
        nativepayRequest.setAttach(payRequest.getOrderName());
        nativepayRequest.setNotifyUrl(payRequest.getAfterUrl());

        log.info("---------NotifyUrl------->"+nativepayRequest.getNotifyUrl());

        try {
            nativePayResponse= YSTPayClient.executeUnitivePay(nativepayRequest);
            log.info("---yst scancode pay return------->"+nativePayResponse);

        } catch (Exception e) {
            log.error("请求接口未知异常",e);
            return new PayResponse(Result.WARM_ERROR,"发送支付请求失败,未知异常", null, nativepayRequest.toString(), "", "json", PAYORDER, "YST");

        }

        if (nativePayResponse!=null){

            return new PayResponse(Result.OK,"请求成功",nativePayResponse,
                       nativepayRequest.toString(), nativePayResponse.toString(), "json", PAYORDER, "YST");
        } else {
            return new PayResponse(Result.WARM_ERROR, "支付接口返回对象为null", null, nativepayRequest.toString(),
                    "", "json", PAYORDER, "YST");
        }
    }

    @Override
    public PayResponse payRefund(PayRequest payRequest) {
        return null;
    }

    @Override
    public PayResponse payCancel(PayRequest payRequest) {
        return null;
    }

    @Override
    public PayResponse queryOrderList(PayRequest payRequest) {


        NativeQueryRequest queryRequest = new NativeQueryRequest();
        queryRequest.setAccount(payRequest.getPayee());
        queryRequest.setChannel(payRequest.getThird());
        queryRequest.setOriginalSequence(payRequest.getSerial());

        NativeQueryResponse nativeQueryResponse =new  NativeQueryResponse();

        try {
            nativeQueryResponse= YSTPayClient.executeUnitivePay(queryRequest);
            log.info("---return infomation from yst for querypay------->"+nativeQueryResponse);

        } catch (Exception e) {
            log.error("请求接口未知异常",e);
            return new PayResponse(Result.WARM_ERROR,"发送查询支付请求失败,未知异常", null, nativeQueryResponse.toString(), "", "json", PAYORDER, "YST");

        }

        if (nativeQueryResponse!=null){

            return new PayResponse(Result.OK,"请求成功",nativeQueryResponse,
                    nativeQueryResponse.toString(), nativeQueryResponse.toString(), "json", PAYORDER, "YST");
        } else {
            return new PayResponse(Result.WARM_ERROR, "查询支付接口返回null", null, nativeQueryResponse.toString(),
                    "", "json", PAYORDER, "YST");
        }

    }

    @Override
    public PayResponse queryOrderView(String orderNo) {
        return null;
    }

    @Override
    public PayResponse queryPayList() {
        return null;
    }


}
