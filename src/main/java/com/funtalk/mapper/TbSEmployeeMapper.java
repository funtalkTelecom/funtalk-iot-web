package com.funtalk.mapper;

import com.funtalk.pojo.TbSEmployee;
import com.funtalk.pojo.TbSEmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbSEmployeeMapper {
    int countByExample(TbSEmployeeExample example);

    int deleteByExample(TbSEmployeeExample example);

    int deleteByPrimaryKey(Integer employeeId);

    int insert(TbSEmployee record);

    int insertSelective(TbSEmployee record);

    List<TbSEmployee> selectByExample(TbSEmployeeExample example);

    TbSEmployee selectByPrimaryKey(Integer employeeId);

    int updateByExampleSelective(@Param("record") TbSEmployee record, @Param("example") TbSEmployeeExample example);

    int updateByExample(@Param("record") TbSEmployee record, @Param("example") TbSEmployeeExample example);

    int updateByPrimaryKeySelective(TbSEmployee record);

    int updateByPrimaryKey(TbSEmployee record);

    List<TbSEmployee> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    TbSEmployee getUserByName(String userName);

    TbSEmployee getUserById(@Param("employee_id")String employee_id);
}