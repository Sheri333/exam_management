package com.projectregistration.registration;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Add_Data_Activitycomputer extends AppCompatActivity {

    EditText txtCoursee, txtcode1, txtcode2, txtcode3;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data_computer);

        txtCoursee = findViewById(R.id.edtCoursee);
        txtcode1 = findViewById(R.id.edtCode1);
        txtcode2 = findViewById(R.id.edtCode2);
        txtcode3 = findViewById(R.id.edtCode3);
        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {

        final String coursee = txtCoursee.getText().toString().trim();
        final String code1 = txtcode1.getText().toString().trim();
        final String code2 = txtcode2.getText().toString().trim();
        final String code3 = txtcode3.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");



 if(coursee.isEmpty()){
            Toast.makeText(this, "Enter Passing Year", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(code3.isEmpty()){
            Toast.makeText(this, "Enter Department", Toast.LENGTH_SHORT).show();
            return;
        }

        else{
                progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://shaheryarmad.000webhostapp.com/insertexam.php",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(Add_Data_Activitycomputer.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else{
                                Toast.makeText(Add_Data_Activitycomputer.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Add_Data_Activitycomputer.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("coursee",coursee);
                    params.put("code1",code1);
                    params.put("code2",code2);
                    params.put("code3",code3);



                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(Add_Data_Activitycomputer.this);
            requestQueue.add(request);

        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
