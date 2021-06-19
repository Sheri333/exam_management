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

public class Edit_Activityl extends AppCompatActivity {

    EditText edId,edName, edCourse1, edCourse2,edCourse3,edEmail,edRoll, edCourse4;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_l);

        edId = findViewById(R.id.ed_id);
        edName = findViewById(R.id.ed_name);
        edCourse1 = findViewById(R.id.ed_course1);
        edRoll = findViewById(R.id.ed_roll);
        edEmail = findViewById(R.id.ed_email);
        edCourse2 = findViewById(R.id.ed_course2);
        edCourse3 = findViewById(R.id.ed_course3);
        edCourse4 = findViewById(R.id.ed_course4);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edId.setText(MainActivityl.employeeArrayList.get(position).getId());
        edName.setText(MainActivityl.employeeArrayList.get(position).getName());
        edRoll.setText(MainActivityl.employeeArrayList.get(position).getRoll());
        edEmail.setText(MainActivityl.employeeArrayList.get(position).getEmail());
        edCourse1.setText(MainActivityl.employeeArrayList.get(position).getCourse1());
        edCourse2.setText(MainActivityl.employeeArrayList.get(position).getCourse2());
        edCourse3.setText(MainActivityl.employeeArrayList.get(position).getCourse3());
        edCourse4.setText(MainActivityl.employeeArrayList.get(position).getCourse4());




    }

    public void btn_updateData(View view) {

        final String name = edName.getText().toString();
        final String roll = edRoll.getText().toString();
        final String email = edEmail.getText().toString();
        final String course1 = edCourse1.getText().toString();
        final String course2 = edCourse2.getText().toString();
        final String course3 = edCourse3.getText().toString();
        final String course4 = edCourse4.getText().toString();
        final String id = edId.getText().toString();





        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "https://shaheryarmad.000webhostapp.com/updateregist.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Edit_Activityl.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivityl.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Edit_Activityl.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("name",name);
                params.put("roll",roll);
                params.put("email",email);
                params.put("course1",course1);
                params.put("course2",course2);
                params.put("course3",course3);
                params.put("course4",course4);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Edit_Activityl.this);
        requestQueue.add(request);





    }
}
