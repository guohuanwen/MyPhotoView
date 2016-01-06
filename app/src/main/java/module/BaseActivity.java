package module;

import android.os.Bundle;
import android.util.Log;

import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by bigwen on 2016/1/4.
 */
public class BaseActivity extends AutoLayoutActivity {
    private String TAG = BaseActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy ");
    }
}
