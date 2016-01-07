package module.weather;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bcgtgjyb.mylibrary.base.MyDataBase;
import com.bcgtgjyb.mylibrary.base.bean.CityName;
import com.bcgtgjyb.myphotoapp.R;

import java.util.ArrayList;
import java.util.List;

import io.SharePrefenceIO;
import tool.MyApplication;

/**
 * Created by bigwen on 2016/1/6.
 */
public class CityChoose extends LinearLayout {
    private String SharePrefenceName = SharePrefenceIO.SharePrefenceNameCityName;
    private String TAG = CityChoose.class.getName();
    private Context mContext;
    private ListView procinceList;
    private ListView cityList;
    //    private Map<String, List<CityName.CityCodeEntity.CityEntity>> cityMap = new HashMap<String, List<CityName.CityCodeEntity.CityEntity>>();
    private ArrayAdapter<String> provinceAdapter;
    private CityAdapter cityAdapter;
    private MyDataBase myDataBase;
    private String[] province = new String[]{"北京",
            "安徽",
            "澳门",
            "重庆",
            "福建",
            "甘肃",
            "广东",
            "广西",
            "贵州",
            "海南",
            "河北",
            "河南",
            "黑龙江",
            "湖北",
            "湖南",
            "吉林",
            "江苏",
            "江西",
            "辽宁",
            "内蒙古",
            "宁夏",
            "青海",
            "山东",
            "山西",
            "陕西",
            "上海",
            "四川",
            "台湾",
            "天津",
            "西藏",
            "香港",
            "新疆",
            "云南",
            "浙江"};
    private boolean isTouchProvince = false;

    public CityChoose(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public CityChoose(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        myDataBase = MyDataBase.getInstence(MyApplication.getContext());
        LayoutInflater.from(mContext).inflate(R.layout.city_choose, this);
        procinceList = (ListView) findViewById(R.id.city_choose_province);
        cityList = (ListView) findViewById(R.id.city_choose_city);
        provinceAdapter = new ArrayAdapter<String>(mContext, R.layout.arraylist_item, R.id.arraylist_item_text, province);
        procinceList.setAdapter(provinceAdapter);
        cityAdapter = new CityAdapter(myDataBase.loadCity("北京"));
        cityList.setAdapter(cityAdapter);

        procinceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick " + province[position]);
                cityAdapter.update(myDataBase.loadCity(province[position]));
                SharePrefenceIO.saveSharePreference("province", province[position], SharePrefenceName);
            }
        });
    }


    private class CityAdapter extends BaseAdapter {
        private List<CityName.CityCodeEntity.CityEntity> list = new ArrayList<CityName.CityCodeEntity.CityEntity>();

        public CityAdapter(List<CityName.CityCodeEntity.CityEntity> list) {
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

        public void update(List<CityName.CityCodeEntity.CityEntity> list) {
            this.list.clear();
            this.list = list;
            notifyDataSetInvalidated();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.arraylist_item, null);
                viewHolder.city = (TextView) convertView.findViewById(R.id.arraylist_item_text);
                viewHolder.city.setText(list.get(position).getCityName());
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
                viewHolder.city.setText(list.get(position).getCityName());
            }
            viewHolder.cityEntity = list.get(position);
            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isTouchProvince) {
                        SharePrefenceIO.saveSharePreference("province", "北京", SharePrefenceName);
                    }
                    SharePrefenceIO.saveSharePreference("city_name", ((ViewHolder) v.getTag()).cityEntity.getCityName(), SharePrefenceName);
                    SharePrefenceIO.saveSharePreference("city_code", ((ViewHolder) v.getTag()).cityEntity.getCityCode(), SharePrefenceName);
                    ((Activity) mContext).finish();
                }
            });
            return convertView;
        }

        public class ViewHolder {
            public TextView city;
            public CityName.CityCodeEntity.CityEntity cityEntity;

        }
    }

    private void saveToDB(List<CityName.CityCodeEntity> entities) {
        for (CityName.CityCodeEntity cityCodeEntity : entities) {
            String province = cityCodeEntity.getProvince();
            for (CityName.CityCodeEntity.CityEntity cityEntity : cityCodeEntity.getCity()) {
                myDataBase.saveCityName(province, cityEntity.getCityName(), cityEntity.getCityCode());
            }
        }
    }
}
