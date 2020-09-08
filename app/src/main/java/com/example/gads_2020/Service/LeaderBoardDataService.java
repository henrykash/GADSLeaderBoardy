package com.example.gads_2020.Service;

import com.example.gads_2020.Model.LeaderBoard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardDataService {
    String baseUrl = "https://gadsapi.herokuapp.com";

    @GET("/api/hours")
    Call<List<LeaderBoard>> learningLeaders();
}
