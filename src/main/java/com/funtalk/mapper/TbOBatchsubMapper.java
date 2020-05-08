package com.funtalk.mapper;

import com.funtalk.pojo.TbOBatchsub;
import com.funtalk.pojo.TbOBatchsubExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbOBatchsubMapper {
    int countByExample(TbOBatchsubExample example);

    int deleteByExample(TbOBatchsubExample example);

    int deleteByPrimaryKey(Integer subId);

    int insert(TbOBatchsub record);

    int insertSelective(TbOBatchsub record);

    List<TbOBatchsub> selectByExample(TbOBatchsubExample example);

    TbOBatchsub selectByPrimaryKey(Integer subId);

    int updateByExampleSelective(@Param("record") TbOBatchsub record, @Param("example") TbOBatchsubExample example);

    int updateByExample(@Param("record") TbOBatchsub record, @Param("example") TbOBatchsubExample example);

    int updateByPrimaryKeySelective(TbOBatchsub record);

    int updateByPrimaryKey(TbOBatchsub record);

    int addBatchSub(@Param("tbOBatchsubList") List<TbOBatchsub> tbOBatchsubList);

    List<String> checkAccnbrValid(@Param("batchId") Integer batchId);

    int deleteByBatchId(@Param("batchId") Integer batchId);


    int updateBatchResult(@Param("tbOBatchsubList") List<TbOBatchsub> tbOBatchsubList);


}