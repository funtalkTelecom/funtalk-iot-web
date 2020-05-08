package com.funtalk.pojo;

import java.util.Date;

public class TbOError {
    private Integer errId;

    private String errType;

    private String topic;

    private String errMessae;

    private Date createTime;

    private String mark;

    public Integer getErrId() {
        return errId;
    }

    public void setErrId(Integer errId) {
        this.errId = errId;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType == null ? null : errType.trim();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public String getErrMessae() {
        return errMessae;
    }

    public void setErrMessae(String errMessae) {
        this.errMessae = errMessae == null ? null : errMessae.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}