package tool.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

import com.bcgtgjyb.myphotoapp.R;

/**
 * Created by bigwen on 2016/1/6.
 */
public class WebActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);
        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");
        Uri uri = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
//        webView = (WebView) findViewById(R.id.web_activity_view);
//        webView.loadUrl(url);
//        webView.setWebViewClient(new WebViewClient(){
//
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
//
//                //调用系统浏览器
//                Uri uri = Uri.parse(url);
//                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//                startActivity(intent);
//                return false;
////                view.loadUrl(url);
////                return false;
//            }
//        });
    }
}
