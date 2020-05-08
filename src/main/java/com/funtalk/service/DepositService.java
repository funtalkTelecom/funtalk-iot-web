package com.funtalk.service;

import com.funtalk.mapper.TbSDepositMapper;
import com.funtalk.pojo.TbSDeposit;
import com.funtalk.pojo.TbSDepositExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepositService {


    @Autowired
    TbSDepositMapper  tbSDepositMapper;
    // 按 cust_id或者employee_id查询，目前账本表就是存储这两种类型的账本,存储字段belongid
    public List<TbSDeposit> queryBalance(String belongId){

        TbSDepositExample tbSDepositExample = new TbSDepositExample();
        tbSDepositExample.createCriteria().andBelongIdEqualTo(belongId);
        List<TbSDeposit>  tbSDepositList =tbSDepositMapper.selectByExample(tbSDepositExample);

        return  tbSDepositList;
    }

}
