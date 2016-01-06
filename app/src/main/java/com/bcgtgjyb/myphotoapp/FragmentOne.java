package com.bcgtgjyb.myphotoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bcgtgjyb.mylibrary.base.BaseModel;
import com.bcgtgjyb.mylibrary.base.MyDataBase;
import com.bcgtgjyb.mylibrary.base.bean.AndroidData;
import com.bcgtgjyb.mylibrary.base.bean.MeiZi;
import com.bumptech.glide.Glide;
import com.kogitune.activity_transition.ActivityTransitionLauncher;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import handler.AndroidDataHandle;
import handler.MeiZiHandler;
import tool.MyApplication;
import tool.webview.OpenPhoneWebView;

/**
 * Created by bigwen on 2015/12/8.
 */
public class FragmentOne extends FragmentBace {
    private boolean init = false;
    private Context mContext;
    private String TAG = FragmentOne.class.getName();
    private View view;
    private ListView mListView;
    private MeiZiHandler meiZiHandlerl = new MeiZiHandler();
    private AndroidDataHandle androidDataHandle = new AndroidDataHandle();
    //第几页数据
    private int count = 1;
    private boolean isTop = false;
    private boolean isBottom = false;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private PhotoListAdapter mPhotoListAdapter;
    private boolean isLoading = false;
    private GestureDetector mGestureDetector;
    //1为下滑，2为上滑，0为默认
    private int listViewSlideToTop = 0;
    private Handler handler = new Handler(Looper.getMainLooper());
    private LayoutInflater inflater;
    //是否有网络
    private boolean inNet = MyApplication.inNet;
    //网络的数据是否更新
    private boolean netDataChange = true;
    private float firstDown = 0;
    private String firstDesc = "";
    private MyDataBase myDataBase;
    private MeiZi.ResultsEntity meiResultsEntity = new MeiZi.ResultsEntity();
    private AndroidData.ResultsEntity andResultsEntity = new AndroidData.ResultsEntity();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ont, null);
        init();
        initRefresh();
        initListView();

        initAutoRefresh();
        return view;
    }

    private void initAutoRefresh() {
        if(inNet){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isBottom=true;
                    nextURLList(1);
                    isBottom=false;
                    mSwipeRefreshLayout.setRefreshing(true);
                }
            },500);
        }else {
            loadDBList(1);
        }
    }


    private void initNetDataChange(String param) {
//        AndroidDB androidDB = AndroidDB.getInstence(mContext);
//        netDataChange = androidDB.isAndroidDescDBFirst(param);
        Log.i(TAG, "initNetDataChange " + netDataChange);
    }


    private void initListView() {
        mPhotoListAdapter = new PhotoListAdapter(getActivity());
        mListView.setAdapter(mPhotoListAdapter);

        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float y = event.getY();
                if (action == MotionEvent.ACTION_DOWN) {
                    firstDown = y;
                } else if (action == MotionEvent.ACTION_MOVE) {
                    if (y > firstDown) {
                        listViewSlideToTop = 1;
                    } else if (y < firstDown) {
                        listViewSlideToTop = 2;
                    } else {
                        listViewSlideToTop = 0;
                    }
                } else if (action == MotionEvent.ACTION_UP) {

                }
                return false;
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.i(TAG, "onScrollStateChanged ");
                if (scrollState != AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
//                    Glide.with(mContext).pauseRequests();
                }
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
//                    Glide.with(mContext).resumeRequests();
                    isTop = false;
                    isBottom = false;
                    if (view.getLastVisiblePosition() == mPhotoListAdapter.getCount() - 1) {
                        isBottom = true;
                        Log.i(TAG, "onScrollStateChanged 滑倒底部" + (count + 1));
                        if (!isLoading && listViewSlideToTop == 2) {

                            listViewSlideToTop = 0;
                            if (inNet) {
                                nextURLList(count + 1);
                            } else {
                                loadDBList(count + 1);
                            }
                        }
                    }
                    if (view.getFirstVisiblePosition() == 0 && listViewSlideToTop == 1) {
                        Log.i(TAG, "onScrollStateChanged 滑倒顶部" + (count - 1));
                        isTop = true;
                        if (!isLoading) {
                            if (count - 1 >= 1) {
                                listViewSlideToTop = 0;
//                                nextURLList(count - 1);
                            }
                        }
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.i(TAG, "onScroll ");
            }
        });


    }


    private void init() {
        mContext = getActivity();
        inflater = LayoutInflater.from(mContext);
        mListView = (ListView) view.findViewById(R.id.fragment_one_list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_one_refresh);

    }


    /**
     * 下拉刷新
     */
    private void initRefresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.i(TAG, "onRefresh ");
                if (inNet) {
                    ((PhotoListAdapter) mListView.getAdapter()).deleteAll();
                    isBottom = true;
                    nextURLList(1);
                    isBottom = false;
                } else {
                    //无网络连接

                }
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private boolean dataInDB = false;

    private boolean loadDBList(final int count) {
        Log.i(TAG, "loadDBList ");
        this.count = count;
        dataInDB = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyDataBase myDataBase = MyDataBase.getInstence(MyApplication.getContext());
                final List<BaseModel> meizi = myDataBase.loadFromDB("select * from " + meiResultsEntity.getTableName() +" where count = ?",
                        new String[]{count + ""}, meiResultsEntity);

                final List<BaseModel> android = myDataBase.loadFromDB("select * from " + andResultsEntity.getTableName() +" where count = ?",
                        new String[]{count + ""}, andResultsEntity);

                if (meizi.size() > 0 && android.size() > 0) {
                    dataInDB = true;
                }
                final List<String> url = new ArrayList<String>();
                for(BaseModel baseModel:meizi){
                    if(baseModel instanceof MeiZi.ResultsEntity){
                        url.add(((MeiZi.ResultsEntity) baseModel).getUrl());
                    }
                }
                final List<AndroidData.ResultsEntity> androidEntity = new ArrayList<AndroidData.ResultsEntity>();
                for(BaseModel baseModel:android){
                    if(baseModel instanceof AndroidData.ResultsEntity){
                        androidEntity.add((AndroidData.ResultsEntity)baseModel);
                    }
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPhotoListAdapter.addBottomItem(url);
                        mPhotoListAdapter.addBottomItemAndroid(androidEntity);
                    }
                });
            }
        }).start();

        return dataInDB;
    }

    //加载list下一个URL
    private void nextURLList(int count) {
        Log.i(TAG, "nextURLList ");
        isLoading = true;
        this.count = count;
        //有网络数据与本地不同
        if (inNet) {
            httpRequest(count);
        }
        //网络数据与本地一样
        else {
            loadDBList(count);

        }


    }

    private void httpRequest(final int count) {
        Log.i(TAG, "httpRequest ");
        final boolean bottom = isBottom;
        meiZiHandlerl.requestUrl(count, new MeiZiHandler.UpdateUI() {
            @Override
            public void updateList(List<String> list) {
                if (bottom) {
                    ((PhotoListAdapter) mListView.getAdapter()).addBottomItem(list);
                }
                mSwipeRefreshLayout.setRefreshing(false);

            }
        });
        androidDataHandle.requestUrl(count, new AndroidDataHandle.UpdateUI() {
            @Override
            public void updateList(List<AndroidData.ResultsEntity> url) {
                //底部加载更多
                if (bottom) {
                    ((PhotoListAdapter) mListView.getAdapter()).addBottomItemAndroid(url);
                }
                mSwipeRefreshLayout.setRefreshing(false);
                if (count == 1) {
                    firstDesc = url.get(0).getUrl();
                    initNetDataChange(firstDesc);
                }
            }
        });
        isLoading = false;
    }


    private class PhotoListAdapter extends BaseAdapter implements View.OnClickListener{
        private List<AndroidData.ResultsEntity> androidData = new ArrayList<AndroidData.ResultsEntity>();
        private List<String> URL = new ArrayList<String>();
        private Context mContext;

        public PhotoListAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return URL.size();
        }

        @Override
        public Object getItem(int position) {
            return URL.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         * 添加Url到顶部
         *
         * @param list
         */
//        public void addTopItem(List<String> list) {
//            Log.i(TAG, "addBottomItem " + URL.size());
//            arrayDeque.addFirst(list);
//            URL.addAll(0, arrayDeque.getFirst());
//            while (arrayDeque.size() > 2) {
//                URL.removeAll(arrayDeque.getLast());
//                arrayDeque.removeLast();
//            }
//            notifyDataSetChanged();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    mListView.smoothScrollToPosition(10, 300);
//                }
//            }, 1000);
//
//
//        }

        /**
         * 添加Url到底部
         *
         * @param list
         */
        public void addBottomItem(List<String> list) {
            Log.i(TAG, "addBottomItem " + list.size());
            URL.addAll(URL.size(), list);
            notifyDataSetChanged();
        }

        public void addBottomItemAndroid(List<AndroidData.ResultsEntity> android) {
            Log.i(TAG, "addBottomItemAndroid " + android.size());
            androidData.addAll(androidData.size(), android);
            notifyDataSetChanged();
        }

        public void deleteAll() {
            Log.i(TAG, "deleteAll " + URL.size());
            URL = null;
            URL = new ArrayList<String>();
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            WeakReference weakReference;
            if (convertView == null) {
                weakReference = new WeakReference(new ViewHolder());
                convertView = inflater.inflate(R.layout.photo_list_item, null);
                ((ViewHolder) weakReference.get()).imageView = (ImageView) convertView.findViewById(R.id.photo_list_item_imageview);
                ((ViewHolder) weakReference.get()).textView1 = (TextView) convertView.findViewById(R.id.photo_list_item_text1);
                convertView.setTag(weakReference.get());
                ((ViewHolder) weakReference.get()).imageView.setOnClickListener(this);
                ((ViewHolder) weakReference.get()).textView1.setOnClickListener(this);
                ((ViewHolder) weakReference.get()).imageView.setTag(R.id.glide_tag_id,URL.get(position));
            } else {
                weakReference = new WeakReference((ViewHolder) convertView.getTag());
                ((ViewHolder) weakReference.get()).imageView.setTag(R.id.glide_tag_id,URL.get(position));
            }
            if (URL.size() > position) {
                Glide.with(mContext).load(URL.get(position))
                        .placeholder(R.drawable.replace)
                        .crossFade()
                        .into(((ViewHolder) weakReference.get()).imageView);
            }
            if (androidData.size() > position) {
                ((ViewHolder) weakReference.get()).textView1.setText(androidData.get(position).getDesc());
                ((ViewHolder) weakReference.get()).textView1.setTag(androidData.get(position));
            }
            return convertView;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.photo_list_item_imageview:
                    Intent intent=new Intent(getActivity(),PhotoActivity.class);
                    intent.putExtra("url",(String)v.getTag(R.id.glide_tag_id));
                    ActivityTransitionLauncher.with(getActivity()).from(v).launch(intent);
                    break;
                case R.id.photo_list_item_text1:
                    OpenPhoneWebView.open(((AndroidData.ResultsEntity)v.getTag()).getUrl(),getActivity());
                    break;
            }
        }

        public final class ViewHolder {
            public ImageView imageView;
            public TextView textView1;
        }
    }


}
