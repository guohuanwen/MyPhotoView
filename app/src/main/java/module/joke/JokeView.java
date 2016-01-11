package module.joke;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bcgtgjyb.mylibrary.base.bean.Joke;
import com.bcgtgjyb.myphotoapp.R;
import com.google.gson.Gson;

import net.HttpCallBack;

import java.util.ArrayList;
import java.util.List;

import handler.JokeHandler;

/**
 * Created by bigwen on 2016/1/11.
 */
public class JokeView extends LinearLayout {
    private Context mContext;
    private String TAG = JokeView.class.getName();
    private ListView mListView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private JokeAdapter jokeAdapter;
    private List<Joke.ShowapiResBodyEntity.ContentlistEntity> list = new ArrayList<Joke.ShowapiResBodyEntity.ContentlistEntity>();
    private JokeHandler jokeHandler = new JokeHandler();
    private int nowCount = 0;
    private Handler handler;

    public JokeView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public JokeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        handler = new Handler(Looper.getMainLooper());
        LayoutInflater.from(mContext).inflate(R.layout.joke_view, this);
        mListView = (ListView) findViewById(R.id.joke_view_list);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.joke_view_refresh);
        initRefresh();
        jokeAdapter = new JokeAdapter(list);
        mListView.setAdapter(jokeAdapter);
        initListView();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                http();
            }
        },800);
    }


    //滑倒顶部
    private boolean isTop = false;
    //滑动底部
    private boolean isBottom = false;
    //是否正在加载
    private boolean isLoading = false;
    //第一次按下的点y坐标
    private float firstTouch = 0;
    //判断下滑或者上滑  下滑为 1   上滑为 2  否则为 0
    private int slideDirection = 0;


    private void initListView() {
        mListView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float y = event.getY();
                if (action == MotionEvent.ACTION_DOWN) {
                    firstTouch = y;
                } else if (action == MotionEvent.ACTION_MOVE) {
                    if (y > firstTouch) {
                        slideDirection = 1;
                    } else if (y < firstTouch) {
                        slideDirection = 2;
                    } else {
                        slideDirection = 0;
                    }
                }
                return false;
            }
        });

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //list没有滑动时
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    isTop = false;
                    isBottom = false;
                    //list显示的最后一个item是adapter最后一个资源
                    if (view.getLastVisiblePosition() == jokeAdapter.getCount() - 1) {
                        isBottom = true;
                        //没有正在加载，并且此时是上滑
                        if (!isLoading && slideDirection == 2) {
                            slideDirection = 0;
                            //处理   加载更多
                            http();
                        }
                    }
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    private void initRefresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                jokeAdapter.clearAll();
                nowCount = 0;
                http();
            }
        });
    }

    private void http() {
        nowCount++;
        AsyncTask asyncTask = new AsyncTask() {
            private Joke jokeTask = null;
            @Override
            protected Object doInBackground(Object[] params) {
                jokeHandler.httpGetJoke(nowCount, new HttpCallBack() {
                    @Override
                    public void onSuccess(String text) {
                        Log.i(TAG, "onSuccess "+text);
                        Gson gson = new Gson();
                        Joke joke = gson.fromJson(text, Joke.class);
                        jokeTask = joke;
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(mContext, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                if(swipeRefreshLayout.isRefreshing()){
                    swipeRefreshLayout.setRefreshing(false);
                }
                if (jokeTask != null) {
                    jokeAdapter.addJoke(jokeTask.getShowapi_res_body().getContentlist());
                }
            }
        };
        asyncTask.execute("");
    }


    private class JokeAdapter extends BaseAdapter {
        private List<Joke.ShowapiResBodyEntity.ContentlistEntity> jokes = new ArrayList<Joke.ShowapiResBodyEntity.ContentlistEntity>();

        public JokeAdapter(List<Joke.ShowapiResBodyEntity.ContentlistEntity> jokes) {
            this.jokes = jokes;
        }

        public void clearAll(){
            jokes.clear();
        }

        public void addJoke(List<Joke.ShowapiResBodyEntity.ContentlistEntity> list) {
            jokes.addAll(list);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return jokes.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.arraylist_item, null);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.arraylist_item_text);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.joke = jokes.get(position);
            viewHolder.textView.setText(jokes.get(position).getTitle());
            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,JokeActivity.class);
                    intent.putExtra("text",((ViewHolder)v.getTag()).joke.getText());
                    mContext.startActivity(intent);
                }
            });
            return convertView;
        }

        class ViewHolder {
            public TextView textView;
            public Joke.ShowapiResBodyEntity.ContentlistEntity joke;
        }
    }
}
