package com.funtalk.mapper;

import com.funtalk.pojo.TbSTaskA;
import com.funtalk.pojo.TbSTaskAExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbSTaskAMapper {
    int countByExample(TbSTaskAExample example);

    int deleteByExample(TbSTaskAExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(TbSTaskA record);

    int insertSelective(TbSTaskA record);

    List<TbSTaskA> selectByExample(TbSTaskAExample example);

    TbSTaskA selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") TbSTaskA record, @Param("example") TbSTaskAExample example);

    int updateByExample(@Param("record") TbSTaskA record, @Param("example") TbSTaskAExample example);

    int updateByPrimaryKeySelective(TbSTaskA record);

    int updateByPrimaryKey(TbSTaskA record);

    List<TbSTaskA> selectUndealtTask();
    List<TbSTaskA> selectProcessingTask();

    int updateStatus(Map<String, Object> paramMap);

    int updateStateByOrderAndPhone(@Param("orderNo") String orderNo,
                                   @Param("phoneAList") List<String> phoneAList,
                                   @Param("state") String state);

    List<TbSTaskA> selectProcessingTask(@Param("cardId") String cardId);

    int insertFromPC(@Param("subtask") TbSTaskA subtask);

    int addTaskBatch(@Param("subtasks") List<TbSTaskA> subtasks);


    List<TbSTaskA> getNeedAuditSms(Map<String, Object> paramMap);

    int getNeedAuditSmsCount(Map<String, Object> paramMap);

    int updateCheckStatus(Map<String, Object> paramMap);

    List<TbSTaskA> getSmsByWorkNo(Map<String, Object> paramMap);
    int getSmsByWorkNoCount(Map<String, Object> paramMap);

    int queryrecordcount(@Param(value ="receiver") String receiver);

    String getSmsAndDeposit(Map<String, Object> paramMap);

    List<TbSTaskA>  getNeedNoticeSms();

    int updateNoticeStatus(@Param("subtask") TbSTaskA subtask);



}