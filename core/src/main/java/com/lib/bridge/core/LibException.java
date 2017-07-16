package com.lib.bridge.core;

/**
 * Lib通信异常类
 *
 * Created by jimmy on 2017/7/15.
 */
public class LibException extends Exception {

    public LibException() {
        super();
    }

    public LibException(String detailMessage) {
        super(detailMessage);
    }

    public LibException(Throwable throwable) {
        super(throwable);
    }

    public LibException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

}
