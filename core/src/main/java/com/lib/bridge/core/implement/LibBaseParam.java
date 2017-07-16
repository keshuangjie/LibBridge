package com.lib.bridge.core.implement;

import com.lib.bridge.core.LibParam;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求参数基类
 *
 * Created by jimmy on 2017/7/15.
 */
public class LibBaseParam implements LibParam {

    private static final String PARAMS_TARGET_KEY = "target";

    private HashMap parameters;

    public LibBaseParam() {
        super();
        this.parameters = new HashMap();
    }

    @Override
    public LibParam setTargetParameter(String target){
        this.parameters.put(PARAMS_TARGET_KEY, target);
        return this;
    }

    @Override
    public String getTargetParameter() {
        return (String)this.parameters.get(PARAMS_TARGET_KEY);
    }

    @Override
    public LibParam putBaseParameter(String key,Object value) {
        if(parameters == null) {
            parameters = new HashMap();
        }
        parameters.put(key,value);
        return this;
    }

    @Override
    public LibParam putBaseParameter(Map<String, Object> params) {
        if(parameters == null) {
            parameters = new HashMap();
        }
        if (params != null && params.size() > 0) {
            parameters.putAll(params);
        }
        return null;
    }

    @Override
    public Object getBaseParameter(String key) {
        if(parameters != null) {
            return parameters.get(key);
        }
        return null;
    }

}
