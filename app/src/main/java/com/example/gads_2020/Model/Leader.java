package com.example.gads_2020.Model;

import com.squareup.moshi.Json;

public class Leader {
    @Json(name = "name")
    public String name;
    @Json(name = "hours")
    public Integer hours;
    @Json(name = "country")
    public String country;
    @Json(name = "badgeUrl")
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

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
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

