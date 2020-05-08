package com.funtalk.mapper;

import com.funtalk.pojo.TbSSubtaskResult;
import com.funtalk.pojo.TbSSubtaskResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TbSSubtaskResultMapper {
    int countByExample(TbSSubtaskResultExample example);

    int deleteByExample(TbSSubtaskResultExample example);

    int deleteByPrimaryKey(Integer nid);

    int insert(TbSSubtaskResult record);

    int insertSelective(TbSSubtaskResult record);

    List<TbSSubtaskResult> selectByExample(TbSSubtaskResultExample example);

    TbSSubtaskResult selectByPrimaryKey(Integer nid);

    int updateByExampleSelective(@Param("record") TbSSubtaskResult record, @Param("example") TbSSubtaskResultExample example);

    int updateByExample(@Param("record") TbSSubtaskResult record, @Param("example") TbSSubtaskResultExample example);

    int updateByPrimaryKeySelective(TbSSubtaskResult record);

    int updateByPrimaryKey(TbSSubtaskResult record);

    List<TbSSubtaskResult> pageQuery(Map<String, Object> advertMap);

    int queryCount(Map<String, Object> advertMap);

    int updateBossStatus(@Param(value = "nid") Integer nid,
                        @Param(value = "sendState") String sendState
                        );
}