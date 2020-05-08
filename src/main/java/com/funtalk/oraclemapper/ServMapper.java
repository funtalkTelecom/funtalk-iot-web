package com.funtalk.oraclemapper;

import com.funtalk.pojo.Serv;
import com.funtalk.pojo.ServExample;
import com.funtalk.pojo.SimpleServ;
import com.funtalk.pojo.TbOBatchsub;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ServMapper {

    int countByExample(ServExample example);

    int deleteByExample(ServExample example);

    int insert(Serv record);

    int insertSelective(Serv record);

    List<Serv> selectByExample(ServExample example);

    int updateByExampleSelective(@Param("record") Serv record, @Param("example") ServExample example);

    int updateByExample(@Param("record") Serv record, @Param("example") ServExample example);

    int cancelLimit(@Param("tbOBatchsubList") List<TbOBatchsub>  tbOBatchsubList);

    List<String> getLimitServ(@Param("tbOBatchsubList") List<TbOBatchsub>  tbOBatchsubList);

    void forcedToActivate(Map<String, Object> paramMap);

    List<SimpleServ>  selectStateByAccnbrForBatch(@Param("accnbrList") List<SimpleServ>  accnbrList);

}