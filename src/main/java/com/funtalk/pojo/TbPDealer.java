package com.funtalk.pojo;

import java.util.Date;

public class TbPDealer {
    private Integer dealerId;

    private String dealerName;

    private String cityCode;

    private String dealerType;

    private String idCode;

    private String idAddress;

    private String createWorkno;

    private String contactPhone;

    private Date createDate;

    private String ifValid;

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getDealerType() {
        return dealerType;
    }

    public void setDealerType(String dealerType) {
        this.dealerType = dealerType == null ? null : dealerType.trim();
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress == null ? null : idAddress.trim();
    }

    public String getCreateWorkno() {
        return createWorkno;
    }

    public void setCreateWorkno(String createWorkno) {
        this.createWorkno = createWorkno == null ? null : createWorkno.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIfValid() {
        return ifValid;
    }

    public void setIfValid(String ifValid) {
        this.ifValid = ifValid == null ? null : ifValid.trim();
    }
}