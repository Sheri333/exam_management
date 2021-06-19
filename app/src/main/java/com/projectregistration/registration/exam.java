package com.projectregistration.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exam extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
   b1 = findViewById(R.id.buttonreg1);
   b1.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent val = new Intent(exam.this,exammain.class);
           startActivity(val);
       }
   });

    }
}