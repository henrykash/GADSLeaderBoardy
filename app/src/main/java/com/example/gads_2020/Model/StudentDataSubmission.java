package com.example.gads_2020.Model;

import com.google.gson.annotations.SerializedName;

public class StudentDataSubmission {
    @SerializedName("firstName")
    public final String firstName;
    @SerializedName("lastName")
    public final String lastName;
    @SerializedName("email")
    public final String email;
    @SerializedName("githubLink")
    public final String githubLink;

    public StudentDataSubmission(String firstName, String lastName, String email, String githubLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.githubLink = githubLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGithubLink() {
        return githubLink;
    }

    @Override
    public String toString() {
        return "StudentDataSubmission{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", githubLink='" + githubLink + '\'' +
                '}';
    }
}
