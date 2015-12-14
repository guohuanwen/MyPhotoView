package com.bcgtgjyb.myphotoapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bigwen on 2015/12/10.
 */
public class FragmentBace extends Fragment{
    private String TAG=FragmentBace.class.getName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach ");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView ");
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated ");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause ");
        
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop ");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy ");
    }


}
