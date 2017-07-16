package com.lib.bridge;

import android.text.TextUtils;

import com.lib.bridge.core.LibConfig;
import com.lib.bridge.core.LibEntry;
import com.lib.bridge.core.LibException;
import com.lib.bridge.core.LibRequest;
import com.lib.bridge.core.LibResponseHandler;

/**
 * Lib通信管理类
 *
 * Created by jimmy on 2017/7/16.
 */
public class LibRequestManager {

    private LibConfig libConfig;

    private static final class Holder {
        public static final LibRequestManager INSTANCE = new LibRequestManager();
    }

    public static LibRequestManager getInstance() {
        return Holder.INSTANCE;
    }

    private LibRequestManager() {
        libConfig = new LibConfig();
    }

    /**
     * 同步请求调用
     *
     * @param libRequest
     * @return
     */
    public Object syncInvoke(LibRequest libRequest) {
        if (libRequest == null || TextUtils.isEmpty(libRequest.getId())) {
            return null;
        }

        try {
            LibEntry libEntry = createLibEntry(libRequest.getId());
            if (libEntry == null) {
                throw new LibException("syncInvoke 构建LibEntry失败");
            }
            return  libEntry.syncInvoke(libRequest.getLibParam());
        } catch (LibException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步请求调用
     *
     * @param libRequest
     * @param handler
     */
    public void asyncInvoke(LibRequest libRequest, LibResponseHandler handler) {
        if (libRequest == null || TextUtils.isEmpty(libRequest.getId())) {
            return;
        }

        try {
            LibEntry libEntry = createLibEntry(libRequest.getId());
            if (libEntry == null) {
                throw new LibException("syncInvoke 构建LibEntry失败");
            }
            libEntry.asyncInvoke(libRequest.getLibParam(), handler);
        } catch (LibException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询对应的LibEntry
     *
     * @param id
     * @return
     * @throws LibException
     */
    private LibEntry createLibEntry(String id) throws LibException {
        String entryName = libConfig.queryLibEntryClassName(id);
        try {
            LibEntry entity = (LibEntry) Class.forName(entryName).newInstance();
            return entity;
        } catch (Throwable e) {
            throw new LibException("createLibEntry 反射构造entry失败", e);
        }
    }

}
