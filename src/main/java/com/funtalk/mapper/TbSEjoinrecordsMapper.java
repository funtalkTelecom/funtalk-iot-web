package com.funtalk.mapper;

import com.funtalk.pojo.TbSEjoinrecords;
import com.funtalk.pojo.TbSEjoinrecordsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSEjoinrecordsMapper {
    int countByExample(TbSEjoinrecordsExample example);

    int deleteByExample(TbSEjoinrecordsExample example);

    int insert(TbSEjoinrecords record);

    int insertSelective(TbSEjoinrecords record);

    List<TbSEjoinrecords> selectByExample(TbSEjoinrecordsExample example);

    int updateByExampleSelective(@Param("record") TbSEjoinrecords record, @Param("example") TbSEjoinrecordsExample example);

    int updateByExample(@Param("record") TbSEjoinrecords record, @Param("example") TbSEjoinrecordsExample example);
}