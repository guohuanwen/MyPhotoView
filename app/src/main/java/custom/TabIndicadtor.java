package custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.bcgtgjyb.myphotoapp.R;

/**
 * Created by bigwen on 2015/12/8.
 */
public class TabIndicadtor extends LinearLayout {
    private Context mContext;
    public TabIndicadtor(Context context) {
        super(context);
        mContext=context;
        init();
    }


    public TabIndicadtor(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.custom_tab_indicadtor,this);
    }


}
