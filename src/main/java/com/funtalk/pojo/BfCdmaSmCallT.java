package com.funtalk.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class BfCdmaSmCallT {

    private String cityCode;

    private String month;

    private Short day;

    private String serviceId;

    private String userId;

    private Integer feeKind;

    private String callType;

    private String callPhone;

    private Date beginDate;

    private Date endDate;



    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getFeeKind() {
        return feeKind;
    }

    public void setFeeKind(Integer feeKind) {
        this.feeKind = feeKind;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType == null ? null : callType.trim();
    }


    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Short getDay() { return day; }

    public void setDay(Short day) {  this.day = day; }

    public String getCallPhone() {  return callPhone; }

    public void setCallPhone(String callPhone) {  this.callPhone = callPhone; }

}