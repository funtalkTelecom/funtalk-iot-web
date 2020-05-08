package com.funtalk.mapper;

import com.funtalk.pojo.SubTask;
import com.funtalk.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SubTaskMapper {

    int insertFromPC(@Param("subtask") SubTask subtask);

    int upadtePhoneA(@Param(value = "taskId") Integer taskId,
                     @Param(value = "phoneNumber") String phoneNumber,
                     @Param(value = "recordNum") Integer recordNum);


    int updateBeforeSend(@Param(value = "taskids") String taskids,
                         @Param(value = "sendOrderId") String sendOrderId);

    int updateSendResult(@Param(value = "sendOrderId") String sendOrderId,
                         @Param(value = "phones") String phones,
                         @Param(value = "state") String state,
                         @Param(value = "iccId") String iccId);


    List<SubTask> getNeadDealTasks(@Param(value = "iccid") String iccid,
                                   @Param(value = "limitNum") Integer limitNum);

    int addTaskBatch(@Param("subtasks") List<SubTask> subtasks);

    List<SubTask> getNeedAuditSms(Map<String, Object> paramMap);

    int getNeedAuditSmsCount(Map<String, Object> paramMap);

    int updateCheckStatus(Map<String, Object> paramMap);

    List<SubTask> getSmsByWorkNo(Map<String, Object> paramMap);

    int getSmsByWorkNoCount(Map<String, Object> paramMap);

    int queryrecordcount(@Param(value ="receiver") String receiver);

    String getSmsAndDeposit(Map<String, Object> paramMap);

    String getSmsNoticeSeq(@Param("transType")String transType);

    List<SubTask> getNeedNoticeSms(Map<String, Object> paramMap);

    List<SubTask>  getNeedNoticeSms();

    int updateNoticeStatus(@Param("subtask") SubTask subtask);

    List<SubTask>  getNeedCheckSms();

    int updateBossStatus(@Param(value = "sendState") String sendState,
                         @Param(value = "nid") Long nid);



}