package com.lib.bridge.core.implement;

import com.lib.bridge.core.LibResponse;

/**
 * 请求返回数据基类
 *
 * Created by jimmy on 2017/7/15.
 */
public class LibBaseResponse implements LibResponse {

    public static final int STATUS_CODE_SUCCESS = 0;

    /** 请求结果状态码 */
    private int statusCode;

    /** 请求结果数据 */
    private Object data;

    public LibBaseResponse() {

    }

    public LibBaseResponse(Object data) {
        this(STATUS_CODE_SUCCESS, data);
    }

    public LibBaseResponse(int statusCode, Object data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    @Override
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public Object getData() {
        return this.data;
    }
}
