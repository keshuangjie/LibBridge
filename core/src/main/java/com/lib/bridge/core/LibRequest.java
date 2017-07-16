package com.lib.bridge.core;

/**
 *
 * lib间通信请求封装
 *
 * Created by jimmy on 2017/7/14.
 */
public interface LibRequest {

    /**
     * 请求调用方式
     */
    enum Method {
        SYNC_REQUEST, /** 同步调用 */
        ASYNC_REQUEST /** 异步调用 */
    }

    String getId();

    void setLibParam(LibParam param);

    LibParam getLibParam();

    Method getMethod();

}
