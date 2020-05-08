package com.funtalk.pojo;

import java.util.Date;

public class TbSSubtaskResult {
    private Integer nid;

    private Integer taskId;

    private String custId;

    private String orderno;

    private String phoneA;

    private String iccidA;

    private String serviceKindA;

    private String cityA;

    private String phoneB;

    private String msg;

    private String state;

    private Integer smsPhoneBId;

    private String cardid;

    private Date createTime;

    private Date sendTime;

    private Date sendDate;

    private String ifSend;

    private String errMsg;

    private Integer ifDemo;

    private String ifRecord;

    private Integer repeatCnt;

    private String workNo;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getPhoneA() {
        return phoneA;
    }

    public void setPhoneA(String phoneA) {
        this.phoneA = phoneA == null ? null : phoneA.trim();
    }

    public String getIccidA() {
        return iccidA;
    }

    public void setIccidA(String iccidA) {
        this.iccidA = iccidA == null ? null : iccidA.trim();
    }

    public String getServiceKindA() {
        return serviceKindA;
    }

    public void setServiceKindA(String serviceKindA) {
        this.serviceKindA = serviceKindA == null ? null : serviceKindA.trim();
    }

    public String getCityA() {
        return cityA;
    }

    public void setCityA(String cityA) {
        this.cityA = cityA == null ? null : cityA.trim();
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

    public Integer getSmsPhoneBId() {
        return smsPhoneBId;
    }

    public void setSmsPhoneBId(Integer smsPhoneBId) {
        this.smsPhoneBId = smsPhoneBId;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getIfSend() {
        return ifSend;
    }

    public void setIfSend(String ifSend) {
        this.ifSend = ifSend == null ? null : ifSend.trim();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg == null ? null : errMsg.trim();
    }

    public Integer getIfDemo() {
        return ifDemo;
    }

    public void setIfDemo(Integer ifDemo) {
        this.ifDemo = ifDemo;
    }

    public String getIfRecord() {
        return ifRecord;
    }

    public void setIfRecord(String ifRecord) {
        this.ifRecord = ifRecord == null ? null : ifRecord.trim();
    }

    public Integer getRepeatCnt() {
        return repeatCnt;
    }

    public void setRepeatCnt(Integer repeatCnt) {
        this.repeatCnt = repeatCnt;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }
}