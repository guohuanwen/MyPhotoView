package com.bcgtgjyb.myphotoapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bcgtgjyb.dialoglbrary.dialog.MyDiolag;

/**
 * Created by bigwen on 2015/12/8.
 */
public class FragmentThree extends Fragment {
    private View view;
    private String TAG = FragmentThree.class.getName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_three,null);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
        return view;
    }




    private void init() {
        String param = " public void onClick(View v) {\n" +
                "                if (v instanceof TextView) {\n" +
                "                    String param = ((TextView) v).getText().toString();\n" +
                "                    if (param.equals(params[0])) {\n" +
                "                        Log.i(TAG, \"onClick enter\");\n" +
                "                    }\n" +
                "                }\n" +
                "            }" +
                "import android.content.Context;\n" +
                "import android.graphics.PixelFormat;\n" +
                "import android.view.KeyEvent;\n" +
                "import android.view.View;\n" +
                "import android.view.WindowManager;\n" +
                "import android.widget.LinearLayout;import android.content.Context;\n" +
                "import android.graphics.PixelFormat;\n" +
                "import android.view.KeyEvent;\n" +
                "import android.view.View;\n" +
                "import android.view.WindowManager;\n" +
                "import android.widget.LinearLayout;";
        final String[] params = new String[]{"enter", "cancel"};
        MyDiolag myDiolag = new MyDiolag();
        myDiolag.showDialog(getActivity(), "myPhotoApp", param, params, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof TextView) {
                    String param = ((TextView) v).getText().toString();
                    if (param.equals(params[0])) {
                        Log.i(TAG, "onClick enter");
                    }
                }
            }
        });

    }
}
