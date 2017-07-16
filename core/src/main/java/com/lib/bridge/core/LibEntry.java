package com.lib.bridge.core;

/**
 * Lib请求入口基类
 *
 * Created by jimmy on 2017/7/14.
 */
public interface LibEntry {


    /**
     * 同步请求调用
     *
     * @param params
     * @return
     */
    Object syncInvoke(LibParam params);

    /**
     * 异步请求调用
     *
     * @param params
     * @param handler
     */
    void asyncInvoke(LibParam params, LibResponseHandler handler);

}
