package com.bcgtgjyb;

import android.test.ActivityInstrumentationTestCase2;

import com.bcgtgjyb.myphotoapp.MainActivity;
import com.bcgtgjyb.myphotoapp.R;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
/*
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
* */

/**
 * Created by bigwen on 2016/1/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    @Test
    public void testFragmentOne(){
        onView(withId(R.id.custom_1)).perform(click());
        onView(withId(R.id.custom_2)).perform(click());
        onView(withId(R.id.custom_3)).perform(click());
        onView(withId(R.id.viewpager)).perform();
        onView(withId(R.id.photo_list_item_imageview)).perform(click());
        onView(withId(R.id.photo_list_item_text1)).perform(click());
//        onData()
    }


}
