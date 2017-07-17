package com.lib.bridge.demo;

import android.app.Activity;
import android.view.View;

import com.lib.bridge.LibIds;
import com.lib.bridge.LibRequestFactory;
import com.lib.bridge.LibRequestManager;
import com.lib.bridge.core.LibParam;
import com.lib.bridge.core.LibRequest;
import com.lib.bridge.core.LibResponse;
import com.lib.bridge.core.LibResponseHandler;
import com.lib.bridge.core.implement.LibBaseParam;

/**
 * Created by jimmy on 2017/7/17.
 */
public class DemoMessage {

    /**
     * 同步获取view
     * @param activity
     * @return
     */
    public static View getView(Activity activity) {
        LibRequest libRequest = LibRequestFactory.newLibRequest(LibIds.DEMO2.getId());
        LibParam param = new LibBaseParam();
        param.setTargetParameter("get_view");
        param.putBaseParameter("activity", activity);
        libRequest.setLibParam(param);
        View view = null;
        try {
            view = (View) LibRequestManager.getInstance().syncInvoke(libRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    /**
     * 异步请求数据
     *
     * @return
     */
    public static void getData(LibResponseHandler handler) {
        LibRequest libRequest = LibRequestFactory.newLibRequest(LibIds.DEMO2.getId());
        LibParam param = new LibBaseParam();
        param.setTargetParameter("get_data");
        libRequest.setLibParam(param);
        LibRequestManager.getInstance().asyncInvoke(libRequest, new LibResponseHandler() {
            @Override
            public void onHandler(LibResponse libResponse) {
                // 回调处理
            }
        });
    }

}
