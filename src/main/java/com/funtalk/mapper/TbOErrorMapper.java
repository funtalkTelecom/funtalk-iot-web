package com.funtalk.mapper;

import com.funtalk.pojo.TbOError;
import com.funtalk.pojo.TbOErrorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbOErrorMapper {
    int countByExample(TbOErrorExample example);

    int deleteByExample(TbOErrorExample example);

    int deleteByPrimaryKey(Integer errId);

    int insert(TbOError record);

    int insertSelective(TbOError record);

    List<TbOError> selectByExample(TbOErrorExample example);

    TbOError selectByPrimaryKey(Integer errId);

    int updateByExampleSelective(@Param("record") TbOError record, @Param("example") TbOErrorExample example);

    int updateByExample(@Param("record") TbOError record, @Param("example") TbOErrorExample example);

    int updateByPrimaryKeySelective(TbOError record);

    int updateByPrimaryKey(TbOError record);

    int insertForBatch(@Param("accnbrList") List<String> accnbrList);
}