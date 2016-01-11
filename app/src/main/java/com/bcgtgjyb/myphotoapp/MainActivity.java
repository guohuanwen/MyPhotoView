package com.bcgtgjyb.myphotoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;
import java.util.List;

import custom.TabIndicadtor;

public class MainActivity extends FragmentActivity {
    private String TAG = MainActivity.class.getName();
    private Toolbar toolbar;
    private AccountHeader headerResult = null;
    private ViewPager mViewPager;
    private TabIndicadtor tabIndicadtor;
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toorBar);
        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        tabIndicadtor=(TabIndicadtor)findViewById(R.id.tabIndicadtor);
        myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager());
        initDrawer();
        initPager();

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintResource(R.color.colorPrimaryDrak);
        tintManager.setStatusBarTintEnabled(true);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setFitsSystemWindows(true);
        toolbar.setTitle(R.string.app_name);
    }

    private void initPager() {
        myPagerAdapter.addFragment(new FragmentOne());
        myPagerAdapter.addFragment(new FragmentTwo());
        myPagerAdapter.addFragment(new FragmentThree());
        mViewPager.setAdapter(myPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);
        tabIndicadtor.setSelect(0);
        tabIndicadtor.setText(new String[]{"图片","天气","笑话"});
        tabIndicadtor.setViewPager(mViewPager);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabIndicadtor.setSelect(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    private void initDrawer() {
        new DrawerBuilder().withActivity(this).build();
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.home)
                .build();
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName("R.string.drawer_item_home");

        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withName("R.string.drawer_item_settings");

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("R.string.drawer_item_settings")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        return false;
                    }
                })
                .build();

        //set the selection to the item with the identifier 1
        result.setSelection(1);
//set the selection to the item with the identifier 2
        result.setSelection(item2);
//set the selection and also fire the `onItemClick`-listener
        result.setSelection(1, true);

        new SecondaryDrawerItem().withName("R.string.drawer_item_dialog").withSelectable(false);
//        //modify an item of the drawer
//        item1.withName("A new name for this drawerItem").withBadge("19").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_red_700));
////notify the drawer about the updated element. it will take care about everything else
//        result.updateItem(item1);
//
////to update only the name, badge, icon you can also use one of the quick methods
//        result.updateName(1, "A new name");
//
////the result object also allows you to add new items, remove items, add footer, sticky footer, ..
//        result.addItem(new DividerDrawerItem());
//        result.addStickyFooterItem(new PrimaryDrawerItem().withName("StickyFooterItem"));
//
////remove items with an identifier
//        result.removeItem(2);
//
////open / close the drawer
//        result.openDrawer();
//        result.closeDrawer();
//
////get the reference to the `DrawerLayout` itself
//        result.getDrawerLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter{
        private List<Fragment> arrayList=new ArrayList<Fragment>();
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment){
            arrayList.add(fragment);
            notifyDataSetChanged();
        }

        @Override
        public Fragment getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i(TAG, "onKeyDown ");
        return super.onKeyDown(keyCode, event);

    }
}
