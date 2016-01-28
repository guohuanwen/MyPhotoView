package com.bcgtgjyb.myphotoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.kogitune.activity_transition.ActivityTransition;

public class PhotoActivity extends FragmentActivity {
    private PhotoView imageView;
//    private ExitActivityTransition exitActivityTransition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        imageView=(PhotoView)findViewById(R.id.image);
        imageView.enable();
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        Glide.with(this).load(url).into(imageView);
        ActivityTransition.with(intent).to(imageView).start(savedInstanceState);

//        exitActivityTransition=ActivityTransition.with(intent).to(imageView).start(savedInstanceState);

    }

//    @Override
//    public void onBackPressed() {
//        exitActivityTransition.exit(this);
//    }
}
