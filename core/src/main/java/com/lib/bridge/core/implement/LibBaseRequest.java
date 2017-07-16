package com.lib.bridge.core.implement;

import android.text.TextUtils;

import com.lib.bridge.core.LibParam;
import com.lib.bridge.core.LibRequest;

/**
 * 请求基础类
 *
 * Created by jimmy on 2017/7/15.
 */
public class LibBaseRequest implements LibRequest {

    /** lib的唯一标识，建议使用applicationId */
    private String id;

    /**  @see com.lib.bridge.core.LibRequest.Method */
    private Method method;

    /** 请求参数 */
    private LibParam libParam;

    public LibBaseRequest(String id) {
        if(TextUtils.isEmpty(id)) {
            throw new IllegalArgumentException("Lib id may not be null");
        }

        this.id = id;
    }

    public LibBaseRequest(String id, Method method) {
        if(TextUtils.isEmpty(id)) {
            throw new IllegalArgumentException("Lib id may not be null");
        }
        if (method == null) {
            throw new IllegalArgumentException("Method may not be null");
        }

        this.id = id;
        this.method = method;
    }

    public LibBaseRequest(String id, Method method, LibParam libParam) {
        this(id, method);
        this.libParam = libParam;

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public void setLibParam(LibParam libParam) {
        this.libParam = libParam;
    }

    @Override
    public LibParam getLibParam() {
        return libParam;
    }

}
