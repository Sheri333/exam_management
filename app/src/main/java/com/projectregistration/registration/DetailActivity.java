package com.projectregistration.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvid,tvname,tvemail, tvcourse1, tvcourse2, tvcourse3, tvcourse4,tvroll;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txtname);
        tvemail = findViewById(R.id.txtemail);
        tvroll = findViewById(R.id.txtRoll);
        tvcourse1 = findViewById(R.id.txcourse1);
        tvcourse2 = findViewById(R.id.txcourse2);
        tvcourse3 = findViewById(R.id.txcourse3);
        tvcourse4 = findViewById(R.id.txtcourse4);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+ MainActivityl.employeeArrayList.get(position).getId());
        tvname.setText("Name: "+ MainActivityl.employeeArrayList.get(position).getName());
        tvroll.setText("Roll: "+ MainActivityl.employeeArrayList.get(position).getRoll());
        tvemail.setText("Email: "+ MainActivityl.employeeArrayList.get(position).getEmail());
        tvcourse1.setText("Course 1: "+ MainActivityl.employeeArrayList.get(position).getCourse1());
        tvcourse2.setText("Course 2: "+ MainActivityl.employeeArrayList.get(position).getCourse2());
        tvcourse3.setText("Course 3: "+ MainActivityl.employeeArrayList.get(position).getCourse3());
        tvcourse4.setText("Course 4: "+ MainActivityl.employeeArrayList.get(position).getCourse4());
    }
}
