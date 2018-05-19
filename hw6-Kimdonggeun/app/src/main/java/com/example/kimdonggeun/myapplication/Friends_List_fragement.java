package com.example.kimdonggeun.myapplication;

import com.example.kimdonggeun.myapplication.sqlite.*;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.ContentValues.TAG;

/**
 * Created by Kim Dong Geun on 2018-04-27.
 */

public class Friends_List_fragement extends ListFragment {
        SQLiteDatabase db;
        profileSQLiteOpenHelper helper;

    public Friends_List_fragement(){
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        String tablename = "kakaoprofile";

        helper = new profileSQLiteOpenHelper(this.getContext(),"profile.db",null,1);
        db=helper.getReadableDatabase();

               // Log.e(TAG,"이까진옴");
                String SQL= "select * from " + tablename;

                Cursor c1=db.rawQuery(SQL,null);

                Profile_Adpater adapter = new Profile_Adpater();
                setListAdapter(adapter);
//                Log.e(TAG,c1.getString(0));
                for(int i=0;i<c1.getCount();i++){
                    c1.moveToNext();
                    String name=c1.getString(1);
                    int img_src=c1.getInt(2);
                    String balloon=c1.getString(3);
                    adapter.additem(name, img_src,balloon);

                }
                c1.close();

            return super.onCreateView(inflater,container,savedInstanceState);

        }



    }


