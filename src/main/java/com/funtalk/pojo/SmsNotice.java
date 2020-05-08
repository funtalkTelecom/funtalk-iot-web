package com.funtalk.pojo;

public class SmsNotice {

    String  uid;
    String  reqseq;
    String  mobile;
    String  state;
    String  statemsg;
    String  backtime;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getReqseq() {
        return reqseq;
    }

    public void setReqseq(String reqseq) {
        this.reqseq = reqseq;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatemsg() {
        return statemsg;
    }

    public void setStatemsg(String statemsg) {
        this.statemsg = statemsg;
    }

    public String getBacktime() {
        return backtime;
    }

    public void setBacktime(String backtime) {
        this.backtime = backtime;
    }

}
