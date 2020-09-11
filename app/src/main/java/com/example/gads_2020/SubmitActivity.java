package com.example.gads_2020;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
            @Override
            public void onClick(View view) {
                showCustomDialog();

            }
        });
    }

    private void showCustomDialog() {

        final Dialog customdialog = new Dialog(SubmitActivity.this);

        customdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        customdialog.setCancelable(true);

        customdialog.setContentView(R.layout.sure_dialog_box);

        final CardView Cardview = findViewById(R.id.sure_cardview);
        final ImageButton closebutton = findViewById(R.id.close_button);
        final TextView sure = findViewById(R.id.sure_textview);
        final Button yes = findViewById(R.id.yes_button);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        customdialog.show();
    }

    private void setCustomdialog2() {

        final Dialog customdialog2 = new Dialog(SubmitActivity.this);

        customdialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);

        customdialog2.setCancelable(true);

        customdialog2.setContentView(R.layout.successful_dialog_box);

        final ImageView check = findViewById(R.id.succesful_imageview);
        final TextView successful = findViewById(R.id.successful_textview);


        customdialog2.show();
    }

    private void setCustomdialog3() {

        final Dialog customdialog3 = new Dialog(SubmitActivity.this);

        customdialog3.requestWindowFeature(Window.FEATURE_NO_TITLE);

        customdialog3.setCancelable(true);

        customdialog3.setContentView(R.layout.successful_not_dialog_box);

        final ImageView check = findViewById(R.id.not_succesful_imageview);
        final TextView successful = findViewById(R.id.not_successful_textview);


        customdialog3.show();

    }

}





