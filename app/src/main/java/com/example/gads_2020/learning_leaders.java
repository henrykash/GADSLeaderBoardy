package com.example.gads_2020;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads_2020.Adapters.LearningLeadersAdapter;
import com.example.gads_2020.Model.LeaderBoard;
import com.example.gads_2020.Service.LeaderBoardDataService;
import com.example.gads_2020.Service.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class learning_leaders extends Fragment {

    private RecyclerView recyclerView;
    private LearningLeadersAdapter learningLeadersAdapter;
    private List<LeaderBoard> leaderBoard;


    //add a public constructor
    public learning_leaders() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        recyclerView = view.findViewById(R.id.learning_leaders);
        leaderBoard = new ArrayList<>();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LeaderBoardDataService leaderBoardDataService = ServiceBuilder.buildService(LeaderBoardDataService.class);
        Call<List<LeaderBoard>> leaderBoardRequest = leaderBoardDataService.learningLeaders();

        leaderBoardRequest.enqueue(new Callback<List<LeaderBoard>>() {
            @Override
            public void onResponse(Call<List<LeaderBoard>> call, Response<List<LeaderBoard>> response) {
                learningLeadersAdapter = new LearningLeadersAdapter();
                learningLeadersAdapter.setLeaderBoard(response.body());
                recyclerView.setAdapter(learningLeadersAdapter);
            }

            @Override
            public void onFailure(Call<List<LeaderBoard>> call, Throwable t) {

            }
        });

    }
}