package com.funtalk.mapper;

import com.funtalk.pojo.TbSMenu;
import com.funtalk.pojo.TbSMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSMenuMapper {
    int countByExample(TbSMenuExample example);

    int deleteByExample(TbSMenuExample example);

    int insert(TbSMenu record);

    int insertSelective(TbSMenu record);

    List<TbSMenu> selectByExample(TbSMenuExample example);

    int updateByExampleSelective(@Param("record") TbSMenu record, @Param("example") TbSMenuExample example);

    int updateByExample(@Param("record") TbSMenu record, @Param("example") TbSMenuExample example);

    List<TbSMenu> getMenuByUserName(String userName);
}