package com.funtalk.mapper;

import com.funtalk.pojo.TbSBillMode;
import com.funtalk.pojo.TbSBillModeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSBillModeMapper {
    int countByExample(TbSBillModeExample example);

    int deleteByExample(TbSBillModeExample example);

    int deleteByPrimaryKey(Integer mId);

    int insert(TbSBillMode record);

    int insertSelective(TbSBillMode record);

    List<TbSBillMode> selectByExample(TbSBillModeExample example);

    TbSBillMode selectByPrimaryKey(Integer mId);

    int updateByExampleSelective(@Param("record") TbSBillMode record, @Param("example") TbSBillModeExample example);

    int updateByExample(@Param("record") TbSBillMode record, @Param("example") TbSBillModeExample example);

    int updateByPrimaryKeySelective(TbSBillMode record);

    int updateByPrimaryKey(TbSBillMode record);

    List<TbSBillMode> selectAll();

    void insertMode(TbSBillMode tbSBillMode);

    void updateBillMode(TbSBillMode tbSBillMode);

    List<TbSBillMode> selectEPMode(@Param("employeeId")  String employeeId);

    TbSBillMode selectMode(String custId);

}