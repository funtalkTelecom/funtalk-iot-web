package com.funtalk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbSTaskA {
    private Integer taskId;

    private String taskSource;

    private String custId;

    private String orderNo;

    private String cardId;

    private String phoneA;

    private String iccid;

    private String serviceKind;

    private String phoneB;

    private String msg;

    private String state;

    private String reqSeq;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private Date sendBeginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date sendEndTime;

    private String sendMark;

    private String workNo;

    private Integer employeeId;

    private String noticeUrl;

    private String noticeSeq;

    private String noticeState;

    private Date noticeTime;

    private String noticeBack;

    private String dealMark;

    private Integer billId;

    private Integer repeatCount;

    private String  auditor;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource == null ? null : taskSource.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getPhoneA() {
        return phoneA;
    }

    public void setPhoneA(String phoneA) {
        this.phoneA = phoneA == null ? null : phoneA.trim();
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid == null ? null : iccid.trim();
    }

    public String getServiceKind() {
        return serviceKind;
    }

    public void setServiceKind(String serviceKind) {
        this.serviceKind = serviceKind == null ? null : serviceKind.trim();
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getReqSeq() {
        return reqSeq;
    }

    public void setReqSeq(String reqSeq) {
        this.reqSeq = reqSeq == null ? null : reqSeq.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendBeginTime() {
        return sendBeginTime;
    }

    public void setSendBeginTime(Date sendBeginTime) {
        this.sendBeginTime = sendBeginTime;
    }

    public Date getSendEndTime() {
        return sendEndTime;
    }

    public void setSendEndTime(Date sendEndTime) {
        this.sendEndTime = sendEndTime;
    }

    public String getSendMark() {
        return sendMark;
    }

    public void setSendMark(String sendMark) {
        this.sendMark = sendMark == null ? null : sendMark.trim();
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getNoticeUrl() {
        return noticeUrl;
    }

    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl == null ? null : noticeUrl.trim();
    }

    public String getNoticeSeq() {
        return noticeSeq;
    }

    public void setNoticeSeq(String noticeSeq) {
        this.noticeSeq = noticeSeq == null ? null : noticeSeq.trim();
    }

    public String getNoticeState() {
        return noticeState;
    }

    public void setNoticeState(String noticeState) {
        this.noticeState = noticeState == null ? null : noticeState.trim();
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticeBack() {
        return noticeBack;
    }

    public void setNoticeBack(String noticeBack) {
        this.noticeBack = noticeBack == null ? null : noticeBack.trim();
    }

    public String getDealMark() {
        return dealMark;
    }

    public void setDealMark(String dealMark) {
        this.dealMark = dealMark == null ? null : dealMark.trim();
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public String getAuditor() { return auditor; }

    public void setAuditor(String auditor) { this.auditor = auditor; }
}