package module.guase;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bcgtgjyb.myphotoapp.R;
import com.google.gson.Gson;

import net.HttpCallBack;

import handler.GuaseHandler;
import module.BaseActivity;

/**
 * Created by bigwen on 2016/1/26.
 */
public class GuaseActivity extends BaseActivity implements View.OnClickListener{
    private String TAG = GuaseActivity.class.getName();
    private TextView titleView;
    private TextView answerView;
    private TextView nextView;
    private GuaseHandler guaseHandler;
    private Handler handler;
    private String SHOWANSWER = "点击查看答案";
    private Bean bean;
    private boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guase);
        titleView = (TextView)findViewById(R.id.activity_guase_title);
        answerView = (TextView)findViewById(R.id.activity_guase_answer);
        nextView = (TextView)findViewById(R.id.activity_guase_next);
        answerView.setOnClickListener(this);
        nextView.setOnClickListener(this);
        handler = new Handler();
        guaseHandler = GuaseHandler.getInstence();
        httpRequest();
    }

    private void httpRequest(){
        isLoading = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                request();
            }
        }).start();
    }

    private void request(){
        guaseHandler.httpGetJoke(new HttpCallBack() {
            @Override
            public void onSuccess(String text) {
                try{
                    Log.i(TAG, "onSuccess " + text);
                    Gson gson = new Gson();
                    Bean bean = gson.fromJson(text, Bean.class);
                    showGuase(bean);
                }catch (Exception e){
                    Log.e(TAG, "onSuccess "+e.toString());
                }
            }
            @Override
            public void onError(Exception e) {

            }
        });
    }



    public void showGuase(final Bean b){
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
        switch (v.getId()){
            case R.id.activity_guase_answer:
                if(bean!=null&&SHOWANSWER.equals(answerView.getText())){
                   answerView.setText(bean.getAnswer());
                }else {
                    answerView.setText(SHOWANSWER);
                }
                break;
            case R.id.activity_guase_next:
                httpRequest();
                break;
        }

    }

    public class Bean{

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
