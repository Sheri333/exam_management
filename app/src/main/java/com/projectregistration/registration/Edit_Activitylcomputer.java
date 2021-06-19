package com.projectregistration.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class Edit_Activitylcomputer extends AppCompatActivity {

    EditText edId, edCoursee, edCode1, edCode2, edCode3;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lcomputer);

        edId = findViewById(R.id.ed_id);
        edCoursee = findViewById(R.id.ed_coursee);
        edCode1 = findViewById(R.id.ed_code1);
        edCode2 = findViewById(R.id.ed_code2);
        edCode3 = findViewById(R.id.ed_code3);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edId.setText(MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getId());
        edCoursee.setText(MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getCoursee());
        edCode1.setText(MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getCode1());
        edCode2.setText(MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getCode2());
        edCode3.setText(MainActivitylcomputer.employeecomputerscienceArrayList.get(position).getCode3());




    }

    public void btn_updateData(View view) {

        final String coursee = edCoursee.getText().toString();
        final String code1 = edCode1.getText().toString();
        final String code2 = edCode2.getText().toString();
        final String code3 = edCode3.getText().toString();
        final String id = edId.getText().toString();





        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "https://shaheryarmad.000webhostapp.com/updatecmp.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Edit_Activitylcomputer.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivitylcomputer.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Edit_Activitylcomputer.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("coursee",coursee);
                params.put("code1",code1);
                params.put("code2",code2);
                params.put("code3",code3);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Edit_Activitylcomputer.this);
        requestQueue.add(request);





    }
}
