package com.example.gads_2020;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads_2020.Adapters.SkillIQAdapter;
import com.example.gads_2020.Model.SkillIQ;
import com.example.gads_2020.Service.ServiceBuilder;
import com.example.gads_2020.Service.SkillIQDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Skill_iq extends Fragment {
    //initialize the RecView , Adapter and the List
    private RecyclerView recyclerView;
    private SkillIQAdapter skillIQAdapter;
    private List<Skill_iq> skillIq;

    //add a public constructor
    public Skill_iq() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_skill_iq, container, false);
        recyclerView = view.findViewById(R.id.skill_iq);
        skillIq = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SkillIQDataService skillIQDataService = ServiceBuilder.buildService(SkillIQDataService.class);
        Call<List<SkillIQ>> skillIQRequest = skillIQDataService.skillIQService();

        skillIQRequest.enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                skillIQAdapter = new SkillIQAdapter();
                skillIQAdapter.setSkillIQ(response.body());
                recyclerView.setAdapter(skillIQAdapter);
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {

            }
        });


    }
}