package com.example.lenovo.bbqu.model;

/**
 * Created by lenovo on 2016/6/11.
 */
public class Package {
    String datetime;
    String remark;
    public Package(String dateTime, String remark){
        this.datetime=dateTime;
        this.remark=remark;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getRemark() {
        return remark;
    }

}
