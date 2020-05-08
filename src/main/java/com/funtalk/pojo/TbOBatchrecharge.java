package com.funtalk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TbOBatchrecharge {

    private Integer batchId;

    private String belongType;

    private String belongId;

    private String workNo;

    private String fileDbName;

    private String filePath;

    private String fileServerName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private String checkState;

    private String payState;

    private String serNum;

    private String rechargeState;

    private String rechargeTransId;

    private Date checkTime;

    private String checkMark;

    private Date payTime;

    private Date rechargeTime;

    private BigDecimal rechargeAmount;

    private Integer rechargeNum;

    private String employeeName;

    private String alterBoss;


    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBelongType() {
        return belongType;
    }

    public void setBelongType(String belongType) {
        this.belongType = belongType == null ? null : belongType.trim();
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId == null ? null : belongId.trim();
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    public String getFileDbName() {
        return fileDbName;
    }

    public void setFileDbName(String fileDbName) {
        this.fileDbName = fileDbName == null ? null : fileDbName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileServerName() {
        return fileServerName;
    }

    public void setFileServerName(String fileServerName) {
        this.fileServerName = fileServerName == null ? null : fileServerName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState == null ? null : checkState.trim();
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum == null ? null : serNum.trim();
    }

    public String getRechargeState() {
        return rechargeState;
    }

    public void setRechargeState(String rechargeState) {
        this.rechargeState = rechargeState == null ? null : rechargeState.trim();
    }

    public String getRechargeTransId() {
        return rechargeTransId;
    }

    public void setRechargeTransId(String rechargeTransId) {
        this.rechargeTransId = rechargeTransId == null ? null : rechargeTransId.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Integer getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(Integer rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    public String getEmployeeName() { return employeeName; }

    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getAlterBoss() {
        return alterBoss;
    }

    public void setAlterBoss(String alterBoss) {
        this.alterBoss = alterBoss == null ? null : alterBoss.trim();
    }

    public String getCheckMark() { return checkMark; }

    public void setCheckMark(String checkMark) { this.checkMark = checkMark; }
}