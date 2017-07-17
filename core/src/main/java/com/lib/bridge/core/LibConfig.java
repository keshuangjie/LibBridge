package com.lib.bridge.core;

import android.text.TextUtils;

import com.lib.bridge.LibIds;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Lib配置类
 *
 * Created by jimmy on 2017/7/15.
 */
public class LibConfig {

    private Map<String, String> entrys;

    public LibConfig() {
        init();
    }

    private void init() {
        entrys = new HashMap<>();
        entrys.put(LibIds.DEMO1.getId(), "com.lib.bridge.demo.DemoEntry");
        entrys.put(LibIds.DEMO2.getId(), "com.example.sample.SampleEntry");
    }

    public String queryLibEntryClassName(String id) {
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return entrys.get(id);
    }

}
