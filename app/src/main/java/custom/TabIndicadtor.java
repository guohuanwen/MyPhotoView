package custom;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bcgtgjyb.myphotoapp.R;

/**
 * Created by bigwen on 2015/12/8.
 */
public class TabIndicadtor extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private ViewPager viewPager;

    public TabIndicadtor(Context context) {
        super(context);
        mContext = context;
        init();
    }


    public TabIndicadtor(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.custom_tab_indicadtor, this);
        textView1 = (TextView) findViewById(R.id.custom_1);
        textView2 = (TextView) findViewById(R.id.custom_2);
        textView3 = (TextView) findViewById(R.id.custom_3);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
    }

    public void setSelect(int position) {
        textView1.setTextColor(Color.BLACK);
        textView2.setTextColor(Color.BLACK);
        textView3.setTextColor(Color.BLACK);
        switch (position) {
            case 0:
                textView1.setTextColor(Color.WHITE);
                break;
            case 1:
                textView2.setTextColor(Color.WHITE);
                break;
            case 2:
                textView3.setTextColor(Color.WHITE);
                break;
        }
    }

    public void setText(String[] text) {
        if (text.length >= 3) {
            textView1.setText(text[0]);
            textView2.setText(text[1]);
            textView3.setText(text[2]);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.custom_1:
                if (viewPager != null) {
                    viewPager.setCurrentItem(0);
                }
                break;
            case R.id.custom_2:
                if (viewPager != null) {
                    viewPager.setCurrentItem(1);
                }
                break;
            case R.id.custom_3:
                if (viewPager != null) {
                    viewPager.setCurrentItem(2);
                }
                break;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }




}
