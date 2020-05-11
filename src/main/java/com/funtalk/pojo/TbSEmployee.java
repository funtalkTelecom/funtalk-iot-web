package com.funtalk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class TbSEmployee  implements java.io.Serializable{
    private Integer employeeId;

    private String employeeName;

    private String workNo;

    private String workPwd;

    private String cityCode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private Integer dealerId;

    private String ifValid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date lastLoginTime;

    private String roleId;

    private String custId;

    private String  allowMenu;

    private Integer  billMode;
    private Integer  billPrice;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    public String getWorkPwd() {
        return workPwd;
    }

    public void setWorkPwd(String workPwd) {
        this.workPwd = workPwd == null ? null : workPwd.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getIfValid() {
        return ifValid;
    }

    public void setIfValid(String ifValid) {
        this.ifValid = ifValid == null ? null : ifValid.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getAllowMenu() { return allowMenu; }

    public void setAllowMenu(String allowMenu) { this.allowMenu = allowMenu; }

    public Integer getBillMode() { return billMode; }

    public void setBillMode(Integer billMode) { this.billMode = billMode; }

    public Integer getBillPrice() { return billPrice; }

    public void setBillPrice(Integer billPrice) { this.billPrice = billPrice; }
}