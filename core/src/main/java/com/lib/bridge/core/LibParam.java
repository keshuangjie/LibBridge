package com.lib.bridge.core;

import java.io.Serializable;
import java.util.Map;

/**
 * lib通信协议参数类
 *
 * Created by jimmy on 2017/7/14.
 */
public interface LibParam extends Serializable {

    /**
     * 设置target
     * @param target
     * @return
     */
    LibParam setTargetParameter(String target);

    /**
     * 获取target参数
     * @return
     */
    String getTargetParameter();

    /**
     * 设置基础参数
     * @param key
     * @param value
     * @return
     */
    LibParam putBaseParameter(String key,Object value);

    /**
     * 设置基础参数
     * @param params
     * @return
     */
    LibParam putBaseParameter(Map<String, Object> params);

    /**
     * 获取基础参数
     * @param key
     * @return
     */
    Object getBaseParameter(String key);

}
