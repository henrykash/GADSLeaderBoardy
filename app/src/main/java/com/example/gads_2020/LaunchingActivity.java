package com.example.gads_2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class LaunchingActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RecyclerView recyclerview, recyclerView2;
    private Button submitbutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching_);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button submitbutton = findViewById(R.id.submit_button);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent (LaunchingActivity.this, SubmitActivity.class));
            }
        });


        ViewPager viewPager = findViewById(R.id.viewpager);
        viewpageradapter pagerAdapter = new viewpageradapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        recyclerview = findViewById(R.id.learning_leaders);
        recyclerView2 = findViewById(R.id.skill_iq);





    }
}