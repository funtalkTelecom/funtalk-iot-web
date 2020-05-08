package com.funtalk.mapper;

import com.funtalk.pojo.TbLCharge;
import com.funtalk.pojo.TbLChargeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbLChargeMapper {
    int countByExample(TbLChargeExample example);

    int deleteByExample(TbLChargeExample example);

    int insert(TbLCharge record);

    int insertSelective(TbLCharge record);

    List<TbLCharge> selectByExampleWithBLOBs(TbLChargeExample example);

    List<TbLCharge> selectByExample(TbLChargeExample example);

    int updateByExampleSelective(@Param("record") TbLCharge record, @Param("example") TbLChargeExample example);

    int updateByExampleWithBLOBs(@Param("record") TbLCharge record, @Param("example") TbLChargeExample example);

    int updateByExample(@Param("record") TbLCharge record, @Param("example") TbLChargeExample example);

    int getTransId(@Param("transType")String transType);

    int updateByKey(@Param("chargeId")int chargeId, @Param("field")String field,
                    @Param("state")int state, @Param("remark")String remark);

    int updateYstPayCallback(@Param("serNum")String serNum, @Param("state")int state);

    List<TbLCharge> getChargelogByWorkno(Map<String, Object> paramMap);

    int getChargelogByWorknoCount(Map<String, Object> paramMap);

    int updateState(Map<String, Object> paramMap);

}