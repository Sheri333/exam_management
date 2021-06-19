package com.projectregistration.registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper1 extends SQLiteOpenHelper {
    public dbhelper1( Context context) {
        super(context, "Userdatas.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetailst(name TEXT primary key,roll TEXT,email TEXT, course1 TEXT, course2 TEXT, course3 TEXT, course4 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop Table if exists Userdetailst");
    }
    public Boolean inseruserdata(String name,String roll,String email,String course1,String course2,String course3,String course4){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("roll",roll);
        contentValues.put("email",email);
        contentValues.put("course1",course1);
        contentValues.put("course2",course2);
        contentValues.put("course3",course3);
        contentValues.put("course4",course4);
    long result = db.insert("Userdetailst",null,contentValues);
    if(result==-1){
        return false;
    }
    else{
        return true;
    }
    }

    public  void deletedata(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Userdetailst",null,null);
        db.close();
    }


    public Cursor getdata(){
SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery("Select * from Userdetailst",null);
return cursor;
    }
}
