package com.projectregistration.registration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivityl extends AppCompatActivity {

    ListView listView;
    MyAdapterl adapter;
Button b1,b7;
    public static ArrayList<Employee> employeeArrayList = new ArrayList<>();
    String url = "https://shaheryarmad.000webhostapp.com/read.php";
    Employee employee;
    dbhelper1 db;
Add_Data_Activity ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainl);

        listView = findViewById(R.id.myListView);
        adapter = new MyAdapterl(this,employeeArrayList);
        listView.setAdapter(adapter);
db = new dbhelper1(this);

        b1= findViewById(R.id.bt45);
        b7 = findViewById(R.id.bt46);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Cursor res = db.getdata();
            while (res.moveToNext()) {
                String name = res.getString(0);
                String roll = res.getString(1);
                String email = res.getString(2);
                String course1 = res.getString(3);
                String course2 = res.getString(4);
                String course3 = res.getString(5);
                String course4 = res.getString(6);
                insertData2(name, roll, email, course1, course2, course3, course4);
            }
            db.deletedata();
    Toast.makeText(MainActivityl.this,"uploaded",Toast.LENGTH_SHORT).show();
    }
});

b7.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Cursor res = db.getdata();
        if(res.getCount()==0){
            Toast.makeText(MainActivityl.this,"No Data",Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Name: "+res.getString(0)+"\n");
            buffer.append("Roll: "+res.getString(1)+"\n");
            buffer.append("Email: "+res.getString(2)+"\n");
            buffer.append("Course1: "+res.getString(3)+"\n");
            buffer.append("Course2: "+res.getString(4)+"\n");
            buffer.append("Course3: "+res.getString(5)+"\n");
            buffer.append("Course3: "+res.getString(6)+"\n");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityl.this);
        builder.setCancelable(true);
        builder.setTitle("pending");
        builder.setMessage(buffer.toString());
        builder.show();

    }
});

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Data","Edit Data","Delete Data"};
                builder.setTitle(employeeArrayList.get(position).getName());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){

                            case 0:

                                startActivity(new Intent(getApplicationContext(),DetailActivity.class)
                                        .putExtra("position",position));

                                break;

                            case 1:
                                startActivity(new Intent(getApplicationContext(), Edit_Activityl.class)
                                        .putExtra("position",position));

                                break;

                            case 2:

                                deleteData(employeeArrayList.get(position).getId());

                                break;


                        }



                    }
                });


                builder.create().show();


            }
        });

        retrieveData();


    }

    private void deleteData(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST, "https://shaheryarmad.000webhostapp.com/delete.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Data Deleted")){
                            Toast.makeText(MainActivityl.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivityl.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivityl.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("id", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }

    public void retrieveData(){

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        employeeArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(sucess.equals("1")){


                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("id");
                                    String name = object.getString("name");
                                    String roll = object.getString("roll");
                                    String email = object.getString("email");
                                    String course1 = object.getString("course1");
                                    String course2 = object.getString("course2");
                                    String course3 = object.getString("course3");
                                    String course4 = object.getString("course4");

                                    employee = new Employee(id,name,roll,email,course1,course2,course3,course4);
                                    employeeArrayList.add(employee);
                                    adapter.notifyDataSetChanged();



                                }



                            }




                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }






                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivityl.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);




    }
    public void btn_add_activity(View view) {
        startActivity(new Intent(getApplicationContext(),Add_Data_Activity.class));
    }


    public void insertData2(String name1,String roll1,String email1,String course11,String course12,String course13,String course14) {

        final String name = name1.trim();
        final String roll = roll1.trim();
        final String email = email1.trim();
        final String course1 = course11.trim();
        final String course2 = course12.trim();
        final String course3 = course13.trim();
        final String course4 = course14.trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        if(name.isEmpty()){
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }

        else if(roll.isEmpty()){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(email.isEmpty()){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(course1.isEmpty()){
            Toast.makeText(this, "Enter Passing Year", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(course4.isEmpty()){
            Toast.makeText(this, "Enter Department", Toast.LENGTH_SHORT).show();
            return;
        }

        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://shaheryarmad.000webhostapp.com/insert.php",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(MainActivityl.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else{
                                Toast.makeText(MainActivityl.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivityl.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

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


            RequestQueue requestQueue = Volley.newRequestQueue(MainActivityl.this);
            requestQueue.add(request);

        }


    }




}
