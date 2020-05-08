package com.funtalk.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbOAccnbr {
    private Integer accOrderId;

    private String belongType;

    private String belongId;

    private String accNbr;

    private String state;

    private Date stateTime;

    private String ifValid;

    private Date createTime;

    private Date validTime;

    private Date invalidTime;

    private String pakId;

    private BigDecimal pakPrice;

    public Integer getAccOrderId() {
        return accOrderId;
    }

    public void setAccOrderId(Integer accOrderId) {
        this.accOrderId = accOrderId;
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

    public String getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr == null ? null : accNbr.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getStateTime() {
        return stateTime;
    }

    public void setStateTime(Date stateTime) {
        this.stateTime = stateTime;
    }

    public String getIfValid() {
        return ifValid;
    }

    public void setIfValid(String ifValid) {
        this.ifValid = ifValid == null ? null : ifValid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public String getPakId() {
        return pakId;
    }

    public void setPakId(String pakId) {
        this.pakId = pakId == null ? null : pakId.trim();
    }

    public BigDecimal getPakPrice() {
        return pakPrice;
    }

    public void setPakPrice(BigDecimal pakPrice) {
        this.pakPrice = pakPrice;
    }
}