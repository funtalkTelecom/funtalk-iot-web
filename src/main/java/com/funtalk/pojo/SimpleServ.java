package com.funtalk.pojo;

public class SimpleServ {

    String accNbr;
    String oldState;
    String newState;

    public String getAccNbr() { return accNbr; }
    public void setAccNbr(String accNbr) { this.accNbr = accNbr; }

    public String getOldState() { return oldState; }
    public void setOldState(String oldState) { this.oldState = oldState; }

    public String getNewState() { return newState; }
    public void setNewState(String newState) { this.newState = newState; }

    @Override
    public String toString() {
        return "SimpleServ{ accNbr='" + accNbr  +  "', oldState='" + oldState + "'," + "',newState='"+newState+"'}";
    }

}
