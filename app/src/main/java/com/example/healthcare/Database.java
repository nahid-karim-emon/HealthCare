package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.Attributes;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super (context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1="create table users(username text,email text,password text)";
        sqLiteDatabase.execSQL (qry1);

        String qry2="create table Doctors(id text primary key,type text,name text,chember text,mobile text,fees text)";
        sqLiteDatabase.execSQL (qry2);

        String qry3="create table LabTest(type text,name text,mobile text,fees text)";
        sqLiteDatabase.execSQL (qry3);

        String qry4="create table Ambulances(name text,hospital text,mobile text)";
        sqLiteDatabase.execSQL (qry4);

        String qry5="create table HealthArticle(name text,about text)";
        sqLiteDatabase.execSQL (qry5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username,String email,String password){
        ContentValues cv=new ContentValues ();
        cv.put ("username",username);
        cv.put ("email",email);
        cv.put ("password",password);
        SQLiteDatabase db=getWritableDatabase ();
        db.insert ("users",null,cv);
        db.close ();
    }
    public void addDoctorDatabase(String id,String type,String name,String chember,String mobile,String fees){
        ContentValues cv=new ContentValues ();
        cv.put ("id",id);
        cv.put ("type",type);
        cv.put ("name",name);
        cv.put ("chember",chember);
        cv.put ("mobile",mobile);
        cv.put ("fees",fees);
        SQLiteDatabase db=getWritableDatabase ();
        db.insert ("Doctors",null,cv);
        db.close ();
    }

    public void addLabTestDatabase(String type,String name,String mobile,String fees){
        ContentValues cv=new ContentValues ();
        cv.put ("type",type);
        cv.put ("name",name);
        cv.put ("mobile",mobile);
        cv.put ("fees",fees);
        SQLiteDatabase db=getWritableDatabase ();
        db.insert ("LabTest",null,cv);
        db.close ();
    }

    public int login(String username,String password){
        int result=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db=getReadableDatabase ();
        Cursor c=db.rawQuery ("select * from users where username=? and password=?",str);
        if(c.moveToFirst ()){
            result=1;
        }
        return result;
    }

    public void addAmbulanceDatabase(String name,String hospital,String mobile){
        ContentValues cv=new ContentValues ();
        cv.put ("name",name);
        cv.put ("hospital",hospital);
        cv.put ("mobile",mobile);
        SQLiteDatabase db=getWritableDatabase ();
        db.insert ("Ambulances",null,cv);
        db.close ();
    }

    public void addHADatabase(String name,String about){
        ContentValues cv=new ContentValues ();
        cv.put("name",name);
        cv.put("about",about);
        SQLiteDatabase db=getWritableDatabase ();
        db.insert ("HealthArticle",null,cv);
        db.close();
    }
    public Boolean UpdateDoctorDatabase(String id,String type,String name,String chember,String mobile,String fees){
        ContentValues cv=new ContentValues ();
        cv.put ("id",id);
        cv.put ("type",type);
        cv.put ("name",name);
        cv.put ("chember",chember);
        cv.put ("mobile",mobile);
        cv.put ("fees",fees);
        SQLiteDatabase db=getWritableDatabase ();
        long result=db.update ("Doctors",cv,"id=?",new String[]{id});
        db.close ();
        if(result==-1)return false;
        else return true;
    }

    public ArrayList<HashMap<String, String>> fetchData(String type){
        ArrayList<HashMap<String, String>> userList=new ArrayList ();
        HashMap<String,String> item;
        String str[]=new String[1];
        str[0]=type;
        SQLiteDatabase db=getWritableDatabase ();
        Cursor cursor=db.rawQuery ("select * from Doctors where type=?",str);
        while (cursor.moveToNext ()) {
            HashMap<String, String> user = new HashMap<> ();
            user.put ("name", cursor.getString (2));
            user.put ("chember", cursor.getString (3));
            user.put ("mobile", cursor.getString (4));
            user.put ("fees", cursor.getString (5));
            userList.add (user);
        }
        return userList;
    }
    public ArrayList<HashMap<String, String>> fetchDataLT(String type){
        ArrayList<HashMap<String, String>> userList=new ArrayList ();
        HashMap<String,String> item;
        String str[]=new String[1];
        str[0]=type;
        SQLiteDatabase db=getWritableDatabase ();
        Cursor cursor=db.rawQuery ("select * from LabTest where type=?",str);
        while (cursor.moveToNext ()) {
            HashMap<String, String> user = new HashMap<> ();
            user.put ("name", cursor.getString (1));
            user.put ("type", cursor.getString (0));
            user.put ("mobile", cursor.getString (2));
            user.put ("fees", cursor.getString (3));
            userList.add (user);
        }
        return userList;
    }
    public ArrayList<HashMap<String, String>> fetchAmbulance(){
        ArrayList<HashMap<String, String>> userList=new ArrayList ();
        HashMap<String,String> item;
        SQLiteDatabase db=getWritableDatabase ();
        Cursor cursor=db.rawQuery ("select * from Ambulances",null);
        while (cursor.moveToNext ()) {
            HashMap<String, String> user = new HashMap<> ();
            user.put ("name", cursor.getString (0));
            user.put ("hospital", cursor.getString (1));
            user.put ("mobile", cursor.getString (2));
            userList.add (user);
        }
        return userList;
    }

    public ArrayList<HashMap<String, String>> fetchHealthArticle(){
        ArrayList<HashMap<String, String>> userList=new ArrayList ();
        HashMap<String,String> item;
        SQLiteDatabase db=getWritableDatabase ();
        Cursor cursor=db.rawQuery ("select * from HealthArticle",null);
        while (cursor.moveToNext ()) {
            HashMap<String, String> user = new HashMap<> ();
            user.put ("name", cursor.getString (0));
            user.put ("about", cursor.getString (1));
            userList.add (user);
        }
        return userList;
    }
}

