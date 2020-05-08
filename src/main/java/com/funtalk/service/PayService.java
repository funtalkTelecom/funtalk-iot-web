package com.funtalk.service;

import com.funtalk.pay.PayRequest;
import com.funtalk.pay.PayResponse;
import com.funtalk.pay.ThirdPayStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PayService implements ThirdPayStrategy {

    private Logger log = LoggerFactory.getLogger(PayService.class);
    private ThirdPayStrategy thirdPayStrategy;


    public void setThirdPayStrategy(ThirdPayStrategy thirdPayStrategy) {
        this.thirdPayStrategy = thirdPayStrategy;
    }

    @Override
    public PayResponse payOrder(PayRequest payRequest) {

        PayResponse payResponse = thirdPayStrategy.payOrder(payRequest);

        return payResponse;
    }

    @Override
    public PayResponse payRefund(PayRequest payRequest) {

        PayResponse payResponse = thirdPayStrategy.payRefund(payRequest);

        return payResponse;
    }

    @Override
    public PayResponse payCancel(PayRequest payRequest) {

        PayResponse payResponse = thirdPayStrategy.payCancel(payRequest);
        return payResponse;
    }

    @Override
    public PayResponse queryOrderList(PayRequest payRequest) {
        return thirdPayStrategy.queryOrderList(payRequest);
    }

    @Override
    public PayResponse queryOrderView(String orderNo) {
        return thirdPayStrategy.queryOrderView(orderNo);
    }

    @Override
    public PayResponse queryPayList() {
        return thirdPayStrategy.queryPayList();
    }
}

