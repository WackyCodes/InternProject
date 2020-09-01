package com.shailendra.intern.home;

/**
 * Created by Shailendra (WackyCodes) on 01/09/2020 07:07
 * ( To Know more, Click : https://linktr.ee/wackycodes )
 */
public class ListModel {

    private String categoryName;
    private String joined;
    private String dateTime;

    public ListModel(String categoryName, String joined, String dateTime) {
        this.categoryName = categoryName;
        this.joined = joined;
        this.dateTime = dateTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getJoined() {
        return joined;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
