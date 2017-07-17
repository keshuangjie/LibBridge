package com.lib.bridge.demo;

import com.lib.bridge.core.LibEntry;
import com.lib.bridge.core.LibParam;
import com.lib.bridge.core.LibResponseHandler;

/**
 * Created by jimmy on 2017/7/17.
 */
public class DemoEntry implements LibEntry {

    @Override
    public Object syncInvoke(LibParam params) {
        return null;
    }

    @Override
    public void asyncInvoke(LibParam params, LibResponseHandler handler) {

    }

}
