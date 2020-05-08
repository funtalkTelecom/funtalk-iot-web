package com.funtalk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SubTask {

    private Long taskId;

    private String taskType;

    private Long   subId;

    private String custId;

    private String phoneB;

    private String msg;

    private Integer state;

    private String reqSeq;

    private String phoneA;

    private String iccidA;

    private String sendOrderId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date sendTime;

    private String auditor;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private String workNo;

    private String noticeUrl;

    private String noticeSeq;

    private String noticeState;

    private Date   noticeTime;

    private String noticeBack;

    private Long  nId;

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIccidA() {
        return iccidA;
    }

    public void setIccidA(String iccidA) {
        this.iccidA = iccidA;
    }

    public String getSendOrderId() {
        return sendOrderId;
    }

    public void setSendOrderId(String sendOrderId) {
        this.sendOrderId = sendOrderId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPhoneA() {
        return phoneA;
    }

    public void setPhoneA(String phoneA) {
        this.phoneA = phoneA;
    }

    public Long getTaskId() { return taskId; }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getPhoneB() {
        return phoneB;
    }

    public void setPhoneB(String phoneB) {
        this.phoneB = phoneB == null ? null : phoneB.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getReqSeq() {
        return reqSeq;
    }

    public void setReqSeq(String reqSeq) {
        this.reqSeq = reqSeq == null ? null : reqSeq.trim();
    }

    public Long getSubId() {  return subId;  }

    public void setSubId(Long subId) {  this.subId = subId; }

    public String getNoticeUrl() { return noticeUrl; }

    public void setNoticeUrl(String noticeUrl) { this.noticeUrl = noticeUrl; }

    public String getTaskType() { return taskType; }

    public void setTaskType(String taskType) { this.taskType = taskType; }

    public String getAuditor() { return auditor; }

    public void setAuditor(String auditor) { this.auditor = auditor; }

    public String getNoticeSeq() { return noticeSeq; }

    public void setNoticeSeq(String noticeSeq) { this.noticeSeq = noticeSeq; }

    public String getNoticeState() { return noticeState; }

    public void setNoticeState(String noticeState) { this.noticeState = noticeState; }

    public Date getNoticeTime() { return noticeTime; }

    public void setNoticeTime(Date noticeTime) { this.noticeTime = noticeTime; }

    public String getNoticeBack() { return noticeBack; }

    public void setNoticeBack(String noticeBack) { this.noticeBack = noticeBack; }

    public Long getnId() { return nId; }
    public void setnId(Long nId) { this.nId = nId; }

}