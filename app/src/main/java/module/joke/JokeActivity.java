package module.joke;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bcgtgjyb.myphotoapp.R;

import net.HttpRequest;

import module.BaseActivity;

/**
 * Created by bigwen on 2016/1/11.
 */
public class JokeActivity extends BaseActivity {
    private TextView textView;
    private String TAG = JokeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);
        textView = (TextView) findViewById(R.id.joke_activity_text);
        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        if (text != null) {
            textView.setText(text);
        }

    }

    private void http(final String url) {
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                try {
                    String text = new HttpRequest().httpGet(url);
                    return text;
                } catch (Exception e) {
                    Log.e(TAG, "doInBackground " + e.toString());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                if (o instanceof String) {
                    textView.setText((String) o);
                }
            }
        };
        asyncTask.execute("");
    }
}
