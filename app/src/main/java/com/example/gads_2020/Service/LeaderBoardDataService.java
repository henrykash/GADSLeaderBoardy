package com.example.gads_2020.Service;

import com.example.gads_2020.Model.Leader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardDataService {
    String baseUrl = "https://gadsapi.herokuapp.com";

    @GET("/api/hours")
    Call<List<Leader>> learningLeaders();
}
