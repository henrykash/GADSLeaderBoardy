package com.example.gads_2020.Model;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

public class Leader {
    @SerializedName("name")
    public String name;
    @SerializedName("hours")
    public String hours;
    @SerializedName("country")
    public String country;
    @SerializedName("badgeUrl")
    public String badgeUrl;


    //constructor
    public Leader() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

}

