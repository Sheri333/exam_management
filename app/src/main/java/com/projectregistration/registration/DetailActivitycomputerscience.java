package com.projectregistration.registration;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivitycomputerscience extends AppCompatActivity {

    TextView tvid, tvcoursee, tvcode1, tvcode2, tvcode3;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_computer);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvcoursee = findViewById(R.id.txcoursee);
        tvcode1 = findViewById(R.id.txcode1);
        tvcode2 = findViewById(R.id.txcode2);
        tvcode3 = findViewById(R.id.txtcourse3);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+ MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getId());
        tvcoursee.setText("Course: "+ MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getCoursee());
        tvcode1.setText("Course Code 1: "+ MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getCode1());
        tvcode2.setText("Course Code 2: "+ MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getCode2());
        tvcode3.setText("Course Code 3: "+ MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getCode3());





    }
}
