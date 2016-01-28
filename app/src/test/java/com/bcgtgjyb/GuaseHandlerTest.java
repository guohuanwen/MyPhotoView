//package com.bcgtgjyb;
//
//import com.bcgtgjyb.myphotoapp.BuildConfig;
//import com.bcgtgjyb.myphotoapp.MainActivity;
//import com.google.gson.Gson;
//
//import net.HttpCallBack;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.robolectric.Robolectric;
//import org.robolectric.RobolectricGradleTestRunner;
//import org.robolectric.annotation.Config;
//
//import handler.GuaseHandler;
//import module.guase.GuaseActivity;
//
///**
// * Created by bigwen on 2016/1/28.
// */
//
//@RunWith(RobolectricGradleTestRunner.class)
//@Config(constants =  BuildConfig.class,emulateSdk = 23)
//public class GuaseHandlerTest {
//    private GuaseHandler guaseHandler;
//    private MainActivity activity;
//
//    @Before
//    public void setUp() throws Exception{
//        activity = Robolectric.setupActivity(MainActivity.class);
//        guaseHandler = GuaseHandler.getInstence();
//    }
//
//    @Test
//    public void testHttp() throws Exception{
//        guaseHandler.httpGetJoke(new HttpCallBack() {
//            @Override
//            public void onSuccess(String text) {
//                Gson gson = new Gson();
//                GuaseActivity.Bean bean = gson.fromJson(text, GuaseActivity.Bean.class);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                throw new RuntimeException(e.toString());
//            }
//        });
//    }
//
//    @Test
//    public void testSave() throws Exception{
//
//    }
//}
