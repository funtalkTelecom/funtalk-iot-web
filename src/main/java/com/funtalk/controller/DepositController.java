package com.funtalk.controller;

import com.funtalk.pojo.TbSDeposit;
import com.funtalk.pojo.TbSEmployee;
import com.funtalk.service.DepositService;
import com.funtalk.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.List;

@Controller
public class DepositController {

    @Autowired
    DepositService depositService;

    @RequestMapping("/deposit/queryallbalance")
    @ResponseBody
    public Result queryAllBalance(HttpServletRequest request) throws Exception{

        float balance=0;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Result result = new Result();

        TbSEmployee user =(TbSEmployee)request.getSession().getAttribute("user");

        List<TbSDeposit> tbSDeposits = depositService.queryBalance(String.valueOf(user.getEmployeeId()));

        for(TbSDeposit tbSDeposit : tbSDeposits )
            balance+=tbSDeposit.getAvailMoney();

        balance=balance/100;

        result.setCode(Result.OK);
        result.setMsg(decimalFormat.format(balance));
        return result;

    }
}
