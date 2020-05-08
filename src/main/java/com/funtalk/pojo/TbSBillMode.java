package com.funtalk.pojo;

import java.util.Date;

public class TbSBillMode {
    private Integer mId;

    private Integer mType;

    private String custId;

    private Integer employeeId;

    private Integer billType;

    private Integer billUnit;

    private Integer billPrice;

    private String ifValid;

    private Date createDate;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getmType() {
        return mType;
    }

    public void setmType(Integer mType) {
        this.mType = mType;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getBillUnit() {
        return billUnit;
    }

    public void setBillUnit(Integer billUnit) {
        this.billUnit = billUnit;
    }

    public Integer getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(Integer billPrice) {
        this.billPrice = billPrice;
    }

    public String getIfValid() {
        return ifValid;
    }

    public void setIfValid(String ifValid) {
        this.ifValid = ifValid == null ? null : ifValid.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}