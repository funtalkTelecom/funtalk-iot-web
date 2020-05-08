package com.funtalk.mapper;

import com.funtalk.pojo.TbSSmstemplate;
import com.funtalk.pojo.TbSSmstemplateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbSSmstemplateMapper {

    int countByExample(TbSSmstemplateExample example);

    int deleteByExample(TbSSmstemplateExample example);

    int deleteByPrimaryKey(Integer temId);

    int insert(TbSSmstemplate record);

    int insertSelective(TbSSmstemplate record);

    List<TbSSmstemplate> selectByExample(TbSSmstemplateExample example);

    TbSSmstemplate selectByPrimaryKey(Integer temId);

    int updateByExampleSelective(@Param("record") TbSSmstemplate record, @Param("example") TbSSmstemplateExample example);

    int updateByExample(@Param("record") TbSSmstemplate record, @Param("example") TbSSmstemplateExample example);

    int updateByPrimaryKeySelective(TbSSmstemplate record);

    int updateByPrimaryKey(TbSSmstemplate record);

    List<TbSSmstemplate> getTemplateByCust(@Param("workNo") String workNo);

    List<TbSSmstemplate> getpageQueryByCust(Map<String, Object> paramMap);

    int queryCount(Map<String, Object> paramMap);

}