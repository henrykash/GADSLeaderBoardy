package com.example.gads_2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gads_2020.Model.StudentDataSubmission;
import com.example.gads_2020.Service.ServiceBuilder;
import com.example.gads_2020.Service.ServiceSubmit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {


    private ImageButton backstack;
    EditText tvname, tvlast, tvlink, email;
    Button btnsubmit;

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

        //initialize edit text views and button

        email = findViewById(R.id.editTextTextEmailAddress);
        tvname = findViewById(R.id.editTextTextPersonName);
        tvlast = findViewById(R.id.editTextTextPersonName2);
        tvlink = findViewById(R.id.editTextTextPersonName3);
        btnsubmit = findViewById(R.id.button);

        //use retrofit to call the end point
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = tvname.getText().toString();
                String lastName = tvlast.getText().toString();
                String emailAddress = email.getText().toString();
                String gitLink = tvlink.getText().toString();
                if (!firstName.isEmpty() && !lastName.isEmpty() && !emailAddress.isEmpty() && !gitLink.isEmpty()) {
                    ServiceSubmit serviceSubmit = ServiceBuilder.buildService(ServiceSubmit.class);
                    Call<StudentDataSubmission> submitRequest = serviceSubmit.submitProject(firstName, lastName, emailAddress, gitLink);
                    submitRequest.enqueue(new Callback<StudentDataSubmission>() {
                        @Override
                        public void onResponse(Call<StudentDataSubmission> call, Response<StudentDataSubmission> response) {
                            if (!response.isSuccessful()) {

                            }
                        }

                        @Override
                        public void onFailure(Call<StudentDataSubmission> call, Throwable t) {

                        }
                    });
                }

            }
        });
    }
}