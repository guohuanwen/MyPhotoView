package module.weather;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bcgtgjyb.mylibrary.base.BaseModel;
import com.bcgtgjyb.mylibrary.base.bean.CityWeather;
import com.bcgtgjyb.myphotoapp.R;
import com.google.gson.Gson;

import net.HttpCallBack;
import net.MyURL;

import java.util.ArrayList;
import java.util.List;

import handler.WeatherHandler;
import io.SharePrefenceIO;

/**
 * Created by bigwen on 2016/1/4.
 */
public class WeatherView extends LinearLayout {
    private String TAG = WeatherView.class.getName();
    private Context mContext;
    private TextView tmp;
    private TextView windy;
    private TextView feng;
    private TextView time;
    private TextView place;
    private ListView listView;
    private WeatherHandler weatherHandler;
    private android.support.v4.app.Fragment fragment;
    private WeatherAdapter weatherAdapter;


    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public WeatherView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public WeatherView(Context mContext, android.support.v4.app.Fragment fragment) {
        super(mContext);
        this.mContext = mContext;
        init();
        this.fragment = fragment;
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.weather_view, this);
        tmp = (TextView) findViewById(R.id.weather_view_tmp);
        windy = (TextView) findViewById(R.id.weather_view_windy);
        feng = (TextView) findViewById(R.id.weather_view_feng);
        time = (TextView) findViewById(R.id.weather_view_time);
        place = (TextView) findViewById(R.id.weather_view_place);
        listView = (ListView) findViewById(R.id.weather_view_list);
        httpRequest();
        weatherHandler = new WeatherHandler();
        place.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.startActivityForResult(new Intent(mContext, WeatherActivity.class), Activity.RESULT_FIRST_USER);
            }

        });
    }

    String t = "";


    private void httpRequest() {
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                weatherHandler.httpGetWeatnerInfo(MyURL.Weather, SharePrefenceIO.loadSharePreference("city_code", "USERCITY", "101010100"), new HttpCallBack() {
                    @Override
                    public void onSuccess(String text) {
                        t = text;
                        Gson gson = new Gson();
                        CityWeather cityWeather = gson.fromJson(text, CityWeather.class);
                        weatherHandler.saveDB(cityWeather.getRetData());
                        weatherHandler.saveDB(cityWeather.getRetData().getToday());
                        for (CityWeather.RetDataEntity.ForecastEntity forecastEntity : cityWeather.getRetData().getForecast()) {
                            weatherHandler.saveDB(forecastEntity);
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e(TAG, "onError " + e.toString());
                    }
                });
                return null;
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
                place.setText(SharePrefenceIO.loadSharePreference("city_name", "USERCITY", "北京"));
                List<BaseModel> forecasts = weatherHandler.loadAllFromDB(new CityWeather.RetDataEntity.ForecastEntity());
                if(forecasts==null||(forecasts!=null&&forecasts.size()==0)){
                    Log.i(TAG, "onPostExecute 预测天气空");
                    return;
                }
                List<CityWeather.RetDataEntity.ForecastEntity> list = new ArrayList<>();
                for (BaseModel baseModel : forecasts) {
                    if (baseModel instanceof CityWeather.RetDataEntity.ForecastEntity) {
                        list.add((CityWeather.RetDataEntity.ForecastEntity) baseModel);
                    }
                }
                if (weatherAdapter == null) {
                    weatherAdapter = new WeatherAdapter(list);
                    listView.setAdapter(weatherAdapter);
                } else {
                    weatherAdapter.update(list);
                }
            }
        };
        asyncTask.execute("");
    }

    public void update() {
        httpRequest();
    }

    public class WeatherAdapter extends BaseAdapter {
        private List<CityWeather.RetDataEntity.ForecastEntity> list = new ArrayList<>();

        public WeatherAdapter(List<CityWeather.RetDataEntity.ForecastEntity> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.weather_list_item, null);
                viewHolder.time = (TextView) convertView.findViewById(R.id.weather_list_item_time);
                viewHolder.type = (TextView) convertView.findViewById(R.id.weather_list_item_type);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.time.setText(list.get(position).getWeek());
            viewHolder.type.setText(list.get(position).getType() + " " +
                    list.get(position).getLowtemp() + "-" + list.get(position).getHightemp());
            Log.i(TAG, "getView " + viewHolder.time + "  " + list);
            return convertView;
        }

        public void update(List<CityWeather.RetDataEntity.ForecastEntity> list) {
            this.list.clear();
            this.list = list;
            notifyDataSetInvalidated();
        }


        public class ViewHolder {
            public TextView time;
            public TextView type;
        }
    }
}
