package com.lib.bridge;

import com.lib.bridge.core.LibParam;
import com.lib.bridge.core.LibRequest;
import com.lib.bridge.core.implement.LibBaseRequest;

/**
 * lib通信request构建工厂
 *
 * Created by jimmy on 2017/7/15.
 */
public class LibRequestFactory {

    public static LibRequest newLibRequest(String id) {
        LibRequest libRequest = new LibBaseRequest(id);
        return libRequest;
    }

    public static LibRequest newLibRequest(String id, LibParam params) {
        LibRequest libRequest = newLibRequest(id);
        libRequest.setLibParam(params);
        return libRequest;
    }

}
