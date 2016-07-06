package com.tronsis.cachedemo;

/**
 * UI回调
 *
 * @author allen@tronsis.com
 * @date 2016-2-20 下午5:41:12
 */
public interface UICallBack {

    /**
     * 处理开始时回调
     */
    public void onStart();

    /**
     * 用于处理完业务逻辑后更新UI
     *
     * @param data 附带数据
     */
    public void refresh(int status, Object data);

    /**
     * 处理失败时回调
     *
     * @param status
     */
    public void onFailure(int status);
}
