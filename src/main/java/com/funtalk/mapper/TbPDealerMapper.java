package com.funtalk.mapper;

import com.funtalk.pojo.TbPDealer;
import com.funtalk.pojo.TbPDealerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPDealerMapper {
    int countByExample(TbPDealerExample example);

    int deleteByExample(TbPDealerExample example);

    int insert(TbPDealer record);

    int insertSelective(TbPDealer record);

    List<TbPDealer> selectByExample(TbPDealerExample example);

    int updateByExampleSelective(@Param("record") TbPDealer record, @Param("example") TbPDealerExample example);

    int updateByExample(@Param("record") TbPDealer record, @Param("example") TbPDealerExample example);
}