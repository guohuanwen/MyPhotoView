package module.weather;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bcgtgjyb.mylibrary.base.BaseModel;
import com.bcgtgjyb.mylibrary.base.bean.CityWeather;
import com.bcgtgjyb.myphotoapp.R;
import com.google.gson.Gson;

import net.HttpCallBack;
import net.MyURL;

import java.util.List;

import handler.WeatherHandler;

/**
 * Created by bigwen on 2016/1/4.
 */
public class WeatherView extends LinearLayout {
    private String TAG = WeatherView.class.getName();
    private Context context;
    private TextView tmp;
    private TextView windy;
    private TextView feng;
    private TextView time;
    private TextView place;
    private WeatherHandler weatherHandler;

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public WeatherView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        LayoutInflater.from(context).inflate(R.layout.weather_view, this);
        tmp = (TextView) findViewById(R.id.weather_view_tmp);
        windy = (TextView) findViewById(R.id.weather_view_windy);
        feng = (TextView) findViewById(R.id.weather_view_feng);
        time = (TextView) findViewById(R.id.weather_view_time);
        place = (TextView) findViewById(R.id.weather_view_place);

        weatherHandler = new WeatherHandler();
        asyncTask.execute("");


    }

    String t = "";
    private AsyncTask asyncTask = new AsyncTask() {
        @Override
        protected Object doInBackground(Object[] params) {

            weatherHandler.httpGetWeatnerInfo(MyURL.Weather, "101010100", new HttpCallBack() {
                @Override
                public void onSuccess(String text) {
                    t = text;
                    Gson gson = new Gson();
                    CityWeather cityWeather = gson.fromJson(text, CityWeather.class);
                    weatherHandler.saveDB(cityWeather.getRetData());
                    weatherHandler.saveDB(cityWeather.getRetData().getToday());
                }

                @Override
                public void onError(Exception e) {

                }
            });

            return t;
        }


        @Override
        protected void onPostExecute(Object o) {
                List<BaseModel> todayEntitys = weatherHandler.loadAllFromDB(new CityWeather.RetDataEntity.TodayEntity());
                if (todayEntitys.size() > 0 && todayEntitys.get(0) instanceof CityWeather.RetDataEntity.TodayEntity) {
                    CityWeather.RetDataEntity.TodayEntity todayEntity = (CityWeather.RetDataEntity.TodayEntity) todayEntitys.get(0);
                    tmp.setText(todayEntity.getCurTemp());
                    windy.setText(todayEntity.getType());
                    feng.setText(todayEntity.getFengxiang() + " " + todayEntity.getFengli());
                    time.setText(todayEntity.getDate());
                }
                List<BaseModel> retDataEntitys = weatherHandler.loadAllFromDB(new CityWeather.RetDataEntity());
                if (retDataEntitys.size() > 0 && retDataEntitys.get(0) instanceof CityWeather.RetDataEntity) {
                    place.setText(((CityWeather.RetDataEntity) retDataEntitys.get(0)).getCity());
                }
        }
    };

}
