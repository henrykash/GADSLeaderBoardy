package com.example.gads_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SubmitActivity extends AppCompatActivity {

    private ImageButton backstack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        ImageButton backstack = findViewById(R.id.backstack);
        backstack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubmitActivity.this, LaunchingActivity.class));
            }
        });
    }
}