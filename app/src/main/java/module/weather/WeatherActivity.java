package module.weather;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by bigwen on 2016/1/6.
 */
public class WeatherActivity extends Activity {
    private View view ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new CityChoose(this);
        setContentView(view);
    }


}
