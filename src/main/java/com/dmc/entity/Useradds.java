package com.dmc.entity;

public class Useradds {
    private Long addid;

    private Long userid;

    private String uadd;

    private String detailadd;

    private String recivername;

    private String reciverphone;

    public Long getAddid() {
        return addid;
    }

    public void setAddid(Long addid) {
        this.addid = addid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUadd() {
        return uadd;
    }

    public void setUadd(String uadd) {
        this.uadd = uadd == null ? null : uadd.trim();
    }

    public String getDetailadd() {
        return detailadd;
    }

    public void setDetailadd(String detailadd) {
        this.detailadd = detailadd == null ? null : detailadd.trim();
    }

    public String getRecivername() {
        return recivername;
    }

    public void setRecivername(String recivername) {
        this.recivername = recivername == null ? null : recivername.trim();
    }

    public String getReciverphone() {
        return reciverphone;
    }

    public void setReciverphone(String reciverphone) {
        this.reciverphone = reciverphone == null ? null : reciverphone.trim();
    }
}