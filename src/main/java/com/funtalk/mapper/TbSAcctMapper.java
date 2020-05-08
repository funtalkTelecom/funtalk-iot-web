package com.funtalk.mapper;

import com.funtalk.pojo.TbSAcct;
import com.funtalk.pojo.TbSAcctExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSAcctMapper {
    int countByExample(TbSAcctExample example);

    int deleteByExample(TbSAcctExample example);

    int deleteByPrimaryKey(Integer acctId);

    int insert(TbSAcct record);

    int insertSelective(TbSAcct record);

    List<TbSAcct> selectByExample(TbSAcctExample example);

    TbSAcct selectByPrimaryKey(Integer acctId);

    int updateByExampleSelective(@Param("record") TbSAcct record, @Param("example") TbSAcctExample example);

    int updateByExample(@Param("record") TbSAcct record, @Param("example") TbSAcctExample example);

    int updateByPrimaryKeySelective(TbSAcct record);

    int updateByPrimaryKey(TbSAcct record);
}