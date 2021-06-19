package com.projectregistration.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exammain extends AppCompatActivity {
Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exammain);
        bt1=findViewById(R.id.buttone);
        bt2=findViewById(R.id.buttonr);
        bt3=findViewById(R.id.buttons);
        bt4=findViewById(R.id.buttond);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vale = new Intent(exammain.this,exammodule.class);
                startActivity(vale);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent val2 = new Intent(exammain.this,MainActivityl.class);
                startActivity(val2);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent val3 = new  Intent(exammain.this,slips.class);
           startActivity(val3);

            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent val4 = new Intent(exammain.this,MainActivitydst.class);
                startActivity(val4);

            }
        });
    }
}