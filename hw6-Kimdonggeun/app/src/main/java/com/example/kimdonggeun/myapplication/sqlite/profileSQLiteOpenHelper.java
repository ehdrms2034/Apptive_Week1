package com.example.kimdonggeun.myapplication.sqlite;


import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.kimdonggeun.myapplication.R;

import static android.content.ContentValues.TAG;

public class profileSQLiteOpenHelper extends SQLiteOpenHelper{

    String TABLE_NAME;

    public profileSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    public profileSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TABLE_NAME = "kakaoprofile";

        int img_src1= R.drawable.man;
        int img_src2= R.drawable.user;

        //데이터 삭제 후
        try{
            String DROP_SQL = "drop table if exists "+TABLE_NAME;
            db.execSQL(DROP_SQL);
       }catch(Exception e){
           Log.e(TAG,"Exception in DROP_sql",e);
       }

        String CREATE_SQL="create table "+TABLE_NAME+" ("
                +"id integer PRIMARY KEY autoincrement, "
                +"name text, "
                +"img_src integer, "
                +"balloon text)";

        //데이터 생성
        try{
            db.execSQL(CREATE_SQL);
        }catch (Exception e){
            Log.e(TAG,"Exception in CREATE_sql",e);
        }

        try{
            for(int i =0; i<=10;i++){
                db.execSQL("insert into "+TABLE_NAME+"(name, img_src, balloon) values ('김동근','"+R.drawable.man+"','안녕하세요')");
                db.execSQL("insert into "+TABLE_NAME+"(name, img_src, balloon) values ('김당근','"+R.drawable.user+"','하이요')");
            }
        }
        catch(Exception e){
                Log.e(TAG,"Exception in insert_sql",e); }





    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}