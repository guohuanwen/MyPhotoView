package tool.Share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialConstants;
import com.tencent.tauth.Tencent;

import tool.MyApplication;


/**
 * Created by bigwen on 2016/1/14.
 */
public class Share {
    private String TAG = Share.class.getName();
    private Tencent mTencent;

    private static Share share;

    public static Share getInstance(){
        if(share==null){
            share = new Share();
        }
        return share;
    }

    private Share( ) {
        initTencent();
    }

    private void initTencent() {
        mTencent = Tencent.createInstance("tencent1105112528", MyApplication.getContext());
    }

    public void shareToQQ(Context context) {
            if (mTencent.isSessionValid() && mTencent.getOpenId() != null) {
                Bundle params = new Bundle();
                params.putString(SocialConstants.PARAM_TITLE,
                        "AndroidSdk_1_3:UiStory title");
                params.putString(SocialConstants.PARAM_COMMENT,
                        "AndroidSdk_1_3: UiStory comment");
                params.putString(SocialConstants.PARAM_IMAGE,
                        "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");
                params.putString(SocialConstants.PARAM_SUMMARY,
                        "AndroidSdk_1_3: UiStory summary");
                params.putString(
                        SocialConstants.PARAM_PLAY_URL,
                        "http://player.youku.com/player.php/Type/Folder/"
                                + "Fid/15442464/Ob/1/Pt/0/sid/XMzA0NDM2NTUy/v.swf");
//                mTencent.story((Activity)context, params, new BaseUiListener());
            }
    }

    public void shareToQzone (Context context) {
        Log.i(TAG, "shareToQzone ");
//分享类型
        Bundle params = new Bundle();
        int shareType = QzonePublish.PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD;
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, shareType);
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, "集合Alpha");//必填
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "笑话");//选填
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, "http://www.wandoujia.com/apps/com.example.learn");//必填
//        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, "");
        mTencent.shareToQzone((Activity)context, params, new BaseUIListener(context));
    }





}
