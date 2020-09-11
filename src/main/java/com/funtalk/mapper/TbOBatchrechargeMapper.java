package com.funtalk.mapper;

import com.funtalk.pojo.TbOBatchrecharge;
import com.funtalk.pojo.TbOBatchrechargeExample;
import com.funtalk.pojo.TbOBatchsub;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TbOBatchrechargeMapper {
    int countByExample(TbOBatchrechargeExample example);

    int deleteByExample(TbOBatchrechargeExample example);

    int deleteByPrimaryKey(Integer batchId);

    int insert(TbOBatchrecharge record);

    int insertSelective(TbOBatchrecharge record);

    List<TbOBatchrecharge> selectByExample(TbOBatchrechargeExample example);

    TbOBatchrecharge selectByPrimaryKey(Integer batchId);

    int updateByExampleSelective(@Param("record") TbOBatchrecharge record, @Param("example") TbOBatchrechargeExample example);

    int updateByExample(@Param("record") TbOBatchrecharge record, @Param("example") TbOBatchrechargeExample example);

    int updateByPrimaryKeySelective(TbOBatchrecharge record);

    int updateByPrimaryKey(TbOBatchrecharge record);

    String getTransId(@Param("transType")String transType);

    List<TbOBatchrecharge> getDealerRechargeList(Map<String, Object> paramMap);

    int getDealerRechargeListCount(Map<String, Object> paramMap);

    int updateAmount(@Param("batchId") Integer batchId,
                     @Param("rechargeNum") Integer rechargeNum,
                     @Param("rechargeAmount") BigDecimal rechargeAmount);


    int updateState(Map<String, Object> paramMap);


}