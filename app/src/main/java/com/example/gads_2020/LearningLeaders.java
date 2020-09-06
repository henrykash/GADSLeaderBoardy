package com.example.gads_2020;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads_2020.Adapters.LearningLeadersAdapter;
import com.example.gads_2020.Model.Leader;
import com.example.gads_2020.Service.LeaderBoardDataService;
import com.example.gads_2020.Service.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeaders extends Fragment {

    Context context;
    private RecyclerView recyclerView;
    private LearningLeadersAdapter learningLeadersAdapter;
    private List<Leader> leaderBoard;
    private View view;
    private LinearLayoutManager linearLayoutManager;


    //add a public constructor
    public LearningLeaders(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.learning_leaders);
        leaderBoard = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LeaderBoardDataService leaderBoardDataService = ServiceBuilder.buildService(LeaderBoardDataService.class);
        Call<List<Leader>> leaderBoardRequest = leaderBoardDataService.learningLeaders();

        leaderBoardRequest.enqueue(new Callback<List<Leader>>() {
            @Override
            public void onResponse(Call<List<Leader>> call, Response<List<Leader>> response) {
                List<Leader> leaderBoard = response.body();
                learningLeadersAdapter = new LearningLeadersAdapter(leaderBoard, getContext());
            }

            @Override
            public void onFailure(Call<List<Leader>> call, Throwable t) {
                Toast.makeText(context, "unable to retrive data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}