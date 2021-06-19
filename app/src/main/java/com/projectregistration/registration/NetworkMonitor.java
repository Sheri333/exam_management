package com.projectregistration.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkMonitor extends BroadcastReceiver {
MainActivityl ad;
dbhelper1 db;
    @Override
    public void onReceive(Context context, Intent intent) {
        if(checkNetworkConnection(context)){

            Cursor res = db.getdata();
                while (res.moveToNext()) {
                    String name = res.getString(0);
                    String roll = res.getString(1);
                    String email = res.getString(2);
                    String course1 = res.getString(3);
                    String course2 = res.getString(4);
                    String course3 = res.getString(5);
                    String course4 = res.getString(6);
                    ad.insertData2(name, roll, email, course1, course2, course3, course4);
                }
db.deletedata();
        }
    }



    public boolean checkNetworkConnection(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
        return (networkInfo!=null && networkInfo.isConnected());
    }



}
