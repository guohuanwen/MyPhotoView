package module.guase;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bcgtgjyb.myphotoapp.R;
import com.google.gson.Gson;

import net.HttpCallBack;

import handler.GuaseHandler;
import module.BaseActivity;
import tool.ScreenUtil;

/**
 * Created by bigwen on 2016/1/26.
 */
public class GuaseActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = GuaseActivity.class.getName();
    private TextView titleView;
    private TextView answerView;
    private TextView nextView;
    private GuaseHandler guaseHandler;
    private Handler handler;
    private String SHOWANSWER = "点击查看答案";
    private Bean bean;
    private boolean isLoading = false;
    private LinearLayout head;
    private LinearLayout.MarginLayoutParams headerMargin;
    private int max;
    private boolean siding = false;
    private boolean isMax = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guase);
        titleView = (TextView) findViewById(R.id.activity_guase_title);
        answerView = (TextView) findViewById(R.id.activity_guase_answer);
        nextView = (TextView) findViewById(R.id.activity_guase_next);
        head = (LinearLayout) findViewById(R.id.activity_guase_refresh);
        answerView.setOnClickListener(this);
        nextView.setOnClickListener(this);
        handler = new Handler();
        guaseHandler = GuaseHandler.getInstence();
        headerMargin = (LinearLayout.MarginLayoutParams) head.getLayoutParams();
        max = ScreenUtil.dip2px(this, 50);
        httpRequest();
    }

    private void httpRequest() {
        isLoading = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                request();
            }
        }).start();
    }

    private void request() {
        guaseHandler.httpGetJoke(new HttpCallBack() {
            @Override
            public void onSuccess(String text) {
                try {
                    Log.i(TAG, "onSuccess " + text);
                    Gson gson = new Gson();
                    Bean bean = gson.fromJson(text, Bean.class);
                    showGuase(bean);
                } catch (Exception e) {
                    Log.e(TAG, "onSuccess " + e.toString());
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }


    public void showGuase(final Bean b) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                bean = b;
                titleView.setText(b.getTitle());
                answerView.setText(SHOWANSWER);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_guase_answer:
                if (bean != null && SHOWANSWER.equals(answerView.getText())) {
                    answerView.setText(bean.getAnswer());

                } else {
                    answerView.setText(SHOWANSWER);
                }
                break;
            case R.id.activity_guase_next:
                httpRequest();
                break;
        }

    }

    private int downY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = y - downY;
                Log.i(TAG, "onTouchEvent " + moveY);
                if (moveY > max) {
                    moveY = max;
                    isMax = true;
                }
                if (moveY > 0) {
                    siding = true;
                    headerMargin.topMargin = -max + moveY;
                    head.setLayoutParams(headerMargin);
                }
                break;
            case MotionEvent.ACTION_UP:

                if (siding == false) {
                    break;
                }
                int mY = y - downY;
                if (mY > max) {
                    mY = max;
                }
                freshView(mY);
                if (isMax) {
                    httpRequest();
                    isMax = false;
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private ValueAnimator valueAnimator = null;

    private void freshView(int y) {
        siding = false;
        valueAnimator = getValueAnimation(y);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (valueAnimator == null) {
                    return;
                }
                if (valueAnimator.isRunning()) {
                    headerMargin.topMargin = (int) valueAnimator.getAnimatedValue();
                    head.setLayoutParams(headerMargin);
                } else {

                }
                handler.postDelayed(this, 16);
            }
        }, 16);
    }

    private ValueAnimator getValueAnimation(int y) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(-max + y, -max);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.setDuration(200);
        valueAnimator.start();
        return valueAnimator;
    }

    public class Bean {

        /**
         * Answer : 少砸不了
         * Title : 玻璃店搬家
         * id : 24654
         */

        private String Answer;
        private String Title;
        private String id;

        public void setAnswer(String Answer) {
            this.Answer = Answer;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAnswer() {
            return Answer;
        }

        public String getTitle() {
            return Title;
        }

        public String getId() {
            return id;
        }
    }
}
