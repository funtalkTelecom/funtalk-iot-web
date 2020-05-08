package com.funtalk.mapper;

import com.funtalk.pojo.SimpleServ;
import com.funtalk.pojo.TbSCardinfo;
import com.funtalk.pojo.TbSCardinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TbSCardinfoMapper {
    int countByExample(TbSCardinfoExample example);

    int deleteByExample(TbSCardinfoExample example);

    int deleteByPrimaryKey(Integer cardId);

    int insert(TbSCardinfo record);

    int insertSelective(TbSCardinfo record);

    List<TbSCardinfo> selectByExample(TbSCardinfoExample example);

    TbSCardinfo selectByPrimaryKey(Integer cardId);

    int updateByExampleSelective(@Param("record") TbSCardinfo record, @Param("example") TbSCardinfoExample example);

    int updateByExample(@Param("record") TbSCardinfo record, @Param("example") TbSCardinfoExample example);

    int updateByPrimaryKeySelective(TbSCardinfo record);

    int updateByPrimaryKey(TbSCardinfo record);

    List<TbSCardinfo> selectByIccidList(@Param("iccidList") List<String> iccidList);

    int updateByIccid(@Param("tbSCardinfo") TbSCardinfo tbSCardinfo);

    List<TbSCardinfo> selectIdleBusinessIccid();

    List<TbSCardinfo> selectRelevantCardInfo(@Param("iccId") String iccId, @Param("seedIccId") String seedIccId);


    int recoverToInit(@Param("iccidList") List<String> iccidList);

    List<SimpleServ> selectBylimit(@Param("offset") int offset, @Param("limit") int limit);

    void updateByAccnbrForBatch(@Param("simpleServList") List<SimpleServ>  simpleServList);

}