package com.funtalk.mapper;

import com.funtalk.pojo.TbRMenuEmployee;
import com.funtalk.pojo.TbRMenuEmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRMenuEmployeeMapper {
    int countByExample(TbRMenuEmployeeExample example);

    int deleteByExample(TbRMenuEmployeeExample example);

    int insert(TbRMenuEmployee record);

    int insertSelective(TbRMenuEmployee record);

    List<TbRMenuEmployee> selectByExample(TbRMenuEmployeeExample example);

    int updateByExampleSelective(@Param("record") TbRMenuEmployee record, @Param("example") TbRMenuEmployeeExample example);

    int updateByExample(@Param("record") TbRMenuEmployee record, @Param("example") TbRMenuEmployeeExample example);

    List<String> selectId(@Param("employee_id")String employee_id);

}