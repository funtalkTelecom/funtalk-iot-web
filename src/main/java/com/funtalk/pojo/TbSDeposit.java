package com.funtalk.pojo;

import java.util.Date;

public class TbSDeposit {
    private Integer depositId;

    private String belongType;

    private String belongId;

    private Integer acctId;

    private String deCode;

    private Integer limitMoney;

    private Integer availMoney;

    private String reInfo1;

    private String reInfo2;

    private Date createTime;

    private Date updateTime;

    public Integer getDepositId() {
        return depositId;
    }

    public void setDepositId(Integer depositId) {
        this.depositId = depositId;
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

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public String getDeCode() {
        return deCode;
    }

    public void setDeCode(String deCode) {
        this.deCode = deCode == null ? null : deCode.trim();
    }

    public Integer getLimitMoney() {
        return limitMoney;
    }

    public void setLimitMoney(Integer limitMoney) {
        this.limitMoney = limitMoney;
    }

    public Integer getAvailMoney() {
        return availMoney;
    }

    public void setAvailMoney(Integer availMoney) {
        this.availMoney = availMoney;
    }

    public String getReInfo1() {
        return reInfo1;
    }

    public void setReInfo1(String reInfo1) {
        this.reInfo1 = reInfo1 == null ? null : reInfo1.trim();
    }

    public String getReInfo2() {
        return reInfo2;
    }

    public void setReInfo2(String reInfo2) {
        this.reInfo2 = reInfo2 == null ? null : reInfo2.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}