package com.example.kimdonggeun.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Kim Dong Geun on 2018-04-28.
 */

public class Menupageadapter extends FragmentPagerAdapter {
    private int tapCount;


    public Menupageadapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                return new Friends_List_fragement();
            case 1:
                return new Chatting_fragment();
            case 2:
                return new Friends_List_fragement();
            case 3:
                return new Friends_List_fragement();
            default:
                return null;
        }

    }
    @Override
    public int getCount(){
        return 4;
    }
}
