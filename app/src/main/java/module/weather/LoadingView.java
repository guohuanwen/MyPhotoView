package module.weather;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.bcgtgjyb.myphotoapp.R;

/**
 * Created by bigwen on 2016/1/7.
 */
public class LoadingView extends View {
    private Context mContext;
    private Paint paint;
    private ValueAnimator valueAnimator;
    private boolean interrupt = false;
    private String TAG = LoadingView.class.getName();

    public LoadingView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        paint = new Paint();
//        paint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (valueAnimator != null && valueAnimator.isRunning()) {
            Log.i(TAG, "onDraw " + valueAnimator.getAnimatedValue());
            canvas.rotate(360 * (float) valueAnimator.getAnimatedValue(),getWidth()/2,getHeight()/2);
        }
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.roale);
        bitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
        canvas.drawBitmap(bitmap, null, new Rect(3,3, getWidth()-3, getHeight()-3), paint);

        if (valueAnimator != null && valueAnimator.isRunning()) {
            invalidate();
        }
    }

    public void start() {
        Log.i(TAG, "start ");
        valueAnimator = null;
        valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.start();
        invalidate();
        if (!interrupt) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    start();
                    invalidate();
                }
            }, valueAnimator.getDuration());
        }
    }

    public void stop() {
        interrupt = true;
    }

    public boolean isStart() {
        interrupt = false;
        if(valueAnimator==null){
            return false;
        }else {
            return valueAnimator.isRunning();
        }
    }
}
