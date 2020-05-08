package com.funtalk.service;

import com.funtalk.mapper.*;
import com.funtalk.pojo.*;
import com.funtalk.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class CustService {

    @Autowired
    TbSCustMapper  tbSCustMapper;
    @Autowired
    TbSMenuMapper  tbSMenuMapper;
    @Autowired
    TbSAcctMapper  tbSAcctMapper;

    public Page queryPage(Map<String,Object> paramMap) {

        Page page = new Page(null,(Integer)paramMap.get("pageno"),(Integer)paramMap.get("pagesize"));

        Integer startIndex = page.getStartno();
        paramMap.put("startindex", startIndex);

        List<TbSCust> datas = tbSCustMapper.queryList(paramMap);

        page.setData(datas);

        Integer totalsize = tbSCustMapper.queryCount(paramMap);

        page.setTotalsize(totalsize);

        return page;
    }



    public List<TbSCust> validateCustName(String custName){

        TbSCustExample  example= new TbSCustExample();
        TbSCustExample.Criteria criteria = example.createCriteria();

        criteria.andCustNameEqualTo(custName);
        return tbSCustMapper.selectByExample(example);

    }

    @Transactional
    public int saveCustInfo(TbSCust tbSCust){

        String custId="LY01A"+tbSCustMapper.getCustIdSeq();

        tbSCust.setCustId(custId);
        tbSCust.setCreateDate(new Date());
        tbSCustMapper.insertSelective(tbSCust);

        TbSAcct  tbSAcct = new TbSAcct();
        tbSAcct.setBelongId(custId);
        tbSAcct.setBelongType("1");
        tbSAcct.setCreateDate(new Date());
        tbSAcct.setIfValid("1");

        return tbSAcctMapper.insertSelective(tbSAcct);

    }

    public List<TbSCust>  getAllCust(){

        TbSCustExample  example= new TbSCustExample();
        return tbSCustMapper.selectByExample(example);
    }



}
