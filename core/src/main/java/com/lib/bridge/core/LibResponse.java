package com.lib.bridge.core;

/**
 * lib间通信返回数据封装
 *
 * Created by jimmy on 2017/7/14.
 */
public interface LibResponse {

    /**
     * 设置请求状态值
     *
     * @param code
     */
    void setStatusCode(int code);

    /**
     * 获取请求状态值
     *
     * @return
     */
    int getStatusCode();

    /**
     * 设置请求返回数据
     *
     * @param data
     */
    void setData(Object data);

    /**
     * 获取请求返回数据
     *
     * @return
     */
    Object getData();

}
