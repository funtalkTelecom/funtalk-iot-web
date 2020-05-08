package com.funtalk.mapper;

import com.funtalk.pojo.TbSDeposit;
import com.funtalk.pojo.TbSDepositExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TbSDepositMapper {
    int countByExample(TbSDepositExample example);

    int deleteByExample(TbSDepositExample example);

    int insert(TbSDeposit record);

    int insertSelective(TbSDeposit record);

    List<TbSDeposit> selectByExample(TbSDepositExample example);

    int updateByExampleSelective(@Param("record") TbSDeposit record, @Param("example") TbSDepositExample example);

    int updateByExample(@Param("record") TbSDeposit record, @Param("example") TbSDepositExample example);

    int updateDeposit(TbSDeposit record);


}