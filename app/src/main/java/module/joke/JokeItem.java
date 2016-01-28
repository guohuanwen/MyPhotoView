package module.joke;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bcgtgjyb.mylibrary.base.bean.Joke;
import com.bcgtgjyb.myphotoapp.R;

/**
 * Created by bigwen on 2016/1/12.
 */
public class JokeItem extends LinearLayout implements View.OnClickListener{
    private Context mContext;
    private TextView textView;
    private Joke.ShowapiResBodyEntity.ContentlistEntity joke;
    private int state = 0;
    public JokeItem(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public JokeItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public JokeItem(Context context,Joke.ShowapiResBodyEntity.ContentlistEntity joke) {
        super(context);
        mContext = context;
        this.joke = joke;
        init();
    }


    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.arraylist_item,this);
        textView = (TextView)findViewById(R.id.arraylist_item_text);
        textView.setText(joke.getTitle());
        this.setOnClickListener(this);
    }

    private void changeView(){
        if(state == 0){
            state = 1;
            String text = Html.fromHtml(joke.getTitle()+"<p></p><p></p>"+joke.getText()).toString();
            textView.setText(text);
        }else {
            state =0;
            textView.setText(joke.getTitle());
        }
    }

    @Override
    public void onClick(View v) {
        changeView();
    }
}
