package tool.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by bigwen on 2016/1/6.
 */
public class OpenPhoneWebView {
    public static void open(String url,Context context){
        Uri uri = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        context.startActivity(i);
    }
}
