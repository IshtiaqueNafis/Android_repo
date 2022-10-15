package com.example.database_guide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("Create Table UserDetails(name TEXT primary key,contact TEXT,dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists UserDetails");
    }

    public Boolean insertUserData(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        long results = DB.insert("UserDetails", null, contentValues);

        return results != -1;

    }

    public Boolean updateUserData(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = DB.rawQuery("SELECT * FROM UserDetails where name=?",new String[]{name});
        if(cursor.getCount()>0){
            long results = DB.update("UserDetails",  contentValues,"name=?",new String[]{name});

            return results != -1;
        }else {
            return false;
        }


    }


    public Boolean deleteUserData(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        Cursor cursor = DB.rawQuery("SELECT * FROM UserDetails where name=?",new String[]{name});
        if(cursor.getCount()>0){
            long results = DB.delete("UserDetails","name=?",new String[]{name});

            return results != -1;
        }else {
            return false;
        }


    }


    public Cursor getData() {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("SELECT * FROM UserDetails",null);



    }
}
