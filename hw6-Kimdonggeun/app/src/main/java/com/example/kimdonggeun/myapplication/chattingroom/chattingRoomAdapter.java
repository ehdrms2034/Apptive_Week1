package com.example.kimdonggeun.myapplication.chattingroom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kimdonggeun.myapplication.Profile;
import com.example.kimdonggeun.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class chattingRoomAdapter extends BaseAdapter {

    private ArrayList<chattingroom> items=new ArrayList<chattingroom>();

    public chattingRoomAdapter() {
    }


    @Override
    public int getCount(){return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos=position;
        final Context context=parent.getContext();

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.chatroom_item,parent,false);
        }

        chattingroom chatroom = items.get(position);


        ImageView chatroom_img = (ImageView) convertView.findViewById(R.id.chatroom_img);
        TextView chatroom_name = (TextView)convertView.findViewById(R.id.chat_per_name);
        TextView chatroom_text = (TextView)convertView.findViewById(R.id.chat_last_text);
        TextView chatroom_date = (TextView)convertView.findViewById(R.id.chatroom_date);
        TextView chatroom_bal = (TextView)convertView.findViewById(R.id.chat_room_balance);


        chatroom_img.setImageResource(chatroom.getImg_src());
        chatroom_name.setText(chatroom.getName());
        chatroom_text.setText(chatroom.getText());
        chatroom_date.setText(chatroom.getDate());
        chatroom_bal.setText(Integer.toString(chatroom.getBalance()));

        return convertView;


    }

    public void additem(String name,int img_name,String text,String date,int bal){
        chattingroom chatroom= new chattingroom(img_name,name,text,date,bal);
        items.add(chatroom);
    }

}
