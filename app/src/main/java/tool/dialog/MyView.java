package tool.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bcgtgjyb.myphotoapp.R;

/**
 * Created by bigwen on 2016/1/5.
 */
public class MyView extends LinearLayout {
    private String TAG = MyView.class.getName();
    private KeyBack keyBack;
    private Context mContext;
    private View view;
    private TextView title;
    private TextView text;
    private TextView defaultBt;
    private TextView button_1;
    private TextView button_2;
    private LinearLayout linearLayout;
    private OnClickListener onClickListener;
    private String [] params ;
    public MyView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }
    public MyView(Context context ,String[] params, OnClickListener onClickListener){
        this(context);
        this.params = params;
        this.onClickListener = onClickListener;
    }

    private void init() {
        view = LayoutInflater.from(mContext).inflate(R.layout.dialog_simple, this);
        title = (TextView) view.findViewById(R.id.dialog_simple_title);
        text = (TextView) view.findViewById(R.id.dialog_simple_text);
        defaultBt = (TextView) view.findViewById(R.id.dialog_simple_button_default);
        button_1 = (TextView) view.findViewById(R.id.dialog_simple_button_enter);
        button_2 = (TextView) view.findViewById(R.id.dialog_simple_button_cancel);
        linearLayout = (LinearLayout)view.findViewById(R.id.dialog_simple_view);
    }

    public void initButton(String[] params) {
        if(params==null){
            defaultBt.setVisibility(View.GONE);
            button_1.setVisibility(View.GONE);
            button_2.setVisibility(View.GONE);
        }
        switch (params.length) {
            case 0:
                defaultBt.setVisibility(View.GONE);
                button_1.setVisibility(View.GONE);
                button_2.setVisibility(View.GONE);
                break;
            case 1:
                defaultBt.setVisibility(View.GONE);
                button_1.setVisibility(View.GONE);
                button_2.setVisibility(View.VISIBLE);
                button_2.setText(params[0]);
                break;
            case 2:
                defaultBt.setVisibility(View.GONE);
                button_1.setVisibility(View.VISIBLE);
                button_2.setVisibility(View.VISIBLE);
                button_1.setText(params[0]);
                button_2.setText(params[1]);
                break;
            case 3:
                defaultBt.setVisibility(View.VISIBLE);
                button_1.setVisibility(View.VISIBLE);
                button_2.setVisibility(View.VISIBLE);
                defaultBt.setText(params[0]);
                button_1.setText(params[1]);
                button_2.setText(params[2]);
            default:
                defaultBt.setVisibility(View.VISIBLE);
                button_1.setVisibility(View.VISIBLE);
                button_2.setVisibility(View.VISIBLE);
                defaultBt.setText(params[0]);
                button_1.setText(params[1]);
                button_2.setText(params[2]);
                break;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i(TAG, "onKeyDown ");
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(keyBack!=null){
                keyBack.back();
            }
        }
        return true;
    }

    public void setKeyBack(KeyBack keyBack) {
        this.keyBack = keyBack;
    }

    public interface KeyBack{
        void back();
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getText() {
        return text;
    }

    public TextView getDefaultBt() {
        return defaultBt;
    }

    public TextView getButton_1() {
        return button_1;
    }

    public TextView getButton_2() {
        return button_2;
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }
}
