package com.bcgtgjyb.myphotoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import module.weather.WeatherView;
import com.bcgtgjyb.dialoglbrary.dialog.MyDiolag;

/**
 * Created by bigwen on 2015/12/8.
 */
public class FragmentTwo extends Fragment {
    private View view;
    private String TAG = FragmentTwo.class.getName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_two, null);
//        init();
        view = new WeatherView(getActivity(),this);
        return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(view instanceof WeatherView){
            ((WeatherView) view).update();
        }
    }
}
