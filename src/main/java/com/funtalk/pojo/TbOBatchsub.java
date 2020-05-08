package com.funtalk.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbOBatchsub {

    private Integer subId;

    private Integer batchId;

    private String accNbr;

    private BigDecimal rechargeAmount;

    private String rechargeState;

    private String rechargeTransId;

    private Date rechargeTime;

    private String rechargeMark;

    private String belongType;

    private String belongId;

    private String activateState;

    private String limitState;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr == null ? null : accNbr.trim();
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
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

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public String getRechargeMark() {
        return rechargeMark;
    }

    public void setRechargeMark(String rechargeMark) {
        this.rechargeMark = rechargeMark == null ? null : rechargeMark.trim();
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

    public String getActivateState() {
        return activateState;
    }

    public void setActivateState(String activateState) {
        this.activateState = activateState == null ? null : activateState.trim();
    }

    public String getLimitState() {
        return limitState;
    }

    public void setLimitState(String limitState) {
        this.limitState = limitState == null ? null : limitState.trim();
    }
}