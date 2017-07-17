package com.example.sample;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.lib.bridge.core.LibEntry;
import com.lib.bridge.core.LibParam;
import com.lib.bridge.core.LibResponse;
import com.lib.bridge.core.LibResponseHandler;
import com.lib.bridge.core.implement.LibBaseResponse;

/**
 * sample实现类
 *
 * Created by jimmy on 2017/7/17.
 */
public class SampleEntry implements LibEntry {
    private static String SAMPLE_TARGET_GET_VIEW = "get_view";
    private static String SAMPLE_TARGET_GET_DATA = "get_data";


    @Override
    public Object syncInvoke(LibParam params) {
        String target = params.getTargetParameter();
        if (TextUtils.isEmpty(target)) {
            return null;
        }
        if (SAMPLE_TARGET_GET_VIEW.equals(target)) {
            return getView(params);
        }
        return null;
    }

    @Override
    public void asyncInvoke(LibParam params, LibResponseHandler handler) {
        String target = params.getTargetParameter();
        if (TextUtils.isEmpty(target)) {
            return;
        }
        if (SAMPLE_TARGET_GET_DATA.equals(target)) {
            getJsonData(handler);
        }

    }

    private View getView(LibParam params) {
        Activity activity = (Activity) params.getBaseParameter("activity");
        if (activity == null) {
            return null;
        }
        TextView textView = new TextView(activity);
        textView.setText("This is a view come from sync request [sample module]");
        textView.setTextColor(activity.getResources().getColor(android.R.color.holo_red_light));
        return textView;
    }

    private void getJsonData(final LibResponseHandler handler) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String data = "this is data come from async lib request [sample module]";
                if (handler != null) {
                    LibResponse response = new LibBaseResponse(data);
                    handler.onHandler(response);
                }
            }
        }).start();
    }

}
