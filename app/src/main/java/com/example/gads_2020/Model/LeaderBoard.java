package com.example.gads_2020.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaderBoard {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hours")
    @Expose
    private String hours;
    @SerializedName("badgeUrl")
    @Expose
    private String image;
    @SerializedName("country")
    @Expose
    private String country;

    public LeaderBoard() {

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() { return country;}

    public void setCountry(String country) {this.country = country;}

    @Override
    public String toString() {
        return "LeaderBoard{" +
                "name='" + name + '\'' +
                ", hours='" + hours + '\'' +
                ", image=" + image +


                '}';
    }
}
