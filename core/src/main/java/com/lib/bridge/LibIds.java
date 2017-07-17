package com.lib.bridge;

/**
 * lib id key枚举
 *
 * Created by jimmy on 2017/7/15.
 */
public enum LibIds {

    DEMO1("com.lib.bridge.demo"),
    DEMO2("com.example.sample");

    private String id;

    LibIds(String id) {
        this.id  = id;
    }

    public String getId() {
        return id;
    }

}
