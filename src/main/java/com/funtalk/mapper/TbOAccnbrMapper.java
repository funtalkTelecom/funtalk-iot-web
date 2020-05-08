package com.funtalk.mapper;

import com.funtalk.pojo.ParamData;
import com.funtalk.pojo.TbOAccnbr;
import com.funtalk.pojo.TbOAccnbrExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbOAccnbrMapper {
    int countByExample(TbOAccnbrExample example);

    int deleteByExample(TbOAccnbrExample example);

    int deleteByPrimaryKey(Integer accOrderId);

    int insert(TbOAccnbr record);

    int insertSelective(TbOAccnbr record);

    List<TbOAccnbr> selectByExample(TbOAccnbrExample example);

    TbOAccnbr selectByPrimaryKey(Integer accOrderId);

    int updateByExampleSelective(@Param("record") TbOAccnbr record, @Param("example") TbOAccnbrExample example);

    int updateByExample(@Param("record") TbOAccnbr record, @Param("example") TbOAccnbrExample example);

    int updateByPrimaryKeySelective(TbOAccnbr record);

    int updateByPrimaryKey(TbOAccnbr record);

    int addBatchOrder(@Param("tbOAccnbrList") List<TbOAccnbr> tbOAccnbrList);

    List<ParamData>  getPackageList();

    int updateRechargeState(Map<String,String> paramMap);


}