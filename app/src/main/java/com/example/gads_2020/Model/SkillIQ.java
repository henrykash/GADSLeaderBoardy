package com.example.gads_2020.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkillIQ {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("skilliq")
    @Expose
    private String skilliq;
    @SerializedName("badgeUrl")
    @Expose
    private String image;
    @SerializedName("country")
    @Expose
    private String country;

    public SkillIQ() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkilliq() {
        return skilliq;
    }

    public void setSkilliq(String skilliq) {
        this.skilliq = skilliq;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "SkillIQ{" +
                "name='" + name + '\'' +
                ", skilliq='" + skilliq + '\'' +
                ", image='" + image + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
