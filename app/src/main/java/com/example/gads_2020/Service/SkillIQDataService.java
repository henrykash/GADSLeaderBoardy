package com.example.gads_2020.Service;

import com.example.gads_2020.Model.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillIQDataService {
    String baseUrl = "https://gadsapi.herokuapp.com";

    @GET("/api/skilliq")
    Call<List<SkillIQ>> skillIQService();
}
