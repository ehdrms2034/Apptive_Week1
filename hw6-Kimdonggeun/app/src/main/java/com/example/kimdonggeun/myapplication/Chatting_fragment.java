package com.example.kimdonggeun.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kimdonggeun.myapplication.chattingroom.chattingRoomAdapter;
import com.example.kimdonggeun.myapplication.sqlite.chatroomSQLiteOpenHelper;

public class Chatting_fragment extends Fragment {

    SQLiteDatabase db;
    chatroomSQLiteOpenHelper helper;
    String tablename = "chatroom";

    public Chatting_fragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.chatting_listview,container,false);

        helper = new chatroomSQLiteOpenHelper(this.getContext(),"chatroom.db",null,1);
        db=helper.getReadableDatabase();
        chattingRoomAdapter Adapter = new chattingRoomAdapter();

        ListView listview = (ListView)root.findViewById(R.id.chat_listview);
        listview.setAdapter(Adapter);


        String SQL= "select * from " + tablename;

        Cursor c1=db.rawQuery(SQL,null);

        for(int i =0; i<c1.getCount();i++){
            c1.moveToNext();
            Adapter.additem(c1.getString(1),c1.getInt(2),c1.getString(3),c1.getString(4),c1.getInt(5));
        }

       return root;
    }
}
