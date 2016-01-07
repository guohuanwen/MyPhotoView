package module.weather;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by bigwen on 2016/1/7.
 */
public class WeatherFigure extends View {
    private String TAG = WeatherFigure.class.getName();
    private Context mContext;
    private int[] highTmp;
    private int[] lowTmp;
    private String[] type;
    private int[] highTmpTrans = new int[4];
    private int[] lowTmpTrans = new int[4];
    private int max = -100;
    private int min = 100;
    private int tmpHeight = 0;
    private Paint paintHigh;
    private Paint paintLow;
    private Paint paintHighText;
    private Paint paintLowText;

    public WeatherFigure(Context context) {
        super(context);
        mContext = context;
        initDate();
        init();
    }

    public WeatherFigure(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initDate();
        init();
    }

//    public WeatherFigure(Context context, int[] highTmp, int[] lowTmp, String[] type) {
//        super(context);
//        this.highTmp = highTmp;
//        this.lowTmp = lowTmp;
//        this.type = type;
//    }

    public void setData(int[] highTmp, int[] lowTmp, String[] type) {
        if (highTmp != null && lowTmp != null && type != null && highTmp.length == 4 && lowTmp.length == 4 && type.length == 4) {
            this.highTmp = highTmp;
            this.lowTmp = lowTmp;
            this.type = type;
            init();
            invalidate();
        }
    }

    private void initDate() {
        highTmp = new int[]{13, 14, 15, 16};
        lowTmp = new int[]{12, 2, 11, 4};
        type = new String[]{"小雨", "多云", "小雨", "多云"};
        paintHigh = new Paint();
        paintLow = new Paint();
        paintHigh.setColor(Color.RED);
        paintLow.setColor(Color.BLUE);

        paintHighText = new Paint();
        paintLowText = new Paint();
        paintHighText.setColor(Color.RED);
        paintLowText.setColor(Color.BLUE);
        paintHighText.setTextSize(30);
        paintLowText.setTextSize(30);
    }

    private void init() {
        Log.i(TAG, "init ");
        for (int i : highTmp) {
            max = Math.max(i, max);
        }
        for (int i : lowTmp) {
            min = Math.min(i, min);
        }

        //后面常数控制线图整体高度，越大高度越低
        tmpHeight = max - min +4;
        for (int i = 0; i < highTmp.length; i++) {
            highTmpTrans[i] = highTmp[i] - min;
        }

        for (int i = 0; i < lowTmp.length; i++) {
            lowTmpTrans[i] = lowTmp[i] - min;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw ");
        int width = getWidth();
        //后面常数控制距离底部距离，越小越低
        int height = getHeight() - 70;
        int width1 = width / 8 * 1;
        int width2 = width / 8 * 3;
        int width3 = width / 8 * 5;
        int width4 = width / 8 * 7;

        int heightHigh1 = height / tmpHeight * highTmpTrans[0];
        int heightHigh2 = height / tmpHeight * highTmpTrans[1];
        int heightHigh3 = height / tmpHeight * highTmpTrans[2];
        int heightHigh4 = height / tmpHeight * highTmpTrans[3];

        int heightLow1 = height / tmpHeight * lowTmpTrans[0];
        int heightLow2 = height / tmpHeight * lowTmpTrans[1];
        int heightLow3 = height / tmpHeight * lowTmpTrans[2];
        int heightLow4 = height / tmpHeight * lowTmpTrans[3];

        canvas.drawCircle(width1, height - heightHigh1, 5, paintHigh);
        canvas.drawCircle(width2, height - heightHigh2, 5, paintHigh);
        canvas.drawCircle(width3, height - heightHigh3, 5, paintHigh);
        canvas.drawCircle(width4, height - heightHigh4, 5, paintHigh);

        canvas.drawCircle(width1, height - heightLow1, 5, paintLow);
        canvas.drawCircle(width2, height - heightLow2, 5, paintLow);
        canvas.drawCircle(width3, height - heightLow3, 5, paintLow);
        canvas.drawCircle(width4, height - heightLow4, 5, paintLow);

        canvas.drawText(highTmp[0] + "", width1 - 10, height - heightHigh1 - 8, paintHighText);
        canvas.drawText(highTmp[1] + "", width2 - 10, height - heightHigh2 - 8, paintHighText);
        canvas.drawText(highTmp[2] + "", width3 - 10, height - heightHigh3 - 8, paintHighText);
        canvas.drawText(highTmp[3] + "", width4 - 10, height - heightHigh4 - 8, paintHighText);

        canvas.drawText(lowTmp[0] + "", width1 - 8, height - heightLow1 + 28, paintLowText);
        canvas.drawText(lowTmp[1] + "", width2 - 8, height - heightLow2 + 28, paintLowText);
        canvas.drawText(lowTmp[2] + "", width3 - 8, height - heightLow3 + 28, paintLowText);
        canvas.drawText(lowTmp[3] + "", width4 - 8, height - heightLow4 + 28, paintLowText);

        canvas.drawLine(width1, height - heightHigh1, width2, height - heightHigh2, paintHigh);
        canvas.drawLine(width2, height - heightHigh2, width3, height - heightHigh3, paintHigh);
        canvas.drawLine(width3, height - heightHigh3, width4, height - heightHigh4, paintHigh);

        canvas.drawLine(width1, height - heightLow1, width2, height - heightLow2, paintLow);
        canvas.drawLine(width2, height - heightLow2, width3, height - heightLow3, paintLow);
        canvas.drawLine(width3, height - heightLow3, width4, height - heightLow4, paintLow);


        //后面常数控制文字到底部距离，越大越低
        canvas.drawText(type[0], width1 - 10, height + 55, paintLowText);
        canvas.drawText(type[1], width2 - 10, height + 55, paintLowText);
        canvas.drawText(type[2], width3 - 10, height + 55, paintLowText);
        canvas.drawText(type[3], width4 - 10, height + 55, paintLowText);
    }


}
