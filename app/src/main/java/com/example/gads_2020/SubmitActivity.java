package com.example.gads_2020;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
    Dialog customdialog, successful, notsuccessful;


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
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                String firstName = tvname.getText().toString();
                String lastName = tvlast.getText().toString();
                String emailAddress = email.getText().toString();
                String gitLink = tvlink.getText().toString();

                if (!firstName.isEmpty() && !lastName.isEmpty() && !emailAddress.isEmpty() && !gitLink.isEmpty()) {
                    ServiceSubmit serviceSubmit = ServiceBuilder.buildService(ServiceSubmit.class);
                    Call<StudentDataSubmission> submitRequest = serviceSubmit.submitProject(firstName, lastName, emailAddress, gitLink
                    );

                    submitRequest.enqueue(new Callback<StudentDataSubmission>() {
                        @Override
                        public void onResponse(Call<StudentDataSubmission> call, Response<StudentDataSubmission> response) {
                            showCustomDialog2();
                        }

                        @Override
                        public void onFailure(Call<StudentDataSubmission> call, Throwable t) {

                            showCustomDialog3();
                        }
                    });
                };

            }
        });

    }
    private void showCustomDialog3() {

        final Dialog customdialog3 = new Dialog(SubmitActivity.this);

        customdialog3.requestWindowFeature(Window.FEATURE_NO_TITLE);

        customdialog3.setCancelable(true);

        customdialog3.setContentView(R.layout.successful_not_dialog_box);

        final CardView Cardview = findViewById(R.id.sure_cardview);
        final ImageView closebutton = findViewById(R.id.not_succesful_imageview);
        final TextView sure = findViewById(R.id.not_successful_textview);

        customdialog3.show();


    }

    private void showCustomDialog2() {
        final Dialog customdialog2 = new Dialog(SubmitActivity.this);

        customdialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);

        customdialog2.setCancelable(true);

        customdialog2.setContentView(R.layout.successful_dialog_box);

        final ImageView closebutton = findViewById(R.id.succesful_imageview);
        final TextView sure = findViewById(R.id.successful_textview);

        customdialog2.show();


    }
}













