package com.funtalk.pojo;

import java.util.Date;

public class TbSAcct {
    private Integer acctId;

    private String belongType;

    private String belongId;

    private Integer ownMoney;

    private String ifValid;

    private Date createDate;

    private Date invalidDate;

    private String createWorkno;

    public String getBelongType() { return belongType;  }

    public void setBelongType(String belongType) {
        this.belongType = belongType == null ? null : belongType.trim();
    }

    public String getBelongId() {  return belongId;  }

    public void setBelongId(String belongId) {
        this.belongId = belongId == null ? null : belongId.trim();
    }

    public Integer getOwnMoney() {  return ownMoney;  }

    public void setOwnMoney(Integer ownMoney) {   this.ownMoney = ownMoney;  }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
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

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public String getCreateWorkno() {
        return createWorkno;
    }

    public void setCreateWorkno(String createWorkno) {
        this.createWorkno = createWorkno == null ? null : createWorkno.trim();
    }
}