package com.funtalk.pojo;

import java.util.Date;

public class TbSSmstemplate {
    private Integer temId;

    private String custId;

    private String temType;

    private String temContent;

    private String ifValid;

    private Date createDate;

    public Integer getTemId() {
        return temId;
    }

    public void setTemId(Integer temId) {
        this.temId = temId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getTemType() {
        return temType;
    }

    public void setTemType(String temType) {
        this.temType = temType == null ? null : temType.trim();
    }

    public String getTemContent() {
        return temContent;
    }

    public void setTemContent(String temContent) {
        this.temContent = temContent == null ? null : temContent.trim();
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