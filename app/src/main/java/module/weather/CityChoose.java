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

import com.bcgtgjyb.mylibrary.base.CityNameHelper;
import com.bcgtgjyb.mylibrary.base.bean.CityName;
import com.bcgtgjyb.myphotoapp.R;
import com.google.gson.Gson;

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
    private CityNameHelper myDataBase;
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
        myDataBase = CityNameHelper.getInstence(MyApplication.getContext());
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
//        saveDB();
    }

    private void saveDB(){
        String name = "{\n" +
                "    \"cityCode\": [\n" +
                "        {\n" +
                "            \"province\": \"北京\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"北京\",\n" +
                "                    \"cityCode\": \"101010100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"朝阳\",\n" +
                "                    \"cityCode\": \"101010300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"顺义\",\n" +
                "                    \"cityCode\": \"101010400\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"怀柔\",\n" +
                "                    \"cityCode\": \"101010500\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"通州\",\n" +
                "                    \"cityCode\": \"101010600\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"昌平\",\n" +
                "                    \"cityCode\": \"101010700\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"延庆\",\n" +
                "                    \"cityCode\": \"101010800\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"丰台\",\n" +
                "                    \"cityCode\": \"101010900\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"石景山\",\n" +
                "                    \"cityCode\": \"101011000\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"大兴\",\n" +
                "                    \"cityCode\": \"101011100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"房山\",\n" +
                "                    \"cityCode\": \"101011200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"密云\",\n" +
                "                    \"cityCode\": \"101011300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"门头沟\",\n" +
                "                    \"cityCode\": \"101011400\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"平谷\",\n" +
                "                    \"cityCode\": \"101011500\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"八达岭\",\n" +
                "                    \"cityCode\": \"101011600\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"佛爷顶\",\n" +
                "                    \"cityCode\": \"101011700\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"汤河口\",\n" +
                "                    \"cityCode\": \"101011800\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"密云上甸子\",\n" +
                "                    \"cityCode\": \"101011900\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"斋堂\",\n" +
                "                    \"cityCode\": \"101012000\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"霞云岭\",\n" +
                "                    \"cityCode\": \"101012100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"北京城区\",\n" +
                "                    \"cityCode\": \"101012200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"海淀\",\n" +
                "                    \"cityCode\": \"101010200\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"天津\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"天津\",\n" +
                "                    \"cityCode\": \"101030100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宝坻\",\n" +
                "                    \"cityCode\": \"101030300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"东丽\",\n" +
                "                    \"cityCode\": \"101030400\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"西青\",\n" +
                "                    \"cityCode\": \"101030500\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"北辰\",\n" +
                "                    \"cityCode\": \"101030600\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"蓟县\",\n" +
                "                    \"cityCode\": \"101031400\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"汉沽\",\n" +
                "                    \"cityCode\": \"101030800\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"静海\",\n" +
                "                    \"cityCode\": \"101030900\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"津南\",\n" +
                "                    \"cityCode\": \"101031000\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"塘沽\",\n" +
                "                    \"cityCode\": \"101031100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"大港\",\n" +
                "                    \"cityCode\": \"101031200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"武清\",\n" +
                "                    \"cityCode\": \"101030200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宁河\",\n" +
                "                    \"cityCode\": \"101030700\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"上海\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"上海\",\n" +
                "                    \"cityCode\": \"101020100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宝山\",\n" +
                "                    \"cityCode\": \"101020300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"嘉定\",\n" +
                "                    \"cityCode\": \"101020500\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"南汇\",\n" +
                "                    \"cityCode\": \"101020600\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"浦东\",\n" +
                "                    \"cityCode\": \"101021300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"青浦\",\n" +
                "                    \"cityCode\": \"101020800\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"松江\",\n" +
                "                    \"cityCode\": \"101020900\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"奉贤\",\n" +
                "                    \"cityCode\": \"101021000\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"崇明\",\n" +
                "                    \"cityCode\": \"101021100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"徐家汇\",\n" +
                "                    \"cityCode\": \"101021200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"闵行\",\n" +
                "                    \"cityCode\": \"101020200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"金山\",\n" +
                "                    \"cityCode\": \"101020700\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"河北\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"石家庄\",\n" +
                "                    \"cityCode\": \"101090101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"张家口\",\n" +
                "                    \"cityCode\": \"101090301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"承德\",\n" +
                "                    \"cityCode\": \"101090402\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"唐山\",\n" +
                "                    \"cityCode\": \"101090501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"秦皇岛\",\n" +
                "                    \"cityCode\": \"101091101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"沧州\",\n" +
                "                    \"cityCode\": \"101090701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"衡水\",\n" +
                "                    \"cityCode\": \"101090801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"邢台\",\n" +
                "                    \"cityCode\": \"101090901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"邯郸\",\n" +
                "                    \"cityCode\": \"101091001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"保定\",\n" +
                "                    \"cityCode\": \"101090201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"廊坊\",\n" +
                "                    \"cityCode\": \"101090601\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"河南\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"郑州\",\n" +
                "                    \"cityCode\": \"101180101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"新乡\",\n" +
                "                    \"cityCode\": \"101180301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"许昌\",\n" +
                "                    \"cityCode\": \"101180401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"平顶山\",\n" +
                "                    \"cityCode\": \"101180501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"信阳\",\n" +
                "                    \"cityCode\": \"101180601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"南阳\",\n" +
                "                    \"cityCode\": \"101180701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"开封\",\n" +
                "                    \"cityCode\": \"101180801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"洛阳\",\n" +
                "                    \"cityCode\": \"101180901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"商丘\",\n" +
                "                    \"cityCode\": \"101181001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"焦作\",\n" +
                "                    \"cityCode\": \"101181101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"鹤壁\",\n" +
                "                    \"cityCode\": \"101181201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"濮阳\",\n" +
                "                    \"cityCode\": \"101181301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"周口\",\n" +
                "                    \"cityCode\": \"101181401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"漯河\",\n" +
                "                    \"cityCode\": \"101181501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"驻马店\",\n" +
                "                    \"cityCode\": \"101181601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"三门峡\",\n" +
                "                    \"cityCode\": \"101181701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"济源\",\n" +
                "                    \"cityCode\": \"101181801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"安阳\",\n" +
                "                    \"cityCode\": \"101180201\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"安徽\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"合肥\",\n" +
                "                    \"cityCode\": \"101220101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"芜湖\",\n" +
                "                    \"cityCode\": \"101220301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"淮南\",\n" +
                "                    \"cityCode\": \"101220401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"马鞍山\",\n" +
                "                    \"cityCode\": \"101220501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"安庆\",\n" +
                "                    \"cityCode\": \"101220601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宿州\",\n" +
                "                    \"cityCode\": \"101220701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阜阳\",\n" +
                "                    \"cityCode\": \"101220801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"亳州\",\n" +
                "                    \"cityCode\": \"101220901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"黄山\",\n" +
                "                    \"cityCode\": \"101221001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"滁州\",\n" +
                "                    \"cityCode\": \"101221101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"淮北\",\n" +
                "                    \"cityCode\": \"101221201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"铜陵\",\n" +
                "                    \"cityCode\": \"101221301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宣城\",\n" +
                "                    \"cityCode\": \"101221401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"六安\",\n" +
                "                    \"cityCode\": \"101221501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"巢湖\",\n" +
                "                    \"cityCode\": \"101221601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"池州\",\n" +
                "                    \"cityCode\": \"101221701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"蚌埠\",\n" +
                "                    \"cityCode\": \"101220201\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"浙江\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"杭州\",\n" +
                "                    \"cityCode\": \"101210101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"舟山\",\n" +
                "                    \"cityCode\": \"101211101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"湖州\",\n" +
                "                    \"cityCode\": \"101210201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"嘉兴\",\n" +
                "                    \"cityCode\": \"101210301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"金华\",\n" +
                "                    \"cityCode\": \"101210901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"绍兴\",\n" +
                "                    \"cityCode\": \"101210501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"台州\",\n" +
                "                    \"cityCode\": \"101210601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"温州\",\n" +
                "                    \"cityCode\": \"101210701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"丽水\",\n" +
                "                    \"cityCode\": \"101210801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"衢州\",\n" +
                "                    \"cityCode\": \"101211001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宁波\",\n" +
                "                    \"cityCode\": \"101210401\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"重庆\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"重庆\",\n" +
                "                    \"cityCode\": \"101040100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"合川\",\n" +
                "                    \"cityCode\": \"101040300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"南川\",\n" +
                "                    \"cityCode\": \"101040400\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"江津\",\n" +
                "                    \"cityCode\": \"101040500\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"万盛\",\n" +
                "                    \"cityCode\": \"101040600\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"渝北\",\n" +
                "                    \"cityCode\": \"101040700\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"北碚\",\n" +
                "                    \"cityCode\": \"101040800\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"巴南\",\n" +
                "                    \"cityCode\": \"101040900\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"长寿\",\n" +
                "                    \"cityCode\": \"101041000\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"黔江\",\n" +
                "                    \"cityCode\": \"101041100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"万州天城\",\n" +
                "                    \"cityCode\": \"101041200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"万州龙宝\",\n" +
                "                    \"cityCode\": \"101041300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"涪陵\",\n" +
                "                    \"cityCode\": \"101041400\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"开县\",\n" +
                "                    \"cityCode\": \"101041500\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"城口\",\n" +
                "                    \"cityCode\": \"101041600\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"云阳\",\n" +
                "                    \"cityCode\": \"101041700\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"巫溪\",\n" +
                "                    \"cityCode\": \"101041800\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"奉节\",\n" +
                "                    \"cityCode\": \"101041900\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"巫山\",\n" +
                "                    \"cityCode\": \"101042000\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"潼南\",\n" +
                "                    \"cityCode\": \"101042100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"垫江\",\n" +
                "                    \"cityCode\": \"101042200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"梁平\",\n" +
                "                    \"cityCode\": \"101042300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"忠县\",\n" +
                "                    \"cityCode\": \"101042400\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"石柱\",\n" +
                "                    \"cityCode\": \"101042500\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"大足\",\n" +
                "                    \"cityCode\": \"101042600\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"荣昌\",\n" +
                "                    \"cityCode\": \"101042700\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"铜梁\",\n" +
                "                    \"cityCode\": \"101042800\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"璧山\",\n" +
                "                    \"cityCode\": \"101042900\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"丰都\",\n" +
                "                    \"cityCode\": \"101043000\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"武隆\",\n" +
                "                    \"cityCode\": \"101043100\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"彭水\",\n" +
                "                    \"cityCode\": \"101043200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"綦江\",\n" +
                "                    \"cityCode\": \"101043300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"酉阳\",\n" +
                "                    \"cityCode\": \"101043400\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"秀山\",\n" +
                "                    \"cityCode\": \"101043600\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"沙坪坝\",\n" +
                "                    \"cityCode\": \"101043700\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"永川\",\n" +
                "                    \"cityCode\": \"101040200\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"福建\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"福州\",\n" +
                "                    \"cityCode\": \"101230101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"泉州\",\n" +
                "                    \"cityCode\": \"101230501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"漳州\",\n" +
                "                    \"cityCode\": \"101230601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"龙岩\",\n" +
                "                    \"cityCode\": \"101230701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"晋江\",\n" +
                "                    \"cityCode\": \"101230509\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"南平\",\n" +
                "                    \"cityCode\": \"101230901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"厦门\",\n" +
                "                    \"cityCode\": \"101230201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宁德\",\n" +
                "                    \"cityCode\": \"101230301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"莆田\",\n" +
                "                    \"cityCode\": \"101230401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"三明\",\n" +
                "                    \"cityCode\": \"101230801\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"甘肃\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"兰州\",\n" +
                "                    \"cityCode\": \"101160101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"平凉\",\n" +
                "                    \"cityCode\": \"101160301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"庆阳\",\n" +
                "                    \"cityCode\": \"101160401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"武威\",\n" +
                "                    \"cityCode\": \"101160501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"金昌\",\n" +
                "                    \"cityCode\": \"101160601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"嘉峪关\",\n" +
                "                    \"cityCode\": \"101161401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"酒泉\",\n" +
                "                    \"cityCode\": \"101160801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"天水\",\n" +
                "                    \"cityCode\": \"101160901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"武都\",\n" +
                "                    \"cityCode\": \"101161001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"临夏\",\n" +
                "                    \"cityCode\": \"101161101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"合作\",\n" +
                "                    \"cityCode\": \"101161201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"白银\",\n" +
                "                    \"cityCode\": \"101161301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"定西\",\n" +
                "                    \"cityCode\": \"101160201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"张掖\",\n" +
                "                    \"cityCode\": \"101160701\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"广东\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"广州\",\n" +
                "                    \"cityCode\": \"101280101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"惠州\",\n" +
                "                    \"cityCode\": \"101280301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"梅州\",\n" +
                "                    \"cityCode\": \"101280401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"汕头\",\n" +
                "                    \"cityCode\": \"101280501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"深圳\",\n" +
                "                    \"cityCode\": \"101280601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"珠海\",\n" +
                "                    \"cityCode\": \"101280701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"佛山\",\n" +
                "                    \"cityCode\": \"101280800\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"肇庆\",\n" +
                "                    \"cityCode\": \"101280901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"湛江\",\n" +
                "                    \"cityCode\": \"101281001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"江门\",\n" +
                "                    \"cityCode\": \"101281101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"河源\",\n" +
                "                    \"cityCode\": \"101281201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"清远\",\n" +
                "                    \"cityCode\": \"101281301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"云浮\",\n" +
                "                    \"cityCode\": \"101281401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"潮州\",\n" +
                "                    \"cityCode\": \"101281501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"东莞\",\n" +
                "                    \"cityCode\": \"101281601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"中山\",\n" +
                "                    \"cityCode\": \"101281701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阳江\",\n" +
                "                    \"cityCode\": \"101281801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"揭阳\",\n" +
                "                    \"cityCode\": \"101281901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"茂名\",\n" +
                "                    \"cityCode\": \"101282001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"汕尾\",\n" +
                "                    \"cityCode\": \"101282101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"韶关\",\n" +
                "                    \"cityCode\": \"101280201\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"广西\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"南宁\",\n" +
                "                    \"cityCode\": \"101300101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"柳州\",\n" +
                "                    \"cityCode\": \"101300301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"来宾\",\n" +
                "                    \"cityCode\": \"101300401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"桂林\",\n" +
                "                    \"cityCode\": \"101300501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"梧州\",\n" +
                "                    \"cityCode\": \"101300601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"防城港\",\n" +
                "                    \"cityCode\": \"101301401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"贵港\",\n" +
                "                    \"cityCode\": \"101300801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"玉林\",\n" +
                "                    \"cityCode\": \"101300901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"百色\",\n" +
                "                    \"cityCode\": \"101301001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"钦州\",\n" +
                "                    \"cityCode\": \"101301101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"河池\",\n" +
                "                    \"cityCode\": \"101301201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"北海\",\n" +
                "                    \"cityCode\": \"101301301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"崇左\",\n" +
                "                    \"cityCode\": \"101300201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"贺州\",\n" +
                "                    \"cityCode\": \"101300701\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"贵州\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"贵阳\",\n" +
                "                    \"cityCode\": \"101260101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"安顺\",\n" +
                "                    \"cityCode\": \"101260301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"都匀\",\n" +
                "                    \"cityCode\": \"101260401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"兴义\",\n" +
                "                    \"cityCode\": \"101260906\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"铜仁\",\n" +
                "                    \"cityCode\": \"101260601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"毕节\",\n" +
                "                    \"cityCode\": \"101260701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"六盘水\",\n" +
                "                    \"cityCode\": \"101260801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"遵义\",\n" +
                "                    \"cityCode\": \"101260201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"凯里\",\n" +
                "                    \"cityCode\": \"101260501\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"云南\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"昆明\",\n" +
                "                    \"cityCode\": \"101290101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"红河\",\n" +
                "                    \"cityCode\": \"101290301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"文山\",\n" +
                "                    \"cityCode\": \"101290601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"玉溪\",\n" +
                "                    \"cityCode\": \"101290701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"楚雄\",\n" +
                "                    \"cityCode\": \"101290801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"普洱\",\n" +
                "                    \"cityCode\": \"101290901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"昭通\",\n" +
                "                    \"cityCode\": \"101291001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"临沧\",\n" +
                "                    \"cityCode\": \"101291101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"怒江\",\n" +
                "                    \"cityCode\": \"101291201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"香格里拉\",\n" +
                "                    \"cityCode\": \"101291301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"丽江\",\n" +
                "                    \"cityCode\": \"101291401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"德宏\",\n" +
                "                    \"cityCode\": \"101291501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"景洪\",\n" +
                "                    \"cityCode\": \"101291601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"大理\",\n" +
                "                    \"cityCode\": \"101290201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"曲靖\",\n" +
                "                    \"cityCode\": \"101290401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"保山\",\n" +
                "                    \"cityCode\": \"101290501\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"内蒙古\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"呼和浩特\",\n" +
                "                    \"cityCode\": \"101080101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"乌海\",\n" +
                "                    \"cityCode\": \"101080301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"集宁\",\n" +
                "                    \"cityCode\": \"101080401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"通辽\",\n" +
                "                    \"cityCode\": \"101080501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阿拉善左旗\",\n" +
                "                    \"cityCode\": \"101081201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"鄂尔多斯\",\n" +
                "                    \"cityCode\": \"101080701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"临河\",\n" +
                "                    \"cityCode\": \"101080801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"锡林浩特\",\n" +
                "                    \"cityCode\": \"101080901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"呼伦贝尔\",\n" +
                "                    \"cityCode\": \"101081000\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"乌兰浩特\",\n" +
                "                    \"cityCode\": \"101081101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"包头\",\n" +
                "                    \"cityCode\": \"101080201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"赤峰\",\n" +
                "                    \"cityCode\": \"101080601\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"江西\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"南昌\",\n" +
                "                    \"cityCode\": \"101240101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"上饶\",\n" +
                "                    \"cityCode\": \"101240301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"抚州\",\n" +
                "                    \"cityCode\": \"101240401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宜春\",\n" +
                "                    \"cityCode\": \"101240501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"鹰潭\",\n" +
                "                    \"cityCode\": \"101241101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"赣州\",\n" +
                "                    \"cityCode\": \"101240701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"景德镇\",\n" +
                "                    \"cityCode\": \"101240801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"萍乡\",\n" +
                "                    \"cityCode\": \"101240901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"新余\",\n" +
                "                    \"cityCode\": \"101241001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"九江\",\n" +
                "                    \"cityCode\": \"101240201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"吉安\",\n" +
                "                    \"cityCode\": \"101240601\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"湖北\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"武汉\",\n" +
                "                    \"cityCode\": \"101200101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"黄冈\",\n" +
                "                    \"cityCode\": \"101200501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"荆州\",\n" +
                "                    \"cityCode\": \"101200801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宜昌\",\n" +
                "                    \"cityCode\": \"101200901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"恩施\",\n" +
                "                    \"cityCode\": \"101201001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"十堰\",\n" +
                "                    \"cityCode\": \"101201101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"神农架\",\n" +
                "                    \"cityCode\": \"101201201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"随州\",\n" +
                "                    \"cityCode\": \"101201301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"荆门\",\n" +
                "                    \"cityCode\": \"101201401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"天门\",\n" +
                "                    \"cityCode\": \"101201501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"仙桃\",\n" +
                "                    \"cityCode\": \"101201601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"潜江\",\n" +
                "                    \"cityCode\": \"101201701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"襄樊\",\n" +
                "                    \"cityCode\": \"101200201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"鄂州\",\n" +
                "                    \"cityCode\": \"101200301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"孝感\",\n" +
                "                    \"cityCode\": \"101200401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"黄石\",\n" +
                "                    \"cityCode\": \"101200601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"咸宁\",\n" +
                "                    \"cityCode\": \"101200701\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"四川\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"成都\",\n" +
                "                    \"cityCode\": \"101270101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"自贡\",\n" +
                "                    \"cityCode\": \"101270301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"绵阳\",\n" +
                "                    \"cityCode\": \"101270401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"南充\",\n" +
                "                    \"cityCode\": \"101270501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"达州\",\n" +
                "                    \"cityCode\": \"101270601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"遂宁\",\n" +
                "                    \"cityCode\": \"101270701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"广安\",\n" +
                "                    \"cityCode\": \"101270801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"巴中\",\n" +
                "                    \"cityCode\": \"101270901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"泸州\",\n" +
                "                    \"cityCode\": \"101271001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宜宾\",\n" +
                "                    \"cityCode\": \"101271101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"内江\",\n" +
                "                    \"cityCode\": \"101271201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"资阳\",\n" +
                "                    \"cityCode\": \"101271301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"乐山\",\n" +
                "                    \"cityCode\": \"101271401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"眉山\",\n" +
                "                    \"cityCode\": \"101271501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"凉山\",\n" +
                "                    \"cityCode\": \"101271601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"雅安\",\n" +
                "                    \"cityCode\": \"101271701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"甘孜\",\n" +
                "                    \"cityCode\": \"101271801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阿坝\",\n" +
                "                    \"cityCode\": \"101271901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"德阳\",\n" +
                "                    \"cityCode\": \"101272001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"广元\",\n" +
                "                    \"cityCode\": \"101272101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"攀枝花\",\n" +
                "                    \"cityCode\": \"101270201\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"宁夏\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"银川\",\n" +
                "                    \"cityCode\": \"101170101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"中卫\",\n" +
                "                    \"cityCode\": \"101170501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"固原\",\n" +
                "                    \"cityCode\": \"101170401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"石嘴山\",\n" +
                "                    \"cityCode\": \"101170201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"吴忠\",\n" +
                "                    \"cityCode\": \"101170301\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"青海\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"西宁\",\n" +
                "                    \"cityCode\": \"101150101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"黄南\",\n" +
                "                    \"cityCode\": \"101150301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"海北\",\n" +
                "                    \"cityCode\": \"101150801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"果洛\",\n" +
                "                    \"cityCode\": \"101150501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"玉树\",\n" +
                "                    \"cityCode\": \"101150601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"海西\",\n" +
                "                    \"cityCode\": \"101150701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"海东\",\n" +
                "                    \"cityCode\": \"101150201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"海南\",\n" +
                "                    \"cityCode\": \"101150401\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"山东\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"济南\",\n" +
                "                    \"cityCode\": \"101120101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"潍坊\",\n" +
                "                    \"cityCode\": \"101120601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"临沂\",\n" +
                "                    \"cityCode\": \"101120901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"菏泽\",\n" +
                "                    \"cityCode\": \"101121001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"滨州\",\n" +
                "                    \"cityCode\": \"101121101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"东营\",\n" +
                "                    \"cityCode\": \"101121201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"威海\",\n" +
                "                    \"cityCode\": \"101121301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"枣庄\",\n" +
                "                    \"cityCode\": \"101121401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"日照\",\n" +
                "                    \"cityCode\": \"101121501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"莱芜\",\n" +
                "                    \"cityCode\": \"101121601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"聊城\",\n" +
                "                    \"cityCode\": \"101121701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"青岛\",\n" +
                "                    \"cityCode\": \"101120201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"淄博\",\n" +
                "                    \"cityCode\": \"101120301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"德州\",\n" +
                "                    \"cityCode\": \"101120401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"烟台\",\n" +
                "                    \"cityCode\": \"101120501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"济宁\",\n" +
                "                    \"cityCode\": \"101120701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"泰安\",\n" +
                "                    \"cityCode\": \"101120801\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"陕西\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"西安\",\n" +
                "                    \"cityCode\": \"101110101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"延安\",\n" +
                "                    \"cityCode\": \"101110300\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"榆林\",\n" +
                "                    \"cityCode\": \"101110401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"铜川\",\n" +
                "                    \"cityCode\": \"101111001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"商洛\",\n" +
                "                    \"cityCode\": \"101110601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"安康\",\n" +
                "                    \"cityCode\": \"101110701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"汉中\",\n" +
                "                    \"cityCode\": \"101110801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宝鸡\",\n" +
                "                    \"cityCode\": \"101110901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"咸阳\",\n" +
                "                    \"cityCode\": \"101110200\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"渭南\",\n" +
                "                    \"cityCode\": \"101110501\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"山西\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"太原\",\n" +
                "                    \"cityCode\": \"101100101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"临汾\",\n" +
                "                    \"cityCode\": \"101100701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"运城\",\n" +
                "                    \"cityCode\": \"101100801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"朔州\",\n" +
                "                    \"cityCode\": \"101100901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"忻州\",\n" +
                "                    \"cityCode\": \"101101001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"长治\",\n" +
                "                    \"cityCode\": \"101100501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"大同\",\n" +
                "                    \"cityCode\": \"101100201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阳泉\",\n" +
                "                    \"cityCode\": \"101100301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"晋中\",\n" +
                "                    \"cityCode\": \"101100401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"晋城\",\n" +
                "                    \"cityCode\": \"101100601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"吕梁\",\n" +
                "                    \"cityCode\": \"101101100\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"新疆\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"乌鲁木齐\",\n" +
                "                    \"cityCode\": \"101130101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"石河子\",\n" +
                "                    \"cityCode\": \"101130301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"昌吉\",\n" +
                "                    \"cityCode\": \"101130401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"吐鲁番\",\n" +
                "                    \"cityCode\": \"101130501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"库尔勒\",\n" +
                "                    \"cityCode\": \"101130601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阿拉尔\",\n" +
                "                    \"cityCode\": \"101130701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阿克苏\",\n" +
                "                    \"cityCode\": \"101130801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"喀什\",\n" +
                "                    \"cityCode\": \"101130901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"伊宁\",\n" +
                "                    \"cityCode\": \"101131001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"塔城\",\n" +
                "                    \"cityCode\": \"101131101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"哈密\",\n" +
                "                    \"cityCode\": \"101131201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"和田\",\n" +
                "                    \"cityCode\": \"101131301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阿勒泰\",\n" +
                "                    \"cityCode\": \"101131401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阿图什\",\n" +
                "                    \"cityCode\": \"101131501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"博乐\",\n" +
                "                    \"cityCode\": \"101131601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"克拉玛依\",\n" +
                "                    \"cityCode\": \"101130201\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"西藏\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"拉萨\",\n" +
                "                    \"cityCode\": \"101140101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"山南\",\n" +
                "                    \"cityCode\": \"101140301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阿里\",\n" +
                "                    \"cityCode\": \"101140701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"昌都\",\n" +
                "                    \"cityCode\": \"101140501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"那曲\",\n" +
                "                    \"cityCode\": \"101140601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"日喀则\",\n" +
                "                    \"cityCode\": \"101140201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"林芝\",\n" +
                "                    \"cityCode\": \"101140401\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"台湾\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"台北县\",\n" +
                "                    \"cityCode\": \"101340101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"高雄\",\n" +
                "                    \"cityCode\": \"101340201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"台中\",\n" +
                "                    \"cityCode\": \"101340401\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"海南\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"海口\",\n" +
                "                    \"cityCode\": \"101310101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"三亚\",\n" +
                "                    \"cityCode\": \"101310201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"东方\",\n" +
                "                    \"cityCode\": \"101310202\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"临高\",\n" +
                "                    \"cityCode\": \"101310203\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"澄迈\",\n" +
                "                    \"cityCode\": \"101310204\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"儋州\",\n" +
                "                    \"cityCode\": \"101310205\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"昌江\",\n" +
                "                    \"cityCode\": \"101310206\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"白沙\",\n" +
                "                    \"cityCode\": \"101310207\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"琼中\",\n" +
                "                    \"cityCode\": \"101310208\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"定安\",\n" +
                "                    \"cityCode\": \"101310209\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"屯昌\",\n" +
                "                    \"cityCode\": \"101310210\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"琼海\",\n" +
                "                    \"cityCode\": \"101310211\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"文昌\",\n" +
                "                    \"cityCode\": \"101310212\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"保亭\",\n" +
                "                    \"cityCode\": \"101310214\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"万宁\",\n" +
                "                    \"cityCode\": \"101310215\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"陵水\",\n" +
                "                    \"cityCode\": \"101310216\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"西沙\",\n" +
                "                    \"cityCode\": \"101310217\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"南沙岛\",\n" +
                "                    \"cityCode\": \"101310220\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"乐东\",\n" +
                "                    \"cityCode\": \"101310221\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"五指山\",\n" +
                "                    \"cityCode\": \"101310222\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"琼山\",\n" +
                "                    \"cityCode\": \"101310102\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"湖南\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"长沙\",\n" +
                "                    \"cityCode\": \"101250101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"株洲\",\n" +
                "                    \"cityCode\": \"101250301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"衡阳\",\n" +
                "                    \"cityCode\": \"101250401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"郴州\",\n" +
                "                    \"cityCode\": \"101250501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"常德\",\n" +
                "                    \"cityCode\": \"101250601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"益阳\",\n" +
                "                    \"cityCode\": \"101250700\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"娄底\",\n" +
                "                    \"cityCode\": \"101250801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"邵阳\",\n" +
                "                    \"cityCode\": \"101250901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"岳阳\",\n" +
                "                    \"cityCode\": \"101251001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"张家界\",\n" +
                "                    \"cityCode\": \"101251101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"怀化\",\n" +
                "                    \"cityCode\": \"101251201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"黔阳\",\n" +
                "                    \"cityCode\": \"101251301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"永州\",\n" +
                "                    \"cityCode\": \"101251401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"吉首\",\n" +
                "                    \"cityCode\": \"101251501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"湘潭\",\n" +
                "                    \"cityCode\": \"101250201\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"江苏\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"南京\",\n" +
                "                    \"cityCode\": \"101190101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"镇江\",\n" +
                "                    \"cityCode\": \"101190301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"苏州\",\n" +
                "                    \"cityCode\": \"101190401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"南通\",\n" +
                "                    \"cityCode\": \"101190501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"扬州\",\n" +
                "                    \"cityCode\": \"101190601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"宿迁\",\n" +
                "                    \"cityCode\": \"101191301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"徐州\",\n" +
                "                    \"cityCode\": \"101190801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"淮安\",\n" +
                "                    \"cityCode\": \"101190901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"连云港\",\n" +
                "                    \"cityCode\": \"101191001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"常州\",\n" +
                "                    \"cityCode\": \"101191101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"泰州\",\n" +
                "                    \"cityCode\": \"101191201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"无锡\",\n" +
                "                    \"cityCode\": \"101190201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"盐城\",\n" +
                "                    \"cityCode\": \"101190701\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"黑龙江\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"哈尔滨\",\n" +
                "                    \"cityCode\": \"101050101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"牡丹江\",\n" +
                "                    \"cityCode\": \"101050301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"佳木斯\",\n" +
                "                    \"cityCode\": \"101050401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"绥化\",\n" +
                "                    \"cityCode\": \"101050501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"黑河\",\n" +
                "                    \"cityCode\": \"101050601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"双鸭山\",\n" +
                "                    \"cityCode\": \"101051301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"伊春\",\n" +
                "                    \"cityCode\": \"101050801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"大庆\",\n" +
                "                    \"cityCode\": \"101050901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"七台河\",\n" +
                "                    \"cityCode\": \"101051002\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"鸡西\",\n" +
                "                    \"cityCode\": \"101051101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"鹤岗\",\n" +
                "                    \"cityCode\": \"101051201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"齐齐哈尔\",\n" +
                "                    \"cityCode\": \"101050201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"大兴安岭\",\n" +
                "                    \"cityCode\": \"101050701\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"吉林\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"长春\",\n" +
                "                    \"cityCode\": \"101060101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"延吉\",\n" +
                "                    \"cityCode\": \"101060301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"四平\",\n" +
                "                    \"cityCode\": \"101060401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"白山\",\n" +
                "                    \"cityCode\": \"101060901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"白城\",\n" +
                "                    \"cityCode\": \"101060601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"辽源\",\n" +
                "                    \"cityCode\": \"101060701\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"松原\",\n" +
                "                    \"cityCode\": \"101060801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"吉林\",\n" +
                "                    \"cityCode\": \"101060201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"通化\",\n" +
                "                    \"cityCode\": \"101060501\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"province\": \"辽宁\",\n" +
                "            \"city\": [\n" +
                "                {\n" +
                "                    \"cityName\": \"沈阳\",\n" +
                "                    \"cityCode\": \"101070101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"鞍山\",\n" +
                "                    \"cityCode\": \"101070301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"抚顺\",\n" +
                "                    \"cityCode\": \"101070401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"本溪\",\n" +
                "                    \"cityCode\": \"101070501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"丹东\",\n" +
                "                    \"cityCode\": \"101070601\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"葫芦岛\",\n" +
                "                    \"cityCode\": \"101071401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"营口\",\n" +
                "                    \"cityCode\": \"101070801\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"阜新\",\n" +
                "                    \"cityCode\": \"101070901\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"辽阳\",\n" +
                "                    \"cityCode\": \"101071001\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"铁岭\",\n" +
                "                    \"cityCode\": \"101071101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"朝阳\",\n" +
                "                    \"cityCode\": \"101071201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"盘锦\",\n" +
                "                    \"cityCode\": \"101071301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"大连\",\n" +
                "                    \"cityCode\": \"101070201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cityName\": \"锦州\",\n" +
                "                    \"cityCode\": \"101070701\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";
        Gson gson = new Gson();
        CityName cityName = gson.fromJson(name, CityName.class);
        List<CityName.CityCodeEntity> cityCodeEntities= cityName.getCityCode();
        saveToDB(cityCodeEntities);
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
